package com.daliu.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Title: 接收任务
 * @Description:
 * @Author: daliu
 * @CreateTime: 2021-07-19 20:01
 * @Version:1.0
 **/
@SpringBootTest
public class ReceiveTaskTest {

    /**
     * 部署流程
     **/
    @Test
    public void deployProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //1.部署流程定义
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("接受任务流程")
                .addClasspathResource("processes/ReceiveTask.bpmn").deploy();
        System.out.println("部署成功，流程ID：" + deploy.getId());
    }

    /**
     * 启动流程
     **/
    @Test
    public void startProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processDefinitionKey = "RecieveTask";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println("启动流程成功");
        System.out.println("流程实例id：" + processInstance.getId());
    }

    /**
     * 查询执行对象
     **/
    @Test
    public void findExecution() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processInstanceId = "2501";
        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstanceId).singleResult();
        System.out.println("执行对象id：" + execution.getId());
    }

    /**
     * 任务查询
     **/
    @Test
    public void findTask() {
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
     * 查询当前的流程实例 act_ru_execution
     **/
    @Test
    public void queryProcessInstance() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> list = runtimeService.createProcessInstanceQuery().list();
        if (null != list && list.size() > 0) {
            for (ProcessInstance pi : list) {
                System.out.println("执行实例ID:" + pi.getId());
                System.out.println("流程定义ID:" + pi.getProcessDefinitionId());
                System.out.println("流程实例ID:" + pi.getProcessInstanceId());
                System.out.println("########################");
            }
        }
    }

    @Test
    public void executionTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String executionId = "2501";

        //使用流程变量设置当日销售额，用来传递业务参数
        int value = 10000;// 应该是去查询数据库，进行汇总 ---耗时操作
        runtimeService.setVariable(executionId, "当前的销售额", value);
        //向后执行一步，如果流程处于等待状态，使得流程继续执行
        runtimeService.signal(executionId);
    }

    @Test
    public void doTask() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String processDefinitionKey = "myProcess";
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
        System.out.println("流程启动成功:" + processInstance.getId() + "   " + processInstance.getProcessDefinitionId() + "  "
                + processInstance.getProcessInstanceId());
        /** 使用流程变量设置当日销售额，用来传递业务参数 */
        int value = 0;// 应该是去查询数据库，进行汇总 ---耗时操作
        int tryNum = 0;
        System.out.println("数据汇总完成");
        runtimeService.setVariable(processInstance.getId(), "当前的销售额", value);
        /** 向后执行一步，如果流程处于等待状态，使得流程继续执行 */
        runtimeService.signal(processInstance.getId());

        /** 从流程变量中获取汇总当日销售额的值 */
        Integer saleMoney = (Integer) runtimeService//
                .getVariable(processInstance.getId(), "当前的销售额");
        System.out.println(saleMoney);
        System.out.println("短信完成");
        /** 向后执行一步，如果流程处于等待状态，使得流程继续执行 */
        runtimeService.signal(processInstance.getId());
        System.out.println("流程执行完成");
    }

    /**
     * 发短信
     */
    @Test
    public void sendMessage() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        String executionId = "2501";
        /** 从流程变量中获取汇总当日销售额的值 */
        Integer value = (Integer) runtimeService//
                .getVariable(executionId, "当前的销售额");
        System.out.println("发送成功");

        /** 向后执行一步，如果流程处于等待状态，使得流程继续执行 */
        runtimeService.signal(executionId);
        System.out.println("流程执行完成");

    }

}