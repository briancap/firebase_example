package com.example.brian.roomy.Firebase;

/**
 * This class deals with all methods relating to the Tenant Node of the Firebase DB
 */

public class Tenant {
    private String tenantId;
    private String tenantName;
    private String phoneNumber;
    private String leaseId;
    private String addressId;
    private String realtyCompanyId;
    private String paymentId;   //venom or other
    private String authId;      //google, phone number, fingerprint

//CONSTRUCTORS
    public Tenant(){
    }

    public Tenant(String tenantName){
        this.tenantName = tenantName;
    }


//GETTERS AND SETTERS
    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(String leaseId) {
        this.leaseId = leaseId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getRealtyCompanyId() {
        return realtyCompanyId;
    }

    public void setRealtyCompanyId(String realtyCompanyId) {
        this.realtyCompanyId = realtyCompanyId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }
}
