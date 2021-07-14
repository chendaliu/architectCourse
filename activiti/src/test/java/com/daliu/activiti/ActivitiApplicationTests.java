package com.daliu.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.HashMap;
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
                //1.条件
                //.deploymentId()  //根据部署id查询
                //.deploymentTenantId()  //根据tenantId查询
                //.deploymentTenantIdLike()  //根据tenantId模糊查询
                //.deploymentNameLike()  //根据部署name模糊查询
                .deploymentName("请假流程")  //根据部署name查询
                //2.排序
                .orderByDeploymentId().asc()  //根据部署id升序
                //.orderByDeploymenTime().desc()  //根据部署时间降序
                //3.结果集
                //.count()  //返回数量
                //.singleResult()  //返回单个对象
                //.listPage()  //分页查询返回集合
                .list();  //返回集合

        deploymentList.forEach(deployment -> {
            System.out.println("部署id：" + deployment.getId());
            System.out.println("部署Name：" + deployment.getName());
            System.out.println("部署时间：" + deployment.getDeploymentTime());
            System.out.println("=====================");
        });
    }

    /**
     * 查询流程定义信息 ACT_RE_PROCDEF
     * 方法跟上面的类似
     **/
    @Test
    public void queryRpocDef() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到流程部署的service
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                //1.条件
                //.deploymentId()  //根据部署id查询
                //.deploymentIds()  //根据部署id集合查询
                .processDefinitionName("请假工作流") // 根据流程定义name查询
                //2.排序
                .orderByDeploymentId().asc()
                //3.结果集
                .list();

        list.forEach(processDefinition -> {
            System.out.println("流程定义id:" + processDefinition.getId());
            System.out.println("流程定义Name:" + processDefinition.getName());
            System.out.println("流程定义key:" + processDefinition.getKey());
            System.out.println("流程定义bpmn文件名:" + processDefinition.getResourceName());
            System.out.println("流程定义图片名:" + processDefinition.getDiagramResourceName());
            System.out.println("流程定义版本号:" + processDefinition.getVersion());
            System.out.println("=====================");
        });
    }

    /**
     * 删除流程定义信息
     * 方法跟上面的类似
     **/
    @Test
    public void deleteProcDef() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //repositoryService.deleteDeployment();
        String deploymentId = "30001";

        //根据流程部署id删除流程部署和流程定义（ACT_RE_DEPLOYMENT, ACT_RE_PROCDEF）。如果当前流程id的流程正在执行，会报错
        repositoryService.deleteDeployment(deploymentId);

        //根据流程部署id删除流程部署，如果当前流程id的流程正在执行，会把正在执行的流程数据删除，包括相关id的：act_re*和act_ru_*和act_hi_*
        //repositoryService.deleteDeployment(deploymentId, true);

        //下面这个方法等价于deleteDeployment(deploymentId, true)
        //repositoryService.deleteDeploymentCascade(deploymentId);
    }

    /**
     * 查询流程图
     **/
    @Test
    public void viewProcessImg() {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //流程定义id
        String processDefinetionId = "LeaveProcess:1:32504";
        String filePath = "d:/";
        File f = new File(filePath + "请假工作流.png");
        try (InputStream inputStream = repositoryService.getProcessDiagram(processDefinetionId);
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(f))) {

            int len = 0;
            byte[] b = new byte[1024];
            while ((len = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, len);
                outputStream.flush();
            }
            System.out.println(String.format("流程图已下载到：%s", filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询最新的流程定义
     **/
    @Test
    public void queryNewProcessDef() {
        HashMap<String, ProcessDefinition> map = new HashMap<>();
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        List<ProcessDefinition> processDefinitionList = repositoryService.createProcessDefinitionQuery()
                .processDefinitionName("请假工作流")
                .orderByProcessDefinitionVersion().desc()
                .listPage(0, 1);
        processDefinitionList.forEach(processDefinition -> {
            System.out.println("流程定义id:" + processDefinition.getId());
            System.out.println("流程定义Name:" + processDefinition.getName());
            System.out.println("流程定义key:" + processDefinition.getKey());
            System.out.println("流程定义bpmn文件名:" + processDefinition.getResourceName());
            System.out.println("流程定义图片名:" + processDefinition.getDiagramResourceName());
            System.out.println("流程定义版本号:" + processDefinition.getVersion());
            System.out.println("=====================");
        });
    }
}
