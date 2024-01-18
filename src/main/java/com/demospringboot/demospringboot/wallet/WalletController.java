/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.wallet;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thinnapath
 */
@RestController
@RequestMapping("/api/wallets")
public class WalletController {
    
    private  WalletService walletService;
    
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }
    
    @GetMapping("")
    public List<Wallet> getWalletList() {
        return walletService.getWalletList();
    }
    
    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable Integer id) {
        return walletService.getWalletById(id);
    }
    
    @PostMapping("")
    public Wallet createWallet(
            @Validated 
            @RequestBody WalletRequest request) {
        return walletService.createWallet(request);
    }

    @PutMapping("/{id}")
    public Wallet updateWallet(@RequestBody UpdateWalletRequest request, 
                                            @PathVariable Integer id) {
        
        return walletService.updateWallet(id, request);
        
    }
    
    @DeleteMapping("/{id}")
    public String deleteWalletById(@PathVariable Integer id) {
        walletService.deleteWalletById(id);
        return "Delete success";
    }
    
}

record UpdateWalletRequest(
        
        @NotNull
                @Size(min = 3, max = 20)
        String walletName) { }

