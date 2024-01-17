package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{var1}") //曜日を取り出す
    public String dispDayOfWeek(@PathVariable String var1) {

        Integer i = Integer.valueOf(var1);
        String str = i.toString();

        int year = Integer.parseInt(str.substring(0, 4));   //最初の文字列の4文字まで切り出す
        int month = Integer.parseInt(str.substring(4, 6));  //文字列の5〜6文字目まで切り出す
        int date = Integer.parseInt(str.substring(6));  //文字列の7文字目まで切り出す

        String[] week_name = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

        Calendar cal = Calendar.getInstance();
        cal.set(year,month-1,date);
        int dayOfWeek =cal.get(Calendar.DAY_OF_WEEK)-1; //曜日の値を0~6までの範囲で曜日を表すため1をマイナスします。

        return week_name[dayOfWeek];
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