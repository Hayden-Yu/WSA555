
package com.wsa500.endpoint.jaxws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listProduct", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listProduct", namespace = "http://com.wsa500.server", propOrder = {
    "cost",
    "unitPrice"
})
public class ListProduct {

    @XmlElement(name = "cost", namespace = "")
    private BigDecimal cost;
    @XmlElement(name = "unitPrice", namespace = "")
    private BigDecimal unitPrice;

    /**
     * 
     * @return
     *     returns BigDecimal
     */
    public BigDecimal getCost() {
        return this.cost;
    }

    /**
     * 
     * @param cost
     *     the value for the cost property
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * 
     * @return
     *     returns BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    /**
     * 
     * @param unitPrice
     *     the value for the unitPrice property
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

}
