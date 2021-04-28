package org.bsim.project.service.iservice;

import org.bsim.project.shared.dto.TransaksiDTO;

import java.util.List;

public interface ITransaksiService {
    TransaksiDTO addNewTransaksi(String clientid, String rekeningid, TransaksiDTO transaksiDTO);

    List<TransaksiDTO> getTransactionList(String clientid, String rekeningid);

    TransaksiDTO getTransactionByTransactionId(String clientid, String rekeningid, String transactionid);
}
