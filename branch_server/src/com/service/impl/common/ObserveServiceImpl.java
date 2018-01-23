package com.service.impl.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.action.common.ReceiveAction;
import com.service.common.ObserverService;
@Service("ObserverService")
public class ObserveServiceImpl implements ObserverService
{
    public List<ReceiveAction> receives = new ArrayList<>();
    //����������
    public void addRece(ReceiveAction rece)
    {
        this.receives.add(rece);
    }
    
    public void deleteRece(ReceiveAction rece)
    {
        this.receives.remove(rece);
    }
    //list�洢�����ߣ�����ÿ�������߹���
    @Override
    public void Notify()
    {
        // TODO Auto-generated method stub
        for (ReceiveAction rece : receives)
        {
            rece.doWork();
        }
    }
}
