package org.bsim.project.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "TransaksiTBL")
public class TransaksiEntity implements Serializable {

    private static final long serialVersionUID= 3046239116449886550L;

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    @Column (nullable = false)
    private String transactionid;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private long transactionprice;

    @Column(nullable = false)
    private LocalDate transactiondate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rekeningid")
    private RekeningEntity rekening;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTransactionprice() {
        return transactionprice;
    }

    public void setTransactionprice(long transactionprice) {
        this.transactionprice = transactionprice;
    }

    public LocalDate getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(LocalDate transactiondate) {
        this.transactiondate = transactiondate;
    }

    public RekeningEntity getRekening() {
        return rekening;
    }

    public void setRekening(RekeningEntity rekening) {
        this.rekening = rekening;
    }
}
