package com.action.common;

public class TestThread implements Runnable
{
    // �����̳߳�
//    public static void main(String[] args)
//    {
//        // ����3���̵߳��̳߳�
//        ThreadPool t = new ThreadPool(3);
//        t.addTask(new Runnable[] {new Task(), new Task(), new Task()});
//        t.addTask(new Runnable[] {new Task(), new Task(), new Task()});
//    }
    // ������
        private static volatile int i = 1;
        @Override
        public void run()
        {// ִ������
            System.out.println("���� " + (i++) + " ���");
        }
}
