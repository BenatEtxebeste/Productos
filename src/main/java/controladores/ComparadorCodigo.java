package controladores;

import java.util.Comparator;

import clases.Producto;

public class ComparadorCodigo implements Comparator<Producto>{

	@Override
	public int compare(Producto o1, Producto o2) {
		return o1.getCodigo().compareTo(o2.getCodigo());
	}
}