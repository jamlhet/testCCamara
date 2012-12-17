/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.connection;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.certiCamara.inventario.entity.BodegaEntity;
import org.certiCamara.inventario.entity.ProductoEntity;
import org.certiCamara.inventario.entity.ProveedorEntity;

/**
 *
 * @author juan
 */
//@Startup
//@Singleton
public class MongoDBConnection {

    private Mongo mongo;
    private DB db;
    private Morphia morphia;
    private Datastore ds;
    private final String DBNAME = "certiCamara";
    private final String HOST = "localhost";
    private final int PORT = 27017;

    /**
     *
     * @throws UnknownHostException
     */
    public MongoDBConnection() {
        try {
            this.mongo = new Mongo(HOST, PORT);
            this.db = mongo.getDB(DBNAME);
            this.morphia = new Morphia();
            this.ds = morphia.map(BodegaEntity.class).map(ProveedorEntity.class).map(ProductoEntity.class).createDatastore(mongo, DBNAME);
            System.out.println("*****Instanciando MongoDBConnection()******************");
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MongoException ex) {
            Logger.getLogger(MongoDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MongoDBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mongo getMongo() {
        return mongo;
    }

    public void setMongo(Mongo mongo) {
        this.mongo = mongo;
    }

    public DB getDb() {
        return db;
    }

    public void setDb(DB db) {
        this.db = db;
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public void setMorphia(Morphia morphia) {
        this.morphia = morphia;
    }

    public Datastore getDs() {
        return ds;
    }

    public void setDs(Datastore ds) {
        this.ds = ds;
    }
}
