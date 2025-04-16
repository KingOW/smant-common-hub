package com.smant.common.mail.service;

public interface EMailService {

    /**
     * 发送简单邮件消息
     * @param to
     * @param subject
     * @param text
     */
    public void sendSimpleEmail(String to, String subject, String text);
}
