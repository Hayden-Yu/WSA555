//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.22 at 08:25:42 PM EDT 
//


package com.wsa500.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.wsa500.endpoint.jaxws.*;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wsa500.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InsertProductResponse_QNAME = new QName("http://com.wsa500.server", "insertProductResponse");
    private final static QName _InsertCustomerResponse_QNAME = new QName("http://com.wsa500.server", "insertCustomerResponse");
    private final static QName _InsertProduct_QNAME = new QName("http://com.wsa500.server", "insertProduct");
    private final static QName _ListCustomerSales_QNAME = new QName("http://com.wsa500.server", "listCustomerSales");
    private final static QName _ListProduct_QNAME = new QName("http://com.wsa500.server", "listProduct");
    private final static QName _ListProductResponse_QNAME = new QName("http://com.wsa500.server", "listProductResponse");
    private final static QName _UpdateCustomer_QNAME = new QName("http://com.wsa500.server", "updateCustomer");
    private final static QName _UpdateCustomerResponse_QNAME = new QName("http://com.wsa500.server", "updateCustomerResponse");
    private final static QName _InsertCustomer_QNAME = new QName("http://com.wsa500.server", "insertCustomer");
    private final static QName _ListCustomerSalesResponse_QNAME = new QName("http://com.wsa500.server", "listCustomerSalesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wsa500.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertProductResponse }
     * 
     */
    public InsertProductResponse createInsertProductResponse() {
        return new InsertProductResponse();
    }

    /**
     * Create an instance of {@link ListProductResponse }
     * 
     */
    public ListProductResponse createListProductResponse() {
        return new ListProductResponse();
    }

    /**
     * Create an instance of {@link InsertCustomerResponse }
     * 
     */
    public InsertCustomerResponse createInsertCustomerResponse() {
        return new InsertCustomerResponse();
    }

    /**
     * Create an instance of {@link InsertProduct }
     * 
     */
    public InsertProduct createInsertProduct() {
        return new InsertProduct();
    }

    /**
     * Create an instance of {@link ListCustomerSales }
     * 
     */
    public ListCustomerSales createListCustomerSales() {
        return new ListCustomerSales();
    }

    /**
     * Create an instance of {@link ListProduct }
     * 
     */
    public ListProduct createListProduct() {
        return new ListProduct();
    }

    /**
     * Create an instance of {@link UpdateCustomer }
     * 
     */
    public UpdateCustomer createUpdateCustomer() {
        return new UpdateCustomer();
    }

    /**
     * Create an instance of {@link UpdateCustomerResponse }
     * 
     */
    public UpdateCustomerResponse createUpdateCustomerResponse() {
        return new UpdateCustomerResponse();
    }

    /**
     * Create an instance of {@link InsertCustomer }
     * 
     */
    public InsertCustomer createInsertCustomer() {
        return new InsertCustomer();
    }

    /**
     * Create an instance of {@link ListCustomerSalesResponse }
     * 
     */
    public ListCustomerSalesResponse createListCustomerSalesResponse() {
        return new ListCustomerSalesResponse();
    }

    /**
     * Create an instance of {@link Sale }
     * 
     */
    public Sale createSale() {
        return new Sale();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Time }
     * 
     */
    public Time createTime() {
        return new Time();
    }

    /**
     * Create an instance of {@link SalesRep }
     * 
     */
    public SalesRep createSalesRep() {
        return new SalesRep();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "insertProductResponse")
    public JAXBElement<InsertProductResponse> createInsertProductResponse(InsertProductResponse value) {
        return new JAXBElement<InsertProductResponse>(_InsertProductResponse_QNAME, InsertProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "insertCustomerResponse")
    public JAXBElement<InsertCustomerResponse> createInsertCustomerResponse(InsertCustomerResponse value) {
        return new JAXBElement<InsertCustomerResponse>(_InsertCustomerResponse_QNAME, InsertCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "insertProduct")
    public JAXBElement<InsertProduct> createInsertProduct(InsertProduct value) {
        return new JAXBElement<InsertProduct>(_InsertProduct_QNAME, InsertProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCustomerSales }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "listCustomerSales")
    public JAXBElement<ListCustomerSales> createListCustomerSales(ListCustomerSales value) {
        return new JAXBElement<ListCustomerSales>(_ListCustomerSales_QNAME, ListCustomerSales.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "listProduct")
    public JAXBElement<ListProduct> createListProduct(ListProduct value) {
        return new JAXBElement<ListProduct>(_ListProduct_QNAME, ListProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "listProductResponse")
    public JAXBElement<ListProductResponse> createListProductResponse(ListProductResponse value) {
        return new JAXBElement<ListProductResponse>(_ListProductResponse_QNAME, ListProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "updateCustomer")
    public JAXBElement<UpdateCustomer> createUpdateCustomer(UpdateCustomer value) {
        return new JAXBElement<UpdateCustomer>(_UpdateCustomer_QNAME, UpdateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "updateCustomerResponse")
    public JAXBElement<UpdateCustomerResponse> createUpdateCustomerResponse(UpdateCustomerResponse value) {
        return new JAXBElement<UpdateCustomerResponse>(_UpdateCustomerResponse_QNAME, UpdateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "insertCustomer")
    public JAXBElement<InsertCustomer> createInsertCustomer(InsertCustomer value) {
        return new JAXBElement<InsertCustomer>(_InsertCustomer_QNAME, InsertCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListCustomerSalesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.wsa500.server", name = "listCustomerSalesResponse")
    public JAXBElement<ListCustomerSalesResponse> createListCustomerSalesResponse(ListCustomerSalesResponse value) {
        return new JAXBElement<ListCustomerSalesResponse>(_ListCustomerSalesResponse_QNAME, ListCustomerSalesResponse.class, null, value);
    }

}
