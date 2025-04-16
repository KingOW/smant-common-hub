package com.smant.common.sms.service;

import java.util.Map;

public interface AliyunSmsService {

    public void sendTemplateSms(String phoneNumber, String template, Map<String,String> msgParam);
}
