package com.datamoto.rest.client;

import java.util.HashMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class JerseyClientPost
{

	public static void main(String[] args)
	{

		try
		{

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:80/json/invoice/post");

			String input = "{\"companyId\":\"12345\",\"clientId\":\"444\",\"amountInvoiced\":\"44.40\"}";

			
			HashMap<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("companyId", "12123");
			hashmap.put("clientId", "877");
			hashmap.put("amountInvoiced", "56.09");
			Form form = new Form();
			form.add("invoice", hashmap);

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

			WebResource webResource1 = client.resource("http://localhost:80/json/invoice");

			MultivaluedMapImpl queryParams = new MultivaluedMapImpl();
			queryParams.add("company_id", "232");
			queryParams.add("invoice_id", "123");
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
