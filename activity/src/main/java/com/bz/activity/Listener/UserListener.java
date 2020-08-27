package com.bz.activity.Listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

/**
 * @author:11411
 * @date: 2020/8/26 16:16
 **/
public class UserListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) {
        delegateExecution.setVariable("intoListener","true");
        System.out.println("listener working");
    }
}
