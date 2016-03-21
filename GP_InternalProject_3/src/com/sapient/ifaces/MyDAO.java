package com.sapient.ifaces;

import java.io.Serializable;
import java.util.List;

public interface MyDAO<T> {

	public Serializable add(T t);

	public T find(Serializable obj);

	public List<T> findAll();

	public T update(T obj);

	public boolean delete(Serializable obj);
}
