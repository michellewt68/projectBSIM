package org.bsim.project.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class DepositoDTO implements Serializable {

    private static final long serialVersionUID= 5016059313722649863L;
    private String depositoid;
    private LocalDate startdate;
    private LocalDate enddate;
    private long taxDeposito;
    private double interestDeposito;
    private long saldoAwalPenempatan;

    private RekeningDTO rekeningDTO;

    public String getDepositoid() {
        return depositoid;
    }

    public void setDepositoid(String depositoid) {
        this.depositoid = depositoid;
    }

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

    public long getTaxDeposito() {
        return taxDeposito;
    }

    public void setTaxDeposito(long taxDeposito) {
        this.taxDeposito = taxDeposito;
    }

    public double getInterestDeposito() {
        return interestDeposito;
    }

    public void setInterestDeposito(double interestDeposito) {
        this.interestDeposito = interestDeposito;
    }

    public long getSaldoAwalPenempatan() {
        return saldoAwalPenempatan;
    }

    public void setSaldoAwalPenempatan(long saldoAwalPenempatan) {
        this.saldoAwalPenempatan = saldoAwalPenempatan;
    }

    public RekeningDTO getRekeningDTO() {
        return rekeningDTO;
    }

    public void setRekeningDTO(RekeningDTO rekeningDTO) {
        this.rekeningDTO = rekeningDTO;
    }
}
