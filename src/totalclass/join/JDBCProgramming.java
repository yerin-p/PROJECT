package totalclass.join;

import java.util.List;
import java.util.Scanner;

public class JDBCProgramming {
	public static void main(String[] args) throws Exception {
		/*
		 * JDBC(Java DataBase Connectivity)
		 * 자바와 DBMS를  연결
		 * PDO(Php Data Objects)와 비슷
		 * 
		 * Driver가 필요
		 * Oracle JDBC Driver (ojdbc-숫자.jar)
		 * jar - Java Archive
		 * tar - Tape Archive
		 * war - web Application Archive
		 */
		
		JoinDAO dao = new JoinDAO();
		List<StudentVO> list = dao.getMembers();
		for (StudentVO vo : list) {
		    System.out.printf("%s \t %s \t %s \t %s\n",vo.getMemId(),vo.getMemName(),vo.getMemHp(),vo.getMemMail());

    	}
		Scanner scanner = new Scanner(System.in);
		System.out.print("조회할 아이디를 입력하세요: ");
		String searchId = scanner.next();
		StudentVO vo = dao.getMember(searchId);
		if (vo != null) {
			System.out.println("이름: " + vo.getMemName());
			System.out.println("직업: " + vo.getMemJob());
		}
		
		System.out.print("수정할 아이디를 입력하세요: ");
		String memId = scanner.next();
		System.out.print("변경할 직업을 입력하세요");
		String memJob = scanner.next();
		
		StudentVO updateVO = new StudentVO();
		updateVO.setMemJob(memJob);
		updateVO.setMemId(memId);
		// 직업 변경
		int updateMember = dao.updateMember(updateVO);
		// 변경 성공시 화면에ㅔ 내용 출력
		if (updateMember > 0) {
			MemberVO member = dao.getMember(memId);
			System.out.println(member.getMemName() + ": " + member.getMemJob() );
		}
		
		scanner.close();
	}

	

}

}
