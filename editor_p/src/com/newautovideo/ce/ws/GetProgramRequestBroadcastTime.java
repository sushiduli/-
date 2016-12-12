/**
 * GetProgramRequestBroadcastTime.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public class GetProgramRequestBroadcastTime  implements java.io.Serializable {
    /* 播出时间（单位：帧） */
    private long start;

    /* 播出时间（单位：帧） */
    private long end;

    public GetProgramRequestBroadcastTime() {
    }

    public GetProgramRequestBroadcastTime(
           long start,
           long end) {
           this.start = start;
           this.end = end;
    }


    /**
     * Gets the start value for this GetProgramRequestBroadcastTime.
     * 
     * @return start   * 播出时间（单位：帧）
     */
    public long getStart() {
        return start;
    }


    /**
     * Sets the start value for this GetProgramRequestBroadcastTime.
     * 
     * @param start   * 播出时间（单位：帧）
     */
    public void setStart(long start) {
        this.start = start;
    }


    /**
     * Gets the end value for this GetProgramRequestBroadcastTime.
     * 
     * @return end   * 播出时间（单位：帧）
     */
    public long getEnd() {
        return end;
    }


    /**
     * Sets the end value for this GetProgramRequestBroadcastTime.
     * 
     * @param end   * 播出时间（单位：帧）
     */
    public void setEnd(long end) {
        this.end = end;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetProgramRequestBroadcastTime)) return false;
        GetProgramRequestBroadcastTime other = (GetProgramRequestBroadcastTime) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.start == other.getStart() &&
            this.end == other.getEnd();
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
        _hashCode += new Long(getStart()).hashCode();
        _hashCode += new Long(getEnd()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetProgramRequestBroadcastTime.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">>getProgramRequest>BroadcastTime"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("start");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Start"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("end");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "End"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
