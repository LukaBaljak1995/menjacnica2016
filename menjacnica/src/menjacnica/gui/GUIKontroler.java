package menjacnica.gui;

import java.awt.EventQueue;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import menjacnica.Menjacnica;
import menjacnica.Valuta;
import menjacnica.gui.models.MenjacnicaTableModel;

public class GUIKontroler {

	private static MenjacnicaGUI menjacnicaGUI;
	private static Menjacnica menjacnica;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnicaGUI = new MenjacnicaGUI();
					menjacnica = new Menjacnica();
					menjacnicaGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void prikaziDodajKursGUI() {
		DodajKursGUI prozor = new DodajKursGUI(menjacnicaGUI);
		prozor.setLocationRelativeTo(menjacnicaGUI.getContentPane());
		prozor.setVisible(true);
	}

	public static void prikaziObrisiKursGUI(int red) {

		ObrisiKursGUI prozor = new ObrisiKursGUI(menjacnicaGUI, menjacnica.vratiKursnuListu().get(red));
		prozor.setLocationRelativeTo(menjacnicaGUI.getContentPane());
		prozor.setVisible(true);

	}

	public static void prikaziIzvrsiZamenu(int red) {
		IzvrsiZamenuGUI prozor = new IzvrsiZamenuGUI(menjacnicaGUI, menjacnica.vratiKursnuListu().get(red));
		prozor.setLocationRelativeTo(menjacnicaGUI.getContentPane());
		prozor.setVisible(true);
	}

	public static void unesiValutu(int sifra, String naziv, String skraceniNaziv, double kupovni, double prodajni,
			double srednji) {

		menjacnica.dodajValutu(menjacnica.napraviValutu(sifra, naziv, skraceniNaziv, kupovni, prodajni, srednji));
	}

	public static LinkedList<Valuta> vratiSveValute() {
		return menjacnica.vratiKursnuListu();
	}

	public static void obrisiValutu(Valuta valuta) {
		menjacnica.obrisiValutu(valuta);
	}

	public static double izvrsiTransakciju(Valuta valuta, boolean prodaja, double iznos) {
		return menjacnica.izvrsiTransakciju(valuta, prodaja, iznos);
	}

	public static void sacuvajUFajl() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(menjacnicaGUI.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();

				menjacnica.sacuvajUFajl(file.getAbsolutePath());
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnicaGUI.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void ucitajIzFajla() {
		try {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(menjacnicaGUI.getContentPane());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				menjacnica.ucitajIzFajla(file.getAbsolutePath());
				menjacnicaGUI.prikaziSveValute();
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(menjacnicaGUI.getContentPane(), e1.getMessage(), "Greska",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
