package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderbookDao;
import bookmall.dao.OrdersDao;
import bookmall.vo.OrderbookVo;
import bookmall.vo.OrdersVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();
	}

	private static void findAllTest() {
		System.out.println("**********************주문 결과**********************");

		List<OrdersVo> list = new OrdersDao().findAll();
		for (OrdersVo vo : list) {
			String info = String.format("[%d] 회원번호:%d, 주문번호:%d, 결제금액:%d, 배달지역:%s", vo.getNo(), vo.getMembers_no(),
					vo.getOrders_no(), vo.getPayment(), vo.getDelevery());
			System.out.println("주문되었습니다.");
			System.out.println(info);
		}
		System.out.println("**********************주문 결과**********************\n");
	}

	private static void insertTest() {
		OrdersVo vo = null;
		OrdersDao dao = new OrdersDao();

		vo = new OrdersVo();
		vo.setMembers_no(2L); // 최종적으로 2번이 주문
		vo.setOrders_no(1L); // 주문번호 1번
		vo.setDelevery("동서대학교"); // 주소 - 동서대학교 센텀캠퍼스
		vo.setPayment(122500L);
		dao.insert(vo);

		System.out.println("Order 입력 성공");

	}

}
