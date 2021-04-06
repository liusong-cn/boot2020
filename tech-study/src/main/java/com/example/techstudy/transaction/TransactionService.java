package com.example.techstudy.transaction;

import com.example.techstudy.entity.Student;
import com.example.techstudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author: Administrator
 * @date: 2021/3/8 23:32
 * 用于验证spring事务管理功能
 */
@Service
public class TransactionService {

//    @Autowired
//    private DataSourceTransactionManager transactionManager;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private StudentService studentService;



    public void doTransaction(){
        System.out.println("do something else");
        System.out.println("begin transaction");

        for (int i = 0; i < 3; i++) {
            //手动开启事务
            DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
            defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
            //事务状态
            TransactionStatus status = platformTransactionManager.getTransaction(defaultTransactionDefinition);
            try {
                Student student = new Student();
                student.setName("zhang" + i);
                student.setAge(i);
                student.setSex(1);
                studentService.create(student);
                if(i/2 == 0)
                    throw new RuntimeException("手工模拟抛出异常,并进行事务回滚");
                platformTransactionManager.commit(status);
            }catch (Exception e){
                //手工回滚此次事务
                platformTransactionManager.rollback(status);
            }

        }
    }
}
