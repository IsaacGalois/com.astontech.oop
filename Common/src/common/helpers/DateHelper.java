package common.helpers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateHelper extends CommonHelper {

    public static java.sql.Date utilDateToSqlDate(java.util.Date uDate) {
        java.sql.Date ret = null;
        if(uDate != null)
            ret = new java.sql.Date(uDate.getTime());
        return ret;
    }

    public static java.util.Date sqlDatetoUtilDate(java.sql.Date sDate) {
        java.util.Date ret = null;
        if(sDate != null)
            ret = new java.util.Date(sDate.getTime());
        return ret;
    }

    public static java.util.Date stringToUtilDate(String dateIn, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        java.util.Date dateOut = null;

        try {
            dateOut = dateFormat.parse(dateIn);
        } catch(ParseException parseEx) {
            logger.error(parseEx);
        }

        return dateOut;
    }
}
