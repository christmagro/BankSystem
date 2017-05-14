package com.chris.bank.service;

import com.chris.bank.dto.ApiAccount;
import com.chris.bank.dto.ApiAccountTransaction;
import com.chris.bank.dto.ApiAccountTransferRequest;
import com.chris.bank.dto.ApiAccountTransferResponse;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
public interface AccountService {

    ApiAccount createAccount(ApiAccount apiAccount, String clientId);

    ApiAccountTransferResponse createTransfer(ApiAccountTransferRequest apiAccountTransferRequest);

    List<ApiAccount> listClientAccounts(String clientId);

    ApiAccountTransaction listAccountTransactions(Long AccountNumber);

}
