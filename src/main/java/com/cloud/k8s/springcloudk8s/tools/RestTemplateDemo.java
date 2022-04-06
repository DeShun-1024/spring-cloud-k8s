package com.cloud.k8s.springcloudk8s.tools;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RestTemplateDemo {

    public void postWithReturnHead() throws IOException {
        String appId = "tt79ee0f53e6d6bf5d01";
        String accessToken = "08011218467549466e397936317271794551316b34476c6662673d3d";

        final byte[] bytes = Files.readAllBytes(Paths.get("./" + "/doc/merchant/" + "/深圳美西西餐饮管理有限公司#business_license_picurl.jpg"));

        final RestTemplate restTemplate = new RestTemplate();
//        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();

        JSONObject param = new JSONObject();
        param.put("app_id", appId);
        param.put("access_token", accessToken);
        param.put("image_type", "jpg");
        param.put("image_content", bytes);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> requestEntity = new HttpEntity<>(param, headers);

        final ResponseEntity<String> exchange = restTemplate.exchange("https://developer.toutiao.com/api/apps/ecpay/saas/image_upload", HttpMethod.POST, requestEntity, String.class);

        final HttpHeaders headers1 = exchange.getHeaders();
        System.out.println(exchange);
    }
}
