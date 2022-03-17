package totalclass.login;

import java.util.Map;

import totalclass.join.StudentDAO;
import totalclass.service.MainService;
import totalclass.util.ScanUtil;
import totalclass.util.View;

public class LoginService {
	private LoginService(){}
	private static LoginService instance;
	public static LoginService getInstance(){
		if(instance == null){
			instance = new LoginService();
		}
		return instance;
}
	private StudentDAO studentDao =StudentDAO.getInstance();
	
	public int login() {
		System.out.println("====================로그인====================");
		System.out.println("1.개인회원\t2.관리자\t0.뒤로가기");
		System.out.println("번호를 입력해주세요>");
		int input =ScanUtil.nextInt();
		
		switch(input){
		case 1: loginstudent(); 
			return View.MAIN;
		case 0: break;
		default:
			System.out.println("다시 입력해주세요");
			login();
			break;
		}
		return View.HOME;
	}
	
	public int loginstudent() {
		System.out.print("아이디>");
		String stuId = ScanUtil.nextLine();
		System.out.print("비밀번호>");
		String stuPw = ScanUtil.nextLine();
		
		Map<String, Object> user = studentDao.selectUser(stuId, stuPw);
		
		if(user == null){
			System.out.println("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");
		}else{
			System.out.println("로그인 성공");
			MainService.login = user;
			System.out.println(MainService.login.get("STU_NAME")+"님(학생) 어서오세요");
			return View.MAIN;
			}		
		return login();
	}
	
}