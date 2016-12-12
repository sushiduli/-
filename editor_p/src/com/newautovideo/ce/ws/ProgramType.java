/**
 * ProgramType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;


/**
 * 节目
 */
public class ProgramType  implements java.io.Serializable {
    /* 播出日期 */
    private java.util.Date broadcastDate;

    /* 频道名称 */
    private java.lang.String channelName;

    /* 节目名称 */
    private java.lang.String programName;

    /* 播出时间（单位：帧） */
    private long broadcastTime;

    /* 栏目名称 */
    private java.lang.String column;

    /* 节目类型 */
    private java.lang.String programType;

    /* 节目代码 */
    private java.lang.String programCode;

    /* 预计时长（单位：帧） */
    private long length;

    /* 播出模式 */
    private java.lang.String broadcastMode;

    /* 首播、重播 */
    private java.lang.String replay;

    /* 绑定状态 */
    private int status;

    /* 时段名称 */
    private java.lang.String groupName;

    /* 关门时间 */
    private java.util.Date editCloseTime;

    public ProgramType() {
    }

    public ProgramType(
           java.util.Date broadcastDate,
           java.lang.String channelName,
           java.lang.String programName,
           long broadcastTime,
           java.lang.String column,
           java.lang.String programType,
           java.lang.String programCode,
           long length,
           java.lang.String broadcastMode,
           java.lang.String replay,
           int status,
           java.lang.String groupName,
           java.util.Date editCloseTime) {
           this.broadcastDate = broadcastDate;
           this.channelName = channelName;
           this.programName = programName;
           this.broadcastTime = broadcastTime;
           this.column = column;
           this.programType = programType;
           this.programCode = programCode;
           this.length = length;
           this.broadcastMode = broadcastMode;
           this.replay = replay;
           this.status = status;
           this.groupName = groupName;
           this.editCloseTime = editCloseTime;
    }


    /**
     * Gets the broadcastDate value for this ProgramType.
     * 
     * @return broadcastDate   * 播出日期
     */
    public java.util.Date getBroadcastDate() {
        return broadcastDate;
    }


    /**
     * Sets the broadcastDate value for this ProgramType.
     * 
     * @param broadcastDate   * 播出日期
     */
    public void setBroadcastDate(java.util.Date broadcastDate) {
        this.broadcastDate = broadcastDate;
    }


    /**
     * Gets the channelName value for this ProgramType.
     * 
     * @return channelName   * 频道名称
     */
    public java.lang.String getChannelName() {
        return channelName;
    }


    /**
     * Sets the channelName value for this ProgramType.
     * 
     * @param channelName   * 频道名称
     */
    public void setChannelName(java.lang.String channelName) {
        this.channelName = channelName;
    }


    /**
     * Gets the programName value for this ProgramType.
     * 
     * @return programName   * 节目名称
     */
    public java.lang.String getProgramName() {
        return programName;
    }


    /**
     * Sets the programName value for this ProgramType.
     * 
     * @param programName   * 节目名称
     */
    public void setProgramName(java.lang.String programName) {
        this.programName = programName;
    }


    /**
     * Gets the broadcastTime value for this ProgramType.
     * 
     * @return broadcastTime   * 播出时间（单位：帧）
     */
    public long getBroadcastTime() {
        return broadcastTime;
    }


    /**
     * Sets the broadcastTime value for this ProgramType.
     * 
     * @param broadcastTime   * 播出时间（单位：帧）
     */
    public void setBroadcastTime(long broadcastTime) {
        this.broadcastTime = broadcastTime;
    }


    /**
     * Gets the column value for this ProgramType.
     * 
     * @return column   * 栏目名称
     */
    public java.lang.String getColumn() {
        return column;
    }


    /**
     * Sets the column value for this ProgramType.
     * 
     * @param column   * 栏目名称
     */
    public void setColumn(java.lang.String column) {
        this.column = column;
    }


    /**
     * Gets the programType value for this ProgramType.
     * 
     * @return programType   * 节目类型
     */
    public java.lang.String getProgramType() {
        return programType;
    }


    /**
     * Sets the programType value for this ProgramType.
     * 
     * @param programType   * 节目类型
     */
    public void setProgramType(java.lang.String programType) {
        this.programType = programType;
    }


    /**
     * Gets the programCode value for this ProgramType.
     * 
     * @return programCode   * 节目代码
     */
    public java.lang.String getProgramCode() {
        return programCode;
    }


    /**
     * Sets the programCode value for this ProgramType.
     * 
     * @param programCode   * 节目代码
     */
    public void setProgramCode(java.lang.String programCode) {
        this.programCode = programCode;
    }


    /**
     * Gets the length value for this ProgramType.
     * 
     * @return length   * 预计时长（单位：帧）
     */
    public long getLength() {
        return length;
    }


