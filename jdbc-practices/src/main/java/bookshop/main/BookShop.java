package bookshop.main;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookShop {

	public static void main(String[] args) {

		// 책 리스트 보여주는 함수
		displayBookInfo();

		InputStream is = System.in;

		Scanner scanner = new Scanner(is);
		System.out.println("대여하고 싶은 책의 번호를 입력하세요.");

		Long no = scanner.nextLong();
		scanner.close();

		new BookDao().update(no, "대여중");

		// 책 리스트 보여주는 함수
		displayBookInfo();
	}

	private static void displayBookInfo() {

		System.out.println("******도서 정보 출력******");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			String info = String.format("[%d] 제목:%s, 작가:%s, 대여유무:%s", vo.getNo(), vo.getTitle(), vo.getAuthorName(),
					vo.getStatus());
			System.out.println(info);
		}
	}

}
