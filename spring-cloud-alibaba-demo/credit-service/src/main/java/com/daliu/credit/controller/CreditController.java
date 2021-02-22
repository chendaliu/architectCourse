package com.daliu.credit.controller;

import com.daliu.credit.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit")
public class CreditController {
    @Autowired
    private Registration registration;

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/add/{userId}/{creditCount}")
    public String addCredit(@PathVariable("userId") Long userId,
                            @PathVariable("creditCount") Integer creditCount) {
        return creditService.addCredit(userId, creditCount);
    }

    @GetMapping(value = "/get/{userId}")
    public String getCredit(@PathVariable("userId") Long userId) {
        return "userId:" + userId + ">>ip and port:" + getIpAndPort();
    }

    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return registration.getHost() + ":" + registration.getPort();
    }

}
