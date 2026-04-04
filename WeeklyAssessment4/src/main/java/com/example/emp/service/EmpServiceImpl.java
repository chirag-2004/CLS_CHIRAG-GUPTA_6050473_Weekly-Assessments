package com.example.emp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emp.entity.Emp;
import com.example.emp.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpRepository repo;

    public List<Emp> getAll() {
        return repo.findAll();
    }

    public Emp getById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void update(Emp emp) {
        repo.save(emp);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}