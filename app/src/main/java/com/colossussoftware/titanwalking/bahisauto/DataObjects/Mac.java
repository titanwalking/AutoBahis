package com.colossussoftware.titanwalking.bahisauto.DataObjects;

/**
 * Created by Ali on 5.01.2018.
 */

public abstract class Mac {

    boolean futbol;
    private String takimlar, macSaati, bahis, kod, tarih;
    private double oran;
    private int oynanmaYuzdesi;

    public boolean isFutbol() {
        return futbol;
    }

    public void setFutbol(boolean futbol) {
        this.futbol = futbol;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Mac{" +
                "futbol=" + futbol +
                ", takimlar='" + takimlar + '\'' +
                ", macSaati='" + macSaati + '\'' +
                ", bahis='" + bahis + '\'' +
                ", kod='" + kod + '\'' +
                ", tarih='" + tarih + '\'' +
                ", oran=" + oran +
                ", oynanmaYuzdesi=" + oynanmaYuzdesi +
                '}';
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getBahis() {
        return bahis;
    }

    public void setBahis(String bahis) {
        this.bahis = bahis;
    }

    public String getMacSaati() {
        return macSaati;
    }

    public void setMacSaati(String macSaati) {
        this.macSaati = macSaati;
    }

    public String getTakimlar() {
        return takimlar;
    }

    public void setTakimlar(String takimlar) {
        this.takimlar = takimlar;
    }

    public double getOran() {
        return oran;
    }

    public void setOran(double oran) {
        this.oran = oran;
    }

    public int getOynanmaYuzdesi() {
        return oynanmaYuzdesi;
    }

    public void setOynanmaYuzdesi(int oynanmaYuzdesi) {
        this.oynanmaYuzdesi = oynanmaYuzdesi;
    }


}
