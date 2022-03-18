package totalclass.service;

import java.math.BigDecimal;
import totalclass.util.ScanUtil;
import totalclass.util.View;

public class MyMenu {
	private static MyMenu instance;
	public static MyMenu getInstance(){
		if(instance == null){
			instance = new MyMenu();
		}
		return instance;
	}	
	private StudentData studata = StudentData.getInstance();
	
	
	public int myMenu() {//권한별 메뉴이동
	try{
		if(((BigDecimal) MainService.login.get("AUTH")).intValue()==1){
			albaMenu();
		}
		
		else {
			System.out.println("관리자는 확인할 수 없습니다.");
		}
	}catch (NullPointerException a) {
		
		}
	
	return View.MAIN;
	}
	
	

	public void albaMenu() {//마이메뉴
		System.out.println("=====================My menu======================");
		System.out.println("1.내 정보 보기\t 2.개인정보 수정/탈퇴 \t 3. 메인메뉴로 돌아가기");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			studata();
			break;
		case 2:
			studata.Modify();
			break;
		case 3:
			break;
			
		default:
			System.out.println("다시 입력해주세요.");
			break;
		}

	}
	
	
	


	public int studata() {
		String[] keyname = {"ID","PASSWORD","이름","생일","연락처","주소","성적"};
		String[] key = {"STU_ID","STU_PW","STU_NAME","STU_BIR","STU_TEL","STU_ADD","STU_GPA"};
		System.out.println("====================개인정보===================");
		for (int i = 0; i < 7; i++) {
			System.out.println(keyname[i] + " : "
					+ MainService.login.get(key[i]));
		}
		System.out.println("===========================================");
		
		return 0;
	}
	


	
}