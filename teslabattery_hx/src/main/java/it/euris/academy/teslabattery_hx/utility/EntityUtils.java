package it.euris.academy.teslabattery_hx.utility;

import it.euris.academy.teslabattery_hx.data.entity.CatenaDiMontaggio;
import it.euris.academy.teslabattery_hx.data.entity.Componenti;
import it.euris.academy.teslabattery_hx.data.entity.Formula;
import it.euris.academy.teslabattery_hx.data.entity.Supervisore;

import java.text.Normalizer;

public class EntityUtils {

    public static CatenaDiMontaggio getCatenaDiMontaggio(Integer id){
        return CatenaDiMontaggio
                .builder()
                .id(id)
                .build();
    }

    public static Supervisore getSuperVisore(Integer id){
        return  Supervisore
                .builder()
                .id(id)
                .build();
    }

    public static Formula getFormula(Integer id){
        return Formula
                .builder()
                .id(id)
                .build();
    }

    public static Componenti getComponenti(Integer id){
        return Componenti
                .builder()
                .id(id)
                .build();
    }
}
