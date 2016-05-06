package menjacnica.gui;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import menjacnica.Menjacnica;
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

}
