import com.bz.ActivityApplication;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:11411
 * @date: 2020/8/26 14:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivityApplication.class)
public class MyProcessTest {

    @Test
    public void deply() throws Exception{
        //获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("processes/useListener.bpmn")
                .deploy();
        System.out.println(deployment.getId() + "   " +  deployment.getName());
    }

    @Test
    public void startProcess() throws Exception{
        //获取流程引擎对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("useListener");
        System.out.println("pid:" + pi.getId() + ", activitiId:" + pi.getActivityId());

    }

    @Test
    public void startProcessWithVariables() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("manager","eric");
        variableMap.put("generalManager","thomson");
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("VacationRequest",variableMap  );
        System.out.println("pid:" + pi.getId() + ", activitiId:" + pi.getActivityId());
    }

    //查询任务
    @Test
    public void queryMyTask() throws Exception{
        //指定任务执行人
        String assignee = "lisi";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //由于在bpmn文件中没有设置assignee，所以主动设置
        processEngine.getTaskService().createTaskQuery().processInstanceId("12501").list().forEach(task -> {
            task.setAssignee("lisi");
            processEngine.getTaskService().saveTask(task);
        });
        //查询个人任务
        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assignee)
                .list();
        tasks.forEach(task -> System.out.println( task.getId() + ":" +task.getName()));
    }

    @Test
    public void queryTaskFormKey() throws Exception{
        String assignee = "jordon";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        List<Task> tasks = processEngine.getTaskService().createTaskQuery()
                .taskAssignee(assignee)
                .list();
        tasks.forEach(task -> System.out.println("taskId:" + task.getId() + ",taskName:" + task.getName()
        + ",formkey:" + task.getFormKey()));
    }

    @Test
    public void completeTask() throws  Exception{
        String taskId = "7502";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        processEngine.getTaskService().complete(taskId);
        System.out.println("mission completed");
    }

    @Test
    public void queryHistoryTasks() throws Exception{
        List<HistoricTaskInstance> list = ProcessEngines.getDefaultProcessEngine().getHistoryService()
                .createHistoricTaskInstanceQuery()
                .taskAssignee("lisi")
                .list();
        list.forEach(task -> System.out.println(task.getId() + ":" + task.getName()));
    }

    /**
     * 当前任务被处理，然后被提交给这个任务的owner，要求该任务为委派类型的，即该任务是某人委派给当前处理人处理的，处理人处理后
     * 再回到owner那里进一步处理
     * @throws Exception
     */
    @Test
    public void resolveTask() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        String taskId = "";
        processEngine.getTaskService().resolveTask(taskId);
        System.out.println("the task is resolved and sent back to the owner,but it need the task is delegated。taskId is:" + taskId );

    }

    @Test
    public void setVariables() throws Exception{
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        //也可以在流程启动时设置流程变量
//        processEngine.getRuntimeService().startProcessInstanceByKey("key",new HashMap<>()  );
        //单个设置变量，单线路中executionId等于procInstId
        runtimeService.setVariable("35001","sex","male");
        //批量设置变量
        Map<String ,String > variables = new HashMap<>();
        variables.put("height","1.7");
        variables.put("weight","50");
        runtimeService.setVariables("35001",variables);

        //单个获取变量
        String sex = (String) runtimeService.getVariable("35001","sex");
        //获取在流程启动时设置的变量manager
        String manager = (String) runtimeService.getVariable("35001","manager");
        //获取所有变量
        Map<String,Object> allVariableMap = runtimeService.getVariables("35001");
        //根据变量名称获取变量至map
        List<String> variableNames = new ArrayList<>();
        variableNames.add("height");
        variableNames.add("weight");
        Map<String ,Object> specialVariableMap = runtimeService.getVariables("35001",variableNames);

        //重复设值为覆盖，如不想覆盖，使用setLocalVariable,该方法设置的变量只针对当前活动有效
        runtimeService.setVariable("35001","sex","female");
        String sexChanged = (String) runtimeService.getVariable("35001","sex");
        System.out.println("test setting variables ");
    }



}
