package com.pepcus.services;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pepcus.entity.Student;
import com.pepcus.repository.StudentRepository;
@Service
public class StudentServiceLinkedList {
  @Autowired
  private StudentRepository studentRepository;
  
  LinkedList<Student> studentLinkedList=new LinkedList<>();

  /**
   * @return
   */
  public LinkedList<Student> getAllStudent() {
    long startTime = System.nanoTime();  
    List<Student> studentList =studentRepository.findAll();
    ListIterator<Student> itr = studentList.listIterator();
    while (itr.hasNext()) {
      studentLinkedList.add(itr.next());
    }
    long endTime = System.nanoTime();
    System.out.println("feching time in LinkedList all students " + (endTime - startTime));
    return studentLinkedList;
  }

  /**
   * @param student
   * @param index
   * @return
   */
  public LinkedList<Student> addStudent(Student student, int index) {
    long startTime = System.nanoTime();
    studentLinkedList.add(index, student);
    long endTime = System.nanoTime();
    System.out.println("Adding time......... " + (endTime - startTime));
    return studentLinkedList;
   
  }

  /**
   * @param student
   * @param id
   * @return
   */
  public LinkedList<Student> updateStudent(Student student, int id) {
    Student savedStudent = null;
    long startTime = System.nanoTime();
    for (Student existingStudent : studentLinkedList) {
      if (existingStudent.getId() == id) {
        savedStudent = existingStudent;
        savedStudent.setFirst_name(student.getFirst_name());
        savedStudent.setTelecoM_Number(student.getTelecoM_Number());
        savedStudent.setGender(student.getGender());
        savedStudent.setAge(student.getAge());
        savedStudent.setAadhar_number(student.getAadhar_number());
        Student updated = studentLinkedList.set(existingStudent.getId() - 1, savedStudent);
        System.out.println("successfully updated!.............");
        System.out.println(updated);
      }
    }
    long endTime = System.nanoTime();
    System.out.println("updation time....... "+(endTime - startTime));
    return studentLinkedList;

  }

  public Student deleteStudent(int stdId) {
    long startTime = System.nanoTime();
    Student removeStudent = null;
    for (Student student : studentLinkedList) {
      if (student.getId() == stdId) {
        removeStudent = student;
      }
    }
    studentLinkedList.remove(removeStudent);
    long endTime = System.nanoTime();
    System.out.println("updation time....... " + (endTime - startTime));
    System.out.println("delete successfully........!");
    return removeStudent;
  }
  /**
   * @return
   */
  public List<Student> sortByAge() {
    // sort using Stream - increasing-order of Age
    long startTime = System.nanoTime();
    List<Student> sortedStudents = studentLinkedList.stream().sorted(Comparator.comparingInt(Student::getAge))
        .collect(Collectors.toList());
    long endTime = System.nanoTime();
    System.out.println("Sorting  time by age....... " + (endTime - startTime));
    return sortedStudents;
  }

  public List<Student> sorByIdt() {
    long startTime = System.nanoTime();
    List<Student> reverseSortedStudents = studentLinkedList.stream()
        .sorted(Comparator.comparingInt(Student::getId).reversed()).collect(Collectors.toList());
    long endTime = System.nanoTime();
    System.out.println("Sorting time by Id....... " + (endTime - startTime));
    return reverseSortedStudents;
  }
}
