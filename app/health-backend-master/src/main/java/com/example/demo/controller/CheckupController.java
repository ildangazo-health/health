package com.example.demo.controller;

import com.example.demo.model.check_up.Checkup;
import com.example.demo.model.check_up.CheckupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CheckupController {
    @Autowired
    private CheckupService checkupService;

    @GetMapping("/checkup/get-all")
    public List<Checkup> getAllCheckups(){
        return checkupService.getAllUCheckups();
    }

    @PostMapping("/checkup/save")
    public Checkup save(@RequestBody Checkup checkup){
        return checkupService.save(checkup);
    }
}
