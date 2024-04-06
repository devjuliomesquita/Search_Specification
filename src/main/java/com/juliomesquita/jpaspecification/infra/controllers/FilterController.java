package com.juliomesquita.jpaspecification.infra.controllers;

import com.juliomesquita.jpaspecification.infra.data.entities.Student;
import com.juliomesquita.jpaspecification.infra.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filter")
@RequiredArgsConstructor
public class FilterController {
    private final StudentRepository studentRepository;

    @GetMapping("/{name}")
    public ResponseEntity<Student> getStdByName(@PathVariable(name = "name") String name){
        Student student = this.studentRepository.findByName(name)
                .orElseThrow();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/{city}/city")
    public ResponseEntity<List<Student>> getStdByCity(@PathVariable(name = "city") String city){
        return new ResponseEntity<>(this.studentRepository.findByAddressCity(city), HttpStatus.OK);
    }

    @GetMapping("/{name}/subject")
    public ResponseEntity<List<Student>> getStdBySujectName(@PathVariable(name = "name") String name){
        return new ResponseEntity<>(this.studentRepository.findBySubjectsName(name), HttpStatus.OK);
    }
}
