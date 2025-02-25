/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package local.sanclemente.ad.exame.dao;

import java.util.List;

/**
 *
 * @author pepecalo
 * @param <T> Tipo de dato del objeto
 */
public interface DAO<T, K> {

    T getById(K id);

//    List<T> getAllByFK(K k);

    List<T> getAll();

//    void save(T t);

}