package osf;

import osf.service.StudentInfoService;
import osf.service.impl.StudentInfoServiceImpl;
import osf.vo.StudentInfoVO;

public class Execute {
	public static void main(String[] args) {
		StudentInfoService sdao = new StudentInfoServiceImpl();
		StudentInfoVO si= new StudentInfoVO();
		si.setSiId("sdsssssdsd");
		sdao.deleteStudentInfo(si);
		System.out.println(sdao.selectStudentInfoList());
	
	}
}
