package com.chris.bank.controller;

import com.chris.bank.dto.ApiClient;
import com.chris.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ApiClient createClient(@RequestBody ApiClient apiClient) {

        return clientService.createClient(apiClient);
    }

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<ApiClient> gallAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public ApiClient getClient(@PathVariable String clientId) {
        return clientService.getClient(clientId);
    }
}
