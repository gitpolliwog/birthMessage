package com.tk.subject.impl;


import com.tk.observer.Observer;
import com.tk.subject.Subject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 具体被观察者
 */
public class ConcreteSubject implements Subject {

    /**
     * 同步容器
     */
    List<Observer> observers = Collections.synchronizedList(new ArrayList<>());

    /**
     * 添加观察者
     *
     * @param observer 观察者
     */
    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * 通知观察者，开始调用发送邮件
     *
     * @param to      待发送邮箱
     * @param title   消息标题
     * @param subject 消息内容
     */
    @Override
    public void notifyObserver(String to, String title, String subject) {
        for (Observer observer : observers) {
            observer.sendMessage(to, title, subject);
        }
    }

}
