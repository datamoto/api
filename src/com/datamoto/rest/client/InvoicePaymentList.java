package com.datamoto.rest.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;


public class InvoicePaymentList implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Expose
	private List<InvoicePayment> invoice = new ArrayList<InvoicePayment> ();

	@Expose
	private String apiKey;
	
	@Expose
	private String authToken;
	
	@Expose
	private String method;
	
	@Expose
	private Integer batchStart;
	
	@Expose
	private Integer batchCount;
	
	@Expose
	private Integer status;
	
	public String getApiKey()
	{
		return apiKey;
	}

	public void setApiKey(String apiKey)
	{
		this.apiKey = apiKey;
	}

	public String getAuthToken()
	{
		return authToken;
	}

	public void setAuthToken(String authToken)
	{
		this.authToken = authToken;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public InvoicePaymentList()
	{
	}

	public void setInvoicePayment(List<InvoicePayment> invoice)
	{
		this.invoice = invoice;
	}

	public List<InvoicePayment> getInvoicePayment()
	{
		return invoice;
	}

	public void addInvoicePayment(InvoicePayment invoice)
	{
		this.invoice.add(invoice);
	}

	public Integer getBatchStart()
	{
		return batchStart;
	}

	public void setBatchStart(Integer batchStart)
	{
		this.batchStart = batchStart;
	}

	public Integer getBatchCount()
	{
		return batchCount;
	}

	public void setBatchCount(Integer batchCount)
	{
		this.batchCount = batchCount;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
}
