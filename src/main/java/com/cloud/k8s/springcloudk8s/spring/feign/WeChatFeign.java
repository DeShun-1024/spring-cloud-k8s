package com.cloud.k8s.springcloudk8s.spring.feign;


import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "center-wechat", path = "/center/center-wechat", fallbackFactory = WeChatFeignFallback.class)
public interface WeChatFeign {

    @GetMapping("/test")
    String test();

}

@Slf4j
@Component
class WeChatFeignFallback implements FallbackFactory<WeChatFeign> {

    @Override
    public WeChatFeign create(Throwable cause) {
        log.error("[center-wechat]异常", cause);

        return null;
    }
}