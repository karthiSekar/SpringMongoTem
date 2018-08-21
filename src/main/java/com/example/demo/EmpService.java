package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpService {
	@Autowired
	EmpRepo repo;
public void add(Emp emp) {
	// TODO Auto-generated method stub
	repo.add( emp);
}
public void delete(String name) {
	// TODO Auto-generated method stub
	repo.delete(name);
}
public List<Emp> findAll() {
	// TODO Auto-generated method stub
	return repo.findAll();
}
public String and() {
	 return repo.and();
	
}
public String or() {
	return repo.or();
}
public String in() {
	
	return repo.in();
}
public String nin() {
	
	return repo.nin();
}
}