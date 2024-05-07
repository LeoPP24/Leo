package com.udg.siiau.controllers;

import com.udg.siiau.models.StudentModel;
import com.udg.siiau.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return service.saveStudent(student);
    }

    @PutMapping()
    public StudentModel editStudent(@RequestBody StudentModel student){
        return service.editStudent(student);
    }

    @GetMapping()
    public ArrayList<StudentModel> getAllStudents(){
        return service.getAllStudents();
    }


    @GetMapping("/findStudentById/{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return service.findStudentById(id);
    }

    @GetMapping("/findStudentByCoto/{coto}")
    public Optional<ArrayList<StudentModel>> finStudentByCoto(@PathVariable String coto){
        return service.findStudentByCoto(coto);
    }


    @GetMapping("/findStudentByNombre/{nombre}")
    public Optional<ArrayList<StudentModel>> finStudentByNombre(@PathVariable String nombre){
        return service.findStudentByNombre(nombre);
    }
    @DeleteMapping("/delete-student-by-id")
    public String deleteStudentById(@RequestParam("id") Long id){
        return service.deleteStudentById(id);
    }


}
