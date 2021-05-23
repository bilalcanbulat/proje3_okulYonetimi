package proje3_okulYonetimi;

import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args) {
    	Giris giris =new Giris();
    	if(giris.kullaniciGirisi()) {
        Islemler islem = new Islemler();
        islem.anaMenu(giris);
    	};
    }
}
