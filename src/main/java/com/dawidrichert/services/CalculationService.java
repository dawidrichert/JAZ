package com.dawidrichert.services;

import com.dawidrichert.models.CalculationData;
import com.dawidrichert.models.DzieloItem;
import com.dawidrichert.models.PracaItem;
import com.dawidrichert.models.ZlecenieItem;
import com.dawidrichert.models.enums.DeductibleCosts;
import com.dawidrichert.models.enums.PayType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculationService {

    private static final String[] months = {
            "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
            "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"
    };

    public List calculate(CalculationData calculationData) {
        switch (calculationData.getContractType()) {
            case PRACA:
                return calculateForPraca(calculationData);
            case ZLECENIE:
                return calculateForZlecenie(calculationData);
            case DZIELO:
                return calculateForDzielo(calculationData);
        }
        return null;
    }

    private List<PracaItem> calculateForPraca(CalculationData calculationData) {

        List<PracaItem> result = new ArrayList<>();
        double wynagrodzenieBrutto = calculationData.getSalary();
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            wynagrodzenieBrutto = Math.floor((calculationData.getSalary() - 66.365) / 0.69680540);
        }
        double emerytalne = wynagrodzenieBrutto * 0.0976;
        double rentowe = wynagrodzenieBrutto * 0.015;
        double chorobowe = wynagrodzenieBrutto * 0.0245;
        double ubezpieczenia = emerytalne + rentowe + chorobowe;
        double kosztyUzyskaniaPrzychodu = 111.25;
        double dochodDoOpodatkowania = Math.ceil(wynagrodzenieBrutto - ubezpieczenia - kosztyUzyskaniaPrzychodu);
        double zaliczkaNaPodatekDochodowy = dochodDoOpodatkowania * 0.18;
        double ulgaPodatkowa = 46.33;
        double podstawaOpodatkowaniaBrutto = wynagrodzenieBrutto - ubezpieczenia;
        double ubezpieczenieZdrowotnePobrane = podstawaOpodatkowaniaBrutto * 0.09;
        if (ubezpieczenieZdrowotnePobrane > zaliczkaNaPodatekDochodowy - ulgaPodatkowa) {
            ubezpieczenieZdrowotnePobrane = zaliczkaNaPodatekDochodowy - ulgaPodatkowa;
        }
        double ubezpieczenieZdrowotneDoOdliczeniaOdPodatku = podstawaOpodatkowaniaBrutto * 775 / 10000;
        if (ubezpieczenieZdrowotneDoOdliczeniaOdPodatku > ubezpieczenieZdrowotnePobrane) {
            ubezpieczenieZdrowotneDoOdliczeniaOdPodatku = ubezpieczenieZdrowotnePobrane;
        }
        double podatekDoZaplatyDoUrzeduSkarbowego = 0;
        if (zaliczkaNaPodatekDochodowy - ulgaPodatkowa - ubezpieczenieZdrowotneDoOdliczeniaOdPodatku > 0) {
            podatekDoZaplatyDoUrzeduSkarbowego = Math.ceil(zaliczkaNaPodatekDochodowy - ulgaPodatkowa - ubezpieczenieZdrowotneDoOdliczeniaOdPodatku);
        }
        double potraceniaRazem = ubezpieczenia + ubezpieczenieZdrowotnePobrane + podatekDoZaplatyDoUrzeduSkarbowego;
        double doWyplatyNetto = wynagrodzenieBrutto - potraceniaRazem;
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            doWyplatyNetto = calculationData.getSalary();
        }

        for (String month : months) {
            result.add(new PracaItem(month, wynagrodzenieBrutto, emerytalne, rentowe, chorobowe, ubezpieczenieZdrowotnePobrane,
                    dochodDoOpodatkowania, podatekDoZaplatyDoUrzeduSkarbowego, doWyplatyNetto));
        }

        return result;
    }

    private List<ZlecenieItem> calculateForZlecenie(CalculationData calculationData) {

        double wynagrodzenieBrutto = calculationData.getSalary();
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            wynagrodzenieBrutto = Math.floor((calculationData.getSalary() - 66.365) / 0.69680540);
        }
        double emerytalne = 0;
        if (calculationData.isDisabilityContribution()) {
            emerytalne = wynagrodzenieBrutto * 0.0976;
        }
        double rentowe = 0;
        if (calculationData.isPensionContribution()) {
            rentowe = wynagrodzenieBrutto * 0.015;
        }
        double chorobowe = 0;
        if (calculationData.isSicknessContribution()) {
            chorobowe = wynagrodzenieBrutto * 0.0245;
        }
        double razemSkladki = emerytalne + rentowe + chorobowe;
        double kosztyUzyskaniaPrzychodu;
        if (DeductibleCosts.PERCENT_20.equals(calculationData.getDeductibleCosts())) {
            kosztyUzyskaniaPrzychodu = (wynagrodzenieBrutto - razemSkladki) * 0.2;
        } else {
            kosztyUzyskaniaPrzychodu = (wynagrodzenieBrutto - razemSkladki) * 0.5;
        }
        double podstawaOpodatkowania = wynagrodzenieBrutto - razemSkladki - kosztyUzyskaniaPrzychodu;
        double naliczonyPodatek = podstawaOpodatkowania * 0.19;
        double zdrowotne = wynagrodzenieBrutto * 0.07766;
        double podatekDoZaplaty = Math.ceil((wynagrodzenieBrutto - razemSkladki - kosztyUzyskaniaPrzychodu) * 0.19 - zdrowotne);
        double doWyplatyNetto = wynagrodzenieBrutto - razemSkladki - podatekDoZaplaty - zdrowotne;
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            doWyplatyNetto = calculationData.getSalary();
        }

        return Collections.singletonList(new ZlecenieItem(wynagrodzenieBrutto, emerytalne, rentowe, chorobowe, zdrowotne,
                kosztyUzyskaniaPrzychodu, podstawaOpodatkowania, naliczonyPodatek, doWyplatyNetto));
    }

    private List<DzieloItem> calculateForDzielo(CalculationData calculationData) {

        double wynagrodzenieBrutto = calculationData.getSalary();
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            wynagrodzenieBrutto = calculationData.getSalary() * 1.168225;
        }
        double kosztyUzyskaniaPrzychodu;
        if (DeductibleCosts.PERCENT_20.equals(calculationData.getDeductibleCosts())) {
            kosztyUzyskaniaPrzychodu = wynagrodzenieBrutto * 0.2;
        } else {
            kosztyUzyskaniaPrzychodu = wynagrodzenieBrutto * 0.5;
        }
        double podstawaOpodatkowania = wynagrodzenieBrutto - kosztyUzyskaniaPrzychodu;
        double podatekDoZaplaty = podstawaOpodatkowania * 0.18;
        double doWyplatyNetto = wynagrodzenieBrutto - podatekDoZaplaty;
        if (PayType.NETTO.equals(calculationData.getPayType())) {
            doWyplatyNetto = calculationData.getSalary();
        }

        return Collections.singletonList(new DzieloItem(wynagrodzenieBrutto, kosztyUzyskaniaPrzychodu,
                podstawaOpodatkowania, podatekDoZaplaty, doWyplatyNetto));
    }
}
