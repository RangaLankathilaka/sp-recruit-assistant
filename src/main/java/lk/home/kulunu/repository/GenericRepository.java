package lk.home.kulunu.repository;

import java.io.Serializable;

public interface GenericRepository<T, ID extends Serializable> {
    <S extends T> S persist(S entity);
}
