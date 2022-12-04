package com.ord.model;

import java.sql.Date;

public class OrdVO implements java.io.Serializable {
	
	private Integer ordId;
	private Integer userId;
	private Integer hotelId;
	private String userName;
	private String hotelName;
	private Date ordDate;
	private Date ordCheckin;
	private Date ordCheckout;
	private Integer ordNights;
	private String ordRemark;
	
	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public Date getOrdCheckin() {
		return ordCheckin;
	}
	public void setOrdCheckin(Date ordCheckin) {
		this.ordCheckin = ordCheckin;
	}
	public Date getOrdCheckout() {
		return ordCheckout;
	}
	public void setOrdCheckout(Date ordCheckout) {
		this.ordCheckout = ordCheckout;
	}
	public Integer getOrdNights() {
		return ordNights;
	}
	public void setOrdNights(Integer ordNights) {
		this.ordNights = ordNights;
	}
	public String getOrdRemark() {
		return ordRemark;
	}
	public void setOrdRemark(String ordRemark) {
		this.ordRemark = ordRemark;
	}
	
	
	
}
