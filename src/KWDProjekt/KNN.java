package KWDProjekt;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

public class KNN {

	// cena, zegar procesora, pamiec wbudowana, przekotna, RAM
	private static int[][] zbiorUczacy = new int[40][7];
	// lista wszystkich telefonow i ich parametrow
	private static ArrayList<Telefon> telefonList = new ArrayList<Telefon>();
	
	private static void iniclaizacja(int cena){
		
		String path;
		if (cena == 1){
			
			path = "dane1000";
			wczystajDane(path);
			telefonList.add(new Telefon(zbiorUczacy[0], "Acer"));
			telefonList.add(new Telefon(zbiorUczacy[1], "Acer"));
			telefonList.add(new Telefon(zbiorUczacy[2], "Acer"));
			telefonList.add(new Telefon(zbiorUczacy[3], "Honor"));
			telefonList.add(new Telefon(zbiorUczacy[4], "Honor"));
			telefonList.add(new Telefon(zbiorUczacy[5], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[6], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[7], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[8], "Motorola"));
			telefonList.add(new Telefon(zbiorUczacy[9], "Motorola"));
			telefonList.add(new Telefon(zbiorUczacy[10], "Motorola"));
			telefonList.add(new Telefon(zbiorUczacy[11], "Nokia"));
			telefonList.add(new Telefon(zbiorUczacy[12], "Nokia"));
			telefonList.add(new Telefon(zbiorUczacy[13], "Nokia"));
			
		} else if (cena == 2){
			
			path = "dane2000";
			wczystajDane(path);
			telefonList.add(new Telefon(zbiorUczacy[0], "Honor"));
			telefonList.add(new Telefon(zbiorUczacy[1], "Honor"));
			telefonList.add(new Telefon(zbiorUczacy[2], "Honor"));
			telefonList.add(new Telefon(zbiorUczacy[3], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[4], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[5], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[6], "Huawei"));
			telefonList.add(new Telefon(zbiorUczacy[7], "Huawei"));
			telefonList.add(new Telefon(zbiorUczacy[8], "Huawei"));
			telefonList.add(new Telefon(zbiorUczacy[9], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[10], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[11], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[12], "Sony"));
			telefonList.add(new Telefon(zbiorUczacy[13], "Sony"));
			telefonList.add(new Telefon(zbiorUczacy[14], "Samsung"));
			telefonList.add(new Telefon(zbiorUczacy[15], "Samsung"));
			telefonList.add(new Telefon(zbiorUczacy[16], "Samsung"));
			
		} else if (cena == 3){
			path = "dane3000";
			wczystajDane(path);
			
			telefonList.add(new Telefon(zbiorUczacy[0], "Google"));
			telefonList.add(new Telefon(zbiorUczacy[1], "Google"));
			telefonList.add(new Telefon(zbiorUczacy[2], "Google"));
			telefonList.add(new Telefon(zbiorUczacy[3], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[4], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[5], "HTC"));
			telefonList.add(new Telefon(zbiorUczacy[6], "LG"));
			telefonList.add(new Telefon(zbiorUczacy[7], "Samsung"));
			telefonList.add(new Telefon(zbiorUczacy[8], "Samsung"));
			telefonList.add(new Telefon(zbiorUczacy[9], "Samsung"));
			telefonList.add(new Telefon(zbiorUczacy[10], "Sony"));
			telefonList.add(new Telefon(zbiorUczacy[11], "Sony"));
			telefonList.add(new Telefon(zbiorUczacy[12], "Sony"));
		}
	}
	
