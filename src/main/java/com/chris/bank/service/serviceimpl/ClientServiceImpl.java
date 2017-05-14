package com.chris.bank.service.serviceimpl;

import com.chris.bank.dto.ApiClient;
import com.chris.bank.exceptionhandling.AddressException;
import com.chris.bank.model.AddressModel;
import com.chris.bank.model.ClientModel;
import com.chris.bank.service.AbstractService;
import com.chris.bank.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Service
public class ClientServiceImpl extends AbstractService implements ClientService {

    @Override
    @Transactional
    public ApiClient createClient(ApiClient apiClient) {
        Set<AddressModel> addresses = modelMapper.mapAsSet(apiClient.getAddresses(), AddressModel.class);
        int primaryAcc = 0;

        for (AddressModel address : addresses) {
            if (address.isAddressPrimary()) {
                primaryAcc++;
            }
            addressRepository.save(address);
        }

        if (primaryAcc != 1) {
            throw new AddressException();
        }

        ClientModel client = modelMapper.map(apiClient, ClientModel.class);
        client.setAddresses(addresses);

        return modelMapper.map(clientRepository.save(client), ApiClient.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ApiClient> getAllClients() {
        return modelMapper.mapAsList(clientRepository.findAll(), ApiClient.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ApiClient getClient(String clientId) {
        return modelMapper.map(clientRepository.findOne(encryptionService.decrypt(clientId)), ApiClient.class);
    }


}
