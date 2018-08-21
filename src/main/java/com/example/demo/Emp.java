package com.example.demo;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Emp")
public class Emp {
@Id
int id;

String name;
String shift;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getShift() {
	return shift;
}
public void setShift(String shift) {
	this.shift = shift;
}
@Override
public String toString() {
	return "Emp [id=" + id + ", name=" + name + ", shift=" + shift + "]";
}
}
