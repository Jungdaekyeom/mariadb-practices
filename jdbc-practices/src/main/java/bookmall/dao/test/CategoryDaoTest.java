package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;
import bookshop.dao.AuthorDao;
import bookshop.vo.AuthorVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		findAllTest();

	}

	private static void findAllTest() {
		System.out.println("**********************카테 고리**********************");

		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			String info = String.format("카테고리번호:%d, 카테고리명:%s", vo.getNo(), vo.getName());

			System.out.println(info);
		}
		System.out.println("**********************카테 고리**********************\n");
	}

	private static void insertTest() {
		CategoryVo vo = null;
		CategoryDao dao = new CategoryDao();

		vo = new CategoryVo();
		vo.setName("스릴러");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setName("판타지");
		dao.insert(vo);

		vo = new CategoryVo();
		vo.setName("무협");
		dao.insert(vo);
		
		System.out.println("Category 입력 성공");


	}

}
