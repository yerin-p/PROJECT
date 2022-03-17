package totalclass.join;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import totalclass.util.JDBCUtil;

public class StudentDAO {
	private static StudentDAO instance;
	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(Map<Object, Object> map) {
		String sql = " insert into STUDENT (STU_ID,STU_PW,STU_NAME,STU_BIR,STU_TEL,STU_ADD,STU_GPA)"
				+ "values (?,?,?,?,?,?,?)";
		
		List<Object> p = new ArrayList<>();
		p.add(map.get("STU_ID"));
		p.add(map.get("STU_PW"));
		p.add(map.get("STU_NAME"));
		p.add(map.get("STU_BIR"));
		p.add(map.get("STU_TEL"));
		p.add(map.get("STU_ADD"));
		p.add(map.get("STU_GRADE"));
		return jdbc.update(sql,p);
	}
	
	
	public Map<String, Object> selectUser(String stuId, String stuPw) {
		String sql = "select * from STUDENT where stu_id = ? and stu_pw = ?"; 
		List<Object> map = new ArrayList<>();
		map.add(stuId);
		map.add(stuPw);
		
		return jdbc.selectOne(sql,map);
	}
	
	

}
