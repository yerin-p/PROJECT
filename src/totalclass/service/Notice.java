package totalclass.service;

import java.math.BigDecimal;

import totalclass.util.View;

public class Notice {
	private static Notice instance;
	public static Notice getInstance() {
		if(instance == null) {
			instance = new Notice();
		}
		return instance;
	}
	private Notice notice = Notice.getInstance();
	
	public int Notice() {//권한별 메뉴이동
		try{
			if(((BigDecimal) MainService.login.get("AUTH")).intValue()==1){
				stuNotice();
			}else {
				lecNotice();
			}
		}catch (NullPointerException a) {
			
			}
		
		return View.MAIN;
		}
	
	    
	public int stuNotice() {
		String[] keyname = {"공지사항"};
		String[] key = {"NOTICE_CONTENT"};
		System.out.println("====================공지사항===================");
		
			System.out.println(keyname[0] + " : "
					+ MainService.login.get(key[0]));
		
		System.out.println("===========================================");
		
		return 0;
	}
	
	public int lecNotice() {
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
