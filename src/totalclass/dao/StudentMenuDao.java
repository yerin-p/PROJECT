package totalclass.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import totalclass.service.MainService;
import totalclass.util.JDBCUtil;

public class StudentMenuDao {
	private StudentMenuDao(){}
	private static StudentMenuDao instance;
	public static StudentMenuDao getInstance(){
		if(instance == null){
			instance = new StudentMenuDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();

	
	public int update(Map<String, Object> studata) {
		String sql = " update STUDENT set STU_ID=?,STU_PW=?,STU_NAME=?,STU_BIR=?,STU_TEL=?,STU_ADD=?,STU_GPA=?,AUTH=? where STU_ID = ? ";
		
		List<Object> p = new ArrayList<>();
		String[] key = {"STU_ID","STU_PW","STU_NAME","STU_BIR","STU_TEL","STU_ADD","STU_GPA","AUTH"};
		for (int i = 0; i < key.length; i++) {
			p.add(studata.get(key[i]));
		}
			p.add(studata.get("STU_ID"));
			
		return jdbc.update(sql, p);
	}	
	
	
	public int delete(){
		String sql = " delete from student where STU_ID=? ";
		List<Object> map = new ArrayList<>();
		map.add(MainService.login.get("STU_ID"));
		
		return jdbc.update(sql, map);
		
	}



}
	