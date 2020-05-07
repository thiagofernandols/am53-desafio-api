package br.com.server.desafio.service;

import java.util.List;

import br.com.server.desafio.model.DataLog;
import br.com.server.desafio.model.DataLogUI;

public interface IDataLogService {

  void create(DataLogUI dataLog);

  void bulkCreate(List<DataLog> list);

  void update(long id, DataLogUI dataLog);

  void delete(long id);

  List<DataLogUI> findAll();

  DataLogUI findById(long id);

  List<DataLogUI> findByIp(String ip);

  List<Object[]> countTotalRequestsByIp();

  List<Object[]> countTotalRequestsByHour();

}