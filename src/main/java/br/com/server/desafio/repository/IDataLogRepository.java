package br.com.server.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.server.desafio.model.DataLog;

public interface IDataLogRepository extends JpaRepository<DataLog, Long> {
	List<DataLog> findByIp(String ip);
	List<DataLog> findAll();
	
	@Query(value = "select ip, count(*) from datalog group by ip order by count(*) desc limit 10", nativeQuery = true)
	List<Object[]> countTotalRequestsByIp();
	
	@Query(value = "select DATE_TRUNC('hour', data), count(*) from  datalog group by DATE_TRUNC('hour', data) order by DATE_TRUNC('hour', data) desc limit 10;", nativeQuery = true)
	List<Object[]> countTotalRequestsByHour();
}