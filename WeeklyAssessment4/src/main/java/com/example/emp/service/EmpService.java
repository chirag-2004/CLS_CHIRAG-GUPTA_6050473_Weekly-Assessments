package com.example.emp.service;

import java.util.List;
import com.example.emp.entity.Emp;

public interface EmpService {

    List<Emp> getAll();

    Emp getById(Integer id);

    void update(Emp emp);

    void delete(Integer id);
}