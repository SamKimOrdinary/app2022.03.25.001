package jdbc.main;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class JdbcDaoMain {

	public static void main(String[] args) {
		
		// DAO 객체 생성
		MemberDao memberDao = new MemberDao();
		
		// Get Connection
		memberDao.getConnection();
		
		// Insert Data
		int nRet = memberDao.setData("김첨지", 180, 79, 19, "남");
		System.out.println(nRet + "건의 Transaction이 발생했습니다.");
		
		nRet = memberDao.setData("이첨지", 180, 79, 19, "남");
		System.out.println(nRet + "건의 Transaction이 발생했습니다.");
		
		MemberDto sndDto = new MemberDto();
		sndDto.setName("너구리");
		sndDto.setHeight(170);
		sndDto.setWeight(100);
		sndDto.setAge(55);
		sndDto.setSex("여");
		nRet = memberDao.setData(sndDto);
		System.out.println(nRet + "건의 Transaction이 발생했습니다.");
		
		// Read Data
		memberDao.getData();
		
		List list = memberDao.getListData();
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		// Close Connection
		memberDao.closeConnection();
	}

}
