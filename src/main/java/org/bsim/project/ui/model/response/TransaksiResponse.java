package org.bsim.project.ui.model.response;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.data.auditing.CurrentDateTimeProvider;

import java.time.LocalDate;

public class TransaksiResponse {

    private String transactionid;
    private String description;
    private long transactionprice;
    private LocalDate transactiondate;
    private String transactiontype;

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

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }
}
