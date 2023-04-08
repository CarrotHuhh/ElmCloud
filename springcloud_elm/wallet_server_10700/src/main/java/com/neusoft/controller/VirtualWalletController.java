package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import com.neusoft.po.VirtualWallet;
import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/VirtualWalletController")
public class VirtualWalletController {
    @Autowired
    private VirtualWalletService virtualWalletService;

    @PostMapping("/getVirtualWalletById/{userId}")
    public CommonResult<VirtualWallet> getVirtualWalletById(
            @PathVariable("userId") String userId) {
        VirtualWallet virtualWallet = virtualWalletService.getVirtualWalletById(userId);
        return new CommonResult(200, "success", virtualWallet);
    }

    @PostMapping("/virtualWalletWithdraw/{amount}/{userId}/{walletInId}")
    public CommonResult<Integer> virtualWalletWithdraw(
            @PathVariable("amount") Double amount,
            @PathVariable("userId") String userId,
            @PathVariable("walletInId") String walletInId) {
        return new CommonResult(200, "success", virtualWalletService.withdraw(amount, userId, walletInId));
    }


    @PostMapping("/virtualWalletTopUp/{amount}/{userId}/{walletOutId}")
    public CommonResult<Integer> virtualWalletTopUp(
            @PathVariable("amount") Double amount,
            @PathVariable("userId") String userId,
            @PathVariable("walletOutId") String walletOutId) throws Exception {
        return new CommonResult(200, "success", virtualWalletService.topUp(amount, userId, walletOutId));
    }

    @PostMapping("/getVirtualWalletBalance/{userId}")
    public CommonResult<Double> getVirtualWalletBalance(
            @PathVariable("userId") String userId) {
        Double balance = virtualWalletService.getVirtualWalletBalance(userId);
        return new CommonResult(200, "success", balance);
    }

    @PostMapping("/listTransByUserId/{userId}")
    public CommonResult<List> listTransByUserId(
            @PathVariable("userId") String userId) {
        List<VirtualWalletTransaction> transactions = virtualWalletService.listTransByUserId(userId);
        return new CommonResult(200, "success", transactions);
    }


    @PostMapping("/payByWallet/{orderId}/{userId}")
    public CommonResult<Integer> payByWallet(
            @PathVariable("userId") String userId,
            @PathVariable("orderId") Integer orderId) throws Exception {
        return new CommonResult(200, "success", virtualWalletService.payByWallet(orderId, userId));
    }
}
