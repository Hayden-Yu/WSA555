
package com.wsa500.endpoint.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "insertProductResponse", namespace = "http://com.wsa500.server")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertProductResponse", namespace = "http://com.wsa500.server")
public class InsertProductResponse {

    @XmlElement(name = "return", namespace = "")
    private com.wsa500.entity.Product _return;

    /**
     * 
     * @return
     *     returns Product
     */
    public com.wsa500.entity.Product getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.wsa500.entity.Product _return) {
        this._return = _return;
    }

}
