package kr.co.vo;

public class EmpVO {
	private String name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String leave_date;
	private int department_id;
	private int position_id;
	private String address;
	private long reg_no;
	private int bank_id;
	private String bank_account;
	
	
	
	public EmpVO(String name, String email, String phone_number, String hire_date, String leave_date, int department_id,
			int position_id, String address, long reg_no, int bank_id, String bank_account) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.leave_date = leave_date;
		this.department_id = department_id;
		this.position_id = position_id;
		this.address = address;
		this.reg_no = reg_no;
		this.bank_id = bank_id;
		this.bank_account = bank_account;
	}

	public EmpVO() {
		System.out.println("empvo inside");
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

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getLeave_date() {
		return leave_date;
	}

	public void setLeave_date(String leave_date) {
		this.leave_date = leave_date;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getPosition_id() {
		return position_id;
	}

	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getReg_no() {
		return reg_no;
	}

	public void setReg_no(long reg_no) {
		this.reg_no = reg_no;
	}

	public int getBank_id() {
		return bank_id;
	}

	public void setBank_id(int bank_id) {
		this.bank_id = bank_id;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	@Override
	public String toString() {
		return "EmpVO [name=" + name + ", email=" + email + ", phone_number=" + phone_number + ", hire_date="
				+ hire_date + ", leave_date=" + leave_date + ", department_id=" + department_id + ", position_id="
				+ position_id + ", address=" + address + ", reg_no=" + reg_no + ", bank_id=" + bank_id
				+ ", bank_account=" + bank_account + "]";
	}
	
	
	

}

