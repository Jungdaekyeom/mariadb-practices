package bookmall.main;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import bookmall.dao.BookDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.test.BookDaoTest;
import bookmall.dao.test.CategoryDaoTest;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookMall {
	public static void main(String[] args) {

		while (true) {
			System.out.println("**********************기본 메뉴**********************");

			System.out.println("메뉴를 선택하세요.");
			System.out.println("1번 : 도서정보 출력");
			System.out.println("2번 : 카테고리 정보");

			InputStream is = System.in;
			Scanner scanner = new Scanner(is);
			Long no = scanner.nextLong();

			if (no == 1L) {
				displayBookInfo(); // 도서 정보 출력 함수
			}
			
			if (no == 2L) {
				displayCategoryInfo(); // 도서 정보 출력 함수
			}

		}

	}

	private static void displayBookInfo() {
		System.out.println("**********************도서 정보**********************");

		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			String info = String.format("[%d] 제목 : %s, \t가격:%s \t카테고리번호:%s", vo.getBook_no(), vo.getTitle(),
					vo.getPrice(), vo.getCategory_no());

			System.out.println(info);
		}

	}
	
	private static void displayCategoryInfo() {
		System.out.println("**********************카테 고리**********************");

		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			String info = String.format("카테고리번호:%d, 카테고리명:%s", vo.getNo(), vo.getName());

			System.out.println(info);
		}

	}

}
