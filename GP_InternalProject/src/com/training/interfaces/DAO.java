package com.training.interfaces;

import java.util.List;

public interface DAO<T> {

	public int add(T t);

	public T find(int key);

	public List<T> findAll();

	public int update(int key, String newInput);

	public int delete(int key);

}