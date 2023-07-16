package com.chryl.controller;

import com.chryl.service.IVRService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chr.yl on 2023/3/6.
 *
 * @author Chr.yl
 */
@Slf4j
@RestController
@RequestMapping("async")
public class ChrylController {

    @Autowired
    private IVRService ivrService;

    /**
     * info
     *
     * @return
     */
    @GetMapping("show")
    public String show() {
        ivrService.handlerChannelEvent();
        return Thread.currentThread().getName();
    }

}
