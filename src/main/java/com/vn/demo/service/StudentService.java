package com.vn.demo.service;

import com.vn.demo.entity.Person;
import com.vn.demo.entity.Student;
import com.vn.demo.factory.RequestInsert;
import com.vn.demo.repository.PersonRepository;
import com.vn.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final PersonRepository personRepository;


    public Student save(Student student) {
        Person person = new Person();
        person.setName(student.getName());
        person.setAge(student.getAge());
        student.setCreatedDate(LocalDateTime.now());
        personRepository.save(person);
        return repository.save(student);
    }


    public List<Student> update(RequestInsert requestInsert) {
        Long id = requestInsert.getId();
        Long id2 = requestInsert.getId2();
        Student student2 = repository.findById(id2).orElse(null);
        Student student = repository.findById(id).orElse(null);
        Long id3 = requestInsert.getId() +2;
        Long id4 = requestInsert.getId2()+3;
        Student student3 = repository.findById(id3).orElse(null);
        Student student4 = repository.findById(id4).orElse(null);
        assert student != null;
        student.setName(requestInsert.getName());
        student.setAge(requestInsert.getAge());
        student2.setName(requestInsert.getName());
        student2.setAge(requestInsert.getAge());
        student3.setName(requestInsert.getName());
        student3.setAge(requestInsert.getAge());
        student4.setName(requestInsert.getName());
        student4.setAge(requestInsert.getAge());
        List<Student> students = Arrays.asList(student, student2,student3, student4);

        Long idPerson = requestInsert.getId();
        Long idPerson2 = requestInsert.getId2();
        Person person2 = personRepository.findById(idPerson2).orElse(null);
        Person person = personRepository.findById(idPerson).orElse(null);
        Long idPerson3 = requestInsert.getId() +2;
        Long idPerson4 = requestInsert.getId2()+3;
        Person person3 = personRepository.findById(idPerson3).orElse(null);
        Person person4 = personRepository.findById(idPerson4).orElse(null);

        person.setName(requestInsert.getName());
        person.setAge(requestInsert.getAge());
        person2.setName(requestInsert.getName());
        person2.setAge(requestInsert.getAge());
        person3.setName(requestInsert.getName());
        person3.setAge(requestInsert.getAge());
        person4.setName(requestInsert.getName());
        person4.setAge(requestInsert.getAge());
        List<Person> persons = Arrays.asList(person, person2,person3, person4);

        List<Person> persons1 =   personRepository.saveAll(persons);
        System.out.println(persons1.size());
        return repository.saveAll(students);
    }

}
