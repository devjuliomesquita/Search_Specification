package com.juliomesquita.jpaspecification.infra.persistence;

import com.juliomesquita.jpaspecification.infra.data.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //    Vamos criar buscar para o student de forma automática
    Optional<Student> findById(Long id); // Buscando um estudando pelo id

    Optional<Student> findByName(String name); // Buscando um estudando pelo nome

    List<Student> findByAddressCity(String city); // Buscando uma lista de estudantes pela cidade

    List<Student> findBySubjectsName(String name); // Buscando uma lista de estudantes pelo nome da matéria
}
