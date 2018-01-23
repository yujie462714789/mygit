package com.action.login;

import com.action.common.ReceiveAction;
import com.service.impl.common.ObserveServiceImpl;

public class AccountAction extends ReceiveAction
{
    private ObserveServiceImpl ob = new ObserveServiceImpl();
    //工作者注入观察者类，获取观察者获取的属性信息
    public AccountAction(ObserveServiceImpl ob)
    {
        this.ob = ob;
    }
    
    @Override
    public void doWork()
    {
        // TODO Auto-generated method stub
        System.out.println("观察者  AccountAction  开始工作    ");
    }
    
}
