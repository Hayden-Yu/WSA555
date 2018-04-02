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
import com.wsa500.entity.SalesRep;
import com.wsa500.entity.Time;

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
		LinkedList<Sale> sales = new LinkedList<>();
		try {
			ResultSet rs = executeQuery(
				"SELECT SalesAmount, Customer.CustomerID, Customer.FirstName AS CSFirstName, Customer.LastName AS CSLastName, " + 
				"Customer.Address1 AS CSAddress1, Customer.Address2 AS CSAddress2, Customer.City AS CSCity, " + 
				"Customer.State AS CSState, Customer.Zip AS CSZip, Customer.Country AS CSCountry, `Year`, `Quarter`, " + 
				"`Month`, `Week`, Product.ProductID, ProductName, ProductDescription, UnitPrice, UnitCost, SalesRep.SalesRepID, " + 
				"SalesRep.FirstName AS SRFirstName, SalesRep.LastName AS SRLastName, SalesRep.Address1 AS SRAddress1, " + 
				"SalesRep.Address2 AS SRAddress2, SalesRep.City AS SRCity, SalesRep.State AS SRState, SalesRep.Zip AS SRZip, " + 
				"SalesRep.Zip AS SRZip, SalesRep.Country AS SRCountry " + 
				"FROM Sales " + 
				"JOIN Customer ON Sales.CustomerID = Customer.CustomerID " + 
				"JOIN `Time` ON Sales.TimeID = `Time`.TimeID " + 
				"JOIN Product ON Sales.ProductID = Product.ProductID " + 
				"JOIN SalesRep ON Sales.SalesRepID = SalesRep.SalesRepID " + 
				"WHERE Customer.LastName = ?", lastName);
			while(rs.next()) {
				Sale sale = new Sale();
				sale.setSalesAmount(rs.getBigDecimal("SalesAmount"));
				
				sale.setCustomer(new Customer());
				sale.getCustomer().setCustomerId(rs.getInt("CustomerID"));
				sale.getCustomer().setFirstName(rs.getString("CSFirstName"));
				sale.getCustomer().setLastName(rs.getString("CSLastName"));
				sale.getCustomer().setAddress1(rs.getString("CSAddress1"));
				sale.getCustomer().setAddress2(rs.getString("CSAddress2"));
				sale.getCustomer().setCity(rs.getString("CSCity"));
				sale.getCustomer().setState(rs.getString("CSState"));
				sale.getCustomer().setZip(rs.getString("CSZip"));
				sale.getCustomer().setCountry(rs.getString("CSCountry"));
				
				sale.setSalesRep(new SalesRep());
				sale.getSalesRep().setSalesRepId(rs.getInt("SalesRepID"));
				sale.getSalesRep().setFirstName(rs.getString("SRFirstName"));
				sale.getSalesRep().setLastName(rs.getString("SRLastName"));
				sale.getSalesRep().setAddress1(rs.getString("SRAddress1"));
				sale.getSalesRep().setAddress2(rs.getString("SRAddress2"));
				sale.getSalesRep().setCity(rs.getString("SRCity"));
				sale.getSalesRep().setState(rs.getString("SRState"));
				sale.getSalesRep().setZip(rs.getString("SRZip"));
				sale.getSalesRep().setCountry(rs.getString("SRCountry"));
				
				sale.setProduct(new Product());
				sale.getProduct().setProductId(rs.getInt("ProductID"));
				sale.getProduct().setProductName(rs.getString("ProductName"));
				sale.getProduct().setProductDescription(rs.getString("ProductDescription"));
				sale.getProduct().setUnitCost(rs.getBigDecimal("UnitCost"));
				sale.getProduct().setUnitPrice(rs.getBigDecimal("UnitPrice"));
				
				sale.setTime(new Time());
				sale.getTime().setYear(rs.getString("Year"));
				sale.getTime().setQuarter(rs.getString("Quarter"));
				sale.getTime().setMonth(rs.getString("Month"));
				sale.getTime().setWeek(rs.getString("Week"));
				
				sales.add(sale);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return sales;
	}

	@Override
	public List<Product> listProductByUnitPrice(BigDecimal unitPrice) {
		LinkedList<Product> products = new LinkedList<Product>();
		try {
			ResultSet rs = executeQuery("SELECT * FROM `Product` WHERE UnitPrice = ?", unitPrice);
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
			ResultSet rs = executeQuery("SELECT * FROM `Product` WHERE UnitCost = ?", cost);
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
			ResultSet rs = executeUpdate("INSERT INTO `Customer` (`FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `Zip`, `Country`) VALUES " + 
				"(?, ?, ?, ?, ?, ?, ?, ?)", 
				customer.getFirstName(), 
				customer.getLastName(), 
				customer.getAddress1(), 
				customer.getAddress2(),
				customer.getCity(),
				customer.getState(),
				customer.getZip(),
				customer.getCountry());
				if(rs != null && rs.next())
	            {
					customer.setCustomerId(rs.getInt(1));
	            }
				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return customer;
	}

	@Override
	public Customer modifyCustoemr(Customer customer) {
		try {
			executeUpdate("UPDATE `Customer` SET `FirstName` = ?, `LastName` = ?, `Address1` = ?, `Address2` = ?, `City` = ?, `State` = ?, `Zip` = ?, `Country` = ?" + 
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
		try {
			ResultSet rs = executeUpdate("INSERT INTO `Product` (`ProductName`, `ProductDescription`, `UnitPrice`, `UnitCost`) VALUES " + 
				"(?, ?, ?, ?)", 
				product.getProductName(),
				product.getProductDescription(),
				product.getUnitPrice(),
				product.getUnitCost());
				if(rs != null && rs.next())
	            {
					product.setProductId(rs.getInt(1));
	            }
				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return product;
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
			stmt.executeUpdate();
			return stmt.getGeneratedKeys();
		}
		finally {
			if (connection != null) {
				connection.close();
			}
		}
		
	}
	
	private PreparedStatement prepareStatement(Connection connection, String sql, Object[] params) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
