package com.chris.bank.dto;

import com.chris.bank.model.AccountModel;
import com.chris.bank.model.AddressModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiClient {
    private String clientId;
    @NotEmpty
    private String clientName;
    @NotEmpty
    private String clientSurname;
    @NotEmpty
    private Date clientDob;
    @Valid
    private List<ApiAddress> addresses;

}
