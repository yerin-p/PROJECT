package totalclass;

import totalclass.join.StudentVO;

public class TotalClassApplication {
	private static StudentVO session = new StudentVO();
	
	
	public static void main(String[] args) {
		// VO객체, DAO, Service, controller, View: MVC 패턴
		public static StudentVO getSession() {
	        return session;
	    }
	}

}
