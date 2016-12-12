/**
 * CEPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.newautovideo.ce.ws;

public interface CEPortType extends java.rmi.Remote {
    public com.newautovideo.ce.ws.ProgramType[] getProgram(com.newautovideo.ce.ws.GetProgramRequest inp) throws java.rmi.RemoteException;
    public com.newautovideo.ce.ws.SetProgramStatusResponse setProgramStatus(com.newautovideo.ce.ws.SetProgramStatusRequest inp) throws java.rmi.RemoteException;
}
