package com.itfvck.wechatframework.timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service(value = "taskDemo")
public class TaskDemo {

	static Logger logger = LoggerFactory.getLogger(TaskDemo.class);

	public void demo() {
		logger.info("task demo " + System.currentTimeMillis());
	}

}
