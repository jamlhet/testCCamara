/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.dao;

import com.google.code.morphia.Datastore;
import java.io.Serializable;
import java.util.List;
import org.certiCamara.inventario.connection.MongoDBConnection;

/**
 *
 * @author fenryr
 */
public class InventarioDaoImpl<T, PK extends Serializable> implements InventarioDao<T, PK> {

    private Class<T> type;
    protected Datastore ds;
    private MongoDBConnection mongoDBConnection;

    public InventarioDaoImpl(Class<T> type) {
        mongoDBConnection = new MongoDBConnection();
        this.type = type;
        this.ds = mongoDBConnection.getDs();
    }

    @Override
    public void create(T o) {
        System.out.println("DAOImpl Create");
        ds.save(o);
    }

    @Override
    public List<T> readAll() {
        System.out.println("DAOImpl ReadAll");
        return ds.find(type).asList();
    }

    @Override
    public List<T> readByString(String field, String value) {
        System.out.println("DAOImpl ReadByString");
        return ds.find(type, field, value).asList();
    }

    @Override
    public List<T> readByNumber(String field, double value) {
        System.out.println("DAOImpl ReadByNumber");
        return ds.find(type, field, value).asList();
    }

    @Override
    public void update(T o) {
        System.out.println("DAOImpl Update");
        ds.save(o);
    }

    @Override
    public void updateString(String field, String string) {
        System.out.println("DAOImpl UpdateByString");
        ds.update(ds.createQuery(type).filter(field, string), ds.createUpdateOperations(type).set(field, string));
    }

    @Override
    public void updateNumber(String field, double value) {
        System.out.println("DAOImpl UpdateByNumber");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(T o) {
        System.out.println("DAOImpl Delete");
        ds.delete(o);
    }

    @Override
    public void deleteByString(String field, String string) {
        System.out.println("DAOImpl DeleteByString");
        ds.delete(ds.createQuery(type).filter(field, string));
    }

    @Override
    public void deleteByNumber(String field, double value) {
        System.out.println("DAOImpl DeleteByNumber");
        ds.delete(ds.createQuery(type).filter(field, value));
    }
}