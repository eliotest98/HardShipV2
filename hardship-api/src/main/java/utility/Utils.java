package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String formatDate(){
        SimpleDateFormat sdf = new SimpleDateFormat(); // creo l'oggetto
        String dataStr = sdf.format(new Date()); // data corrente
        sdf.applyPattern("dd-MM-yyyy");
        System.out.println(dataStr);
        return dataStr.substring(0,8);
    }
}
