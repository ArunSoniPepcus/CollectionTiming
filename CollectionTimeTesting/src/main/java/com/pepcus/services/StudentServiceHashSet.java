package com.pepcus.services;

import com.pepcus.entity.Student;
import com.pepcus.repository.StudentRepository;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceHashSet {
  @Autowired
  private StudentRepository studentRepository;
  List<Student> studentList;
  HashSet<Student> studentHashSet = new HashSet<Student>();

  /**
   * @return
   */
  public HashSet<Student> getAllStudents() {
    long startTime = System.nanoTime();
    studentList = studentRepository.findAll();
    for (Student student : studentList) {
      studentHashSet.add(student);
    }
    long endTime = System.nanoTime();
    System.out.println("Geting time all student.... " + (endTime - startTime));
    return studentHashSet;
  }

  /**
   * @param student
   * @return
   */
  public Student addStudent(Student student) {
    long startTime = System.nanoTime();
    studentHashSet.add(student);
    long endTime = System.nanoTime();
    System.out.println("Adding time student.... " + (endTime - startTime));
    return student;
  }

  /**
   * @param student
   * @param id
   * @return
   */
  public HashSet<Student> update(Student student, int id) {
    long startTime = System.nanoTime();
    for (Student student2 : studentHashSet) {
      if (student2.getId() == id) {
        student2.setAadhar_number(student.getAadhar_number());
        student2.setAge(student.getAge());
        student2.setFirst_name(student.getFirst_name());
        student2.setGender(student.getGender());
        System.out.println("update Successfully");
      }
    }
    studentHashSet.add(student);
    long endTime = System.nanoTime();
    System.out.println("updating time student.... " + (endTime - startTime));
    return studentHashSet;

  }

  /**
   * @param id
   * @return
   */
  public Object delete(int id) {
    long startTime = System.nanoTime();
    Iterator<Student> it = studentHashSet.iterator();
    Object value = it.next();
    if (value.equals(id)) {
      studentHashSet.remove(value);
    }
    long endTime = System.nanoTime();
    System.out.println("Deleting time student.... " + (endTime - startTime));
    return value;

  }
  
  /**
   * @return
   */
  public String sortById() {
    long startTime = System.nanoTime();
    System.out.println("--- student after sorted ---");
    studentHashSet.stream().sorted(Comparator.comparingInt(Student::getId));
    long endTime = System.nanoTime();
    System.out.println("Sorting time student.... " + (endTime - startTime));
    return "Successfully Sorted.......... ";
  }

}
