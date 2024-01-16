package com.techacademy;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController<DayOfWeek> {

    @GetMapping("/dispDayOfWeek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable int yyyy,@PathVariable int mm,@PathVariable int dd) {
        LocalDate ld = LocalDate.of(yyyy, mm, dd);
        DayOfWeek w = ld.getDayOfWeek();
        return w.getDisplayName(TextStyle.LocaleDate.JAPANESE);
        }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
}