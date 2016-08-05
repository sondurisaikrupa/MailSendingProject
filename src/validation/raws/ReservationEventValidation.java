package validation.raws;

import java.sql.Timestamp;

import string.date.conversions.DateUtility;

import com.business.constants.EDDCommonConstants;
import com.pojos.events.ReservationEvent;

public class ReservationEventValidation {
	
	public static ReservationEvent validateRawData(String rawData) throws Exception{
		System.out.println(EDDCommonConstants.PROCESSING_VALIDATION);
		
		String reservationId=rawData.substring(0, 1);
		String reservationDateTime=rawData.substring(1, 15);
		String reservationTypeCode=rawData.substring(15, 16);
		String infantBookedType=rawData.substring(16, 19);
		
		ReservationEvent reservationEvent=validatingData(reservationId,reservationDateTime,reservationTypeCode,infantBookedType); 
		
		return reservationEvent;
	}

	private static ReservationEvent validatingData(String reservationId,
			String reservationDateTime, String reservationTypeCode,
			String infantBookedType) throws Exception {
		Integer validatedReservationId=Integer.
				parseInt(reservationId);
		Timestamp validatedReservationDateTime=DateUtility.
				convertStringToDateTime(reservationDateTime);
		
		ReservationEvent reservationEvent = new 
				ReservationEvent(validatedReservationId, validatedReservationDateTime, reservationTypeCode, infantBookedType);
		
		return reservationEvent;
		
	}
 
}
