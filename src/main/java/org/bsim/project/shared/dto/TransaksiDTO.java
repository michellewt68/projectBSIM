package org.bsim.project.shared.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class TransaksiDTO implements Serializable {

    private static final long serialVersionUID= -7016348951790177342L;

    private long id;
    private String transactionid;
    private String description;
    private long transactionprice;
    private LocalDate transactiondate;

    private RekeningDTO rekeningDTO;

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

    public RekeningDTO getRekeningDTO() {
        return rekeningDTO;
    }

    public void setRekeningDTO(RekeningDTO rekeningDTO) {
        this.rekeningDTO = rekeningDTO;
    }
}
