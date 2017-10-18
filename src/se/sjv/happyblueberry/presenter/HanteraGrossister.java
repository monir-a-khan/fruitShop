package se.sjv.happyblueberry.presenter;

import java.util.Scanner;

import se.sjv.happyblueberry.models.Grossist;
import se.sjv.happyblueberry.persistence.Grossister;

public class HanteraGrossister {
    String frukt = "";

    public void skapaNyGrossist() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv in namn");
        String namn = scanner.next();

        Grossist grossist = new Grossist();
        grossist.setNamn(namn);
        do {
            System.out.println("Skriv in de frukter som säljs, en i taget");
            System.out.println("Skriv in s för att spara och avsluta");
            frukt = scanner.next();
            if (!frukt.equals("s")) {
                grossist.läggTillVara(frukt);
            }
        } while (!frukt.equals("s"));

        Grossister grossister = Grossister.getInstance();
        grossister.grossistLista.add(grossist);
    }
}