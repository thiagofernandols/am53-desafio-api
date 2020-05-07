package br.com.server.desafio.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.server.desafio.model.DataLog;
import br.com.server.desafio.service.IDataLogService;

@RestController
@CrossOrigin
@RequestMapping("upload")
public class UploadController {

  @Autowired
  IDataLogService service;

  @PostMapping()
  public String upload(@RequestParam("file") MultipartFile file) {
    try {
      this.saveUpload(file);
      return "Operation performed successfully!";

    } catch (IOException e) {
      return e.getMessage();
    }
  }

  private void saveUpload(MultipartFile file) throws IOException {
    List<DataLog> list = new ArrayList<>();
    byte[] bytes = file.getBytes();
    String content = new String(bytes);
    String[] rows = content.split("\n");
    for (int i = 0; i < rows.length; i++) {
      String[] columns = rows[i].split("\\|");
      Date date = null;
      try {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        date = formatter.parse(columns[0]);
        } catch (ParseException e) {
          e.printStackTrace();
      }
      list.add(new DataLog(date, columns[1], columns[2].replace("\"", ""), columns[3], columns[4].replace("\"", "")));
    }
    service.bulkCreate(list);
  }
}