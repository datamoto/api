package com.datamoto.rest.client;

import java.io.Serializable;
import com.google.gson.annotations.Expose;

public class Query implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Expose
	private Long clientId;
	
	@Expose
	private String salesOrderNumber;

	@Expose
	private Long salesOrderId;
	
	public Long getClientId()
	{
		return clientId;
	}

	public void setClientId(Long clientId)
	{
		this.clientId = clientId;
	}

	public String getSalesOrderNumber()
	{
		return salesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber)
	{
		this.salesOrderNumber = salesOrderNumber;
	}

	public Long getSalesOrderId()
	{
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId)
	{
		this.salesOrderId = salesOrderId;
	}
	
}
