package com.pepcus.controllers;

import com.pepcus.entity.Student;
import com.pepcus.services.StudentServiceLinkedHashMap;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentControllerLinkedHashMap {
  @Autowired
  private StudentServiceLinkedHashMap serviceLinkedHashMap;

  @GetMapping("/get")
  public ResponseEntity<LinkedHashMap<Integer,Student>> getStudents() {
    LinkedHashMap<Integer,Student> hashMap = serviceLinkedHashMap.getAllStudents();
    if (hashMap.size() == 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(hashMap));
  }
  @PostMapping("/Add")
  public Student addStudent(@RequestBody Student student){
    return serviceLinkedHashMap.addStudent(student);
  }
  @PatchMapping("/Update/{id}")
  public Student update(@RequestBody Student student,@PathVariable("id") Integer id) {
    return serviceLinkedHashMap.update(student,id);
  }
  
  @DeleteMapping("/dlt/{id}")
  public Student delete(@PathVariable("id") Integer id) {
    return serviceLinkedHashMap.delete(id);
  }
}

