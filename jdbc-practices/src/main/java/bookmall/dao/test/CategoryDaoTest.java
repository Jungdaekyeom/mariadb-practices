package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;
import bookshop.dao.AuthorDao;
import bookshop.vo.AuthorVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		insertTest();
		// findAllTest();

	}

	private static void findAllTest() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}

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
		
		System.out.println("입력 성공");


	}

}
