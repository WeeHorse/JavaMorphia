package application;

import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public class Connection {

    private static final Connection instance = new Connection();

    public Connection(){}

    public static Connection getInstance() {
        return instance;
    }

    Datastore datastore = null;

    public Datastore getDatastore() {
        if(datastore == null){
            connect();
        }
        return datastore;
    }

    public void connect(){
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.baeldung.morphia");
        Datastore datastore = morphia.createDatastore(new MongoClient(), "library");
        datastore.ensureIndexes();
    }

}
