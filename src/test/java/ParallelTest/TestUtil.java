package ParallelTest;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TestUtil extends ParallelExecution {

    public static String screenshotpath;

       public static void captureScreenshot(String methodName) throws IOException {

        //Using GregorianCalendar to fetch the time details
        Calendar cal = new GregorianCalendar();
        //Month value is always 1 less than actual. For February, MONTH would return 1 
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.HOUR_OF_DAY);

        //Take screen shot and store it in volatile memory with reference name scrFile
        File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {

            //Create unique file name and store in under screenshot folder of root directory
            screenshotpath = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + year + "_" + date+ "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpeg";
            
            //Copy the file to destination
            FileHandler.copy(scrFile, new File(screenshotpath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

}