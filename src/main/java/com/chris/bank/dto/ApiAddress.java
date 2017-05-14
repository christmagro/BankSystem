package com.chris.bank.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Christian Magro on 13/05/2017.
 */
@Data
@EqualsAndHashCode
public class ApiAddress {
    @NotEmpty
    private String addressLine1;
    private String addressLine2;
    @NotEmpty
    private String addressCity;
    @NotEmpty
    private String addressCounty;
    private boolean addressPrimary;
}
