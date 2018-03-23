
package com.wsa500.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listCustomerSales", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listCustomerSales", namespace = "http://com.wsa500.server")
public class ListCustomerSales {

    @XmlElement(name = "customerLastName", namespace = "")
    private String customerLastName;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCustomerLastName() {
        return this.customerLastName;
    }

    /**
     * 
     * @param customerLastName
     *     the value for the customerLastName property
     */
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

}
