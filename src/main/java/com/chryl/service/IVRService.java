package com.chryl.service;

import org.springframework.scheduling.annotation.Async;

/**
 * 接口使用async
 * Created by Chr.yl on 2023/7/16.
 *
 * @author Chr.yl
 */
public interface IVRService {
    @Async
    void handlerChannelEvent();
}
