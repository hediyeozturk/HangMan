package AdamAsmaca;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Oyun {

	public static void main(String[] args) {
		Hosgeldiniz();
		Oyna();
	}



	private static void Oyna() {
		Boolean oyunBitti=false;
		do {
			EnumKategori kategori= KategoriSec();
			String path= "";
			switch (kategori) {
			case Sehirler:
				path= (System.getProperty("user.home") + "/Desktop");
				File sorularDosyasi= new File(path+"\\Sehirler.hdy");
				LinkedList<String> sorular= SorulariGetir(sorularDosyasi);
				String SecilenSoru="ayşe";
				for (int i = 0; i < SecilenSoru.length(); i++) {
					System.out.print("  _  ");
				}
				break;

			default:
				break;
			}
		} while (oyunBitti);
		

	}
	
	private static String SoruGetir(LinkedList<String> sorular) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, sorular.leng max + 1);

	}



	private static LinkedList SorulariGetir(File sorularDosyasi) {
		Map<EnumKategori, LinkedList<String>> kategoriSoruMap= new HashMap<EnumKategori, LinkedList<String>>();

		try (FileInputStream fileInputStream = new FileInputStream(sorularDosyasi)) {
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Map<EnumKategori, String> kayitliMap= (Map<EnumKategori, String>) objectInputStream.readObject();
			for (EnumKategori kategori : kayitliMap.keySet()) {
				LinkedList<String> sorular= kategoriSoruMap.get(kategori);
				return sorular;
			}
		} catch (Exception e) {
			System.out.println("Okuma Hatası" + e.getMessage());
		}
		return null;
	}

	private static void Hosgeldiniz() {
		String metin="=====================================================\n"
				+"|                 ADAM ASMACA                       |\n"
				+"=====================================================\n";
		System.out.println(metin);
	}


	private static EnumKategori KategoriSec() {
		Boolean secimYapildi=false;
		do {
			try(Scanner scanner = new Scanner(System.in)) {
				String metin="| OYNAMAK İSTEDİĞİNİZ KATEGORİ?                     |\n"
						+"|   1-ŞEHİRLER | 2-ÜNLÜLER | 3-İNGİLİZCE KELİMELER  |\n"
						+"======================================================\n";
				System.out.println(metin);
				int secim=scanner.nextInt();
				switch(secim) {
					case 1:
						return EnumKategori.Sehirler;
					case 2:
						return EnumKategori.Unluler;
					case 3:
						return EnumKategori.Ingilizce;
					default:
						System.out.println("Hatalı seçim yaptınız..");
						break;
				}
			} catch (Exception e) {
			    System.out.println("Hatalı seçim yaptınız..");
			}
				
		} while (!secimYapildi);
		return null;
		
	}

	private static void AdamOlustur(int hatasayisi) {
		String asiliAdam="";
		switch(hatasayisi) {
		case 0 :
			asiliAdam="\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
					+ "\n"
			        + "\n"
			        + "\n"
			        + "\n"
			        + "________________________";
			break;
		case 1 :
			asiliAdam="\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
			        + "|\n"
			        + "|\n"
			        + "|\n"
			        + "________________________";
			break;		
		case 2 :
			asiliAdam="___________________\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
					+ "|\n"
			        + "|\n"
			        + "|\n"
			        + "|\n"
			        + "________________________";
			break;
		case 3 :
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "| \n"
					+ "| \n"
					+ "| \n"
			        + "| \n"
			        + "| \n"
			        + "| \n"
			        + "________________________";
			break;
		case 4:
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "|        @\n"
					+ "|  \n"
					+ "|  \n"
			        + "|  \n"
			        + "|  \n"
			        + "|"
			        + "________________________";
			break;
		case 5:
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "|        @\n"
					+ "|        |\n"
					+ "|        |\n"
			        + "|       \n"
			        + "|       \n"
			        + "|"
			        + "________________________";
			break;
		case 6:
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "|        @\n"
					+ "|   >----|\n"
					+ "|        |\n"
			        + "|      \n"
			        + "|      \n"
			        + "|"
			        + "________________________";
			break;
		case 7:
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "|        @\n"
					+ "|   >----|----<\n"
					+ "|        |\n"
			        + "|      \n"
			        + "|      \n"
			        + "|"
			        + "________________________";
			break;
		case 8:	asiliAdam="___________________\n"
				+ "|        |\n"
				+ "|        |\n"
				+ "|        @\n"
				+ "|   >----|----<\n"
				+ "|        |\n"
		        + "|       / \n"
		        + "|      /  \n"
		        + "|"
		        + "________________________";
			break;
		case 9:
			asiliAdam="___________________\n"
					+ "|        |\n"
					+ "|        |\n"
					+ "|        @\n"
					+ "|   >----|----<\n"
					+ "|        |\n"
			        + "|       / \\\n"
			        + "|      /   \\ \n"
			        + "|"
			        + "________________________";
			//oyunu bitir.
			break;
		}	
		System.out.println(asiliAdam);
		
	}

}
