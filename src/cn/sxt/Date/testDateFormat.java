package cn.sxt.Date;

import com.sun.org.apache.xpath.internal.objects.XString;
import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDateFormat {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd:hh-mm-ss");
        String str = df.format(new Date(200000));
        System.out.println(str);
    }

}