	private static void wczystajDane(String path){
		
		int dane = 0;
		String wynik = null;
		String liczba = "";
		int[] tab = new int[7];
		int i = 0;
		int j = 0;
		
		try {
			
			@SuppressWarnings("resource")
			FileReader file = new FileReader(path);

			while ((dane = file.read()) != -1){
				
				wynik = String.valueOf((char)dane);
				if (!wynik.equals(" ")){
					if (!wynik.equals("\r") && !wynik.equals("\n")){
						liczba = liczba + wynik;
					} else if(wynik.equals("\n")){
						
						tab[i] = Integer.valueOf(liczba);
						zbiorUczacy[j] = tab;
						j++;
						
						tab = new int[7];
						liczba ="";
						i = 0;
					}
						
				} else {
					
					tab[i] = Integer.valueOf(liczba);
					i++;
					liczba="";
						
				}
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		tab[i] = Integer.valueOf(liczba);
		zbiorUczacy[j] = tab;
		
		for (int[] element: zbiorUczacy){
			for(int x: element){
				System.out.print(x+" ");
			}
			System.out.println("");
		}
	}

	private String knnserach(String[] array) {
		// tworzenie HashSet na otrzymanej talbicy Stringow w celu zniwelowania
		// powtorzen
		HashSet<String> h = new HashSet<String>(Arrays.asList(array));
		// przeksztalcenie HashSet spowrotem do tablicy Stringow
		String[] uniqueValues = h.toArray(new String[0]);
		// liczba unikalnych wartosci
		int[] counts = new int[uniqueValues.length];
		// liczenie ile unikalne wartosci powtarzaja sie w maciezystej tablicy
		for (int i = 0; i < uniqueValues.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals(uniqueValues[i])) {
					counts[i]++;
				}
			}
		}

		for (int i = 0; i < uniqueValues.length; i++)
			System.out.println("Unikalne wartoœci -> " + uniqueValues[i] + " Suma -> " + counts[i]);

		// znajdowanie maksymalnej wartoœci wyst¹pien
		int max = counts[0];
		for (int counter = 1; counter < counts.length; counter++) {
			if (counts[counter] > max) {
				max = counts[counter];
			}
		}
		System.out.println("maksymalna wartoœæ wyst¹pienia: " + max);

		// znajdujemy ile razy "maksymalna wartoœæ wyst¹pienia" powtarza siê
		// (przynajmiej raz)
		int freq = 0;
		for (int counter = 0; counter < counts.length; counter++) {
			if (counts[counter] == max) {
				freq++;
			}
		}

		// jesli jest tylko jedna maksymala wartosc,
		// czyli liczba sasiadow tej samej klasy nie jest taka sama to zwracamy
		// nasza klase
		int index = -1;
		if (freq == 1) {
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					index = counter;
					break;
				}
			}
			return uniqueValues[index];
		} else {// jesli klasy sasadow sa takie same to losujemy jedna z nich i
				// ja zwracamy
			int[] ix = new int[freq];// tablica na te same klasy, z ktorej
										// bedziemy losowac
			int ixi = 0;
			for (int counter = 0; counter < counts.length; counter++) {
				if (counts[counter] == max) {
					ix[ixi] = counter;// jeszcze raz znajdujemy maksymalne
										// wartosci i je zapisujemy
					ixi++;
				}
			}

			for (int counter = 0; counter < ix.length; counter++) {

				System.out.println("Pasujace modele -> " + ix[counter]);
			}

			// wybieramy losowo
			Random generator = new Random();
			// losujemy od zera do maksymalnego indeksu naszej tablicy
			int rIndex = generator.nextInt(ix.length);
			System.out.println("Wylosowano ->" + ix[rIndex]);
			int nIndex = ix[rIndex];

			return uniqueValues[nIndex];
		}

	}

	public String wyszukajModel(Integer[] szukanyTelefon, int cena) {
		
		iniclaizacja(cena);
		
		int k = 7;// liczba sasiadow
		// lista wynikow dla kazdego modela w jakim stopniu pasuje do szukanego
		ArrayList<Wynik> wynikList = new ArrayList<Wynik>();
		for (Telefon telefon : telefonList) {
			double odleglosc = 0.0;
			// zaimplementowana odleg³oœæ euklidesowa
			for (int j = 0; j < telefon.atrybuty.length; j++) {
				// mierzone odleglosci miedzy wartosciami ze zbioru uczacego a
				// wartoscia,
				// dla ktorej szukamy klasy
				odleglosc += Math.pow(telefon.atrybuty[j] - szukanyTelefon[j], 2);
			}
			double euklidesOdl = Math.sqrt(odleglosc);
			wynikList.add(new Wynik(euklidesOdl, telefon.model));
		}

		Collections.sort(wynikList, new sortujWgPrawdopodobienstwa());
		// brane jest pod uwage tylko k najbliszych s¹siadów
		String[] Ksasiadow = new String[k];
		for (int x = 0; x < k; x++) {
			System.out.println(wynikList.get(x).model + " .... " + wynikList.get(x).podobienstwo);
			// pobieranie wartosci z wynikowej kolekcji
			Ksasiadow[x] = wynikList.get(x).model;
		}
		String Class = knnserach(Ksasiadow);
		telefonList = new ArrayList<Telefon>();
		return "Najlepszy model telefonu to: " + Class;
	}

	// klasa do przechowywania modeli telefonow
	static class Telefon {
		int[] atrybuty;
		String model;

		public Telefon(int[] atrybuty, String model) {
			this.model = model;
			this.atrybuty = atrybuty;
		}
	}

	// klasa do przechowywania wynikow (podobienstwo telefonu, model telefonu
	static class Wynik {
		double podobienstwo;
		String model;

		public Wynik(double podobienstwo, String model) {
			this.model = model;
			this.podobienstwo = podobienstwo;
		}
	}

	// prosta klasa porównuj¹ca wartoœci z klasy Result implemetujaca odpowiedni
	// interfejs
	static class sortujWgPrawdopodobienstwa implements Comparator<Wynik> {
		@Override
		public int compare(Wynik a, Wynik b) {
			return a.podobienstwo < b.podobienstwo ? -1 : a.podobienstwo == b.podobienstwo ? 0 : 1;
		}
	}
}
