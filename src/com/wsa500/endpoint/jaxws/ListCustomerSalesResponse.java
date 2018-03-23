
package com.wsa500.endpoint.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listCustomerSalesResponse", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listCustomerSalesResponse", namespace = "http://com.wsa500.server")
public class ListCustomerSalesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.wsa500.entity.Sale> _return;

    /**
     * 
     * @return
     *     returns List<Sale>
     */
    public List<com.wsa500.entity.Sale> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.wsa500.entity.Sale> _return) {
        this._return = _return;
    }

}
