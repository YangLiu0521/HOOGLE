package tw.com.hoogle.compare.model;


public class CompareVO implements java.io.Serializable {
	private String hotelName;
	private String hotelAddress;
	private String roomName;
	private Integer roomPrice;
	private byte[] hotelpicNo;

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}

	public byte[] getHotelpicNo() {
		return hotelpicNo;
	}

	public void setHotelpicNo(byte[] hotelpicNo) {
		this.hotelpicNo = hotelpicNo;
	}



	
	
	
	

}
