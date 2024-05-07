package com.udg.siiau.services;

import com.udg.siiau.models.StudentModel;
import com.udg.siiau.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    //CRUD

    public StudentModel saveStudent(StudentModel student){
        if(repository.findStudentModelByCoto(student.getCoto()).toString().equals("Optional[[]]")){
            return repository.save(student);
        }else{
            //retornar un error de repetido
            StudentModel studentError = new StudentModel();
                studentError.setId(-1L);
            return studentError;
        }



    }

    public ArrayList<StudentModel> getAllStudents(){
        return (ArrayList<StudentModel>) repository.findAll();
    }

    public Optional<StudentModel> findStudentById(Long id){
        return repository.findById(id);
    }



    public StudentModel editStudent(StudentModel student){
        return repository.save(student);
    }

    public String deleteStudentById(Long id){

        if(findStudentById(id).isPresent()){
            repository.deleteById(id);
            return "student deleted successfully";
        }else {
            return "student with id="+ id+ " not foud";
        }
    }

    public Optional<ArrayList<StudentModel>> findStudentByCoto(String coto){
        return repository.findStudentModelByCoto(coto);
    }
    public Optional<ArrayList<StudentModel>> findStudentByNombre(String nombre){
        return repository.findStudentModelByNombre(nombre);
    }
}
