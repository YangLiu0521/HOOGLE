package tw.com.hoogle.room.model;



public class RoomVO implements java.io.Serializable{
	private Integer roomAuto;
	private Integer hotelId;
	private Integer roomTotal;
	private Integer nonreserved;
	private String roomName;
	private String roomType;
	private Integer roomPrice;
	
	public Integer getRoomAuto() {
		return roomAuto;
	}
	public void setRoomAuto(Integer roomAuto) {
		this.roomAuto = roomAuto;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public Integer getRoomTotal() {
		return roomTotal;
	}
	public void setRoomTotal(Integer roomTotal) {
		this.roomTotal = roomTotal;
	}
	public Integer getNonreserved() {
		return nonreserved;
	}
	public void setNonreserved(Integer nonreserved) {
		this.nonreserved = nonreserved;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public Integer getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(Integer roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	
	
	

}
