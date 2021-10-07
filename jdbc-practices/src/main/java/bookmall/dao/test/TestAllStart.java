package bookmall.dao.test;

public class TestAllStart {

	public static void main(String[] args) {		
		
		// 여러번 실행되면 안됨
		// PK, FK에 맞춰 순서 정렬해둠.
		// 순서 바뀌면 안됨.
		CategoryDaoTest categoryDaoTest = new CategoryDaoTest();
		categoryDaoTest.main(args);
		
		BookDaoTest bookDaoTest = new BookDaoTest();
		bookDaoTest.main(args);
		
		MemberDaoTest memberDaoTest = new MemberDaoTest();
		memberDaoTest.main(args);

		CartDaoTest cartDaoTest = new CartDaoTest();
		cartDaoTest.main(args);
		
		// 값을 어떻게 넣어야 할 지 모르겠어서 일단 보류
		// OrderDaoTest orderDaoTest = new OrderDaoTest();
		// orderDaoTest.main(args);
		

	}

}
