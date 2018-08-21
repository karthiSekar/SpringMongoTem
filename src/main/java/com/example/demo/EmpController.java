package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
@Autowired
EmpService service;
	@PostMapping("/valueAdding")
	public void adding(@RequestBody Emp emp) {
		service.add(emp);
		
	}
	@DeleteMapping("/DeleteByName/name/{name}")
	String go(@PathVariable("name") String name) {
		service.delete(name);
		
		return "deleted";

	}
	@GetMapping("/all")
	public List<Emp> findAll() {
		return service.findAll();
	}
	@DeleteMapping("/and")
	public String andOperation() {
		return service.and();
		
	}
	@DeleteMapping("/or")
	public String orOperation() {
		return service.or();
		
	}
	@DeleteMapping("/in")
	public String inOperation() {
		return service.in();
		
	}
	@DeleteMapping("/nin")
	public String ninOperation() {
		return service.nin();
		
	}
	
	/*@GetMapping("/sort")
	public List<Emp> sorting() {
		Query q8 = new Query();
		q8.with(new Sort(org.springframework.data.domain.Sort.Direction.ASC, "name"));
		List<Emp> b7 = mongo.find(q8, Emp.class);
		return b7;
	}

	@PutMapping("/update")
	public String update(@RequestParam("id") int id) {

		Query q9 = new Query();
		q9.addCriteria(Criteria.where("id").is(id));
		Update up = new Update();
		up.set("name", "name4");
		mongo.updateFirst(q9, up, Emp.class);
		return "Updated";
	}

	@PutMapping("/updateMult")
	public String updateMany(@RequestParam("author") String name) {

		Query q9 = new Query();
		q9.addCriteria(Criteria.where("name").is(name));
		Update up = new Update();
		up.set("name", "name4");
		mongo.updateMulti(q9, up, Emp.class);

		return "Updated";
	}

	@DeleteMapping("/del")
	public String deleting() {

		Query qq = new Query();
		qq.addCriteria(Criteria.where("name").is("name1"));
		mongo.findAndRemove(qq, Emp.class);
		return "Deleted";
	}

	@DeleteMapping("/delAllSpecific")
	public String delAllSpecific() {

		Query qq = new Query();
		qq.addCriteria(Criteria.where("name").is("name1"));
		mongo.findAllAndRemove(qq, Emp.class);
		return "Deleted Specified Field";
	}

	@GetMapping("/UserNamesCheck")
	public List<Emp> getByUserName() {
		Query query6 = new Query();
		query6.addCriteria(Criteria.where("name").regex("n.*a", "i"));
		List<Emp> userTest6 = mongo.find(query6, Emp.class);
		return userTest6;
	}
	
	@GetMapping("/All Function/function/id/shift/{function}/{id}/{shift}")
	public List<Emp> allFunction(@PathVariable("function") String function, @RequestParam("name") List<String> name,
			@PathVariable("id") int id, @PathVariable("shift") String shift) {
		List<Emp> emp = new ArrayList<>();
		switch (function) {
		case "and":
			Query q = new Query();
			q.addCriteria(Criteria.where("name").in(name).andOperator(Criteria.where("id").is(id),
					Criteria.where("shift").is(shift)));
			System.out.println(q.toString());
			emp = mongo.find(q, Emp.class, "Emp");
			break;
		case "or":
			Query q1 = new Query();
			q1.addCriteria(Criteria.where("name").in(name).orOperator(Criteria.where("id").is(id),
					Criteria.where("shift").is(shift)));
			System.out.println(q1.toString());
			emp = mongo.find(q1, Emp.class, "Emp");
			break;
		case "in":
			Query q2 = new Query();
			q2.addCriteria(Criteria.where("name").in(name));
			emp = mongo.find(q2, Emp.class, "Emp");
			System.out.println(emp);
			break;
		case "nin":
			Query q3 = new Query();
			q3.addCriteria(Criteria.where("name").nin(name));
			emp = mongo.find(q3, Emp.class, "Emp");
			System.out.println(emp);
			break;
		}
		return emp;
	}
	@GetMapping("/All Function")
	public List<Emp> allFunction( @RequestParam("name") List<String> name,@RequestParam("shift") List<String> shift,@RequestParam("id") List<Integer> id) {
		Query q = new Query();
		if(name!=null&shift!=null&id!=null){
			q.addCriteria(Criteria.where("name").in(name).andOperator(Criteria.where("shift").in(shift),Criteria.where("id").in(id)));
			List<Emp>emp = mongo.find(q, Emp.class, "Emp");
		return emp;
		}
		return null;
		
}
}
*/
}