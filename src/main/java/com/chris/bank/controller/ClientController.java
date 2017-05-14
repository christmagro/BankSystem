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


    /**
     * An Api Used to create a new client
     *
     * @param apiClient Complex object containing all the information required to create a new user
     * @return New created client details
     */
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ApiClient createClient(@RequestBody ApiClient apiClient) {

        return clientService.createClient(apiClient);
    }

    /**
     * An Api used to list all clients
     *
     * @return A list of Client complex object
     */
    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<ApiClient> gallAllClients() {
        return clientService.getAllClients();
    }

    /**
     * An Api used to return a particular client
     * @param clientId An encoded ID representing a unique client in the system
     * @return Client details
     */

    @RequestMapping(value = "/client/{clientId}", method = RequestMethod.GET)
    public ApiClient getClient(@PathVariable String clientId) {
        return clientService.getClient(clientId);
    }
}
