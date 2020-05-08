package br.com.server.desafio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.server.desafio.model.DataLog;
import br.com.server.desafio.repository.IDataLogRepository;
import br.com.server.desafio.service.IDataLogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesafioApplicationTests {

	@Autowired
	private IDataLogService service;

	@MockBean
	private IDataLogRepository repository;

	@Test
	public void findAllTest() {
		when(repository.findAll()).thenReturn(Stream.of(
				new DataLog(1L, new Date(), "192.168.1.12", "GET / HTTP/1.1", "200",
						"swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"),
				new DataLog(2L, new Date(), "192.168.1.12", "GET / HTTP/1.1", "200",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393"))
				.collect(Collectors.toList()));
		assertEquals(2, service.findAll().size());
	}
	
	@Test
	public void findByIp() {
		when(repository.findByIp("192.168.1.12")).thenReturn(Stream.of(
				new DataLog(1L, new Date(), "192.168.1.12", "GET / HTTP/1.1", "200",
						"swcd (unknown version) CFNetwork/808.2.16 Darwin/15.6.0"),
				new DataLog(2L, new Date(), "192.168.1.12", "GET / HTTP/1.1", "200",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393"))
				.collect(Collectors.toList()));
		assertEquals(2, service.findByIp("192.168.1.12").size());
	}

	@Test
	public void delete() {
		service.delete(1L);
		verify(repository, times(1)).deleteById(1L);
	}
}
