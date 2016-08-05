package com.pojos.events;

import java.sql.Timestamp;

public class ReservationEvent {
	private int reservationId;
	private Timestamp reservationDateTime;
	private String reservationTypeCode;
	private String infantBookedType;
	
	public ReservationEvent() {
	}
	
	public Integer getReservationId() {
		return reservationId;
	}
	public ReservationEvent(Integer reservationId,
			Timestamp reservationDateTime, String reservationTypeCode,
			String infantBookedType) {
		super();
		this.reservationId = reservationId;
		this.reservationDateTime = reservationDateTime;
		this.reservationTypeCode = reservationTypeCode;
		this.infantBookedType = infantBookedType;
	}
	@Override
	public String toString() {
		return "ReservationEvent [reservationId=" + reservationId
				+ ", reservationDateTime=" + reservationDateTime
				+ ", reservationTypeCode=" + reservationTypeCode
				+ ", infantBookedType=" + infantBookedType + "]";
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}
	public Timestamp getReservationDateTime() {
		return reservationDateTime;
	}
	public void setReservationDateTime(Timestamp reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}
	public String getReservationTypeCode() {
		return reservationTypeCode;
	}
	public void setReservationTypeCode(String reservationTypeCode) {
		this.reservationTypeCode = reservationTypeCode;
	}
	public String getInfantBookedType() {
		return infantBookedType;
	}
	public void setInfantBookedType(String infantBookedType) {
		this.infantBookedType = infantBookedType;
	}
	
	
	
}
