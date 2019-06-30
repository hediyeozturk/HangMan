package AdamAsmaca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SoruOlustur {

	public static void main(String[] args) {

		IslemSec();
	}

	private static void IslemSec() {
		Boolean secimYapildi=false;
		do {
			try(Scanner scanner = new Scanner(System.in)) {
				String metin="| YAPMAK İSTEDİĞİNİZ İŞLEM NEDİR?               |\n"
						+"|   1-OTOMATİK OLUŞTUR | 2-KENDİM OLUŞTURAYIM       |\n"
						+"=====================================================\n";
				System.out.println(metin);
				int secim=scanner.nextInt();
				switch(secim) {
					case 1:
						SorulariOtomatikOlustur();
						secimYapildi=true;
						break;
					case 2:
						KullaniciSoruOlustursun();
						secimYapildi=true;
						break;
					default:
						System.out.println("Hatalı seçim yaptınız..");
						break;
				}
				System.exit(0);
			} catch (Exception e) {
			    System.out.println("Hatalı seçim yaptınız..");
			}
				
		} while (!secimYapildi);
		
	}

	private static void KullaniciSoruOlustursun() {
		// TODO Auto-generated method stub
		
	}

	private static void SorulariOtomatikOlustur() {
		Map<EnumKategori, LinkedList<String>> kategoriSoruMap= new HashMap<EnumKategori, LinkedList<String>>();
		LinkedList<String> Sehirler=new LinkedList<String>();
		Sehirler.add("İSTANBUL");
		Sehirler.add("ADANA");
		Sehirler.add("ORDU");
		Sehirler.add("İZMİR");
		Sehirler.add("ERZİNCAN");
		Sehirler.add("ZONGULDAK");
		Sehirler.add("ANTALYA");
		Sehirler.add("GAZİANTEP");
		Sehirler.add("KAYSERİ");
		Sehirler.add("TEKİRDAĞ");
		Sehirler.add("KIRKLARELİ");

		kategoriSoruMap.put(EnumKategori.Sehirler, Sehirler);

		String path= System.getProperty("user.home") + "/Desktop";
		File sorularDosyasi= new File(path+"\\Sehirler.hdy");
		//File sorularDosyasi= new File("Z:\\Java\\AdamAsmaca\\Sorular.hdy");
		
		try (FileOutputStream fileOutputStream = new FileOutputStream(sorularDosyasi,true)) {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(kategoriSoruMap);
			fileOutputStream.flush();
			System.out.println("Başarıyla kaydedildi.");
		} catch (Exception e) {
			System.out.println("Yazma Hatası" + e.getMessage());
		}
		
		try (FileInputStream fileInputStream = new FileInputStream(sorularDosyasi)) {
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Map<EnumKategori, String> kayitliSehirler= (Map<EnumKategori, String>) objectInputStream.readObject();
			for (EnumKategori kategori : kayitliSehirler.keySet()) {
				LinkedList<String> sorular= kategoriSoruMap.get(kategori);
				for (String soru : sorular) {
					System.out.println(soru);
				}
					
			}
		} catch (Exception e) {
			System.out.println("Okuma Hatası" + e.getMessage());
		}


		// TODO Auto-generated method stub
		
	}

}
