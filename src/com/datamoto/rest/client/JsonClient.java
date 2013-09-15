package com.datamoto.rest.client;

import java.math.BigDecimal;
import java.util.Calendar;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JsonClient
{

	public static void main(String[] args)
	{

		try
		{

			Client client = Client.create();

			// Get the API Key and Auth token
			// You only do once... here I am doing repeatedly just for testing
			
			WebResource webResource = client.resource("http://localhost:80/json/apikeygen/post");
			
			ApiKeyRequest key = new ApiKeyRequest();
			key.setUsername("json@dm.com");
			key.setPassword("api123");
			key.setCompanyId(39L);
			
			String input = new Gson().toJson(key);
			System.out.println("sending key request: " + input);
			
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
			
			if (response.getStatus() != 200)
			{
				System.out.println("Failed : HTTP error code : " + response.getStatus());
			}
			else
			{
				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);				
				
				key = new Gson().fromJson(output, ApiKeyRequest.class);
			}
			
			if (key == null || key.getApiKey() == null || key.getAuthToken() == null)
			{
				System.out.println("No API keys to continue.... Exiting... \n");
				return;
			}
			
			// Get a batch of 100 draft and sent status invoices for the list of sales order ids.

			InvoiceList il = new InvoiceList();
			Query q1 = new Query();
			q1.setSalesOrderId(62L);
			il.addQuery(q1);
			Query q2 = new Query();
			q2.setSalesOrderId(63L);
			il.addQuery(q2);
			
			il.setApiKey(key.getApiKey());
			il.setAuthToken(key.getAuthToken());
			il.setMethod("getHeaderListFullfilled");
			
			
			String request = new Gson().toJson(il);
			System.out.println("Sending request for invoices =" +  request);
			
			webResource = client.resource("http://localhost:80/json/listinvoice/post");

			response = webResource.type("application/json").post(ClientResponse.class, request);
			InvoiceList im = null;
			if (response.getStatus() != 200)
			{
				System.out.println("Failed : HTTP error code : " + response.getStatus());
			}
			else
			{
				System.out.println("\nOutput from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);
				
				im = new Gson().fromJson(output, InvoiceList.class);

				for (int i=0; i<im.getInvoice().size(); i++)
				{
					System.out.println("Received: " + im.getInvoice().get(i).getInvoiceNumber() + ": " + im.getInvoice().get(i).getAmountInvoiced());
				}
			}
			
			// Say you process all these invoices. Every one paid there invoices in full.
			// Update the payment information in a batch
			
			if (im != null)
			{
				InvoicePaymentList ipl = new InvoicePaymentList ();
				
				for (int i=0; i<im.getInvoice().size(); i++)
				{
					Invoice inv = im.getInvoice().get(i);
					InvoicePayment ip = new InvoicePayment();
					ip.setClientId(inv.getClientId());
					ip.setClientName(inv.getClientName());
					ip.setDate(Calendar.getInstance().getTime());
					ip.setInvoiceId(inv.getInvoiceId());
					ip.setInvoiceNumber(inv.getInvoiceNumber());
					ip.setInvoiceStatus(6); // partial = 2, paid = 6
					ip.setPayment(inv.getAmountInvoiced().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
					ip.setPaymentMethod("Credit Card");					
					ipl.addInvoicePayment(ip);
				}
				if (ipl.getInvoicePayment().size() > 0)
				{
					ipl.setApiKey(key.getApiKey());
					ipl.setAuthToken(key.getAuthToken());
					ipl.setMethod("payList");
					request = new Gson().toJson(ipl);
					System.out.println("Sending request for invoices =" +  request);
					
					webResource = client.resource("http://localhost:80/json/listinvoicepay/post");

					response = webResource.type("application/json").post(ClientResponse.class, request);
					
					if (response.getStatus() != 200)
					{
						System.out.println("Failed : HTTP error code : " + response.getStatus());
					}
					else
					{
						System.out.println("Your payments are processed...");
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
