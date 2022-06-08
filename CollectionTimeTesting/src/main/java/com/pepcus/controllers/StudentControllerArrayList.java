package com.pepcus.controllers;

import com.pepcus.entity.Student;
import com.pepcus.services.StudentServiceArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
public class StudentControllerArrayList {
  @Autowired
  private StudentServiceArrayList studentServiceArrayList;

  @GetMapping
  public ResponseEntity<ArrayList<Student>> getStudents() {
    ArrayList<Student> list = studentServiceArrayList.getAllStudents();
    if (list.size() == 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
  }

  @PostMapping("/{index}")
  public ArrayList<Student> addStudent(@RequestBody Student student, @PathVariable("index") int index) {
    return studentServiceArrayList.addStudent(student, index);
  }

  @PutMapping("/{id}")
  public ArrayList<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
    return studentServiceArrayList.updateStudent(student, id);

  }

  @DeleteMapping("/{stdId}")
  public Student deleteStudent(@PathVariable("stdId") int stdId) {
    return studentServiceArrayList.deleteStudent(stdId);
  }

  // Second requirement find Duplicate data in db
  // First get the data and then add duplicate student in particular index
  // (using post) and then hit this api
  @GetMapping("/duplicate")
  public ArrayList<Student> duplicate() {
    return studentServiceArrayList.duplicates();
  }

  @GetMapping("/sortByAge")
  public List<Student> sortbyAge() {
    System.out.println("sorted age");
    return studentServiceArrayList.sortByAge();
  }
  @GetMapping("/sortById")
  public List<Student> sortbuId() {
    return studentServiceArrayList.sorById();
  }
}