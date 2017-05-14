package com.chris.bank.service;

import com.chris.bank.dto.ApiClient;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
public interface ClientService {


    ApiClient createClient(ApiClient apiClient);
    List<ApiClient> getAllClients();
    ApiClient getClient(String clientId);
}
