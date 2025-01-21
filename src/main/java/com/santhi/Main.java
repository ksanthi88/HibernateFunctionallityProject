package com.santhi;

import com.santhi.repository.HQLQueries;
import com.santhi.service.StudentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //StudentService studentService = new StudentService();
       // StudentService.createTable();
        //StudentService.addStudent();
        //StudentService.findStudent();
        //StudentService.updateStudent();
       // StudentService.deleteStudent();
        HQLQueries.getStudents();
    }
}