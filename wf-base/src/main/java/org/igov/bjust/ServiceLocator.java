/**
 * ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.igov.bjust;

public class ServiceLocator extends org.apache.axis.client.Service implements org.igov.bjust.Service {

    public ServiceLocator() {
    }


    public ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Binding_IService
    private java.lang.String Binding_IService_address = "https://bjust.face.ua/soap/service";

    public java.lang.String getBinding_IServiceAddress() {
        return Binding_IService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Binding_IServiceWSDDServiceName = "Binding_IService";

    public java.lang.String getBinding_IServiceWSDDServiceName() {
        return Binding_IServiceWSDDServiceName;
    }

    public void setBinding_IServiceWSDDServiceName(java.lang.String name) {
        Binding_IServiceWSDDServiceName = name;
    }

    public org.igov.bjust.IService getBinding_IService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Binding_IService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBinding_IService(endpoint);
    }

    public org.igov.bjust.IService getBinding_IService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.igov.bjust.Binding_IServiceStub _stub = new org.igov.bjust.Binding_IServiceStub(portAddress, this);
            _stub.setPortName(getBinding_IServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBinding_IServiceEndpointAddress(java.lang.String address) {
        Binding_IService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.igov.bjust.IService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.igov.bjust.Binding_IServiceStub _stub = new org.igov.bjust.Binding_IServiceStub(new java.net.URL(Binding_IService_address), this);
                _stub.setPortName(getBinding_IServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Binding_IService".equals(inputPortName)) {
            return getBinding_IService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("BJUST", "Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("BJUST", "Binding_IService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Binding_IService".equals(portName)) {
            setBinding_IServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
