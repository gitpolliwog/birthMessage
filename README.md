#启动步骤
1、用maven工具下载依赖

2、找到项目根目录下message.text

3、将出生日期修改为今天，例（2021-08-31/2021-8-31）

4、修改邮箱改为自己的邮箱

5、打开com.tk.schedule.ScheduledService

6、将run方法上的注解的cron表达式调整为指定日期，例如今天12点@Scheduled(cron = "0 0 12 * * *") ，这个日期就是定时器执行日期，即邮箱发送时间

7、启动主程序com.tk.MessageApplication 的main方法