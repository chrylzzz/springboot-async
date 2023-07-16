package com.chryl.service.impl;

import com.chryl.service.IVRService;
import org.springframework.stereotype.Component;

/**
 * Created by Chr.yl on 2023/7/16.
 *
 * @author Chr.yl
 */
@Component
public class IVRServiceV1 implements IVRService {
    @Override
    public void handlerChannelEvent() {
        System.out.println("V1");
    }
}
