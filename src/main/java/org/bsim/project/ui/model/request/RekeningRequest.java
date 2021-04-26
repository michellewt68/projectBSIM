package org.bsim.project.ui.model.request;

public class RekeningRequest {
    private String norekening;
    private long saldo;

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
}
