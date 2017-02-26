package service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by bulov on 21.02.2017.
 */
public final class ProjectUtils {

    public static int random(int max, int min){
        return (int)(Math.random()*(max-min+1)+min);
    }

    public static int getWorkDays(LocalDate startDay, LocalDate endDay){
        long days = ChronoUnit.DAYS.between(startDay, endDay);
        int workDays = 0;
        for(int i = 0; i <= days; i++ ){
            DayOfWeek dayOfWeek = startDay.plusDays(i).getDayOfWeek();
            switch (dayOfWeek){
                case MONDAY:
                    workDays++;
                    break;
                case THURSDAY:
                    workDays++;
                    break;
                case WEDNESDAY:
                    workDays++;
                    break;
                case TUESDAY:
                    workDays++;
                    break;
                case FRIDAY:
                    workDays++;
                    break;
            }
        }
        return workDays;
    }


}
