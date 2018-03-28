package com.wsa500.endpoint;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.wsa500.business.SalesBusiness;
import com.wsa500.business.SalesBusinessImpl;
import com.wsa500.entity.Customer;
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
	
 	public SalesService() {
		this.businessService = new SalesBusinessImpl();
	}
	
	@WebMethod(action = "listCustomerSales")
	public List<Sale> listCustomerSales(
		@WebParam(name = "customerLastName") String lastName) {
		return businessService.listSalesByCustomerLastName(lastName);
	}
	
	@WebMethod(action = "listProduct")
	public List<Product> listProduct(
		@WebParam(name = "cost") BigDecimal cost,
		@WebParam(name = "unitPrice") BigDecimal unitPrice) {
		if (cost != null) {
			return businessService.listProductByCost(cost);
		} else {
			return businessService.listProductByUnitPrice(unitPrice);
		}
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
