package proje3_okulYonetimi;


public class Giris extends VeritabaniBaglanti {


	public Giris() {
		super("root", "","okul_proje", "kullanici");
	}
	
	public boolean kullaniciGirisi() {
		boolean kontrol=false;
		do {
		System.out.println("L�tfen kullan�c� Ad�n� Giriniz");
		String kullanici =Main.scan.next();
		System.out.println("L�tfen �ifrenizi Giriniz");
		String sifre =Main.scan.next();
		if (!girisKontrolu(kullanici,sifre)) {
			System.out.println("Hatal� giri� yapt�n�z. L�tren tekrar deneyiniz..");
		} else {kontrol=true;}
		}while (!kontrol);
		return kontrol;
		
	}

	
	
	

}
