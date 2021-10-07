package bookmall.vo;

public class MembersVo {

	private Long member_no; // 회원번호.
	private String name;
	private String email;
	private String password;
	private String phone;

	public Long getMember_no() {
		return member_no;
	}

	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberVo [member_no=" + member_no + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + "]";
	}

}
