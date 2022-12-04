package com.room.model;

import java.util.List;

public interface RoomDAO_interface {
	
	public void insert(RoomVO roomVO);
	public void update(RoomVO roomVO);
	public void delete(Integer roomAuto);
	public RoomVO findByPrimaryKey(Integer roomAuto);
	public List<RoomVO> getAll();
	
}
