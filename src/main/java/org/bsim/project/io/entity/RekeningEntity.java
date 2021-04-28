package org.bsim.project.io.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "RekeningTBL")
public class RekeningEntity implements Serializable {

    private static final long serialVersionUID = 8065808364494277814L;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private String rekeningid;

    @Column(nullable = false)
    private String norekening;

    @Column(nullable = false)
    private long saldo;

    @Column(nullable = false)
    private long tax;

    @Column(nullable = false)
    private double interest;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid")
    private ClientEntity client;

    @OneToMany(mappedBy = "rekening")
    private List<DepositoEntity> depositoEntities;

    @OneToMany(mappedBy = "rekening")
    private List<TransaksiEntity> transaksiEntities;

    public List<TransaksiEntity> getTransaksiEntities() {
        return transaksiEntities;
    }

    public void setTransaksiEntities(List<TransaksiEntity> transaksiEntities) {
        this.transaksiEntities = transaksiEntities;
    }

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

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<DepositoEntity> getDepositoEntities() {
        return depositoEntities;
    }

    public void setDepositoEntities(List<DepositoEntity> depositoEntities) {
        this.depositoEntities = depositoEntities;
    }
}
