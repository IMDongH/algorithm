package java8.Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) {

        /**
         * mutable 하지 않다 - thread safe 하지 않음
         * date.setTime(before3Second); 를 하면 date 의 시간 값이 변하기 때문
         * 이름이 명확하지 않음 ex)date.getTime() 시간을 가져오는게 아니다.
         */
        Date date = new Date();

        /**
         * type safe 하지 않다 - month 의 경우 1월이 0부터 시작함 -> 10월이면 9 를 넣어주어야한다.
         */
        GregorianCalendar dongBirthDay = new GregorianCalendar(1999, Calendar.OCTOBER,7);
    }
}
