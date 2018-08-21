package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class EmpRepo {
@Autowired
MongoTemplate mongo;
void add(Emp emp){
	mongo.save(emp);
	
	
}
public void delete(String name) {
	// TODO Auto-generated method stub
	Query query2 = new Query(Criteria.where("name").is(name));
	Emp empObj = mongo.findOne(query2, Emp.class);
	mongo.remove(empObj);
	// mongo.dropCollection("Emp");
	// mongo.findAndRemove(query2, Emp.class);
	Query query1 = new Query(Criteria.where("name").exists(true).orOperator(Criteria.where("name").is("frog"),
			Criteria.where("name").is("dog")));
	mongo.remove(query1, Emp.class);
}
public List<Emp> findAll() {
	// TODO Auto-generated method stub
	return mongo.findAll(Emp.class);

}
public String and() {
	Query q = new Query();
	q.addCriteria(Criteria.where("id").exists(true).andOperator(Criteria.where("name").is("name2"),
			Criteria.where("shift").is("day")));
	// System.out.println(q.toString());
	System.out.println(mongo.find(q, Emp.class));
	return "deleted";	
	}
public String or() {
	Query q5 = new Query();
	q5.addCriteria(Criteria.where("id").exists(true).orOperator(Criteria.where("name").is("name2"),
			Criteria.where("shift").is("day")));
	mongo.findAllAndRemove(q5, Emp.class);
	return "deleted";
}
public String in() {
	Query q6 = new Query();
	q6.addCriteria(Criteria.where("name").in("name1", "name2"));
	mongo.findAllAndRemove(q6, Emp.class);
	return "deleted";
}
public String nin() {
	Query q6 = new Query();
	q6.addCriteria(Criteria.where("name").nin("name1", "name2"));
	mongo.findAllAndRemove(q6, Emp.class);
	return "deleted";
}
}
