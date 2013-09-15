package com.datamoto.rest.client;

import java.io.Serializable;
import com.google.gson.annotations.Expose;

public class ApiKeyRequest implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Expose 
	private String username;
	@Expose 
	private String password;
	@Expose 
	private Long companyId;
	@Expose 
	private String apiKey;
	@Expose 
	private String authToken;
	@Expose 
	private String status;
	
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Long getCompanyId()
	{
		return companyId;
	}
	public void setCompanyId(Long companyId)
	{
		this.companyId = companyId;
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
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
}
