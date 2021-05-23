package proje3_okulYonetimi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Islemler{
    private String kisiTuru;

    public void anaMenu(Giris giris) {
    	String secim;
        System.out.println("====================================");
        System.out.println(" OGRENCI VE OGRETMEN YONETIM PANELI");
        System.out.println("====================================");
        System.out.println("1- OGRENCI ISLEMLERI");
        System.out.println("2- OGRETMEN ISLEMLERI");
        System.out.println("Q- CIKIS");
      
		secim = Main.scan.next();
        if(secim.equals("Q")){
            cikis();
        }else if (secim.equals("1")){
            kisiTuru = "OGRENCI";
            islemMenusu(giris);
        }else if(secim.equals("2")) {
            kisiTuru = "OGRETMEN";
            islemMenusu(giris);
        }else {
            System.out.println("Hatali Giris");
            anaMenu(giris);
        }
    }

    private void islemMenusu(Giris giris) {
        System.out.println("============= ISLEMLER =============");
        System.out.println("1-EKLEME");
        System.out.println("2-ARAMA");
        System.out.println("3-LISTELEME");
        System.out.println("4-SILME");
        System.out.println("5-ANA MENÃœ");
        System.out.println("Q-CIKIS\n");
        System.out.println("SECIMINIZ:");
        String tercih = Main.scan.next().toUpperCase();

        switch(tercih) {
            case "1":	ekle(giris);
                break;
            case "2":	ara(giris);
                break;
            case "3":	listele(giris);
                break;
            case "4":	sil(giris);
                break;
            case "5":	anaMenu(giris);
                break;
            case "Q":	cikis();
                break;
            default: 	System.out.println("Yanlis Giris");
                islemMenusu(giris);
                break;
        }
    }

    private void cikis() {
        System.out.println("GULE GULE ...");
    }

    private void ekle(Giris giris) {
    	boolean eklendiMi;
        System.out.println("----------------- "+ kisiTuru + " EKLEME ------------------");
        System.out.print("Ad Soyad:");
        String adSoyad = Main.scan.next();
        System.out.print("Kimlik No:");
        String kimlikNo = Main.scan.next();
        System.out.print("Yas:");
        int yas = Main.scan.nextInt();

        if(kisiTuru.equals("OGRENCI")) {
            System.out.print("Sinif:");
            String sinif = Main.scan.next();
            System.out.print("Okul No:");
            String numara = Main.scan.next();
            Ogrenci  ogrenci = new Ogrenci(adSoyad,kimlikNo,yas,numara,sinif);
            eklendiMi=giris.vtEkleOgrenci(ogrenci);
        }else {
            System.out.print("SicilNo:");
            String sicilNo = Main.scan.next();
            System.out.print("Bolum:");
            String bolum = Main.scan.next();
            Ogretmen ogretmen = new Ogretmen(adSoyad,kimlikNo,yas,sicilNo,bolum);
            eklendiMi=giris.vtEkleOgretmen(ogretmen,"ogretmen");
            //if (!eklendiMi) System.out.println("Veritabanýna bilgi giriþi YAPILAMADI."); else System.out.println("Baþarýlý Giriþ");
        }
        islemMenusu(giris);
    }

    private void ara(Giris giris){

        System.out.println("----------------- " + kisiTuru + " BILGILERI ------------------");
        System.out.print("Aradiginiz Kisinin Kimlik Numarasi:");
        String kimlikNo = Main.scan.next();
        if (kisiTuru.equals("OGRENCI")) {
        	giris.vtAraOgrenci(kimlikNo);
        }else {
        	giris.vtAraOgretmen(kimlikNo);
        }
        islemMenusu(giris);
    }

    private void listele (Giris giris) {
        if (kisiTuru.equals("OGRENCI")) {
            giris.vtOgrenciListele();
        }else{
        	giris.vtOgretmenListele();
        }

        islemMenusu(giris);
    }

    private void sil(Giris giris) {
        System.out.print("Silmek IstediGiniz "+ kisiTuru + " nin Kimlik NumarasÄ±:");
        String kimlikNo = Main.scan.next();
        if (kisiTuru.equals("OGRENCI")) {
           giris.vtOgrenciSil(kimlikNo);
        }else {
        	giris.vtOgretmenSil(kimlikNo);
        }
        islemMenusu(giris);
    }
    
}
