
package com.wsa500.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertCustomerResponse", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertCustomerResponse", namespace = "http://com.wsa500.server")
public class InsertCustomerResponse {

    @XmlElement(name = "return", namespace = "")
    private com.wsa500.entity.Customer _return;

    /**
     * 
     * @return
     *     returns Customer
     */
    public com.wsa500.entity.Customer getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.wsa500.entity.Customer _return) {
        this._return = _return;
    }

}
