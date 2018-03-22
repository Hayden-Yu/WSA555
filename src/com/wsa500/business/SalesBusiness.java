package com.wsa500.business;

import java.math.BigDecimal;
import java.util.List;

import com.wsa500.entity.*;

public interface SalesBusiness {
	List<Sale> listSalesByCustomerLastName(String lastName);
	List<Product> listProductByUnitPrice(BigDecimal unitPrice);
	List<Product> listProductByCost(BigDecimal cost);
	Customer persistCustomer(Customer customer);
	Customer modifyCustoemr(Customer customer);
	Product persistProduct(Product product);
}
