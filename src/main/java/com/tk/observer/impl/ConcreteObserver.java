package com.tk.observer.impl;

import com.tk.observer.Observer;
import com.tk.util.MailUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 具体观察者，用于消息发送
 */
@Component
public class ConcreteObserver implements Observer {

    @Resource
    private MailUtil mailUtil;

    /**
     * 发送邮箱
     *
     * @param to      待发送邮箱
     * @param title   消息标题
     * @param subject 消息内容
     */
    @Override
    public void sendMessage(String to, String title, String subject) {
        mailUtil.sendMail(to, title, subject);
    }
}
