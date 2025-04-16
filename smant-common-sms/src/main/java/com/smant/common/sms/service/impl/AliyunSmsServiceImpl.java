package com.smant.common.sms.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.aliyun.sdk.service.dysmsapi20180501.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateRequest;
import com.aliyun.sdk.service.dysmsapi20180501.models.SendMessageWithTemplateResponse;
import com.smant.common.sms.service.AliyunSmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service(value = "aliyunSmsService")
@Slf4j
public class AliyunSmsServiceImpl implements AliyunSmsService {

    @Autowired
    @Qualifier(value = "smsClient")
    private AsyncClient smsClient;

    @Override
    public void sendTemplateSms(String phoneNumber, String template, Map<String, String> msgParam) {
        try {
            SendMessageWithTemplateRequest sendMessageWithTemplateRequest = SendMessageWithTemplateRequest.builder()
                    .build();
            CompletableFuture<SendMessageWithTemplateResponse> response = smsClient.sendMessageWithTemplate(sendMessageWithTemplateRequest);
            SendMessageWithTemplateResponse resp = response.get();
            log.info("发送短信响应结果：{}", JSONObject.toJSONString(resp));
        } catch (Exception e) {
            log.error("发送短信失败：阿里云发送短信接口出现异常.", e);
        } finally {
            smsClient.close();
        }
    }
}
