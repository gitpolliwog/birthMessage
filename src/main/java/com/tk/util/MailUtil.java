package com.tk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 邮箱工具类
 */
@Component
public class MailUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送邮箱
     *
     * @param to      待发送邮箱
     * @param title   消息标题
     * @param subject 消息内容
     */
    public void sendMail(String to, String title, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setCc(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(subject);
        try {
            mailSender.send(message);
            logger.info("邮件已发送。");
        } catch (Exception e) {
            logger.error("邮件发送发生异常了！", e);
        }
    }
}
