package utils;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class YMFormatter{

public YearMonth ymFormatter(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM yy");
    return YearMonth.parse(date, formatter);
    }
}
