package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.MembersDao;
import bookmall.vo.BookVo;
import bookmall.vo.MembersVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		System.out.println("**********************개인 정보**********************");

		List<MembersVo> list = new MembersDao().findAll();
		for (MembersVo vo : list) {
			String info = String.format("[%d], 이름:%s, 전화:%s, 메일:%s, 비번:%s", vo.getMember_no(), vo.getName(),
					vo.getPhone(), vo.getEmail(), vo.getPassword());

			System.out.println(info);
		}
		System.out.println("**********************개인 정보**********************\n");
	}

	private static void insertTest() {
		MembersVo vo = null;
		MembersDao dao = new MembersDao();

		vo = new MembersVo();
		vo.setName("Luffy");
		vo.setEmail("Monkey.com");
		vo.setPassword("1234");
		vo.setPhone("1-1");
		dao.insert(vo);

		vo = new MembersVo();
		vo.setName("Zoro");
		vo.setEmail("Roronoa.com");
		vo.setPassword("5678");
		vo.setPhone("2-2");
		dao.insert(vo);

		System.out.println("Member 입력 성공");

	}

}
