
package com.wsa500.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertCustomer", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertCustomer", namespace = "http://com.wsa500.server")
public class InsertCustomer {

    @XmlElement(name = "customer", namespace = "")
    private com.wsa500.entity.Customer customer;

    /**
     * 
     * @return
     *     returns Customer
     */
    public com.wsa500.entity.Customer getCustomer() {
        return this.customer;
    }

    /**
     * 
     * @param customer
     *     the value for the customer property
     */
    public void setCustomer(com.wsa500.entity.Customer customer) {
        this.customer = customer;
    }

}
