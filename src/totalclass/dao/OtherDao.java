package totalclass.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import totalclass.util.JDBCUtil;

public class OtherDao {

	private static OtherDao instance;

	public static OtherDao getInstance() {
		if (instance == null)
			instance = new OtherDao();
		return instance;
	}

	private static JDBCUtil jdbc = JDBCUtil.getInstance();


	// 가이드 리스트 - 완
	public static List<Map<String, Object>> guideList() {
		String sql = "SELECT GUIDE_NO, GUIDE_TITLE, GUIDE_CONTENT, MAN_ID "
				+ "FROM GUIDE " + "ORDER BY GUIDE_NO DESC";

		return jdbc.selectList(sql);
	}

	// 가이드 게시글 조회 - 완
	public static List<Map<String, Object>> selectGuide(
			Map<String, Object> param) {

		String sql = "SELECT GUIDE_NO, GUIDE_TITLE, GUIDE_CONTENT, MAN_ID "
				+ "FROM GUIDE " + "WHERE GUIDE_NO =?";

		List<Object> p = new ArrayList<>();
		p.add(param.get("GUIDE_NO"));

		return jdbc.selectList(sql, p);
	}

	// 가이드 게시글 수정 - 완
	public static int updateGuide(Map<String, Object> param) {
		String sql = "UPDATE GUIDE SET GUIDE_TITLE = ?, GUIDE_CONTENT = ? "
				+ "WHERE GUIDE_NO = " + "(SELECT GUIDE_NO " + "FROM GUIDE "
				+ "WHERE GUIDE_NO = ?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("GUIDE_TITLE"));
		p.add(param.get("GUIDE_CONTENT"));
		p.add(param.get("GUIDE_NO"));
		return jdbc.update(sql, p);
	}

	// 가이드 게시글 삭제 - 완
	public static int deleteGuide(Map<String, Object> param) {
		String sql = "DELETE FROM GUIDE " + "WHERE GUIDE_NO = ("
				+ "SELECT GUIDE_NO " + "FROM GUIDE " + "WHERE GUIDE_NO = ?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("GUIDE_NO"));
		return jdbc.update(sql, p);
	}

	// 가이드 게시글 등록 - 완
	public static int insertGuide(Map<String, Object> param) {
		String sql = "INSERT INTO GUIDE (GUIDE_NO, GUIDE_TITLE, GUIDE_CONTENT, MAN_ID) "
				+ "VALUES (SEQGUIDENO.NEXTVAL, ?, ?, (SELECT DISTINCT MAN_ID FROM GUIDE WHERE MAN_ID = ?))";

		List<Object> p = new ArrayList<>();
		p.add(param.get("GUIDE_TITLE"));
		p.add(param.get("GUIDE_CONTENT"));
		p.add(param.get("MAN_ID"));
		return jdbc.update(sql, p);
	}

	// ------------------------------------------------------------------------------------

	// 공지 리스트 - 완
	public static List<Map<String, Object>> NoticeList() {
		String sql = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, MAN_ID "
				+ "FROM NOTICE " + "ORDER BY NOTICE_NO DESC";

		return jdbc.selectList(sql);
	}

	// 공지 게시글 조회 - 완
	public static List<Map<String, Object>> selectNotice(
			Map<String, Object> map) {

		String sql = "SELECT NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, MAN_ID "
				+ "FROM NOTICE " + "WHERE NOTICE_NO =?";

		List<Object> p = new ArrayList<>();
		p.add(map.get("NOTICE_NO"));

		return jdbc.selectList(sql, p);
	}
	
	// 공지 게시글 등록 - 완
	public static int insertNotice(Map<String, Object> map) {
		String sql = "INSERT INTO NOTICE (NOTICE_NO, NOTICE_TITLE, NOTICE_CONTENT, NOTICE_DATE, MAN_ID) "
				+ "VALUES (SEQGUIDENO.NEXTVAL, ?, ?, ?, "
				+ "(SELECT DISTINCT MAN_ID FROM GUIDE WHERE MAN_ID = ?))";

		List<Object> p = new ArrayList<>();
		p.add(map.get("NOTICE_TITLE"));
		p.add(map.get("NOTICE_CONTENT"));
		p.add(map.get("NOTICE_DATE"));
		p.add(map.get("MAN_ID"));
		return jdbc.update(sql, p);
	}

	
	// ------------------------------------------------------------------------------------

	// 가이드 게시글 수정 - 완
	public static int updateNotice(Map<String, Object> param) {
		String sql = "UPDATE NOTICE SET NOTICE_TITLE = ?, NOTICE_CONTENT = ? "
				+ "WHERE NOTICE_NO = " + "(SELECT NOTICE_NO " + "FROM NOTICE "
				+ "WHERE NOTICE_NO = ?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("NOTICE_TITLE"));
		p.add(param.get("NOTICE_CONTENT"));
		p.add(param.get("NOTICE_NO"));
		return jdbc.update(sql, p);
	}

	// 가이드 게시글 삭제 - 완
	public static int deleteNotice(Map<String, Object> param) {
		String sql = "DELETE FROM NOTICE " + "WHERE NOTICE_NO = ("
				+ "SELECT NOTICE_NO " + "FROM NOTICE " + "WHERE NOTICE_NO = ?)";

		List<Object> p = new ArrayList<>();
		p.add(param.get("NOTICE_NO"));
		return jdbc.update(sql, p);
	}



}