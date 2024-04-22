package com.gypApp_main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeLoginRequest {

    private String username;
    private String oldPassword;
    private String newPassword;
}
