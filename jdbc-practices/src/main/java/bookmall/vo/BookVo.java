package bookmall.vo;

public class BookVo {

	private Long book_no; // 책 번호
	private String title; // 책 이름
	private Long price; // 책 가격
	private Long category_no; // 카테고리 번호

	/**
	 * @return the book_no
	 */
	public Long getBook_no() {
		return book_no;
	}

	/**
	 * @param book_no the book_no to set
	 */
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return the category_no
	 */
	public Long getCategory_no() {
		return category_no;
	}

	/**
	 * @param category_no the category_no to set
	 */
	public void setCategory_no(Long category_no) {
		this.category_no = category_no;
	}

	@Override
	public String toString() {
		return "BookVo [book_no=" + book_no + ", title=" + title + ", price=" + price + ", category_no=" + category_no
				+ "]";
	}

}
