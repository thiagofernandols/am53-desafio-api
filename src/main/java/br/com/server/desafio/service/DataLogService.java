package br.com.server.desafio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.server.desafio.model.DataLog;
import br.com.server.desafio.model.DataLogUI;
import br.com.server.desafio.repository.IDataLogRepository;

@Service
public class DataLogService implements IDataLogService {
  @Autowired
  IDataLogRepository repository;

  public void create(DataLogUI dataLog) {
    repository.save(new DataLog(dataLog.getData(), dataLog.getIp(), dataLog.getRequest(), dataLog.getStatus(),
        dataLog.getUserAgent()));
  }

  public void bulkCreate(List<DataLog> list) {
    repository.saveAll(list);
  }

  public void update(long id, DataLogUI dataLog) {
    DataLog dataLogBd = repository.findById(id).get();
    dataLogBd.setData(dataLog.getData());
    dataLogBd.setIp(dataLog.getIp());
    dataLogBd.setRequest(dataLog.getRequest());
    dataLogBd.setStatus(dataLog.getStatus());
    dataLogBd.setUserAgent(dataLog.getUserAgent());
    repository.save(dataLogBd);
  }

  public void delete(long id) {
    repository.deleteById(id);
  }

  public List<DataLogUI> findAll() {
    List<DataLog> dataLogs = repository.findAll();
    List<DataLogUI> returnList = new ArrayList<>();

    for (DataLog dataLog : dataLogs) {
      returnList.add(new DataLogUI(dataLog.getId(), dataLog.getData(), dataLog.getIp(), dataLog.getRequest(),
          dataLog.getStatus(), dataLog.getUserAgent()));
    }

    return returnList;
  }

  public DataLogUI findById(long id) {
    DataLog dataLog = repository.findById(id).get();
    return new DataLogUI(dataLog.getId(), dataLog.getData(), dataLog.getIp(), dataLog.getRequest(), dataLog.getStatus(),
        dataLog.getUserAgent());
  }

  public List<DataLogUI> findByIp(String ip) {
    List<DataLog> dataLogs = repository.findByIp(ip);
    List<DataLogUI> returnList = new ArrayList<>();

    for (DataLog dataLog : dataLogs) {
      returnList.add(new DataLogUI(dataLog.getId(), dataLog.getData(), dataLog.getIp(), dataLog.getRequest(),
          dataLog.getStatus(), dataLog.getUserAgent()));
    }

    return returnList;
  }

  public List<Object[]> countTotalRequestsByIp() {
    List<Object[]> list = repository.countTotalRequestsByIp();
    return list;
  }
  
  public List<Object[]> countTotalRequestsByHour() {
    List<Object[]> list = repository.countTotalRequestsByHour();
    return list;
  }

}