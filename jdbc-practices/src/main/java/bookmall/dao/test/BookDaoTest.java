package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		insertTest();
		// findAllTest();
	}
	
	private static void findAllTest() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}

	}

	private static void insertTest() {
		BookVo vo = null;
		BookDao dao = new BookDao();
		
		vo = new BookVo();
		vo.setTitle("메이즈 러너"); // 책 이름
		vo.setPrice(12500L); // 책 가격
		vo.setCategory_no(1L); // 책 카테고리 번호
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("스코치 트라이얼"); // 책 이름
		vo.setPrice(15000L); // 책 가격
		vo.setCategory_no(2L); // 책 카테고리 번호
		dao.insert(vo);
		
		vo = new BookVo();
		vo.setTitle("데스 큐어"); // 책 이름
		vo.setPrice(17500L); // 책 가격
		vo.setCategory_no(3L); // 책 카테고리 번호
		dao.insert(vo);
		
		System.out.println("입력 성공");

	}

}
