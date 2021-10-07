package bookmall.vo;

public class OrderbookVo {

	private Long orders_no;
	private Long book_no;
	private Long amount;

	/**
	 * @return the orders_no
	 */
	public Long getOrders_no() {
		return orders_no;
	}

	/**
	 * @param orders_no the orders_no to set
	 */
	public void setOrders_no(Long orders_no) {
		this.orders_no = orders_no;
	}

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
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderbookVo [orders_no=" + orders_no + ", book_no=" + book_no + ", amount=" + amount + "]";
	}

}
