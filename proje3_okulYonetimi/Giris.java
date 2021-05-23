package proje3_okulYonetimi;


public class Giris extends VeritabaniBaglanti {


	public Giris() {
		super("root", "","okul_proje", "kullanici");
	}
	
	public boolean kullaniciGirisi() {
		boolean kontrol=false;
		do {
		System.out.println("Lütfen kullanýcý Adýný Giriniz");
		String kullanici =Main.scan.next();
		System.out.println("Lütfen Þifrenizi Giriniz");
		String sifre =Main.scan.next();
		if (!girisKontrolu(kullanici,sifre)) {
			System.out.println("Hatalý giriþ yaptýnýz. Lütren tekrar deneyiniz..");
		} else {kontrol=true;}
		}while (!kontrol);
		return kontrol;
		
	}

	
	
	

}
