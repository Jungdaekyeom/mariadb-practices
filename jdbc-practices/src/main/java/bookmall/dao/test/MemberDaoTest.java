package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.MemberDao;
import bookmall.vo.BookVo;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {
		insertTest();
		// findAllTest();
	}

	private static void findAllTest() {
		List<MemberVo> list = new MemberDao().findAll();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}

	}

	private static void insertTest() {
		MemberVo vo = null;
		MemberDao dao = new MemberDao();

		vo = new MemberVo();
		vo.setName("Monkey D. Luffy");
		vo.setEmail("Monkey@naver.com");
		vo.setPassword("1234");
		vo.setPhone("010-1111-1111");
		dao.insert(vo);

		vo = new MemberVo();
		vo.setName("Roronoa Zoro");
		vo.setEmail("Zoro@gmail.com");
		vo.setPassword("5678");
		vo.setPhone("010-2222-2222");
		dao.insert(vo);
		
		System.out.println("입력 성공");

	}

}
