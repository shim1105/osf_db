package osf.service.impl;

import java.util.List;

import osf.dao.StudentDAO;
import osf.dao.impl.StudentDAOImpl;
import osf.service.StudentInfoService;
import osf.vo.StudentInfoVO;

public class StudentInfoServiceImpl implements StudentInfoService {
	private StudentDAO sdao= new StudentDAOImpl();
	
	@Override
	public List<StudentInfoVO> selectStudentInfoList() {
		return sdao.selectStudentInfoList();
	}

	@Override
	public StudentInfoVO selectStudentInfo() {
		return sdao.selectStudentInfo();
	}

	@Override
	public int insertStudentInfo(StudentInfoVO si) {
		return sdao.insertStudentInfo(si);
	}

	@Override
	public int updateStudentInfo(StudentInfoVO si) {
		return sdao.updateStudentInfo(si);
	}

	@Override
	public int deleteStudentInfo(StudentInfoVO si) {
		return sdao.deleteStudentInfo(si);
	}

}
