package one;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


/*
 *@author 10068921(LgyTT@alog.com)
 *@date 2018/8/10 9:56
 *@description:
  *Java8的时间和日期
 */public class Data_Time {

     private void getNow()//获得当前时间
     {
        LocalDateTime now=LocalDateTime.now();// 取当前日期
         LocalDate localDate = LocalDate.of(2018, 12, 8);// 根据年月日取日期，12月就是12：
         LocalDate endOfFeb = LocalDate.parse("2014-02-28");
         int y=localDate.getYear();//年
         int y1=endOfFeb.getYear();
         Month m=localDate.getMonth();//月
         int d=localDate.getDayOfMonth();//日
        int yd= localDate.getDayOfYear();//年中的第几天
         System.out.println(yd);
         System.out.println(LocalDate.now().isLeapYear());//是不是闰年

     }
     private void MonthDay()//查看重复日
     {
         LocalDate now =LocalDate.now();
         MonthDay md=MonthDay.of(8,10);
         MonthDay day=MonthDay.from(now);
         if(md.equals(day))
             System.out.println("today is your birthday!");
         else System.out.println("today is not your birthday!");
     }
     private void period(){//计算两个时间之间的天数，月数
         LocalDate now=LocalDate.now();
         LocalDate of=LocalDate.of(2014,9,15);
         Period period=Period.between(of,now);
         System.out.println("The days are "+period.getDays());
         System.out.println("The year ="+period.getYears());
         System.out.println("The month ="+period.getMonths());
     }
     private void zonld(){//时区不同处理
         LocalDateTime now =LocalDateTime.now();
         ZonedDateTime zoneTime=now.atZone(ZoneId.systemDefault());
         ZonedDateTime zonedtime1=ZonedDateTime.of(now,ZoneId.systemDefault());

        // LocalDateTime datetime = LocalDateTime.of(2014, Month.JANUARY, 14, 19, 30);
         ZoneOffset offset=ZoneOffset.of("+05:30");
         OffsetDateTime time=OffsetDateTime.of(now,offset);
         System.out.println("Time="+time);
         System.out.println("1="+zoneTime);
         System.out.println("2="+zonedtime1);
     }
    private void with() {
        LocalDate today = LocalDate.now();
        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth()); //2018-08-01
// 取本月第2天：
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2); //2018-08-02
// 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth()); // 2018-08-31
// 取下一天：
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1); // 变成了2018-09-01
// 取2015年1月第一个周一，这个计算用Calendar要死掉很多脑细胞：
        LocalDate firstMondayOf2015 = LocalDate.parse("2015-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)); // 2015-01-05
        System.out.println(firstMondayOf2015);
    }
    private  void parse2(){//使用预定义的格式器对时间进行解析和格式化
         String date="2018-08-10";
        DateTimeFormatter datetimef=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local=LocalDate.parse(date,datetimef);
        System.out.println("local="+local);

        LocalDate now =LocalDate.now();
        DateTimeFormatter dateformate=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String local1=now.format(dateformate);
        System.out.println("String dates="+local1);


    }
    @Test
    public void TestA(){

    }
     public static void main(String[]args){
         Data_Time dt=new Data_Time();
//         dt.getNow();
//         dt.MonthDay();
//         dt.period();
//         dt.zonld();
//         dt.with();
         dt.parse2();
     }




}
