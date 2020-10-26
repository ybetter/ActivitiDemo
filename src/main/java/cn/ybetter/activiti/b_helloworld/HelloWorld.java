package cn.ybetter.activiti.b_helloworld;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;

/**
 * 模拟请假的流程
 *
 * @author yb
 * @since 2020/10/19
 */
public class HelloWorld {

    // 得到流程引擎
    {
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void deployProcess() {
        // 得到流程部署的service
    }

}
