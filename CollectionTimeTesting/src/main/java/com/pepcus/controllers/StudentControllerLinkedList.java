package com.pepcus.controllers;

import com.pepcus.entity.Student;
import com.pepcus.services.StudentServiceLinkedList;
import java.util.LinkedList;
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
@RequestMapping("/students")
public class StudentControllerLinkedList {
  @Autowired
  private StudentServiceLinkedList serviceLinkedList;

   @GetMapping("/get")
   public ResponseEntity<LinkedList<Student>> getStudent() {
     LinkedList<Student> linkedList = serviceLinkedList.getAllStudent();
     if (linkedList.size() == 0) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
     return ResponseEntity.of(Optional.of(linkedList));
   }

   @PostMapping("/post/{index}")
   public LinkedList<Student> addStudent(@RequestBody Student student,@PathVariable("index") int index) {
     return serviceLinkedList.addStudent(student,index);
   }

   @PutMapping("/put/{id}")
   public LinkedList<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
     return serviceLinkedList.updateStudent(student, id);

   }

   @DeleteMapping("/dlt/{stdId}")
   public Student deleteStudent(@PathVariable("stdId") int stdId) {
     return serviceLinkedList.deleteStudent(stdId);
   }
   @GetMapping("/sortByAge")
   public List<Student> sortbyAge() {
     return serviceLinkedList.sortByAge();
   }
   @GetMapping("/sortById")
   public List<Student> sortbuId() {
     return serviceLinkedList.sorByIdt();
   }
}
