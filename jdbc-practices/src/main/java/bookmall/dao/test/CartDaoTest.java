package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		System.out.println("**********************장바 구니**********************");

		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			String info = String.format("회원번호:%d, 책번호:%d, 수량:%d", vo.getMembers_no(), vo.getBook_no(), vo.getAmount());

			System.out.println(info);
		}
		System.out.println("**********************장바 구니**********************\n");

	}

	private static void insertTest() {
		CartVo vo = null;
		CartDao dao = new CartDao();

		vo = new CartVo();
		vo.setMembers_no(1L); // 1번이 카트에 넣은 것
		vo.setBook_no(2L); // 2번 책
		vo.setAmount(3L); // 수량 3개
		dao.insert(vo);

		vo = new CartVo();
		vo.setMembers_no(2L); // 2번이 카트에 넣은 것
		vo.setBook_no(3L); // 3번 책
		vo.setAmount(7L); // 수량 7개
		dao.insert(vo);

		System.out.println("Cart 입력 성공");

	}
}
