package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emp.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
