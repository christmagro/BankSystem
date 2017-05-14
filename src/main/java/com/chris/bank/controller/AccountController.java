package com.chris.bank.controller;

import com.chris.bank.dto.ApiAccount;
import com.chris.bank.dto.ApiAccountTransaction;
import com.chris.bank.dto.ApiAccountTransferRequest;
import com.chris.bank.dto.ApiAccountTransferResponse;
import com.chris.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public ApiAccount createAccount(@RequestBody ApiAccount apiAccount,
                                    @PathVariable String clientId) {

        return accountService.createAccount(apiAccount, clientId);
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ApiAccountTransferResponse createTransfer(@RequestBody ApiAccountTransferRequest apiAccountTransferRequest) {

        return accountService.createTransfer(apiAccountTransferRequest);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public List<ApiAccount> getClientAccounts(@PathVariable String clientId) {

        return accountService.listClientAccounts(clientId);
    }

    @RequestMapping(value = "/transactions/{accountNumber}", method = RequestMethod.GET)
    public ApiAccountTransaction getAccountTransactions(@PathVariable Long accountNumber) {

        return accountService.listAccountTransactions(accountNumber);
    }

}
