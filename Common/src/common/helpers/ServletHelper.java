package common.helpers;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class ServletHelper extends CommonHelper {

    public static void logRequestParams(HttpServletRequest request) {
        //notes: not gonna be pretty, needs a good refactor

        Enumeration<String> paramNameList = request.getParameterNames();
        while(paramNameList.hasMoreElements()) {
            String paramName = paramNameList.nextElement();
            String value = "";
            for (String str: request.getParameterValues(paramName)) {
                value += str;
            }

            logger.info("Parameter Name = " + paramName + " - Value(s) = "+value);
        }
    }
}
