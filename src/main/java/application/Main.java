package application;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import org.bson.types.ObjectId;

import java.util.List;

// https://www.baeldung.com/mongodb-morphia

public class Main {

    public static void main( String[] args ) {
        System.out.println(args);
        // Datastore datastore = new application.Connection().getInstance().getDatastore();

        Morphia morphia = new Morphia();
        morphia.mapPackage("com.baeldung.morphia");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "library");
        datastore.ensureIndexes();

        Publisher publisher = new Publisher(new ObjectId(), "Awsome application.Publisher");

        Book book = new Book("9781565927186", "Learning Java", 3.95, publisher);
        Book companionBook = new Book("9789332575103", "Java Performance Companion",
                1.95, publisher);

        book.addCompanionBook(companionBook);

        datastore.save(companionBook);
        datastore.save(book);

        List<Book> books = datastore.createQuery(Book.class)
                .field("title")
                .contains("Learning Java")
                .find()
                .toList();

        System.out.println(books.size());

        System.out.println(books.get(0));

    }

}
