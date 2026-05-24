package com.viggad.trackingmoney.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountRequest {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String avatarURL;

}
