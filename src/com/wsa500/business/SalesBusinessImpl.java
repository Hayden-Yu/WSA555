package com.wsa500.business;

import java.math.BigDecimal;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.wsa500.entity.Customer;
import com.wsa500.entity.Product;
import com.wsa500.entity.Sale;

public class SalesBusinessImpl implements SalesBusiness {

	private DataSource dataSource;
	
	public SalesBusinessImpl() {
		try {
			InitialContext ctx = new InitialContext();
			this.dataSource = (DataSource) ctx.lookup("jdbc/Mysql_wsa500");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Sale> listSalesByCustomerLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByUnitPrice(BigDecimal unitPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> listProductByCost(BigDecimal cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer persistCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer modifyCustoemr(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product persistProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
