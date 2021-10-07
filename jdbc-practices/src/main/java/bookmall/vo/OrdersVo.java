package bookmall.vo;

public class OrdersVo {
	private Long no;
	private Long members_no;
	private Long orders_no;
	private Long payment;
	private String delevery;

	/**
	 * @return the no
	 */
	public Long getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(Long no) {
		this.no = no;
	}

	/**
	 * @return the member_no
	 */
	public Long getMembers_no() {
		return members_no;
	}

	/**
	 * @param member_no the member_no to set
	 */
	public void setMembers_no(Long members_no) {
		this.members_no = members_no;
	}

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
	 * @return the payment
	 */
	public Long getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Long payment) {
		this.payment = payment;
	}

	/**
	 * @return the delevery
	 */
	public String getDelevery() {
		return delevery;
	}

	/**
	 * @param delevery the delevery to set
	 */
	public void setDelevery(String delevery) {
		this.delevery = delevery;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", members_no=" + members_no + ", orders_no=" + orders_no + ", payment=" + payment
				+ ", delevery=" + delevery + "]";
	}

}
