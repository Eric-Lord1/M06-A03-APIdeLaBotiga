package com.ericayxendri.accesadades.botiga.services;

import java.util.List;
import java.util.Optional;

public interface IService<T, ID>  {
   
    List<T> findAll();
   
    Optional<T> findById(ID id);
   
    T save(T entity);
   
    void deleteById(ID id);

}
