package com.action.common;

public class TestThread implements Runnable
{
    // 测试线程池
//    public static void main(String[] args)
//    {
//        // 创建3个线程的线程池
//        ThreadPool t = new ThreadPool(3);
//        t.addTask(new Runnable[] {new Task(), new Task(), new Task()});
//        t.addTask(new Runnable[] {new Task(), new Task(), new Task()});
//    }
    // 任务类
        private static volatile int i = 1;
        @Override
        public void run()
        {// 执行任务
            System.out.println("任务 " + (i++) + " 完成");
        }
}
