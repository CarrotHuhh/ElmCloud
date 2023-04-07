package com.neusoft.controller;

import com.neusoft.po.CommonResult;
import com.neusoft.po.VirtualWallet;
import com.neusoft.po.VirtualWalletTransaction;
import com.neusoft.service.VirtualWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/VirtualWalletController")
public class VirtualWalletController {
    @Autowired
    private VirtualWalletService virtualWalletService;

    @GetMapping("/getVirtualWalletById/{userId}")
    public CommonResult<VirtualWallet> getVirtualWalletById(
            @PathVariable("userId") String userId) {
        VirtualWallet virtualWallet = virtualWalletService.getVirtualWalletById(userId);
        return new CommonResult(200, "success", virtualWallet);
    }

    @GetMapping("/virtualWalletWithdraw/{amount}/{userId}/{walletInId}")
    public CommonResult<Integer> virtualWalletWithdraw(
            @PathVariable("amount") Double amount,
            @PathVariable("userId") String userId,
            @PathVariable("walletInId") String walletInId) throws Exception {
        return new CommonResult(200, "success", virtualWalletService.withdraw(amount, userId, walletInId));
    }


    @GetMapping("/virtualWalletWithdraw/{amount}/{userId}/{walletOutId}")
    public CommonResult<Integer> virtualWalletTopUp(
            @PathVariable("amount") Double amount,
            @PathVariable("userId") String userId,
            @PathVariable("walletOutId") String walletOutId) throws Exception {
        return new CommonResult(200, "success", virtualWalletService.topUp(amount, userId, walletOutId));
    }

    @GetMapping("/getVirtualWalletBalance/{userId}")
    public CommonResult<Double> getVirtualWalletBalance(
            @PathVariable("userId") String userId) {
        Double balance = virtualWalletService.getVirtualWalletBalance(userId);
        return new CommonResult(200, "success", balance);
    }

	@GetMapping("/listTransByUserId/{userId}")
	public CommonResult<List> listTransByUserId(
			@PathVariable("userId") String userId) {
        List<VirtualWalletTransaction> transactions = virtualWalletService.listTransByUserId(userId);
		return new CommonResult(200, "success", transactions);
	}


	@GetMapping("/payByWallet/{orderId}/{userId}")
	public CommonResult<Integer> payByWallet(
			@PathVariable("userId") String userId,
            @PathVariable("orderId") Integer orderId) throws Exception {
		return new CommonResult(200, "success", virtualWalletService.payByWallet(orderId,userId));
	}
}
