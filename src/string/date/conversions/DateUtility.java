package string.date.conversions;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateUtility {
	
	public static Timestamp convertStringToDateTime(String time) throws Exception{
		
		SimpleDateFormat simpleDateFormat = new 
				SimpleDateFormat("yyyyMMddHHmmss");
		Long l=simpleDateFormat.parse(time).getTime();
		Timestamp timestamp = new Timestamp(l);
		return timestamp;
	}

}
