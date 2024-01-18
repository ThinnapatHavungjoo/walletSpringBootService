/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.wallet;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author thinnapath
 */
public record WalletRequest(
        
        @NotNull
                    @Size(min = 3, max = 20, message = "Wallet name should be between 3 and 20 Char")
        String walletName,

        @NotNull
        @Email (message = "Email should be valid") 
        String email 
        ){
    
}
