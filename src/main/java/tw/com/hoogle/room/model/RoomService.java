package tw.com.hoogle.room.model;

import java.util.List;



public class RoomService {	

		private RoomDAO_interface dao;

		public RoomService() {
			dao = new RoomDAO();
		}

		public RoomVO addRoom( Integer hotelId, Integer roomTotal, Integer nonreserved,String roomName, String roomType,Integer roomPrice) {

			RoomVO roomVO = new RoomVO();
			
			//roomVO.setRoomAuto(roomAuto);
			roomVO.setHotelId(hotelId);
			roomVO.setRoomTotal(roomTotal);
			roomVO.setNonreserved(nonreserved);
			roomVO.setRoomName(roomName);
			roomVO.setRoomType(roomType);
			roomVO.setRoomPrice(roomPrice);
			dao.insert(roomVO);

			return roomVO;
		}

		

		public RoomVO updateRoom(Integer roomAuto ,Integer hotelId, Integer roomTotal, Integer nonreserved,String roomName, String roomType,Integer roomPrice) {


			RoomVO roomVO = new RoomVO();
			
			roomVO.setRoomAuto(roomAuto);
			roomVO.setHotelId(hotelId);
			roomVO.setRoomTotal(roomTotal);
			roomVO.setNonreserved(nonreserved);
			roomVO.setRoomName(roomName);
			roomVO.setRoomType(roomType);
			roomVO.setRoomPrice(roomPrice);
			dao.update(roomVO);
			return roomVO;
			
		}
		public void deleteRoom(Integer roomAuto) {
			dao.delete(roomAuto);
		}

		public RoomVO getOneRoom(Integer roomAuto) {
			return dao.findByPrimaryKey(roomAuto);
		}

		public List<RoomVO> getAll() {
			return dao.getAll();
		}
	

		// 預留給 Struts 2 用的
		public void updateRoom(RoomVO roomVO) {
			dao.update(roomVO);
		}


		
			
}
//		
//		public void deleteRoom(Integer roomAuto) {
//			dao.delete(roomAuto);
//		}
//		
//		public RoomVO getOneRoom(Integer roomAuto) {
//			return dao.findByPrimaryKey(roomAuto);
//		}
//		
//		public List<RoomVO> getAll(){
//			return dao.getAll();
//		}
//
//	}


