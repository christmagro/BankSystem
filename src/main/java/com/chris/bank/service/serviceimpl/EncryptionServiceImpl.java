package com.chris.bank.service.serviceimpl;

import com.chris.bank.service.EncryptionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;

/**
 * Created by Christian Magro on 14/05/2017.
 */
@Component
public class EncryptionServiceImpl implements EncryptionService, InitializingBean {

    @Value("${encryption.password}")
    private String password;

    @Value("${encryption.salt}")
    private String salt;

    private BytesEncryptor encryptor;


    @Override
    public void afterPropertiesSet() throws Exception {
        encryptor = Encryptors.standard(password, salt);
    }

    @Override
    public String encrypt(Long id) {
        return Base64.getEncoder().encodeToString(encryptor.encrypt(id.toString().getBytes()));
    }

    @Override
    public Long decrypt(String input) {
        return Long.valueOf(new String(encryptor.decrypt(Base64.getDecoder().decode(input))));
    }


}