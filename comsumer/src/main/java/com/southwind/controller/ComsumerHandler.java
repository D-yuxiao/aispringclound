package com.southwind.controller;

import com.southwind.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/comsumer")
public class ComsumerHandler {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        return restTemplate.getForEntity("http://localhost:8081/student/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Object findAll2(){
        return restTemplate.getForObject("http://localhost:8081/student/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Object findById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8081/student/findById/{id}",Object.class,id).getBody();
    }
    @GetMapping("/findById2/{id}")
    public Object findById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8081/student/findById/{id}",Student.class,id);
    }

    @PutMapping("/save")
    public void save(@RequestBody Student student){
        restTemplate.postForEntity("http://localhost:8081/student/save",student,null).getBody();
    }

    @PutMapping("/save2")
    public void save2(@RequestBody Student student){
        restTemplate.postForObject("http://localhost:8081/student/save",student,void.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student){
        restTemplate.put("http://localhost:8081/student/update",student);
    }

    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8081/student/deleteById/{id}",id);
    }
}
