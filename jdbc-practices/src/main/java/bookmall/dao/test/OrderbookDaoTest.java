package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderbookDao;
import bookmall.dao.OrdersDao;
import bookmall.vo.BookVo;
import bookmall.vo.OrderbookVo;
import bookmall.vo.OrdersVo;

public class OrderbookDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {

		System.out.println("**********************주문 목록**********************");

		List<OrderbookVo> list = new OrderbookDao().findAll();
		for (OrderbookVo vo : list) {
			String info = String.format("주문번호:%d, 책번호:%d, 수량:%d", vo.getOrders_no(), vo.getBook_no(), vo.getAmount());

			System.out.println(info);
		}
		System.out.println("**********************주문 목록**********************\n");

	}

	private static void insertTest() {
		OrderbookVo vo = null;
		OrderbookDao dao = new OrderbookDao();

		vo = new OrderbookVo();
		vo.setOrders_no(1L); // 책
		vo.setBook_no(3L); // 책 가격
		vo.setAmount(7L); // 책 가격
		dao.insert(vo);

		System.out.println("Orderbook 입력 성공");

	}

}
