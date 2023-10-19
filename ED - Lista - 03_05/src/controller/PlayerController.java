package controller;

import br.edu.fatec.zl.Lista;
import model.Musica;

public class PlayerController {
	
	Musica song;

	public PlayerController() {
		super();
	}
	
	public void adicionaMusica(Lista<Musica> lista, String musica) {
		String []aux = musica.split(";");
		int auxi = Integer.parseInt(aux[2]);
		song = new Musica(aux[0],aux[1],auxi);
		lista.addFirst(song);
		System.out.println("A música foi adicionada a lista.");
	}
	
	public void removeMusica(Lista<Musica> lista, int place) {
		if(!lista.isEmpty()) {
			try {
				song = lista.get(place);
				System.out.println("A música "+song.getNome()+" foi retirada da playlist.");
				lista.remove(place);
			} catch (Exception e) {
				System.err.println("Não existe música nessa posição.");
			}
		}else {
			System.err.println("A playlist está vazia.");
		}
	}
	
	public void executaPlaylist(Lista<Musica> lista) {
		if(lista.isEmpty()){
			System.err.println("A playlist está vazia.");
		}else {
			while(!lista.isEmpty()) {
				try {
					song = lista.get(0);
				} catch (Exception e) {
					System.err.println(e);
				}
				System.out.println("A musica "+song.getNome()+" do artista "+song.getNomeArtista()+" está sendo tocada.");
				try {
					Thread.sleep(song.getDuracao());
				} catch (InterruptedException e) {
					System.err.println();
				}
				try {
					lista.removeFirst();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
				
	
	}
}
