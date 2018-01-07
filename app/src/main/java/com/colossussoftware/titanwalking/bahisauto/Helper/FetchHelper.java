package com.colossussoftware.titanwalking.bahisauto.Helper;

import com.colossussoftware.titanwalking.bahisauto.DataObjects.FutbolMaci;
import com.colossussoftware.titanwalking.bahisauto.DataObjects.Mac;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Ali on 6.01.2018.
 */

public class FetchHelper {

    public static ArrayList<Mac> fetchMisliFutbol() {
        try {
            String title;
            ArrayList<Mac> kupon;
            kupon = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.misli.com/iddaa-en-cok-oynanan-futbol-maclari").get();    // web siteye bağlantıyı gerçeleştirme

            Element table = doc.select("table").get(0);
            Elements rows = table.select("tr");
            while (kupon.size() < 6) {

                for (int i = 2; i < rows.size(); i++) {
                    Element row = rows.get(i);
                    Elements cols = row.select("td");

                    String takimIsimleri = cols.get(5).select("a").first().text();
                    String bahis = cols.get(6).select("div[class=most-sell-bettype]").text();
                    String oran = cols.get(6).select("div[class=most-sell-odd-a]").text().replace(',', '.');
                    String oynanmaYuzdesi = cols.get(6).select("div[class=most-sell-odd-ratio]").text().substring(1);
                    String kod = cols.get(2).select("a").first().text();
                    String tarih = cols.get(1).text();

                    FutbolMaci fm = new FutbolMaci();
                    fm.setTakimlar(takimIsimleri);
                    fm.setBahis(bahis);
                    fm.setOran(Double.parseDouble(oran));
                    fm.setOynanmaYuzdesi(Integer.parseInt(oynanmaYuzdesi));
                    fm.setKod(kod);
                    fm.setTarih(tarih);


                    if (fm.getOynanmaYuzdesi() >= 40 && fm.getOran() >= 1.5) {
                        kupon.add(fm);
                    }
                }
            }
            return kupon;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}
