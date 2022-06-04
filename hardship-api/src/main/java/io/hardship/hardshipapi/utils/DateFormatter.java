package io.hardship.hardshipapi.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatter {
    public static String dateFormatterByDate(Date date, FormatDateType type ) throws ParseException {
        SimpleDateFormat dateFor = new SimpleDateFormat(type.toString());
        String dateString = dateFor.format(date);
        return dateString;
    }
}
