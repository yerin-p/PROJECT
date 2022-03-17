package totalclass.join;

import java.sql.Date;
import java.util.Objects;

public class StudentVO {
	
	private String stuId;
	private String stuPassword;
	private String stuName;
	private String stuBir;
	private String stuTel;
	private String stuAdd;
	private Date stuRegDate;
	private String stuGrade;
	
	public StudentVO() {
	}

	public StudentVO(String stuId, String stuPassword) {
		this.stuId = stuId;
		this.stuPassword = stuPassword;
	}
	
	

	public StudentVO(String stuId, String stuPassword, String stuName, String stuBir, String stuTel, String stuAdd,
			Date stuRegDate, String stuGrade) {
		this.stuId = stuId;
		this.stuPassword = stuPassword;
		this.stuName = stuName;
		this.stuBir = stuBir;
		this.stuTel = stuTel;
		this.stuAdd = stuAdd;
		this.stuRegDate = stuRegDate;
		this.stuGrade = stuGrade;
	}

	
	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuPassword() {
		return stuPassword;
	}

	public void setStuPassword(String stuPassword) {
		this.stuPassword = stuPassword;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuBir() {
		return stuBir;
	}

	public void setStuBir(String stuBir) {
		this.stuBir = stuBir;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getStuAdd() {
		return stuAdd;
	}

	public void setStuAdd(String stuAdd) {
		this.stuAdd = stuAdd;
	}

	public Date getStuRegDate() {
		return stuRegDate;
	}

	public void setStuRegDate(Date stuRegDate) {
		this.stuRegDate = stuRegDate;
	}

	public String getStuGrade() {
		return stuGrade;
	}

	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(stuId, stuPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		return Objects.equals(stuId, other.stuId) && Objects.equals(stuPassword, other.stuPassword);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("StudentVO{");
        sb.append("custId=").append(stuId);
        sb.append(", stuPassword='").append(stuPassword).append('\'');
        sb.append(", stuName='").append(stuName).append('\'');
        sb.append(", stuBir='").append(stuBir).append('\'');
        sb.append(", stuTel='").append(stuTel).append('\'');
        sb.append(", stuAdd='").append(stuAdd).append('\'');
        sb.append(", stuRegDate='").append(stuRegDate).append('\'');
        sb.append(", stuGrade='").append(stuGrade).append('\'');
        sb.append('}');
        return sb.toString();
	}
	
	

}
