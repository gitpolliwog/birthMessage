package com.tk.schedule;

import com.tk.observer.impl.ConcreteObserver;
import com.tk.subject.impl.ConcreteSubject;
import com.tk.util.FileUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Calendar;

/**
 * @author taoke
 * @date 2021-8-30 21:37:20
 * @description 定时器，每日九点开始发送消息
 */
@Service
public class ScheduledService {

    /**
     * 待发送内容
     */
    private String SUBJECT = "祝你生日快乐，天天开心哦!";

    @Resource
    private ConcreteObserver observer;

    /**
     * 定时器入口
     */
    @Scheduled(cron = "0 16 8 * * *")
    public void run() {
        //读取message.txt文件
        String s = FileUtil.readTextContent("/message.txt");
        if (!StringUtils.isEmpty(s)) {
            String[] text = s.split(",");
            String number = text[0];
            String name = text[1];
            String birthDay = text[2];
            String mail = text[3];
            if (isBirthDay(birthDay)) {
                ConcreteSubject concreteSubject = new ConcreteSubject();
                concreteSubject.addObserver(observer);
                concreteSubject.notifyObserver(mail, "生日快乐！", "工号为" + number + "的客户" + name + " ，" + SUBJECT);
            }

        }

    }

    /**
     * 判断传入的日期和今天相比，今天是否是生日
     *
     * @param birthDay 出生日期
     * @return 结果
     */
    private boolean isBirthDay(String birthDay) {
        Calendar now = Calendar.getInstance();
        if (!StringUtils.isEmpty(birthDay)) {
            String[] split = birthDay.split("-");
            if (split.length > 2) {
                String month = (now.get(Calendar.MONTH) + 1) + "";
                month = month.length() == 1 ? "0" + month : month;
                String day = (now.get(Calendar.DAY_OF_MONTH)) + "";
                if (split[1].equals(month) && split[2].equals(day)) {
                    return true;
                }
            }
        }
        return false;
    }

}
