package file.io.operations;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import com.business.constants.EDDCommonConstants;

public class FileUtilityOperations {
	
	public static void writeDataToAFile(String data) throws IOException{
		System.out.println(EDDCommonConstants.PROCESSING_WRITE_OPERATION);
		File file= new File(EDDCommonConstants.FILE_PATH);
		FileUtils.writeStringToFile(file, data,"UTF-8");
		System.out.println(EDDCommonConstants.PROCESSED_WRITE_OPERATION);
	}
	
	public static void readDataFromAFile(String data) throws IOException{
		System.out.println(EDDCommonConstants.PROCESSING_READ_OPERATION);
		File file= new File(EDDCommonConstants.FILE_PATH);
		FileUtils.writeStringToFile(file, data,"UTF-8");
		System.out.println(EDDCommonConstants.PROCESSED_READ_OPERATION);
	}
	
}
