package com.neusoft.controller;

import java.util.List;

import com.neusoft.po.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import com.neusoft.po.CreditsRecord;
import com.neusoft.service.CreditsWalletService;

@RefreshScope
@RestController
@RequestMapping("/CreditsWalletController")
public class CreditsWalletController {
    @Autowired
    private CreditsWalletService creditsWalletService;


    @PostMapping("/getCreditsById/{userId}")
    public CommonResult<Integer> getCreditsById(
            @PathVariable("userId") String userId) {
        return new CommonResult(200, "success", creditsWalletService.getCreditsById(userId));
    }

    @PostMapping("/creditsAdd/{amount}/{userId}")
    public CommonResult<Integer> creditsAdd(
            @PathVariable("amount") Integer amount,
            @PathVariable("userId") String userId) {
        return new CommonResult(200, "success", creditsWalletService.creditsAdd(amount, userId));
    }

    @PostMapping("/creditsDeduct/{amount}/{userId}")
    public CommonResult<Integer> creditsDeduct(
            @PathVariable("amount") Integer amount,
            @PathVariable("userId") String userId) {
        return new CommonResult(200, "success", creditsWalletService.creditsDeduct(amount, userId));
    }

    @PostMapping("/getCreditsRecordById/{userId}")
    public CommonResult<List> getCreditsRecordById(
            @PathVariable("userId") String userId) {
        List<CreditsRecord> list = creditsWalletService.getCreditsRecordById(userId);
        return new CommonResult(200, "success", list);
    }

}