    /**
     * Sets the length value for this ProgramType.
     * 
     * @param length   * 预计时长（单位：帧）
     */
    public void setLength(long length) {
        this.length = length;
    }


    /**
     * Gets the broadcastMode value for this ProgramType.
     * 
     * @return broadcastMode   * 播出模式
     */
    public java.lang.String getBroadcastMode() {
        return broadcastMode;
    }


    /**
     * Sets the broadcastMode value for this ProgramType.
     * 
     * @param broadcastMode   * 播出模式
     */
    public void setBroadcastMode(java.lang.String broadcastMode) {
        this.broadcastMode = broadcastMode;
    }


    /**
     * Gets the replay value for this ProgramType.
     * 
     * @return replay   * 首播、重播
     */
    public java.lang.String getReplay() {
        return replay;
    }


    /**
     * Sets the replay value for this ProgramType.
     * 
     * @param replay   * 首播、重播
     */
    public void setReplay(java.lang.String replay) {
        this.replay = replay;
    }


    /**
     * Gets the status value for this ProgramType.
     * 
     * @return status   * 绑定状态
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ProgramType.
     * 
     * @param status   * 绑定状态
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the groupName value for this ProgramType.
     * 
     * @return groupName   * 时段名称
     */
    public java.lang.String getGroupName() {
        return groupName;
    }


    /**
     * Sets the groupName value for this ProgramType.
     * 
     * @param groupName   * 时段名称
     */
    public void setGroupName(java.lang.String groupName) {
        this.groupName = groupName;
    }


    /**
     * Gets the editCloseTime value for this ProgramType.
     * 
     * @return editCloseTime   * 关门时间
     */
    public java.util.Date getEditCloseTime() {
        return editCloseTime;
    }


    /**
     * Sets the editCloseTime value for this ProgramType.
     * 
     * @param editCloseTime   * 关门时间
     */
    public void setEditCloseTime(java.util.Date editCloseTime) {
        this.editCloseTime = editCloseTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProgramType)) return false;
        ProgramType other = (ProgramType) obj;
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
            ((this.channelName==null && other.getChannelName()==null) || 
             (this.channelName!=null &&
              this.channelName.equals(other.getChannelName()))) &&
            ((this.programName==null && other.getProgramName()==null) || 
             (this.programName!=null &&
              this.programName.equals(other.getProgramName()))) &&
            this.broadcastTime == other.getBroadcastTime() &&
            ((this.column==null && other.getColumn()==null) || 
             (this.column!=null &&
              this.column.equals(other.getColumn()))) &&
            ((this.programType==null && other.getProgramType()==null) || 
             (this.programType!=null &&
              this.programType.equals(other.getProgramType()))) &&
            ((this.programCode==null && other.getProgramCode()==null) || 
             (this.programCode!=null &&
              this.programCode.equals(other.getProgramCode()))) &&
            this.length == other.getLength() &&
            ((this.broadcastMode==null && other.getBroadcastMode()==null) || 
             (this.broadcastMode!=null &&
              this.broadcastMode.equals(other.getBroadcastMode()))) &&
            ((this.replay==null && other.getReplay()==null) || 
             (this.replay!=null &&
              this.replay.equals(other.getReplay()))) &&
            this.status == other.getStatus() &&
            ((this.groupName==null && other.getGroupName()==null) || 
             (this.groupName!=null &&
              this.groupName.equals(other.getGroupName()))) &&
            ((this.editCloseTime==null && other.getEditCloseTime()==null) || 
             (this.editCloseTime!=null &&
              this.editCloseTime.equals(other.getEditCloseTime())));
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
        if (getChannelName() != null) {
            _hashCode += getChannelName().hashCode();
        }
        if (getProgramName() != null) {
            _hashCode += getProgramName().hashCode();
        }
        _hashCode += new Long(getBroadcastTime()).hashCode();
        if (getColumn() != null) {
            _hashCode += getColumn().hashCode();
        }
        if (getProgramType() != null) {
            _hashCode += getProgramType().hashCode();
        }
        if (getProgramCode() != null) {
            _hashCode += getProgramCode().hashCode();
        }
        _hashCode += new Long(getLength()).hashCode();
        if (getBroadcastMode() != null) {
            _hashCode += getBroadcastMode().hashCode();
        }
        if (getReplay() != null) {
            _hashCode += getReplay().hashCode();
        }
        _hashCode += getStatus();
        if (getGroupName() != null) {
            _hashCode += getGroupName().hashCode();
        }
        if (getEditCloseTime() != null) {
            _hashCode += getEditCloseTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProgramType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "BroadcastDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("channelName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ChannelName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "BroadcastTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("column");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Column"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "ProgramCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("length");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Length"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("broadcastMode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "BroadcastMode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("replay");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Replay"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "GroupName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("editCloseTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "EditCloseTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
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
