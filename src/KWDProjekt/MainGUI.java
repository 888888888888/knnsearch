package KWDProjekt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import KWDProjekt.KNN;

public class MainGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel pole;
	
	private TextField cena;
	private TextField wydajnosc;
	private TextField wyposazenie;
	private TextField bateria;
	private TextField wyswietlacz;
	private TextField audio;
	private TextField aparat;
	
	private JTextPane wynik;

	protected boolean cenaFlaga = false;
	protected boolean wyswietlaczFlaga = false;
	protected boolean bateriaFlaga = false;
	protected boolean wyposazenieFlaga = false;
	protected boolean zegarFlaga = false;
	protected boolean audioFlaga = false;
	protected boolean aparatFlaga = false;
	
	public MainGUI() {
		// TODO Auto-generated constructor stub
		initComponents();
	}
	
	private void initComponents() {

		JToolBar toolBar = new JToolBar();

		JButton buttonWyszukajModel = new JButton("Start alogrytm");
		buttonWyszukajModel.setActionCommand("Model");
		buttonWyszukajModel.addActionListener(this);

		toolBar.add(buttonWyszukajModel);
		toolBar.addSeparator();

		JButton buttonDodajModel = new JButton("Parametr K");
		buttonDodajModel.setActionCommand("Dodaj");
		buttonDodajModel.addActionListener(this);

		toolBar.add(buttonDodajModel);

		add(toolBar, BorderLayout.NORTH);
		initBd();

	}
	
public void initBd() {
		
		GridLayout layout = new GridLayout(0,1);
		
		pole = new JPanel();
		
		// ustawiam domyslne bilae tlo
        pole.setBackground(new java.awt.Color(255, 255, 255));
        pole.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        pole.setLayout(layout);
        pole.setPreferredSize(new Dimension(550, 80));
        
        GridLayout layout2 = new GridLayout(0,7);
        
        JPanel polaczenie = new JPanel();
        polaczenie.setLayout(layout2);
        
        cena = new TextField();
        cena.setText("Podaj cene");
        cena.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (cena.getText().length() == 0){
					cena.setText("Podaj cene");
					cenaFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (cenaFlaga  == false){
					cena.setText("");
					cenaFlaga = true;
				}
			}
		});
        
        wydajnosc = new TextField();
        wydajnosc.setText("ocena wydajnosci");
        wydajnosc.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(wydajnosc.getText().length() == 0){
					wydajnosc.setText("Zegar Procesora");
					zegarFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (zegarFlaga == false){
					wydajnosc.setText("");
					zegarFlaga = true;
				}
			}
		});
        
        wyposazenie = new TextField();
        wyposazenie.setText("ocena wyposazenia");
        wyposazenie.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(wyposazenie.getText().length() == 0){
					wyposazenie.setText("wyposazenie Wbudowana");
					wyposazenieFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if( wyposazenieFlaga == false){
					wyposazenie.setText("");
					wyposazenieFlaga = true;
				}
			}
		});
        
        bateria = new TextField();
        bateria.setText("ocena baterii");
        bateria.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(bateria.getText().length() == 0){
					bateria.setText("bateria Ekranu");
					bateriaFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(bateriaFlaga == false){
					bateria.setText("");
					bateriaFlaga = true;
				}
			}
		});
        
        wyswietlacz = new TextField();
        wyswietlacz.setText("ocena wyswietlacza");
        wyswietlacz.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (wyswietlacz.getText().length() == 0){
					wyswietlacz.setText("wyposazenie wyswietlacz");
					wyswietlaczFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(wyswietlaczFlaga == false){
					wyswietlacz.setText("");
					wyswietlaczFlaga = true;
				}
			}
		});
    
        audio = new TextField();
        audio.setText("ocena audio");
        audio.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (audio.getText().length() == 0){
					audio.setText("ocena audio");
					audioFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(audioFlaga == false){
					audio.setText("");
					audioFlaga = true;
				}
			}
		});
        
        aparat = new TextField();
        aparat.setText("ocena aparatu");
        aparat.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (aparat.getText().length() == 0){
					aparat.setText("ocena aparatu");
					aparatFlaga = false;
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if(aparatFlaga == false){
					aparat.setText("");
					aparatFlaga = true;
				}
			}
		});
        
        polaczenie.add(cena);
        polaczenie.add(wydajnosc);
        polaczenie.add(wyposazenie);
        polaczenie.add(bateria);
        polaczenie.add(wyswietlacz);
        polaczenie.add(audio);
        polaczenie.add(aparat);
        
        pole.add(polaczenie);
        
        wynik = new JTextPane();
        wynik.setEditable(false);
        pole.add(wynik);
        
		JButton button = new JButton("WYSZUKAJ");
		button.setActionCommand("wyszukaj");
		button.addActionListener(this);
		pole.add(button);
		
		add(pole);
        
		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		try {
			Method m = this.getClass().getDeclaredMethod(cmd);
			m.invoke(this);// wywo³anie metody

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public void wyszukaj(){
		
		int cenaInteger = Integer.valueOf(cena.getText());
		int zegarProcesotaInteger = Integer.valueOf(wydajnosc.getText());
		int wyposazenieInteger = Integer.valueOf(wyposazenie.getText());
		int bateriaInteger = Integer.valueOf(bateria.getText());
		int wyswietlaczInteger = Integer.valueOf(wyswietlacz.getText());
		int audioInteger = Integer.valueOf(audio.getText());
		int aparatInteger = Integer.valueOf(aparat.getText());
		
		int cena = (double)cenaInteger/1000 <= 1 ? 1: (double)cenaInteger/1000 <= 2 ? 2 : 3;
		System.out.println(cena);
		int cenaWspolczynik = Integer.valueOf(String.valueOf(String.valueOf(cenaInteger).charAt(1))+String.valueOf(String.valueOf(cenaInteger).charAt(2))); 
		
		Integer[] szukanyTelefon = new Integer[] {cenaWspolczynik,zegarProcesotaInteger,wyposazenieInteger,bateriaInteger,wyswietlaczInteger
				,audioInteger,aparatInteger};
		KNN knnsearch = new KNN();
		wynik.setText(knnsearch.wyszukajModel(szukanyTelefon,cena));
		
		//ustawianie obiektu do usuniecia
		knnsearch = null;
	}

	public static void main(String arg[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, SQLException, IOException {

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
			new MainGUI();
		}
	}

}
