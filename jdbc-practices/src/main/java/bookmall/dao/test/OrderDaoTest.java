package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		// findAllTest();
	}

	private static void findAllTest() {
		List<OrderVo> list = new OrderDao().findAll();
		for (OrderVo vo : list) {
			System.out.println(vo);
		}

	}

	private static void insertTest() {
		OrderVo vo = null;
		OrderDao dao = new OrderDao();

		vo = new OrderVo();
		vo.setMembers_no(2L); // 최종적으로 2번이 주문
		vo.setOrders_no(1L); // 주문번호 1번
		vo.setDelevery("동서대학교 센텀캠퍼스"); // 주소 - 동서대학교 센텀캠퍼스
		dao.insert(vo);

		System.out.println("입력 성공");

	}

}
