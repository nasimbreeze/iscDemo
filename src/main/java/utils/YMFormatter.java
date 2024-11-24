package utils;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class YMFormatter{

public YearMonth YMFormatter(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM yy");
    YearMonth ym = YearMonth.parse(date, formatter);
    return ym;
    }
}
