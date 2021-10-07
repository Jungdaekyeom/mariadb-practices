package bookmall.vo;

public class CartVo {

	private Long members_no;
	private Long book_no;
	private Long amount;

	public Long getMembers_no() {
		return members_no;
	}

	public void setMembers_no(Long members_no) {
		this.members_no = members_no;
	}

	public Long getBook_no() {
		return book_no;
	}

	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CartVo [members_no=" + members_no + ", book_no=" + book_no + ", amount=" + amount + "]";
	}

}
