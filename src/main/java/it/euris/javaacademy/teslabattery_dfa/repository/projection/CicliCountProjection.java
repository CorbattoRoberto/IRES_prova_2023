package it.euris.javaacademy.teslabattery_dfa.repository.projection;

public interface CicliCountProjection {
    Long getCountMonthly();

    Integer getCountSuccessfulMonthly();

    Integer getCountFailedMonthly();

    String successMonthlyPercentage();

    Integer failedByState();

    Integer wastedMaterials();
}
