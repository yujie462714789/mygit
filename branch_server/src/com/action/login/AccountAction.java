package com.action.login;

import com.action.common.ReceiveAction;
import com.service.impl.common.ObserveServiceImpl;

public class AccountAction extends ReceiveAction
{
    private ObserveServiceImpl ob = new ObserveServiceImpl();
    //������ע��۲����࣬��ȡ�۲��߻�ȡ��������Ϣ
    public AccountAction(ObserveServiceImpl ob)
    {
        this.ob = ob;
    }
    
    @Override
    public void doWork()
    {
        // TODO Auto-generated method stub
        System.out.println("�۲���  AccountAction  ��ʼ����    ");
    }
    
}
