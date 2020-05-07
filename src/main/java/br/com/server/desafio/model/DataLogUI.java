package br.com.server.desafio.model;

import java.util.Date;


public class DataLogUI {
 
	private long id;
 
	private Date data;
 
	private String ip;
 
	private String request;
 
	private String status;
 
	private String userAgent;
	
	protected DataLogUI() {
	}
 
	public DataLogUI(Date data, String ip, String request, String status, String userAgent) {
		this.data = data;
		this.ip = ip;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}
 
	public DataLogUI(long id, Date data, String ip, String request, String status, String userAgent) {
		this.id = id;
		this.data = data;
		this.ip = ip;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}
	
	public long getId() {
		return this.id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequest() {
		return this.request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}	
}