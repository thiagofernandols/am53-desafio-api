package br.com.server.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.server.desafio.model.DataLogUI;
import br.com.server.desafio.service.IDataLogService;

@RestController
@CrossOrigin
@RequestMapping("log")
public class DataLogController {
  @Autowired
  IDataLogService service;

  @GetMapping()
  public List<DataLogUI> findAll() {
    List<DataLogUI> dataLogUI = service.findAll();    
    return dataLogUI;
  }

  @GetMapping("/{id}")
  public DataLogUI findById(@PathVariable long id) {
    DataLogUI dataLogUI = service.findById(id);    
    return dataLogUI;
  }

  @GetMapping("/ip/{ip}")
  public List<DataLogUI> findByIp(@PathVariable String ip) {
    List<DataLogUI> dataLogUI = service.findByIp(ip);    
    return dataLogUI;
  }

  @PostMapping()
  public String create(@RequestBody DataLogUI dataLog) {
    service.create(dataLog);

    return "Operation performed successfully!";
  }

  @PutMapping("/{id}")
  public String update(@PathVariable long id, @RequestBody DataLogUI dataLog) {
    service.update(id, dataLog);

    return "Operation performed successfully!";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable long id) {
    service.delete(id);

    return "Operation performed successfully!";
  }

  @GetMapping("/counttotalrequestsbyip")
  public List<Object[]> countTotalRequestsByIp() {
    List<Object[]> list = service.countTotalRequestsByIp();  
    return list;
  }

  @GetMapping("/counttotalrequestsbyhour")
  public List<Object[]> countTotalRequestsByHour() {
    List<Object[]> list = service.countTotalRequestsByHour();  
    return list;
  }
}