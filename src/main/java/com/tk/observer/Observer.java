package com.tk.observer;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 观察者，用于消息发送
 */
public interface Observer {

    /**
     * 发送邮箱
     *
     * @param to      待发送邮箱
     * @param title   消息标题
     * @param subject 消息内容
     */
    void sendMessage(String to, String title, String subject);

}
