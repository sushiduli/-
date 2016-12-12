/**
 * CEBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public class CEBindingSkeleton implements com.newautovideo.ce.ws.CEPortType, org.apache.axis.wsdl.Skeleton {
    private com.newautovideo.ce.ws.CEPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "getProgramRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">getProgramRequest"), com.newautovideo.ce.ws.GetProgramRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getProgram", _params, new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "getProgramResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">getProgramResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getProgram"));
        _myOperationsList.add(_oper);
        if (_myOperations.get("getProgram") == null) {
            _myOperations.put("getProgram", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getProgram")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "setProgramStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">setProgramStatusRequest"), com.newautovideo.ce.ws.SetProgramStatusRequest.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setProgramStatus", _params, new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", "setProgramStatusResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://newautovideo.com/ce/ws", ">setProgramStatusResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "setProgramStatus"));
        _myOperationsList.add(_oper);
        if (_myOperations.get("setProgramStatus") == null) {
            _myOperations.put("setProgramStatus", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setProgramStatus")).add(_oper);
    }

    public CEBindingSkeleton() {
        this.impl = new com.newautovideo.ce.ws.CEBindingImpl();
    }

    public CEBindingSkeleton(com.newautovideo.ce.ws.CEPortType impl) {
        this.impl = impl;
    }
    public com.newautovideo.ce.ws.ProgramType[] getProgram(com.newautovideo.ce.ws.GetProgramRequest inp) throws java.rmi.RemoteException
    {
        com.newautovideo.ce.ws.ProgramType[] ret = impl.getProgram(inp);
        return ret;
    }

    public com.newautovideo.ce.ws.SetProgramStatusResponse setProgramStatus(com.newautovideo.ce.ws.SetProgramStatusRequest inp) throws java.rmi.RemoteException
    {
        com.newautovideo.ce.ws.SetProgramStatusResponse ret = impl.setProgramStatus(inp);
        return ret;
    }

}
