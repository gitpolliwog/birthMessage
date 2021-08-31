package com.tk.subject;

import com.tk.observer.Observer;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 被观察者
 */
public interface Subject {

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 通知观察者，开始调用发送邮件
     *
     * @param to      待发送邮箱
     * @param title   消息标题
     * @param subject 消息内容
     */
    void notifyObserver(String to, String title, String subject);
}
