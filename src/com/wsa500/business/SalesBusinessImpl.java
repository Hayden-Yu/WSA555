package com.wsa500.business;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
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
			this.dataSource = (DataSource) ctx.lookup("jdbc/wsa500_sales");
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
		LinkedList<Product> products = new LinkedList<Product>();
		try {
			ResultSet rs = executeQuery("SELECT * FROM `product` WHERE UnitPrice = ?", unitPrice);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setProductDescription(rs.getString("ProductDescription"));
				product.setUnitCost(rs.getBigDecimal("UnitCost"));
				product.setUnitPrice(rs.getBigDecimal("UnitPrice"));
				products.add(product);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> listProductByCost(BigDecimal cost) {
		LinkedList<Product> products = new LinkedList<Product>();
		try {
			ResultSet rs = executeQuery("SELECT * FROM `product` WHERE UnitCost = ?", cost);
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt("ProductID"));
				product.setProductName(rs.getString("ProductName"));
				product.setProductDescription(rs.getString("ProductDescription"));
				product.setUnitCost(rs.getBigDecimal("UnitCost"));
				product.setUnitPrice(rs.getBigDecimal("UnitPrice"));
				products.add(product);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return products;
	}

	@Override
	public Customer persistCustomer(Customer customer) {
		try {
			ResultSet rs = executeUpdate("INSERT INTO `customer` (`FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `Zip`, `Country`) VALUES" + 
				"(?, ?, ?, ?, ?, ?, ?, ?)", 
				customer.getFirstName(), 
				customer.getLastName(), 
				customer.getAddress1(), 
				customer.getAddress2(),
				customer.getCity(),
				customer.getState(),
				customer.getZip(),
				customer.getCountry());
				Integer id = null;
				if(rs.next())
	            {
	                id = rs.getInt(1);
	            }
				customer.setCustomerId(id);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer modifyCustoemr(Customer customer) {
		try {
			executeUpdate("UPDATE `customer` SET `FirstName` = ?, `LastName` = ?, `Address1` = ?, `Address2` = ?, `City` = ?, `State` = ?, `Zip` = ?, `Country` = ?" + 
				"WHERE `CustomerID` = ?",
				customer.getFirstName(), 
				customer.getLastName(), 
				customer.getAddress1(), 
				customer.getAddress2(),
				customer.getCity(),
				customer.getState(),
				customer.getZip(),
				customer.getCountry(),
				customer.getCustomerId());
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return customer;
	}

	@Override
	public Product persistProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private ResultSet executeQuery(String sql, Object...params) throws SQLException {
		Connection connection = null; 
		try {
			connection = dataSource.getConnection();
			return prepareStatement(connection, sql, params).executeQuery();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
	
	private ResultSet executeUpdate(String sql, Object...params) throws SQLException {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement stmt = prepareStatement(connection, sql, params);
			return stmt.getGeneratedKeys();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
		
	}
	
	private PreparedStatement prepareStatement(Connection connection, String sql, Object[] params) throws SQLException {
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
		return statement;
	}
	
}
