package org.bsim.project.shared.dto;

import java.io.Serializable;

public class RekeningDTO implements Serializable {

    private static final long serialVersionUID= -3788977803564935348L;
    private long id;
    private String rekeningid;
    private String norekening;
    private long saldo;
    private long tax;
    private double interest;
    private boolean isActive;

    private ClientDTO clientDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRekeningid() {
        return rekeningid;
    }

    public void setRekeningid(String rekeningid) {
        this.rekeningid = rekeningid;
    }

    public String getNorekening() {
        return norekening;
    }

    public void setNorekening(String norekening) {
        this.norekening = norekening;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getTax() {
        return tax;
    }

    public void setTax(long tax) {
        this.tax = tax;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
