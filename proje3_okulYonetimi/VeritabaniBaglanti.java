package proje3_okulYonetimi;

import java.sql.*;


public class VeritabaniBaglanti{
	
	Connection conn = null;
	Statement stmt =null;
	ResultSet rs=null;
	
	private String databaseUserName="";
	private String databasePassword="";
	private String query="";

	private String databaseName="";
	private String databaseTableName="";
		
	
	public VeritabaniBaglanti(String databaseUserName, String databasePassword, String databaseName, String databaseTableName) {
		this.databaseUserName = databaseUserName;
		this.databasePassword = databasePassword;
		this.databaseName = databaseName;
		this.databaseTableName = databaseTableName;
		
	
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName,databaseUserName, databasePassword);
	System.out.println("Baðlandý ->" + databaseName);
	stmt = (Statement) conn.createStatement();
	
	}catch (ClassNotFoundException e) {
	System.out.println("Connector Bulunamadý. ");
	System.err.println("Baðlantý Baþarýsýz\nClassNotFoundException");
	}
	catch (SQLException e) {
	System.out.println("Baðlantý Baþarýsýz\nSql Exception");
	}
	
	}

	protected boolean girisKontrolu(String kullaniciAdi, String sifre) {
		boolean kontrol=false;
		query="SELECT * FROM "+databaseTableName+" WHERE kullanici_adi='"+kullaniciAdi+"' AND sifre='"+sifre+"'";
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				kontrol=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return kontrol;	
	}
	
	protected boolean vtEkleOgretmen(Ogretmen lst, String databaseTableName) {
		boolean kontrol=false;
		query="INSERT INTO "+databaseTableName+" VALUES ('"+lst.getAdSoyad()+"','"+lst.getKimlikNo()+"','"+lst.getYas()+"','"+lst.getBolum()+"','"+ lst.getSicilNo()+"')";
		try {
			stmt.executeUpdate(query);
				kontrol=true;
				System.out.println("Baþarýlý Giriþ");
		} catch (SQLException e) {
			System.out.println("Veritabanýna bilgi giriþi YAPILAMADI.");
			//e.printStackTrace();
		}
	return kontrol;	
		
	}
	
	protected boolean vtEkleOgrenci(Ogrenci lst) {
		boolean kontrol=false;
		query="INSERT INTO ogrenci VALUES ('"+lst.getAdSoyad()+"','"+lst.getKimlikNo()+"','"+lst.getYas()+"','"+lst.getNumara()+"','"+ lst.getSinif()+"')";
		System.out.println(query);
		try {
			stmt.executeUpdate(query);
				kontrol=true;
				System.out.println("Baþarýlý Giriþ");
		} catch (SQLException e) {
			System.out.println("Veritabanýna bilgi giriþi YAPILAMADI.");
			//e.printStackTrace();
		}
	return kontrol;	
	}
	

protected boolean vtAraOgrenci(String kn) {
	boolean kontrol=false;
	query="SELECT * FROM ogrenci WHERE kimlikNo='"+kn+"'";
	try {
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString("adSoyad")+" "+ rs.getString("kimlikNo")+" "+rs.getString("yas")+" "+rs.getString("numara")+" "+rs.getString("sinif"));
		}
			} catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		//e.printStackTrace();
	}
return kontrol;	
	
}

protected boolean vtAraOgretmen(String kn) {
	boolean kontrol=false;
	query="SELECT * FROM ogretmen WHERE kimlikNo='"+kn+"'";
	
	try {
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString("adSoyad")+" "+ rs.getString("kimlikNo")+" "+rs.getString("yas")+" "+rs.getString("bolum")+" "+rs.getString("sicilNo"));
		}

			} catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		//e.printStackTrace();
	}
return kontrol;	
	
}


protected boolean vtOgretmenListele() {
	boolean kontrol=false;
	query="SELECT * FROM ogretmen";
	
	try {
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString("adSoyad")+" "+ rs.getString("kimlikNo")+" "+rs.getString("yas")+" "+rs.getString("bolum")+" "+rs.getString("sicilNo"));
		}

			} catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		//e.printStackTrace();
	}
return kontrol;	
	
}


protected boolean vtOgrenciListele() {
	boolean kontrol=false;
	query="SELECT * FROM ogrenci";
	
	try {
		rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getString("adSoyad")+" "+ rs.getString("kimlikNo")+" "+rs.getString("yas")+" "+rs.getString("numara")+" "+rs.getString("sinif"));
		}

			} catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		//e.printStackTrace();
	}
return kontrol;	
	
}


protected boolean vtOgrenciSil(String kn) {
	boolean kontrol=false;
	query="DELETE FROM ogrenci WHERE kimlikNo='"+kn+"'";
	
	try {
		stmt.executeUpdate(query);
			} catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		kontrol=false;
		//e.printStackTrace();
	}
return kontrol;	
	
}

protected boolean vtOgretmenSil(String kn) {
	boolean kontrol=false;
	query="DELETE FROM ogretmen WHERE kimlikNo='"+kn+"'";
	
	try {
		stmt.executeUpdate(query);
			} 
	catch (SQLException e) {
		System.out.println("BULUNAMADI.");
		kontrol=false;
		//e.printStackTrace();
	}
return kontrol;	
	
}


}