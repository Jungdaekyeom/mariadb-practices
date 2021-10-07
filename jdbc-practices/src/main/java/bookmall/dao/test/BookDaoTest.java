package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		System.out.println("**********************도서 정보**********************");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			String info = String.format("[%d] 제목 : %s, \t가격:%s \t카테고리번호:%s", vo.getBook_no(), vo.getTitle(),
					vo.getPrice(), vo.getCategory_no());

			System.out.println(info);
		}
		System.out.println("**********************도서 정보**********************\n");

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

		System.out.println("Book 입력 성공");

	}

}
