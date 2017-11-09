
public class Customer {
	private int id;
	private String first_name;
	private String last_name;
	private String address;
	private String email;
	private String cc_id;
	public Cart cart;
	Customer() {
		id = 0;
		first_name = null;
		last_name = null;
		address = null;
		email = null;
		cc_id = null;
		cart = null;
	}
	
	public void setID(int customerID) {
		id = customerID;
	}
	public int getID() {
		return id;
	}
	
	public void setName(String first, String last) {
		first_name = first;
		last_name = last;
	}
	public String getFirstName() {
		return first_name;
	}
	public String getLastName() {
		return last_name;
	}
	
	public void setAddress(String customerAddress) {
		address = customerAddress;
	}
	public String getAddress() {
		return address;
	}
	
	public void setEmail(String customerEmail) {
		email = customerEmail;
	}
	public String getEmail() {
		return email;
	}
	
	public void setCC_ID(String customerCC_ID) {
		cc_id = customerCC_ID;
	}
	public String getCC_ID() {
		return cc_id;
	}
	
	
}
