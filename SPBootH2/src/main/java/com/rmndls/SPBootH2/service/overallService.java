package com.rmndls.SPBootH2.service;

import com.rmndls.SPBootH2.model.*;
import com.rmndls.SPBootH2.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class overallService {
    private mathematicsRepo mathematicsRepo;
    private chemistryRepo chemistryRepo;
    private physicsRepo physicsRepo;
    private studentRepo studentRepo;

    public void addStudent(student s){
        studentRepo.save(s);
    }

    public void mathsMarks(mathematics m){
        mathematicsRepo.save(m);
    }

    public void chemMarks(chemistry c){
        chemistryRepo.save(c);
    }

    public void physMarks(physics p){ physicsRepo.save(p); }

    public List<student> getStudents() {

        return studentRepo.findAll();
    }

    public List<mathematics> getMathMarks() {

        return mathematicsRepo.findAll();
    }

    public List<physics> getPhyMarks() {

        return physicsRepo.findAll();
    }

    public List<chemistry> getChemMarks() {

        return chemistryRepo.findAll();
    }

    @Autowired
    public void setMathematicsRepo(mathematicsRepo mathematicsRepo) {
        this.mathematicsRepo = mathematicsRepo;
    }

    @Autowired
    public void setChemistryRepo(chemistryRepo chemistryRepo) {
        this.chemistryRepo = chemistryRepo;
    }

    @Autowired
    public void setPhysicsRepo(physicsRepo physicsRepo) {
        this.physicsRepo = physicsRepo;
    }

    @Autowired
    public void setStudentRepo(studentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
}
