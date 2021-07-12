package com.daliu.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

@SpringBootTest
class ActivitiApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 部署流程定义<br/>
     * 这里使用RepositoryService部署流程定义
     * addClasspathResource表示从类路径下加载资源文件，一次只能加载一个文件
     **/
    @Test
    public void deployProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deploy = repositoryService.createDeployment().name("请假流程")
                .addClasspathResource("processes/LeaveProcess.bpmn").deploy();
        System.out.println("部署成功，流程ID：" + deploy.getId());
    }

    /**
     * 把bpmn和png压缩到LeaveProcess.zip里，再进行部署
     **/
    @Test
    public void deployProcess2() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程部署的service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //不加 '/' 代表当前文件夹
        //InputStream inputStream=this.getClass().getResourceAsStream("LeaveProcess.zip");
        //加 '/' 代表根目录classpath
        InputStream inputStream = this.getClass().getResourceAsStream("/LeaveProcess.zip");

        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        Deployment deploy = repositoryService.createDeployment().name("请假流程")
                .addZipInputStream(zipInputStream).deploy();
        System.out.println("部署成功:流程部署ID：" + deploy.getId());
    }

    /**
     * 启动流程
     **/
    @Test
    public void startProcess() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //String processDefinitionId = "LeaveProcess:2:12504";
        String processDefinitionKey = "LeaveProcess";
        //runtimeService.startProcessInstanceById(processDefinitionId);
        runtimeService.startProcessInstanceByKey(processDefinitionKey);
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
     * 查询流程部署信息 act_re_deployment
     **/
    @Test
    public void queryProcessDef() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程部署的service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Deployment> deploymentList = repositoryService.createDeploymentQuery()
                //条件
                //.deploymentId()
                //.deploymentNameLike()
                .deploymentName("请假流程")
                //排序
                .orderByDeploymentId().asc()
                //结果集
                //.count()
                //.singleResult()
                //.listPage()
                .list();

        deploymentList.forEach(deployment -> {
            System.out.println("部署id：" + deployment.getId());
            System.out.println("部署Name：" + deployment.getName());
            System.out.println("部署时间：" + deployment.getDeploymentTime());
            System.out.println("=====================");
        });
    }


}
