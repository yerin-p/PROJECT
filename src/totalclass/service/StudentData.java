package totalclass.service;

import java.util.HashMap;
import java.util.Map;

import totalclass.dao.StudentMenuDao;
import totalclass.util.ScanUtil;
import totalclass.util.View;

public class StudentData {
	private StudentData(){}//생성자
	private static StudentData instance;//변수생성
	public static StudentData getInstance(){
		if(instance == null){
			instance = new StudentData();
		}
		return instance;
}
	private StudentMenuDao studentMenuDao = StudentMenuDao.getInstance();
	
	public int Modify() {
		System.out.println("==========================================");
		System.out.println("1.수정\t2.탈퇴\t3.마이메뉴\t0.로그아웃");
		System.out.print("입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			update();
			Modify();
			break;
		case 2:
			delete();
			break;
		case 3:
			return View.MYMENU;
		case 0:
			System.out.println("로그아웃합니다.");
			return View.HOME;
		default:
			System.out.println("다시 입력해주세요");
			break;
		}
		return 0;

	}

	private int delete() {
		System.out.println("====================탈퇴====================");
		Map<String, Object> studata = new HashMap<>();
		System.out.println("정말로 탈퇴 하시겠습니까");
		System.out.print("1.YES\t2.NO");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			int result = studentMenuDao.delete();
			if (0 < result) {
				System.out.println("삭제 성공");
				System.out.println("처음 화면으로 돌아갑니다.");
				return View.HOME;
			} else {
				System.out.println("삭제 실패");
			}
			break;
		case 2:
			Modify();
			break;

		default:
			System.out.println("다시 입력해주세요");
			break;
		}
		return View.MAIN;
	}

	
	private void update() {
		System.out.println("====================수정====================");
		Map<String, Object> studata = new HashMap<>();
		String[] keyname = {"ID","PASSWORD","이름","생일","연락처","주소","성적","권한"};
		String[] key = {"STU_ID","STU_PW","STU_NAME","STU_BIR","STU_TEL","STU_ADD","STU_GPA","AUTH"};
				studata.put(key[0],MainService.login.get(key[0]));
		for (int i = 1; i < 7 ; i++) {
			System.out.println("1." + keyname[i] + "을 변경하시겠습니까?\t 2.다음");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				System.out.println(MainService.login.get(key[i])
						+ "\t<-를 대신할 값을 입력하세요>");
				String input2 = ScanUtil.nextLine();
				studata.put(key[i], input2);
				break;
			case 2:
				studata.put(key[i], MainService.login.get(key[i]));
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}
		}
		studata.put("AUTH", 1);
		studata.put(key[7], MainService.login.get(key[7]));
		int result = studentMenuDao.update(studata);
		
		
		
		if (0 < result) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}


}