/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demospringboot.demospringboot.wallet;

import com.demospringboot.demospringboot.exception.DuplicationException;
import com.demospringboot.demospringboot.exception.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author thinnapath
 */
@Service
public class WalletService {
    
    private List<Wallet> walletList = new ArrayList<> (List.of(
            new Wallet(1, "Saving house", "savinghouse@gmail.com"),
            new Wallet(2, "Saving car", "savingcar@gmail.com"),
            new Wallet(3, "Penny wallet", "savingpenny@gmail.com")
    ));
    
    public List<Wallet> getWalletList() {
        return walletList;
    }

    public Wallet createWallet(WalletRequest request) {
        walletList.stream().filter(wallet -> wallet.getEmail().equals(request.email()))
                .findFirst()
                .ifPresent(wallet -> {
                    throw new DuplicationException("wallet wit Email" + request.email() + " already exists");
                });
        
        Optional<Integer> maxId = walletList.stream()
                .map(Wallet::getId)
                .max(Integer::compareTo);
        
        int  nextId = maxId.orElse(0) + 1;
        
        Wallet wallet = new Wallet(nextId, request.walletName(), request.email());
        walletList.add(wallet);
        return wallet;
    }
    
    public Wallet getWalletById(Integer id) {
        return walletList.stream().filter(wallet -> wallet.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Wallet not found by id " + id));
    }

    public Wallet updateWallet(Integer id, UpdateWalletRequest request) {
        for (Wallet wallet: walletList) {
            if (wallet.getId().equals(id)) {
                wallet.setWalletName(request.walletName());
                return wallet;
            }
        }
        throw new NotFoundException("Wallet not found by Id " + id);
    }

    void deleteWalletById(Integer id) {
        
        walletList.removeIf(wallet -> wallet.getId().equals(id));
    }
}
