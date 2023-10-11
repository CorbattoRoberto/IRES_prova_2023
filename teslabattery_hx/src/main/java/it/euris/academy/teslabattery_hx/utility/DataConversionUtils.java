package it.euris.academy.teslabattery_hx.utility;


import it.euris.academy.teslabattery_hx.data.enums.StatoCicloProduttivo;
import it.euris.academy.teslabattery_hx.data.enums.TipoRobot;

import java.time.LocalDateTime;

public class DataConversionUtils {


    public static String numberToString(Number value){
        return value == null ? null : value.toString();
    }
    public static Integer stringToInteger(String value){
        return value == null ? null : Integer.parseInt(value);
    }

    public static Boolean stringToBoolean(String value){
        return value == null ? null : Boolean.valueOf(value);
    }
    public static String booleanToString(Boolean value){
        return value == null ? null : value.toString();
    }
    public static TipoRobot stringToTipoRobot(String value) {
        for(TipoRobot tipoRobotValore : TipoRobot.values()){
            if (tipoRobotValore.name().equalsIgnoreCase(value))
                return tipoRobotValore;
        }
        return null;
    }
    public static String tipoRobotToString(TipoRobot value) {
        return value== null ? null : value.name();
    }
    public static StatoCicloProduttivo stringToStatoCicloProduttivo(String value) {
        for(StatoCicloProduttivo  statoCicloProduttivoValore : StatoCicloProduttivo .values()){
            if (statoCicloProduttivoValore.name().equalsIgnoreCase(value))
                return statoCicloProduttivoValore;
        }
        return null;
    }
    public static String statoCicloProduttivoToString(StatoCicloProduttivo value) {
        return value== null ? null : value.name();
    }


    public static LocalDateTime stringToLocalDateTime(String value){
        return value == null ? null : LocalDateTime.parse(value);
    }
    public static String localDateTimeToString(LocalDateTime value){
        return value == null ? null : value.toString();
    }
}
