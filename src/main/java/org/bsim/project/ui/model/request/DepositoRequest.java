package org.bsim.project.ui.model.request;

import java.time.LocalDate;

public class DepositoRequest {

    private LocalDate startdate;
    private LocalDate enddate;
    private long saldoAwalPenempatan;

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public long getSaldoAwalPenempatan() {
        return saldoAwalPenempatan;
    }

    public void setSaldoAwalPenempatan(long saldoAwalPenempatan) {
        this.saldoAwalPenempatan = saldoAwalPenempatan;
    }
}
