package main.apps;

import validation.raws.ReservationEventValidation;

import com.business.constants.EDDCommonConstants;
import com.pojos.events.ReservationEvent;

import email.utility.EmailUtility;
import file.io.operations.FileUtilityOperations;

public class AppForBusinessUtility {

	public static void main(String[] args) throws Exception {
		System.out.println(EDDCommonConstants.STARTED_JOB);
		
		String rawData=EDDCommonConstants.RAW_DATA;
		
		ReservationEvent validatedData=ReservationEventValidation.validateRawData(rawData);
		
		FileUtilityOperations.writeDataToAFile(validatedData.toString());
		
		EmailUtility.sendMailWithAttachment();
		
		System.out.println(EDDCommonConstants.ENDED_JOB);
	}
}
