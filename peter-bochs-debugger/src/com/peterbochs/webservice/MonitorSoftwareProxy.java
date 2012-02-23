package com.peterbochs.webservice;

public class MonitorSoftwareProxy implements MonitorSoftware {
  private String _endpoint = null;
  private MonitorSoftware monitorSoftware = null;
  
  public MonitorSoftwareProxy() {
    _initMonitorSoftwareProxy();
  }
  
  public MonitorSoftwareProxy(String endpoint) {
    _endpoint = endpoint;
    _initMonitorSoftwareProxy();
  }
  
  private void _initMonitorSoftwareProxy() {
    try {
      monitorSoftware = (new MonitorSoftwareServiceLocator()).getMonitorSoftware();
      if (monitorSoftware != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)monitorSoftware)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)monitorSoftware)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (monitorSoftware != null)
      ((javax.xml.rpc.Stub)monitorSoftware)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public MonitorSoftware getMonitorSoftware() {
    if (monitorSoftware == null)
      _initMonitorSoftwareProxy();
    return monitorSoftware;
  }
  
  public void log(java.lang.String software, java.lang.String message1, java.lang.String message2, java.lang.String message3, java.lang.String info, java.lang.String magicNumber) throws java.rmi.RemoteException{
    if (monitorSoftware == null)
      _initMonitorSoftwareProxy();
    monitorSoftware.log(software, message1, message2, message3, info, magicNumber);
  }
  
  public void log2(java.lang.String software, java.lang.String message1, java.lang.String message2, java.lang.String message3, java.lang.String info, java.lang.String magicNumber, java.lang.String software_version) throws java.rmi.RemoteException{
    if (monitorSoftware == null)
      _initMonitorSoftwareProxy();
    monitorSoftware.log2(software, message1, message2, message3, info, magicNumber, software_version);
  }
  
  
}