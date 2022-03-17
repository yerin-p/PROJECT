package totalclass.join;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;

public class JoinDAO {
	public List<StudentVO> getStudents() throws Exception {
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
	    new OracleDriver();
		/*
		 * JDBC 순서
		 * 0. 드라이버 로딩
		 * 1. 드라이버를 통해 DB 접속(DB서버 주소, 사용자 계정, 비밀번호 필요)
		 * 2. 쿼리문 작성할 객체 생성(Statement)
		 * 3. 쿼리(질의)문 작성한 뒤 실행
		 * 4. 실행 결과를 돌려받음(ResultSet: Select에만 필요)
		 * 5. 자원 반납 
		 */
		
	    // 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 드라이버를 통해 DB 접속
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.36.33:1521:xe","PJ","java");
		// 쿼리문 작성 객체 생성
		Statement statement = connection.createStatement();
		// 쿼리문 작성
		String sql = "select stu_id, stu_password, stu_name, stu_bir, stu_tel, stu_add, stu_regDate, stu_grade from student";
		// 쿼리문 실행후 결과 받기
		ResultSet resultSet = statement.executeQuery(sql);
		
		List<StudentVO> list = new ArrayList<StudentVO>();
		
	    while (resultSet.next()) {
			String stuId = resultSet.getString("stu_id");
			String stuPassword = resultSet.getString("stu_password");
			String stuName = resultSet.getString("stu_name");
			String stuBir = resultSet.getString("stu_bir");
			String stuTel = resultSet.getString("stu_tel");
			String stuAdd = resultSet.getString("stu_add");
			Date stuRegDate = resultSet.getDate("stu_regDate");
			String stuGrade = resultSet.getString("stu_grade");
			list.add(new StudentVO(stuId, stuPassword, stuName, stuBir, stuTel, stuAdd, null, stuGrade));
	    }
	    // 자원반납
	    resultSet.close();
	    statement.close();
	    connection.close();
		return list;
	}
		
		public void insertMember(StudentVO vo) {
			
		}
		public int updateMember(StudentVO vo) throws Exception {
//			class.forName("oracle.jdbc.driver.OracleDriver");
			
			DriverManager.registerDriver(new OracleDriver()); //오타방지
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PYR","java");
			String sql = "update student set stu_name = ? where mem_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, vo.getMemJob());
			statement.setString(2, vo.getMemId());
			
			// 업데이트를 실행하고 난 결과: 업데이트한 row 갯수
			int executeUpdate = statement.executeUpdate();
			
			statement.close();
			connection.close();
			
			return executeUpdate;

		}
		public void deleteStudent(String id) {
			
		}

	}