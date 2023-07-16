package com.chryl.service.impl;

import com.chryl.service.IVRService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by Chr.yl on 2023/7/16.
 *
 * @author Chr.yl
 */
/*
    @Primary同一个接口的实现类，最多只能有一个添加该注解
    在controller中注入接口，默认使用的是Primary  标注的实现类的方法
 */
@Primary//优先注入
@Component
public class IVRServiceV2 implements IVRService {
    @Override
    public void handlerChannelEvent() {
        System.out.println("V2");
    }
}
