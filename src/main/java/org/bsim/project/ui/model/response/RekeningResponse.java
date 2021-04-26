package org.bsim.project.ui.model.response;

public class RekeningResponse {
    private String rekeningid;
    private String norekening;
    private long saldo;
    private long tax;
    private double interest;

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
}
