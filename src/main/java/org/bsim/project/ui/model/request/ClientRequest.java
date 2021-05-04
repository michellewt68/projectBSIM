package org.bsim.project.ui.model.request;

import java.time.LocalDate;

public class ClientRequest {
    private String clientName;
    private String clientAddress;
    private String clientPhonenumber;
    private LocalDate clientDOB;
    private long clientNIK;
    private String clientMothername;
    private String clientPassword;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhonenumber() {
        return clientPhonenumber;
    }

    public void setClientPhonenumber(String clientPhonenumber) {
        this.clientPhonenumber = clientPhonenumber;
    }

    public LocalDate getClientDOB() {
        return clientDOB;
    }

    public void setClientDOB(LocalDate clientDOB) {
        this.clientDOB = clientDOB;
    }

    public long getClientNIK() {
        return clientNIK;
    }

    public void setClientNIK(long clientNIK) {
        this.clientNIK = clientNIK;
    }

    public String getClientMothername() {
        return clientMothername;
    }

    public void setClientMothername(String clientMothername) {
        this.clientMothername = clientMothername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }
}
