package view;

import javax.swing.JOptionPane;

import br.edu.fatec.zl.Lista;
import controller.PlayerController;
import model.Musica;

public class Principal {

	public static void main(String[] args) {
		PlayerController pc = new PlayerController();
		Lista<Musica> lista = new Lista<Musica>();

		int c = 0;
		
		while(c!=9) {
			c = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para adicionar musicas, 2 para remover musicas e 3 para tocar a playlist ou 9 para encerrar"));
			switch (c) {
			case 1:
				String musi = JOptionPane.showInputDialog("Insira a música do seguinte modo: Nome da musica;Nome do artista;duração");
				pc.adicionaMusica(lista, musi);
				break;
			case 2:
				int i = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição da música a ser retirada"));
				pc.removeMusica(lista, i);
				break;
			case 3:
				pc.executaPlaylist(lista);
				break;
			case 9:
				System.out.println("Finalizando...");
				break;
			default:
				System.err.println("Opção não encontrada.");
				break;
			}
		}
	}

}
