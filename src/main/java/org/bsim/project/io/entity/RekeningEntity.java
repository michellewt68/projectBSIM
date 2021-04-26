package org.bsim.project.io.entity;


import javax.persistence.*;
import java.io.Serializable;

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

    private final long tax = 2000 ;
    private final double interest= 0.5;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid")
    private ClientEntity client;

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

    public double getInterest() {
        return interest;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }
}
