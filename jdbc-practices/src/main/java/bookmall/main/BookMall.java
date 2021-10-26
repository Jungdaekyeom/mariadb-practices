package bookmall.main;

import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CartDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.dao.test.MemberDaoTest;
import bookmall.dao.test.OrderDaoTest;
import bookmall.dao.test.OrderbookDaoTest;

public class BookMall {
	public static void main(String[] args) {

		System.out.println("MySQL <데이터베이스 모델링> -JDBC Programming-평가 과제입니다.");
		System.out.println("총 테이블 6개는 각각 2초의 간격을 두고 실행됩니다.");
		System.out.println("3초 뒤 실행됩니다.");

		for (int i = 3; i > 0; i--) {
			try {
				System.out.print(i + "  ");
				Thread.sleep(1000); // 1초 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 여러번 실행되면 안됨
		// PK, FK에 맞춰 순서 정렬해둠.
		// 순서 바뀌면 안됨.
		try {

			CategoryDaoTest categoryDaoTest = new CategoryDaoTest();
			categoryDaoTest.main(args);
			Thread.sleep(2000); // 2초 대기

			BookDaoTest bookDaoTest = new BookDaoTest();
			bookDaoTest.main(args);
			Thread.sleep(2000); // 2초 대기

			MemberDaoTest memberDaoTest = new MemberDaoTest();
			memberDaoTest.main(args);
			Thread.sleep(2000); // 2초 대기

			CartDaoTest cartDaoTest = new CartDaoTest();
			cartDaoTest.main(args);
			Thread.sleep(2000); // 2초 대기

			OrderDaoTest orderDaoTest = new OrderDaoTest();
			orderDaoTest.main(args);
			Thread.sleep(2000); // 2초 대기

			OrderbookDaoTest orderbookDaoTest = new OrderbookDaoTest();
			orderbookDaoTest.main(args);
			
			Thread.sleep(1000);
			System.out.println("끝났습니다.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
