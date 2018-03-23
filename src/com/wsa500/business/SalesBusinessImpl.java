package com.wsa500.business;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	
	private ResultSet executeSQL(String sql, Object...params) throws SQLException {
		Connection connection = null; 
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof String) {
					statement.setString(i + 1, (String)params[i]);
				}
				else if (params[i] instanceof BigDecimal) {
					statement.setBigDecimal(i + 1, (BigDecimal)params[i]);
				}
				else if (params[i].getClass() == int.class ||
						params[i] instanceof Integer) {
					statement.setInt(i + 1, (int)params[i]);
				} else {
					throw new RuntimeException(
						"Type " + params[i].getClass() + " is not yet supported");
				}
			}
			return statement.executeQuery();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
