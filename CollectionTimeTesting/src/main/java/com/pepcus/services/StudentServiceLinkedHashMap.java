package com.pepcus.services;

import com.pepcus.entity.Student;
import com.pepcus.repository.StudentRepository;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceLinkedHashMap {
  @Autowired
  private StudentRepository studentRepository;
  List<Student> studentList;
  LinkedHashMap<Integer,Student> studentLinkedHashMap = new LinkedHashMap<>();

  public LinkedHashMap<Integer,Student> getAllStudents() {
    long startTime=System.nanoTime();
    studentList = studentRepository.findAll();
    for (Student student : studentList) {
      studentLinkedHashMap.put(student.getId(),student);
    }
    long endTime=System.nanoTime();
    System.out.println("Geting time all student in HashMap.... "+(endTime-startTime));
    return studentLinkedHashMap;
  }

  public Student addStudent(Student student) {
    long startTime=System.nanoTime();
    studentLinkedHashMap.put(student.getId(),student);
    long endTime=System.nanoTime();
    System.out.println("Adding time student.... "+(endTime-startTime));
    return student;
  }

  public Student update(Student student, Integer id) {
    Student update=null;
    long startTime=System.nanoTime();
    if(studentLinkedHashMap.containsKey(id)) {
       studentLinkedHashMap.replace(id, student);
        System.out.println("update Successfully");
      }
    long endTime=System.nanoTime();
    System.out.println("updating time student.... "+(endTime-startTime));
    return   update;
   
  }

  public Student delete(Integer id) {
    Student containStudentObj=null;
    long startTime=System.nanoTime();
   if (studentLinkedHashMap.containsKey(id)) {
     containStudentObj=studentLinkedHashMap.get(id);
   }
       studentLinkedHashMap.replace(id, containStudentObj);
   long endTime=System.nanoTime();
   System.out.println("Deleting time student.... "+(endTime-startTime));
  return containStudentObj;
  
  }
}
