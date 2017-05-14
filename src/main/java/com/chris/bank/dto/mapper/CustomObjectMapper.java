package com.chris.bank.dto.mapper;

import com.chris.bank.dto.ApiAccount;
import com.chris.bank.dto.ApiAddress;
import com.chris.bank.dto.ApiClient;
import com.chris.bank.dto.ApiTransaction;
import com.chris.bank.model.AccountModel;
import com.chris.bank.model.AddressModel;
import com.chris.bank.model.ClientModel;
import com.chris.bank.model.TransactionModel;
import com.chris.bank.service.EncryptionService;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Component
public class CustomObjectMapper extends ConfigurableMapper {

    @Autowired
    EncryptionService encryptionService;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");



    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        factory.registerClassMap(factory.classMap(ApiAccount.class, AccountModel.class)
                .customize(new CustomMapper<ApiAccount, AccountModel>() {
                    @Override
                    public void mapAtoB(ApiAccount apiAccount, AccountModel accountModel, MappingContext context) {
                        if (apiAccount.getAccountId() != null) {
                            accountModel.setAccountId(encryptionService.decrypt(apiAccount.getAccountId()));
                        }
                    }

                    @Override
                    public void mapBtoA(AccountModel accountModel, ApiAccount apiAccount, MappingContext context) {
                        String formatDateTime = accountModel.getAccountTimestamp().toLocalDateTime().format(formatter);
                        apiAccount.setAccountCreated(formatDateTime);
                        apiAccount.setAccountId(encryptionService.encrypt(accountModel.getAccountId()));
                    }
                }).byDefault().toClassMap());

        factory.registerClassMap(factory.classMap(ApiAddress.class, AddressModel.class)
                .customize(new CustomMapper<ApiAddress, AddressModel>() {

                }).byDefault().toClassMap());

        factory.registerClassMap(factory.classMap(ApiClient.class, ClientModel.class)
                .customize(new CustomMapper<ApiClient, ClientModel>() {
                    @Override
                    public void mapAtoB(ApiClient apiClient, ClientModel clientModel, MappingContext context) {
                        if (apiClient.getClientId() != null) {
                            clientModel.setClientId(encryptionService.decrypt(apiClient.getClientId()));
                        }
                    }

                    @Override
                    public void mapBtoA(ClientModel clientModel, ApiClient apiClient, MappingContext context) {
                        apiClient.setClientId(encryptionService.encrypt(clientModel.getClientId()));
                    }
                }).byDefault().toClassMap());

        factory.registerClassMap(factory.classMap(ApiTransaction.class, TransactionModel.class)
                .customize(new CustomMapper<ApiTransaction, TransactionModel>() {
                    @Override
                    public void mapBtoA(TransactionModel transactionModel, ApiTransaction apiTransaction, MappingContext context) {
                        apiTransaction.setDestinationAccountNumber(transactionModel.getTransactionDebitAccount().getAccountNumber());
                        apiTransaction.setSourceAccountNumber(transactionModel.getTransactionCreditAccount().getAccountNumber());
                    }
                }).byDefault().toClassMap());
    }
}
