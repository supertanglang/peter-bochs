/**
 * MonitorSoftware.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package peter.webservice;

public interface MonitorSoftware extends java.rmi.Remote {
    public void log(java.lang.String software, java.lang.String message1, java.lang.String message2, java.lang.String message3, java.lang.String info, java.lang.String magicNumber) throws java.rmi.RemoteException;
    public void log2(java.lang.String software, java.lang.String message1, java.lang.String message2, java.lang.String message3, java.lang.String info, java.lang.String magicNumber, java.lang.String software_version) throws java.rmi.RemoteException;
}
