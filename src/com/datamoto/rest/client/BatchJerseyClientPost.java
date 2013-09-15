package com.datamoto.rest.client;

import java.math.BigDecimal;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class BatchJerseyClientPost
{

	public static void main(String[] args)
	{

		try
		{

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:80/json/listinvoice/post");

			//String input = "{\"invoice\": [{\"companyId\":\"12345\",\"clientId\":\"444\",\"amountInvoiced\":\"44.40\"}]}";
			//System.out.println("sending:" + input);

			InvoiceList invMdl = new InvoiceList();
			Invoice inv = new Invoice();
			inv.setCompanyId(1234L);
			inv.setClientId(444L);
			inv.setAmountInvoiced(new BigDecimal("44.40"));
			invMdl.addInvoice(inv);
			
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			String json = gson.toJson(invMdl);
			System.out.println("json=" +  json);
			
			
			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

			if (response.getStatus() != 200)
			{
				System.out.println("Failed : HTTP error code : " + response.getStatus());
			}
			else
			{
				System.out.println("Output from Server .... \n");
				String output = response.getEntity(String.class);
				System.out.println(output);
				System.out.println("Output from Server ...converting to object... \n");
				
				InvoiceList im = new Gson().fromJson(output, InvoiceList.class);
				for (int i=0; i<im.getInvoice().size(); i++)
				{
					//System.out.println(im.getInvoice().get(i).getAmountPaid());
				}
			}
			/*
			 * WebResource resource = client.resource(
			 * "http://localhost:8080/CustomerService/rest/customers");
			 * List<Customer> customers =
			 * resource.path("/findCustomersByCity/Any%20Town"
			 * ).accept("application/json").get(new
			 * GenericType<List<Customer>>(){});
			 * 
			 * for(Customer customer : customers) {
			 * System.out.println(customer.getFirstName()); }
			 * 
			 * Read more:
			 * http://www.javacodegeeks.com/2012/04/moxy-as-your-jax-rs
			 * -json-provider_18.html#ixzz1uzMRJ5uW
			 * 
			 * http://www.javacodegeeks.com/2012/04/moxy-as-your-jax-rs-json-
			 * provider_18.html
			 */

			WebResource webResource1 = client.resource("http://localhost:80/json/listinvoice");

			MultivaluedMapImpl queryParams = new MultivaluedMapImpl();
			queryParams.add("company_id", "232");			
			String s = webResource1.queryParams(queryParams).get(String.class);
			System.out.println(s);
			/*
			 * ClientResponse response1 =
			 * webResource1.accept("application/json")
			 * .get(ClientResponse.class);
			 * 
			 * if (response1.getStatus() != 200) { throw new
			 * RuntimeException("Failed : HTTP error code : " +
			 * response1.getStatus()); }
			 * 
			 * output = response1.getEntity(String.class);
			 * 
			 * System.out.println("Output from Server .... \n");
			 * System.out.println(output);
			 */
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}
}
