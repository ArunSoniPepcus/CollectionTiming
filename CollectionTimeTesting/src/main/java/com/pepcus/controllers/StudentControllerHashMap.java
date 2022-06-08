package com.pepcus.controllers;

import java.util.HashMap;
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

import com.pepcus.entity.Student;
import com.pepcus.services.StudentServiceHashMap;

@RestController
@RequestMapping("/students")
public class StudentControllerHashMap {
  @Autowired
  private StudentServiceHashMap serviceHashMap;

  @GetMapping("/")
  public ResponseEntity<HashMap<Integer,Student>> getStudents() {
    HashMap<Integer,Student> hashMap = serviceHashMap.getAllStudents();
    if (hashMap.size() == 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(hashMap));
  }
  @PostMapping
  public Student addStudent(@RequestBody Student student){
    return serviceHashMap.addStudent(student);
  }
  @PatchMapping("/{id}")
  public Student update(@RequestBody Student student,@PathVariable("id") Integer id) {
    return serviceHashMap.update(student,id);
  }
  
  @DeleteMapping("/delete/{id}")
  public Student delete(@PathVariable("id") Integer id) {
    return serviceHashMap.delete(id);
  }
}
