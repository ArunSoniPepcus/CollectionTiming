package com.pepcus.controllers;

import com.pepcus.entity.Student;
import com.pepcus.services.StudentServiceHashSet;
import java.util.HashSet;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentControllerHashSet {
  @Autowired
  private StudentServiceHashSet serviceHashSet;

  @GetMapping("/")
  public ResponseEntity<HashSet<Student>> getStudents() {
    HashSet<Student> list = serviceHashSet.getAllStudents();
    if (list.size() == 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
  }
  @PostMapping("/add")
  public Student addStudent(@RequestBody Student student){
    return serviceHashSet.addStudent(student);
  }
  @PatchMapping("/update/{id}")
  public HashSet<Student> update(@RequestBody Student student,@PathVariable("id") int id) {
    return serviceHashSet.update(student,id);
    
  }
  @DeleteMapping("/delete/{id}")
  public Object delete(@PathVariable("id") int id) {
    return serviceHashSet.delete(id);
  }
  @GetMapping("/sorted")
  public String sortById(){
     return serviceHashSet.sortById();
  }
}
