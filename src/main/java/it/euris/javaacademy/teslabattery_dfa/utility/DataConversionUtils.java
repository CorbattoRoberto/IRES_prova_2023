package it.euris.javaacademy.teslabattery_dfa.utility;

import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.ComponentName;
import it.euris.javaacademy.teslabattery_dfa.data.entity.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DataConversionUtils {

    //TODO implementare una conversione a unita' di misura per ingredient

    private DataConversionUtils(){}

    public static String numberToString(Number value){
        return value == null ? null : value.toString();
    }

    public static Integer stringToInteger(String value){
        return value == null ? null : Integer.parseInt(value);
    }

    public static LocalDateTime stringToLocalDateTime(String value){
        return value == null ? null : LocalDateTime.parse(value);
    }

    public static String localDateTimeToString(LocalDateTime value){
        return value == null ? null : value.toString();
    }

    public static ComponentName stringToComponentName(String value) {
        for(ComponentName componentName : ComponentName.values()){
            if (componentName.name().equalsIgnoreCase(value))
                return componentName;
        }
        return null;
    }

    public static Status stringToStatus(String value) {
        for(Status status : Status.values()){
            if (status.name().equalsIgnoreCase(value))
                return status;
        }
        return null;
    }

    public static BigDecimal stringToBigDecimal(String value){
        return value == null ? null : new BigDecimal(value);
    }

    public static String bigDecimalToString(BigDecimal value){
        return value == null ? null : value.toString();
    }

    public static Boolean stringToBoolean(String value){
        return value == null ? null : Boolean.valueOf(value);
    }

    public static String booleanToString(Boolean value){
        return value == null ? null : value.toString();
    }

    public static String stringTypeToString(ComponentName value) {
        return value== null ? null : value.name();
    }
    public static String stringTypeToStatus(Status value) {
        return value== null ? null : value.name();
    }
}
