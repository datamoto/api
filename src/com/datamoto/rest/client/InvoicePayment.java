package com.datamoto.rest.client;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class InvoicePayment implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Expose
	private String apiKey;
	
	@Expose
	private String authToken;
	
	@Expose
	private String method;
	
	@Expose
	private Long id;
	@Expose
	private Long invoiceId;
	@Expose
	private Double payment;
	@Expose
	private String paymentMethod;
	@Expose
	private Date date;
	@Expose
	private String currency;
	@Expose
	private String note;
	@Expose
	private Integer alertEmail;
	@Expose
	private Integer type;
	@Expose
	private Double conversionRate;
	@Expose
	private Date conversionDate;
	@Expose
	private String invoiceNumber;
	@Expose
	private Double invoiceConversionRate;
	@Expose
	private String clientName;
	@Expose
	private Long clientId;
	@Expose
	private Date updateDate;
	@Expose
	private String updatedBy;
	@Expose
	private Integer invoiceStatus;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getInvoiceId()
	{
		return invoiceId;
	}
	public void setInvoiceId(Long invoiceId)
	{
		this.invoiceId = invoiceId;
	}
	public Double getPayment()
	{
		return payment;
	}
	public void setPayment(Double payment)
	{
		this.payment = payment;
	}
	public String getPaymentMethod()
	{
		return paymentMethod;
	}
	public void setPaymentMethod(String method)
	{
		this.paymentMethod = method;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public String getCurrency()
	{
		return currency;
	}
	public void setCurrency(String currency)
	{
		this.currency = currency;
	}
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public Integer getAlertEmail()
	{
		return alertEmail;
	}
	public void setAlertEmail(Integer alertEmail)
	{
		this.alertEmail = alertEmail;
	}
	public Integer getType()
	{
		return type;
	}
	public void setType(Integer type)
	{
		this.type = type;
	}
	public Double getConversionRate()
	{
		return conversionRate;
	}
	public void setConversionRate(Double conversionRate)
	{
		this.conversionRate = conversionRate;
	}
	public Date getConversionDate()
	{
		return conversionDate;
	}
	public void setConversionDate(Date conversionDate)
	{
		this.conversionDate = conversionDate;
	}
	public String getInvoiceNumber()
	{
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber)
	{
		this.invoiceNumber = invoiceNumber;
	}
	public Double getInvoiceConversionRate()
	{
		return invoiceConversionRate;
	}
	public void setInvoiceConversionRate(Double invoiceConversionRate)
	{
		this.invoiceConversionRate = invoiceConversionRate;
	}
	public String getClientName()
	{
		return clientName;
	}
	public void setClientName(String clientName)
	{
		this.clientName = clientName;
	}
	public Long getClientId()
	{
		return clientId;
	}
	public void setClientId(Long clientId)
	{
		this.clientId = clientId;
	}
	public Date getUpdateDate()
	{
		return updateDate;
	}
	public void setUpdateDate(Date updateDate)
	{
		this.updateDate = updateDate;
	}
	public String getUpdatedBy()
	{
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy)
	{
		this.updatedBy = updatedBy;
	}
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
	public Integer getInvoiceStatus()
	{
		return invoiceStatus;
	}
	public void setInvoiceStatus(Integer invoiceStatus)
	{
		this.invoiceStatus = invoiceStatus;
	}
}
