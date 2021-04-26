package org.bsim.project.ui.model.response;

import java.time.LocalDate;

public class ClientResponse {
    private String clientid;
    private String clientname;
    private String clientaddress;
    private String clientphonenumber;
    private LocalDate clientdob;
    private long clientnik;
    private String clientmothername;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getClientaddress() {
        return clientaddress;
    }

    public void setClientaddress(String clientaddress) {
        this.clientaddress = clientaddress;
    }

    public String getClientphonenumber() {
        return clientphonenumber;
    }

    public void setClientphonenumber(String clientphonenumber) {
        this.clientphonenumber = clientphonenumber;
    }

    public LocalDate getClientdob() {
        return clientdob;
    }

    public void setClientdob(LocalDate clientdob) {
        this.clientdob = clientdob;
    }

    public long getClientnik() {
        return clientnik;
    }

    public void setClientnik(long clientnik) {
        this.clientnik = clientnik;
    }

    public String getClientmothername() {
        return clientmothername;
    }

    public void setClientmothername(String clientmothername) {
        this.clientmothername = clientmothername;
    }
}
