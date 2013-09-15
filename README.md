api
===

REST APIs for Datamoto Online Order Management Software

Datamoto REST APIs provides following: 

a. Invoice and Billing

Create, track and manage quote, invoice and payment online. Recurring invoice, foreign currency, PDF, and Email support. 

b. Sales Order Management 

Create sales order, fulfill order, split orders, handle return and cancel. Full cycles of quote to order and order to invoice are supported. 


To get access to these API, you first need to be a registered user of the Datamoto. Then you can create a App key and use the APP key for login.

You can also find some of the detail at http://datamoto.com


API Functional Spec:
--------------------

1) Two points of entries:
	http://datamoto.com/json/api/<module>
	http://datamoto.com/xml/api/<module>
	
2) Security
	- communcation is based on API key and auth token.
	- user first need to generate these by logging in to the account.
	- api key and auth toke must present in all communcation with the server.
	- api key works as username+companyid and auth token works as password.
	- api key and auth token can only be used from API not from datanoto application/web site.

3) REST API 
	- json is supported
	- xml is supported	
	
4) Request in json or xml format
   - api key
   - auth token
   - method (e.g., get, add, update, create, getList etc.)
   - actual request
   
5) Supported methods  (<module> method name)
	- <listinvoice> getList : returns list of invoices for the companyId (companyId is extract by datamoto from api key - nothing is supply in the API)
	- <listinvoice> getListByStatus : returns list of invoices for the matching status	(must supply status)
	- <listinvoice> updateList: update all the invoices and return success or failure. Update in done in the transaction. (must supply invoiceIds)	
	- <invoice> get : return a invoice (must supply invoiceId)
	- <invoice> update : update and return the invoice (must supply invoiceId)
    - <invoiceprofile> get
	- <invoiceprofile> generateInvoiceNow
	- <invoiceprofile> close
	
	- <payment> add : add a new payment for an invoice. (must supply invoiceId)
	- <payment> update : update a payment for an invoice (must supply invoiceId and paymentId)
	
	- <salesorderprofile> create : create a sales order profile (must supply clientId)
	- <salesorderprofile> update : update a sales order profile (must supply clientId, soId)
	- <salesorderprofile> close  : close a sales order profile (must supply clientId, soId)
	- <salesorderprofile> generateOrderNow  : generates a sales order immediately (must supply clientId, soId)
	- <salesorderprofile> process : checks the profile and if required it will generate sales order or close the profile or simply do nothing (must supply clientId, soId)
	
	
Design:
	com.billing.menu.api.model : put all the model classes such as Invoice, BatchInvoice, InvoiceProfile, Payment, Salesorder, SalesorderProfile. These classes are strip down versions of the 
	DAO objects. These objects will only reflect the customer data - not the referrential or internal information of the business logic.
	
	com.billing.menu.api : put all the common classes needed to link json/xml and wicket model. This also contains two web pages (for json and xml) to route the call 
	
	com.billing.menu.api.invoice : this will contains actual implementation of the service and handler of post method for json and xml. The Helper is the main class who deciphers and makes appropriate 
	calls according to the method name. It also checks the credentials and verifies the security.
	
