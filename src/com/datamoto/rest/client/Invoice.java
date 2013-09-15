package com.datamoto.rest.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import com.google.gson.annotations.Expose;

public class Invoice implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Expose
	private String apiKey;
	
	@Expose
	private String authToken;
	
	@Expose
	private String method;
	
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
	
	@Expose
	private Long companyId;
	@Expose
	private Long clientId;
	@Expose
	private String clientName;
	@Expose
	private Long invoiceId;
	@Expose
	private String invoiceNumber;
	@Expose
	private BigDecimal amountInvoiced;
	@Expose
	private BigDecimal outstandingAmount;
	@Expose
	private Date invoiceDate;
	@Expose
	private String currencyCode;
	@Expose
	private Double exchangeRate;
	@Expose
	private Date exchangeRateDate;
	@Expose
	private Integer status;
	@Expose
	private String purchaseOrderNumber;
	@Expose
	private Long salesOrderId;
	@Expose
	private String salesOrderNumber;
	
	public BigDecimal getAmountInvoiced()
	{
		return amountInvoiced;
	}
	public void setAmountInvoiced(BigDecimal amountInvoiced)
	{
		this.amountInvoiced = amountInvoiced;
	}
	public Date getInvoiceDate()
	{
		return invoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate)
	{
		this.invoiceDate = invoiceDate;
	}
	public Long getCompanyId()
	{
		return companyId;
	}
	public void setCompanyId(Long companyId)
	{
		this.companyId = companyId;
	}
	public Long getClientId()
	{
		return clientId;
	}
	public void setClientId(Long clientId)
	{
		this.clientId = clientId;
	}
	public String getClientName()
	{
		return clientName;
	}
	public void setClientName(String clientName)
	{
		this.clientName = clientName;
	}
	public Long getInvoiceId()
	{
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId)
	{
		this.invoiceId = invoiceId;
	}
	public String getInvoiceNumber()
	{
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber)
	{
		this.invoiceNumber = invoiceNumber;
	}
	public BigDecimal getOutstandingAmount()
	{
		return outstandingAmount;
	}
	public void setOutstandingAmount(BigDecimal outstandingAmount)
	{
		this.outstandingAmount = outstandingAmount;
	}
	public String getCurrencyCode()
	{
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode)
	{
		this.currencyCode = currencyCode;
	}
	public Double getExchangeRate()
	{
		return exchangeRate;
	}
	public void setExchangeRate(Double exchangeRate)
	{
		this.exchangeRate = exchangeRate;
	}
	public Date getExchangeRateDate()
	{
		return exchangeRateDate;
	}
	public void setExchangeRateDate(Date exchangeRateDate)
	{
		this.exchangeRateDate = exchangeRateDate;
	}
	public Integer getStatus()
	{
		return status;
	}
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	public String getPurchaseOrderNumber()
	{
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber)
	{
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public Long getSalesOrderId()
	{
		return salesOrderId;
	}
	public void setSalesOrderId(Long salesOrderId)
	{
		this.salesOrderId = salesOrderId;
	}
	public String getSalesOrderNumber()
	{
		return salesOrderNumber;
	}
	public void setSalesOrderNumber(String salesOrderNumber)
	{
		this.salesOrderNumber = salesOrderNumber;
	}	
}
