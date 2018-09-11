package jaxb.shorp;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *@descripion:
 *
 *@author 10068921(LgyTT)
 *@date 2018/8/21 15:18
 */
public class DateAdapter extends XmlAdapter<String , Date> {
    private String pattern="yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat fmt=new SimpleDateFormat(pattern);
    @Override
    public Date unmarshal(String v) throws Exception {
        return fmt.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return fmt.format(v);
    }
}
