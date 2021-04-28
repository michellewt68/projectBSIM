package org.bsim.project.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="DepositoTBL")
public class DepositoEntity implements Serializable {

    private static final long serialVersionUID= 2359741598302510521L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String depositoid;

    @Column(nullable = false)
    private LocalDate startdate;

    @Column(nullable = false)
    private LocalDate enddate;

    @Column(nullable = false)
    private long taxDeposito;

    @Column(nullable = false)
    private double interestDeposito;

    @Column(nullable = false)
    private long saldoAwalPenempatan;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "rekeningid")
    private RekeningEntity rekening;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public RekeningEntity getRekening() {
        return rekening;
    }

    public void setRekening(RekeningEntity rekening) {
        this.rekening = rekening;
    }
}
