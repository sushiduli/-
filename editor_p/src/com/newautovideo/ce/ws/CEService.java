/**
 * CEService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public interface CEService extends javax.xml.rpc.Service {
    public java.lang.String getCEPortAddress();

    public com.newautovideo.ce.ws.CEPortType getCEPort() throws javax.xml.rpc.ServiceException;

    public com.newautovideo.ce.ws.CEPortType getCEPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
