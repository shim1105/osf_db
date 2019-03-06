package osf.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import osf.dao.StudentDAO;
import osf.db.DBConnection;
import osf.vo.StudentInfoVO;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public List<StudentInfoVO> selectStudentInfoList() {
		String  sql= "select * from student_info ";
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<StudentInfoVO> studentList= new ArrayList<>();
			while(rs.next()) {
				StudentInfoVO si= new StudentInfoVO();
				si.setSiNum(rs.getInt("si_num"));
				si.setSiId(rs.getString("si_id"));
				si.setSiName(rs.getString("si_name"));				
				studentList.add(si);
				
			}
			return studentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public StudentInfoVO selectStudentInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("입력 아이디");
		String str= scan.nextLine();
		String  sql= "select * from student_info ";
		sql= " where si_id= "+str;
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			List<StudentInfoVO> studentList= new ArrayList<>();
			while(rs.next()) {
				StudentInfoVO si= new StudentInfoVO();
				si.setSiNum(rs.getInt("si_num"));
				si.setSiId(rs.getString("si_id"));
				si.setSiName(rs.getString("si_name"));	
				studentList.add(si);
				
			}
			for(StudentInfoVO sv:studentList) {
				return sv;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public int insertStudentInfo(StudentInfoVO si) {
		String sql= "insert into student_info";
		sql +=" (si_num,Si_id,si_pwd,si_name,si_age,si_phone,ci_num)";
		sql += " valuse(SEQ_student_Info_si_num.nextval, ";
		sql +=" ?,?,?,?,?,?)";
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement(sql);
			ps.setString(1,si.getSiId());
			ps.setString(2, si.getSiPwd());
			ps.setString(3, si.getSiName());
			ps.setInt(4, si.getSiAge());
			ps.setString(5, si.getSiPhone());
			ps.setInt(6, si.getCiNum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudentInfo(StudentInfoVO si) {
		String sql="update student_info ";
		sql +=" set si_pwd=?, si_name=?, si_age=?, si_phone=? where si_id=?";
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement(sql);
			ps.setString(1, si.getSiPwd());
			ps.setString(2, si.getSiName());
			ps.setInt(3, si.getSiAge());
			ps.setString(4,si.getSiPhone());
			ps.setString(5, si.getSiId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteStudentInfo(StudentInfoVO si) {
		String sql= "delete from student_info ";
		sql += " where si_id=?";
		try {
			PreparedStatement ps = DBConnection.getCon().prepareStatement(sql);
			ps.setString(1,si.getSiId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
}
