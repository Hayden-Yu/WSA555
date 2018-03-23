
package com.wsa500.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertProduct", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertProduct", namespace = "http://com.wsa500.server")
public class InsertProduct {

    @XmlElement(name = "product", namespace = "")
    private com.wsa500.entity.Product product;

    /**
     * 
     * @return
     *     returns Product
     */
    public com.wsa500.entity.Product getProduct() {
        return this.product;
    }

    /**
     * 
     * @param product
     *     the value for the product property
     */
    public void setProduct(com.wsa500.entity.Product product) {
        this.product = product;
    }

}
