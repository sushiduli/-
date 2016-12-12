/**
 * SetProgramStatusRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public class SetProgramStatusRequest  implements java.io.Serializable {
    /* 节目代码 */
    private java.lang.String programCode;

    /* 0-未绑定，1-已绑定 */
    private int status;

    public SetProgramStatusRequest() {
    }

    public SetProgramStatusRequest(
           java.lang.String programCode,
           int status) {
           this.programCode = programCode;
           this.status = status;
    }


    /**
     * Gets the programCode value for this SetProgramStatusRequest.
     * 
     * @return programCode   * 节目代码
     */
    public java.lang.String getProgramCode() {
        return programCode;
    }


    /**
     * Sets the programCode value for this SetProgramStatusRequest.
     * 
     * @param programCode   * 节目代码
     */
    public void setProgramCode(java.lang.String programCode) {
        this.programCode = programCode;
    }


    /**
     * Gets the status value for this SetProgramStatusRequest.
     * 
     * @return status   * 0-未绑定，1-已绑定
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this SetProgramStatusRequest.
     * 
     * @param status   * 0-未绑定，1-已绑定
     */
    public void setStatus(int status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SetProgramStatusRequest)) return false;
        SetProgramStatusRequest other = (SetProgramStatusRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.programCode==null && other.getProgramCode()==null) || 
             (this.programCode!=null &&
              this.programCode.equals(other.getProgramCode()))) &&
            this.status == other.getStatus();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getProgramCode() != null) {
            _hashCode += getProgramCode().hashCode();
        }
        _hashCode += getStatus();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SetProgramStatusRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">setProgramStatusRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
