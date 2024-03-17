package org.example.shipping_services_for_everyone.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> display(T object);
    void addNew(T object);
    void edit(T object);
    void delete(T object);
    List<T> find(T object);
    Boolean checkIdIsExist(T object);

}

