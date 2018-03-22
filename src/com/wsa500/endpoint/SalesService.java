package com.wsa500.endpoint;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.wsa500.business.SalesBusiness;
import com.wsa500.business.SalesBusinessImpl;
import com.wsa500.entity.Customer;
import com.wsa500.entity.ListProductRequest;
import com.wsa500.entity.ListProductResponse;
import com.wsa500.entity.ListSalesResponse;
import com.wsa500.entity.ObjectFactory;
import com.wsa500.entity.Product;
import com.wsa500.entity.Sale;

@WebService(
	portName = "SalesPort",
	serviceName = "SalesService",
	targetNamespace = "http://com.wsa500.server",
	wsdlLocation = "WEB-INF/wsdl/SalesPorts.wsdl"
)
public class SalesService {
	private final SalesBusiness businessService;
	private final ObjectFactory objectFactory;
	
 	public SalesService() {
		this.businessService = new SalesBusinessImpl();
		this.objectFactory = new ObjectFactory();
	}
	
	@WebMethod(action = "listCustomerSales")
	public ListSalesResponse listCustomerSales(
		@WebParam(name = "customerLastName") String lastName) {
		ListSalesResponse response =  new ListSalesResponse();
		List<Sale> sales = businessService.listSalesByCustomerLastName(lastName);
		if (sales != null) {
			for (Sale sale: sales) {
				response.getSales().add(sale);
			}
		}
		return response;
	}
	
	@WebMethod(action = "listProduct")
	public ListProductResponse listProduct(
		@WebParam(name = "listProductRequest") ListProductRequest request) {
		ListProductResponse response = new ListProductResponse();
		List<Product> products;
		if (request.getUnitCost() != null) {
			products = businessService.listProductByCost(request.getUnitCost());
		} else {
			products = businessService.listProductByUnitPrice(request.getUnitPrice());
		}
		if (products != null) {
			for (Product product: products) {
				response.getProducts().add(product);
			}
		}
		return response;
	}
	
	@WebMethod(action = "insertCustomer")
	public Customer insertCustomer(
		@WebParam(name = "customer") Customer request) {
		return businessService.persistCustomer(request);
	}
	
	@WebMethod(action = "updateCustomer")
	public Customer updateCustomer(
		@WebParam(name = "customer") Customer request) {
		return businessService.modifyCustoemr(request);
	}
	
	@WebMethod(action = "insertProduct")
	public Product insertProduct(
		@WebParam(name = "product") Product request) {
		return businessService.persistProduct(request);
	}
}
