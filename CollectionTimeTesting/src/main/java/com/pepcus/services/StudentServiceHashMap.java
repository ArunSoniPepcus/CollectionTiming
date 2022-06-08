package com.pepcus.services;

import com.pepcus.entity.Student;
import com.pepcus.repository.StudentRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arun
 *
 */
@Service
public class StudentServiceHashMap {
  @Autowired
  private StudentRepository studentRepository;
  List<Student> studentList;
  HashMap<Integer,Student> studentHashMap = new HashMap<>();

  /**
   * @return
   */
  public HashMap<Integer,Student> getAllStudents() {
    long startTime=System.nanoTime();
    studentList = studentRepository.findAll();
    for (Student student : studentList) {
      studentHashMap.put(student.getId(),student);
    }
    long endTime=System.nanoTime();
    System.out.println("Geting time all student in HashMap.... "+(endTime-startTime));
    return studentHashMap;
  }

  /**
   * @param student
   * @return
   */
  public Student addStudent(Student student) {
    long startTime=System.nanoTime();
    studentHashMap.put(student.getId(),student);
    long endTime=System.nanoTime();
    System.out.println("Adding time student.... "+(endTime-startTime));
    return student;
  }

  /**
   * @param student
   * @param id
   * @return
   */
  public Student update(Student student, Integer id) {
    Student update=null;
    long startTime=System.nanoTime();
    if(studentHashMap.containsKey(id)) {
       studentHashMap.replace(id, student);
        System.out.println("update Successfully");
      }
    long endTime=System.nanoTime();
    System.out.println("updating time student.... "+(endTime-startTime));
    return   update;
   
  }

  /**
   * @param id
   * @return
   */
  public Student delete(Integer id) {
    Student containStudentObj=null;
    long startTime=System.nanoTime();
   if (studentHashMap.containsKey(id)) {
     containStudentObj=studentHashMap.get(id);
   }
       studentHashMap.replace(id, containStudentObj);
   long endTime=System.nanoTime();
   System.out.println("Deleting time student.... "+(endTime-startTime));
  return containStudentObj;
  
  }
}


