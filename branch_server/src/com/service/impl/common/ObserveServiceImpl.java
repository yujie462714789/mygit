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
    //新增工作者
    public void addRece(ReceiveAction rece)
    {
        this.receives.add(rece);
    }
    
    public void deleteRece(ReceiveAction rece)
    {
        this.receives.remove(rece);
    }
    //list存储工作者，提醒每个工作者工作
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
