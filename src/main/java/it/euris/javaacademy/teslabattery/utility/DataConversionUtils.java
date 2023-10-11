package it.euris.javaacademy.teslabattery.utility;

import it.euris.javaacademy.teslabattery.data.enums.ProductiveCycleStatus;
import it.euris.javaacademy.teslabattery.data.enums.RobotTask;

import java.time.LocalDateTime;

public class DataConversionUtils {
    private DataConversionUtils() {
    }

    public static String numberToString(Number value) {
        return value == null ? null : value.toString();
    }

    public static Integer stringToInteger(String value) {
        return value == null ? null : Integer.parseInt(value);
    }

    public static LocalDateTime stringToLocalDateTime(String value) {
        return value == null ? null : LocalDateTime.parse(value);
    }

    public static String localDateTimeToString(LocalDateTime value) {
        return value == null ? null : value.toString();
    }


    public static RobotTask stringToRobotTask(String value) {
        for (RobotTask robotTaskValue : RobotTask.values()) {
            if (robotTaskValue.name().equalsIgnoreCase(value))
                return robotTaskValue;
        }
        return null;
    }

    public static String robotTaskToString(RobotTask value) {
        return value == null ? null : value.name();
    }

    public static ProductiveCycleStatus stringToProductiveCycleStatus(String value) {
        for (ProductiveCycleStatus productiveCycleStatusValue : ProductiveCycleStatus.values()) {
            if (productiveCycleStatusValue.name().equalsIgnoreCase(value))
                return productiveCycleStatusValue;
        }
        return null;
    }

    public static String productiveCycleStatusTaskToString(ProductiveCycleStatus value) {
        return value == null ? null : value.name();
    }


}
