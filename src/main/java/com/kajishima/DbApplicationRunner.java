package com.kajishima;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.kajishima.service.ApplicationRunnerService;

@Component
public class DbApplicationRunner implements ApplicationRunner {

	@Autowired
	ApplicationRunnerService applicationRunnerService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		applicationRunnerService.applicationRunnerService();

	}

}
