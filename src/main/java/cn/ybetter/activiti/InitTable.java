package cn.ybetter.activiti;

import org.activiti.engine.*;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 初始化，在数据库中生成activiti相关表
 *
 * @author yb
 * @since 2020/10/12
 */
public class InitTable {

    /**
     * 初始化数据库表方式一
     */
    @Test
    public void initTable1() {

        // 创建数据源
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/activiti_demo");
//        dataSource.setUsername("root");
//        dataSource.setPassword("root");
        // 创建流程引擎的配置
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.jdbc.Driver");
        configuration.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/activiti_demo");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("root");
        /**
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE 如果数据库中没有activiti的表，他也不会创建
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP 创建表，使用完之后删除
         * ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE 如果数据库里面没有表，就创建
         *
         * drop_create 代表如果数据库里面有表，那么先删除在创建
         */
        // 配置表的初始化方式
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 得到流程引擎
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * 初始化数据库表方式二
     */
    @Test
    public void initTable2() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("/activiti.cfg.xml");
        // 得到流程引擎
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * 初始化数据库表方式三
     */
    @Test
    public void initTable3() {
        // 使用这种方式必须创建activiti.cfg.xml 并配置好数据库的信息
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
        // 流程图的部署、修改、删除的服务器act_ge_bytearray,act_re_deployment,act_re_model,act_re_procdef
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 流程运行act_ru_event_subscr,act_ru_execution,act_ru_identitylink,act_ru_job,act_ru_task,act_ru_variable
        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService = processEngine.getTaskService();
        // 查询历史记录的服务器act_hi_actinst,act_hi_attachment,act_hi_comment,act_hi_detail,act_hi_identitylink,act_hi_procinst,act_hi_taskinst,act_hi_varinst
        HistoryService historyService = processEngine.getHistoryService();
        // 页面表单的服务器[了解]
        FormService formService = processEngine.getFormService();
        // 对工作流的用户管理的表的操作act_id_group,act_id_info,act_id_membership,act_id_user
        IdentityService identityService = processEngine.getIdentityService();
        // 管理器
        ManagementService managementService = processEngine.getManagementService();

    }

    /**
     * 初始化数据库表方式四
     */
    @Test
    public void initTable4() {
        // 使用这种方式必须创建activiti.cfg.xml 并配置好数据库的信息
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println(processEngine);
    }

}
