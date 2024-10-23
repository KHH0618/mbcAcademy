package com.lec.lect;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener("/LC")
public class Ex4WebListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 프로젝트가 메모리에 로드될때 실행
		System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ context 시작될 때 ★ ★ ★ ★ ★ ★ ★ ★ ★");
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("★ ★ ★ ★ ★ ★ ★ ★ ★ context 종료될 때 ★ ★ ★ ★ ★ ★ ★ ★ ★");
	}

}
