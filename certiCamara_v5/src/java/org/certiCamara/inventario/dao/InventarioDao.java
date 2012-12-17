/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.certiCamara.inventario.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fenryr
 */
public interface InventarioDao<T, PK extends Serializable> {

    /**
     * Persist the newInstance object into database
     */
    void create(T newInstance);

    /**
     *
     * @return
     */
    public List<T> readAll();

    /**
     * Retrieve an object that was previously persisted to the database using
     * the indicated id as primary key
     */
    List<T> readByString(String field, String string);

    /**
     *
     * @param field
     * @param value
     * @return
     */
    List<T> readByNumber(String field, double value);

    /**
     * Save changes made to a persistent object.
     */
    void update(T transientObject);

    /**
     *
     * @param field
     * @param string
     */
    public void updateString(String field, String string);

    /**
     *
     * @param field
     * @param string
     */
    public void updateNumber(String field, double value);

    /**
     * Remove an object from persistent storage in the database
     */
    void delete(T persistentObject);

    /**
     *
     * @param field
     * @param string
     */
    void deleteByString(String field, String string);

    /**
     *
     * @param field
     * @param value
     */
    void deleteByNumber(String field, double value);
}