package com.action.common;

import java.util.LinkedList;
import java.util.List;

import org.python.modules.synchronize;

public final class ThreadPool// ���ܱ��̳��Զ����̳߳�
{
    private static int size;
    
    private WorkThread[] works;
    
    private List<Runnable> taskList = new LinkedList<Runnable>();
    
    public ThreadPool()
    {
        
    }
    
    public ThreadPool(int size)
    {
        this.size = size;// �߳���
        works = new WorkThread[size];
        for (WorkThread work : works)
        {
            work = new WorkThread();//����ʵ����
            work.start();
        }
    }
    
    public void addTask(Runnable[] tasks)
    {
        synchronized (taskList)
        {
            for (Runnable task : tasks)
            {
                taskList.add(task);
                taskList.notify();
            }
        }
    }
    
    private class WorkThread extends Thread
    {
        boolean isRunning = true;
        
        Runnable runn = null;
        
        public void run()
        {
            while (isRunning)
            {
                synchronized (taskList)
                {
                    while (isRunning && taskList.isEmpty())
                    {
                        try
                        {
                            taskList.wait(10);
                        }
                        catch (InterruptedException e)
                        {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (taskList != null)
                    {
                        runn = taskList.remove(0);
                        runn.run();
                    }
                }
            }
        }
    }
    
    
}

