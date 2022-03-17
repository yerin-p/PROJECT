package totalclass.service;

import java.util.Map;

import totalclass.controller.Controller;
import totalclass.util.ScanUtil;
import totalclass.util.View;

public class MainService {
	public static Map<String, Object> login;

	private MainService(){}
	private static MainService instance;
	public static MainService getInstance(){
		if(instance == null){
			instance = new MainService();
		}
		return instance;
	}	
	public static void main(){
		new MainService().service();
	}
	
	
	
	
	public int service() {
		int view = View.MAIN;
		
		while(true){
			switch(view){
			case View.MAIN: view = serviceList(); break;
			case View.HOME: view = new Controller().start(); break;
			}
		}
	}
	

	public int serviceList(){
		System.out.println("===========================================");
		System.out.println(" 1. 마이메뉴\t2. 수강신청\t3. 공지사항");
		System.out.println(" 4. 개인 Q&A\t5. 로그아웃\t0. 종료");
		System.out.println("===========================================");
		System.out.print(">");
		int input = ScanUtil.nextInt();
		
		switch(input){
		case 1:	return View.MYMENU;
		case 2: return View.SIGNUP;
		case 3: return View.NOTICE;
		case 4: return View.QNASTUDENT;
		case 5: 
			login = null;
			return View.HOME;
		case 0: 
			System.out.println("종료합니다.");
			System.exit(0);
		default :
			System.out.println("잘못 입력하였습니다.");
			break;
		}
		return View.MAIN;
	}
	
}