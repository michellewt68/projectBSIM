package org.bsim.project.ui.model.request;

import java.time.LocalDate;

public class TransaksiRequest {

    private String description;
    private long transactionprice;

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

}
