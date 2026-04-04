package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.emp.dto.EmpDto;
import com.example.emp.entity.Emp;
import com.example.emp.service.EmpService;

@Controller
public class EmployeeController {

	@Autowired
	private EmpService service;

	@GetMapping("/viewall")
	public String viewAll(Model model) {
		List<Emp> list = service.getAll();
		model.addAttribute("emps", list);
		return "viewall";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {

		Emp emp = service.getById(id);

		EmpDto dto = new EmpDto();
		BeanUtils.copyProperties(emp, dto);

		model.addAttribute("emp", dto);

		return "edit";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("emp") EmpDto dto, BindingResult result, Model model) {
		if (result.hasErrors())
			return "edit";
		Emp emp = new Emp();
		BeanUtils.copyProperties(dto, emp);
		service.update(emp);
		model.addAttribute("msg", "Employee Edited");
		model.addAttribute("emps", service.getAll());
		return "viewall";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		service.delete(id);
		model.addAttribute("msg", "Employee Deleted");
		model.addAttribute("emps", service.getAll());
		return "viewall";
	}
}