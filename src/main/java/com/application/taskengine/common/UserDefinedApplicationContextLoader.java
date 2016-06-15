package com.application.taskengine.common;

import com.application.common.context.ApplicationServiceLocator;
import com.application.config.contextloader.ApplicationContextLoaderListener;
import com.application.taskengine.itf.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;

/**
 * Created by cheng on 2015/8/25.
 */
@Component
public class UserDefinedApplicationContextLoader extends ApplicationContextLoaderListener {

	private static final Logger logger = LoggerFactory.getLogger(UserDefinedApplicationContextLoader.class);

	@Override public void contextInitialized(ServletContextEvent servletContextEvent) {
		super.contextInitialized(servletContextEvent);
		initTaskCentry(servletContextEvent);
	}


		/**
         * 初始化任务中心
         * @author cheng
         * 2014年7月27日
         * 下午9:28:15
         * @param event
         */
	private void initTaskCentry(ServletContextEvent event) {
		logger.info("task init");
		ApplicationServiceLocator.getBean(ITaskService.class).initTask();
	}
}