package com.daliu.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

/**
 * @Title: 排他网关demo
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-07-16 10:40
 * @Version:1.0
 **/
@SpringBootTest
public class ExclusiveGatewayProcessTest {
    /**
     * 部署流程
     **/
    @Test
    public void deployProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("报销流程")
                .addClasspathResource("processes/ExclusiveGateWay.bpmn").deploy();
        System.out.println("部署成功，流程ID：" + deploy.getId());
    }

    /**
     * 启动流程
     **/
    @Test
    public void startProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processDefinitionKey = "ExclusiveGateWay";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println("启动流程成功");
    }

    /**
     * 任务查询
     **/
    @Test
    public void findTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String assignee = "张三";
        //通过办理人查询任务
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(assignee).list();
        taskList.forEach(task -> {
            System.out.println("====================================");
            System.out.println("任务ID：" + task.getId());
            System.out.println("流程实例ID：" + task.getProcessInstanceId());
            System.out.println("执行实例ID：" + task.getExecutionId());
            System.out.println("流程定义ID：" + task.getProcessDefinitionId());
            System.out.println("任务名ID：" + task.getName());
            System.out.println("任务办理人：" + task.getAssignee());
        });
    }

    /**
     * 任务查询
     **/
    @Test
    public void findAllTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        //通过办理人查询任务
        List<Task> taskList = taskService.createTaskQuery().list();
        taskList.forEach(task -> {
            System.out.println("====================================");
            System.out.println("任务ID：" + task.getId());
            System.out.println("流程实例ID：" + task.getProcessInstanceId());
            System.out.println("执行实例ID：" + task.getExecutionId());
            System.out.println("流程定义ID：" + task.getProcessDefinitionId());
            System.out.println("任务名ID：" + task.getName());
            System.out.println("任务办理人：" + task.getAssignee());
        });
    }

    /**
     * 办理任务
     **/
    @Test
    public void completeTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        String taskId = "5007";
        HashMap<String, Object> variables = new HashMap<>();
        variables.put("money", 600);
        variables.put("member", "张三");
        taskService.complete(taskId, variables);

        System.out.println("任务完成");
    }

}