package com.pepcus.services;

import com.pepcus.entity.Student;
import com.pepcus.repository.StudentRepository;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceArrayList {
  @Autowired
  private StudentRepository studentRepository;

  ArrayList<Student> studentArrayList;

  public ArrayList<Student> getAllStudents() {
    long startTime = System.nanoTime();
    studentArrayList = (ArrayList<Student>) studentRepository.findAll();
    long endTime = System.nanoTime();
    System.out.println("feching time all Student " + (endTime - startTime));
    return studentArrayList;
  }

  public ArrayList<Student> addStudent(Student student, int index) {

    long startTime = System.nanoTime();
    studentArrayList.add(index, student);
    long endTime = System.nanoTime();
    System.out.println("Adding time......... " + (endTime - startTime));
    return studentArrayList;

  }

  public ArrayList<Student> updateStudent(Student student, int id) {
    long startTime = System.nanoTime();
    Student savedStudent = null;
    for (Student existingStudent : studentArrayList) {
      if (existingStudent.getId() == id) {
        savedStudent = existingStudent;
        savedStudent.setFirst_name(student.getFirst_name());
        savedStudent.setTelecoM_Number(student.getTelecoM_Number());
        savedStudent.setGender(student.getGender());
        savedStudent.setAge(student.getAge());
        savedStudent.setAadhar_number(student.getAadhar_number());
        Student updated = studentArrayList.set(existingStudent.getId() - 1, savedStudent);
        System.out.println("successfully updated!.............");
        System.out.println(updated);
      }
    }
    long endTime = System.nanoTime();
    System.out.println("updation time....... " + (endTime - startTime));
    return studentArrayList;

  }

  public Student deleteStudent(int stdId) {
    long startTime = System.nanoTime();
    Student removeStudent = null;
    for (Student student : studentArrayList) {
      if (student.getId() == stdId) {
        removeStudent = student;
      }
    }
    studentArrayList.remove(removeStudent);
    long endTime = System.nanoTime();
    System.out.println("Deleting time....... " + (endTime - startTime));
    return removeStudent;
  }

  public ArrayList<Student> duplicates() {
    long startTime = System.nanoTime();
    Set<Student> studentSet = new HashSet<>();
    ArrayList<Student> ouput = new ArrayList<>();
    for (Student student : studentArrayList) {
      if (!studentSet.add(student)) {
        ouput.add(student);
      }
    }
    long endTime = System.nanoTime();
    System.out.println("Deleting time....... " + (endTime - startTime));
    return ouput;

  }

  public List<Student> sortByAge() {
    // sort using Stream - increasing-order of Age
    long startTime = System.nanoTime();
    List<Student> sortedStudents = studentArrayList.stream().sorted(Comparator.comparingInt(Student::getAge))
        .collect(Collectors.toList());
    long endTime = System.nanoTime();
    System.out.println("Sorting  time by age....... " + (endTime - startTime));
    return sortedStudents;
  }

  public List<Student> sorByIdt() {
    long startTime = System.nanoTime();
    List<Student> reverseSortedStudents = studentArrayList.stream()
        .sorted(Comparator.comparingInt(Student::getId).reversed()).collect(Collectors.toList());
    long endTime = System.nanoTime();
    System.out.println("Sorting time by Id....... " + (endTime - startTime));
    return reverseSortedStudents;
  }
}
