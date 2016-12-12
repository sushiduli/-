/**
 * GetProgramRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public class GetProgramRequest  implements java.io.Serializable {
    /* 播出日期 */
    private java.util.Date broadcastDate;

    private com.newautovideo.ce.ws.GetProgramRequestBroadcastTime broadcastTime;

    /* 频道名称 */
    private java.lang.String channelName;

    /* 栏目名称 */
    private java.lang.String column;

    /* 节目名称 */
    private java.lang.String programName;

    /* 节目类型：无、广告类、导视类 */
    private java.lang.String programType;

    /* 节目代码 */
    private java.lang.String programCode;

    public GetProgramRequest() {
    }

    public GetProgramRequest(
           java.util.Date broadcastDate,
           com.newautovideo.ce.ws.GetProgramRequestBroadcastTime broadcastTime,
           java.lang.String channelName,
           java.lang.String column,
           java.lang.String programName,
           java.lang.String programType,
           java.lang.String programCode) {
           this.broadcastDate = broadcastDate;
           this.broadcastTime = broadcastTime;
           this.channelName = channelName;
           this.column = column;
           this.programName = programName;
           this.programType = programType;
           this.programCode = programCode;
    }


    /**
     * Gets the broadcastDate value for this GetProgramRequest.
     * 
     * @return broadcastDate   * 播出日期
     */
    public java.util.Date getBroadcastDate() {
        return broadcastDate;
    }


    /**
     * Sets the broadcastDate value for this GetProgramRequest.
     * 
     * @param broadcastDate   * 播出日期
     */
    public void setBroadcastDate(java.util.Date broadcastDate) {
        this.broadcastDate = broadcastDate;
    }


    /**
     * Gets the broadcastTime value for this GetProgramRequest.
     * 
     * @return broadcastTime
     */
    public com.newautovideo.ce.ws.GetProgramRequestBroadcastTime getBroadcastTime() {
        return broadcastTime;
    }


    /**
     * Sets the broadcastTime value for this GetProgramRequest.
     * 
     * @param broadcastTime
     */
    public void setBroadcastTime(com.newautovideo.ce.ws.GetProgramRequestBroadcastTime broadcastTime) {
        this.broadcastTime = broadcastTime;
    }


    /**
     * Gets the channelName value for this GetProgramRequest.
     * 
     * @return channelName   * 频道名称
     */
    public java.lang.String getChannelName() {
        return channelName;
    }


    /**
     * Sets the channelName value for this GetProgramRequest.
     * 
     * @param channelName   * 频道名称
     */
    public void setChannelName(java.lang.String channelName) {
        this.channelName = channelName;
    }


    /**
     * Gets the column value for this GetProgramRequest.
     * 
     * @return column   * 栏目名称
     */
    public java.lang.String getColumn() {
        return column;
    }


    /**
     * Sets the column value for this GetProgramRequest.
     * 
     * @param column   * 栏目名称
     */
    public void setColumn(java.lang.String column) {
        this.column = column;
    }


    /**
     * Gets the programName value for this GetProgramRequest.
     * 
     * @return programName   * 节目名称
     */
    public java.lang.String getProgramName() {
        return programName;
    }


    /**
     * Sets the programName value for this GetProgramRequest.
     * 
     * @param programName   * 节目名称
     */
    public void setProgramName(java.lang.String programName) {
        this.programName = programName;
    }


    /**
     * Gets the programType value for this GetProgramRequest.
     * 
     * @return programType   * 节目类型：无、广告类、导视类
     */
    public java.lang.String getProgramType() {
        return programType;
    }


    /**
     * Sets the programType value for this GetProgramRequest.
     * 
     * @param programType   * 节目类型：无、广告类、导视类
     */
    public void setProgramType(java.lang.String programType) {
        this.programType = programType;
    }


    /**
     * Gets the programCode value for this GetProgramRequest.
     * 
     * @return programCode   * 节目代码
     */
    public java.lang.String getProgramCode() {
        return programCode;
    }


    /**
     * Sets the programCode value for this GetProgramRequest.
     * 
     * @param programCode   * 节目代码
     */
    public void setProgramCode(java.lang.String programCode) {
        this.programCode = programCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetProgramRequest)) return false;
        GetProgramRequest other = (GetProgramRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.broadcastDate==null && other.getBroadcastDate()==null) || 
             (this.broadcastDate!=null &&
              this.broadcastDate.equals(other.getBroadcastDate()))) &&
            ((this.broadcastTime==null && other.getBroadcastTime()==null) || 
             (this.broadcastTime!=null &&
              this.broadcastTime.equals(other.getBroadcastTime()))) &&
            ((this.channelName==null && other.getChannelName()==null) || 
             (this.channelName!=null &&
              this.channelName.equals(other.getChannelName()))) &&
            ((this.column==null && other.getColumn()==null) || 
             (this.column!=null &&
              this.column.equals(other.getColumn()))) &&
            ((this.programName==null && other.getProgramName()==null) || 
             (this.programName!=null &&
              this.programName.equals(other.getProgramName()))) &&
            ((this.programType==null && other.getProgramType()==null) || 
             (this.programType!=null &&
              this.programType.equals(other.getProgramType()))) &&
            ((this.programCode==null && other.getProgramCode()==null) || 
             (this.programCode!=null &&
              this.programCode.equals(other.getProgramCode())));
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
        if (getBroadcastDate() != null) {
            _hashCode += getBroadcastDate().hashCode();
        }
        if (getBroadcastTime() != null) {
            _hashCode += getBroadcastTime().hashCode();
        }
        if (getChannelName() != null) {
            _hashCode += getChannelName().hashCode();
        }
        if (getColumn() != null) {
            _hashCode += getColumn().hashCode();
        }
        if (getProgramName() != null) {
            _hashCode += getProgramName().hashCode();
        }
        if (getProgramType() != null) {
            _hashCode += getProgramType().hashCode();
        }
        if (getProgramCode() != null) {
            _hashCode += getProgramCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetProgramRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">getProgramRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "BroadcastDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "BroadcastTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">>getProgramRequest>BroadcastTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channelName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ChannelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("column");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Column"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
