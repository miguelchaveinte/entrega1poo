package es.uva.es.poo.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uva.es.poo.clases.*;
import es.uva.inf.poo.maps.GPSCoordinate;

public class ContenedorTest {

	@Test
	public void testConstructor() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054383","500-Kg",200.0,"100-ft3",false);
		assertNotNull(contenedorPrueba);
	}
	@Test
	public void testConstructorVolumenMetros() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054383","500-lb",200.0,"100-m3",false);
		assertNotNull(contenedorPrueba);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorCodigoControlFalso() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054385","500-Kg",200.0,"100-m3",false);
		assertNotNull(contenedorPrueba);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorIdentificadorFalso() {
		Contenedor contenedorPrueba=new Contenedor("CSQUU3054383","500-Kg",-200.0,"100-m3",false);
		assertNotNull(contenedorPrueba);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorPesoInvalido() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054385","500-Kgg",200.0,"100-m3",false);
		assertNotNull(contenedorPrueba);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorPesoNegativo() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054383","-500-Kg",200.0,"100-ft3",false);
		assertNotNull(contenedorPrueba);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorVolumenNegativo() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054383","500-Kg",200.0,"-100-ft3",false);
		assertNotNull(contenedorPrueba);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testConstructorVolumenInvalido() {
		Contenedor contenedorPrueba=new Contenedor("CSQU3054385","500-Kg",200.0,"100-m33",false);
		assertNotNull(contenedorPrueba);
	}
	@Test
	public void testComprobarIdentificador() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSQU3054383";
		contenedor.comprobarIdentificador(identificador);	
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testComprobarIdentificadorIdMasLargo() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSSQU3054383";
		contenedor.comprobarIdentificador(identificador);	
	}

	@Test(expected=IllegalArgumentException.class) 
	public void testComprobarIdentificadorMinusculas() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSsQU3054383";
		contenedor.comprobarIdentificador(identificador);	
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testComprobarIdentificadorCodigoInvalido() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSSQZ3054383";
		contenedor.comprobarIdentificador(identificador);	
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testComprobarIdentificadorSerieInvalida() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSSUZ30543583";
		contenedor.comprobarIdentificador(identificador);	
	}
	@Test
	public void obtenerDigitoControl() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSQU3054383";
		int digitoControl=contenedor.obtenerDigitoControl(identificador);
		assertEquals(digitoControl,3);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void obtenerDigitoControlIdInvalido() {
		Contenedor contenedor=new Contenedor();
		String identificador="CSQU38054383";
		int digitoControl=contenedor.obtenerDigitoControl(identificador);
		assertEquals(digitoControl,3);
	}
	@Test
	public void testGetIdentificador() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		assertEquals(pruebaContenedor.getIdentificador(),"CSQU3054383");
	}
	@Test
	public void testSetRecogida() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		pruebaContenedor.setRecogida();
		assertTrue(pruebaContenedor.getEstado());
	}
	@Test
	public void testSetTransito() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		pruebaContenedor.setTransito();
		assertFalse(pruebaContenedor.getEstado());
	}
	@Test
	public void testGetEstado() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		assertFalse(pruebaContenedor.getEstado());
	}
	@Test
	public void testSetTecho() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		pruebaContenedor.setTecho();
		assertTrue(pruebaContenedor.getTecho());
	}
	@Test
	public void testSetNoTecho() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		pruebaContenedor.setNoTecho();
		assertFalse(pruebaContenedor.getTecho());
	}
	@Test
	public void testGetTecho() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		assertFalse(pruebaContenedor.getTecho());
	}
	@Test
	public void testHacerTrayecto() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		Puerto destino=new Puerto("ES-MAD");
		pruebaContenedor.hacerTrayecto(destino);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testHacerTrayectoNull() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		Puerto destino=null;
		pruebaContenedor.hacerTrayecto(destino);
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testHacerTrayectoAtributosNull() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		Puerto destino=new Puerto();
		pruebaContenedor.hacerTrayecto(destino);
	}
	@Test
	public void testHacerViaje() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		Puerto destino=new Puerto("ES-MAD");
		GPSCoordinate coordenadaMuelle=new GPSCoordinate(40.5,40.5);
		Muelle destinoMuelle=new Muelle(12,coordenadaMuelle,'O',50);
		destino.añadirMuelle(destinoMuelle);
		
		pruebaContenedor.hacerTrayecto(destino);
		Puerto puertoOrigen=new Puerto("ES-VAL");
		GPSCoordinate coordenada=new GPSCoordinate(40.5,40.5);
		Muelle añadirOrigen=new Muelle(20,coordenada,'F',5);
		añadirOrigen.asignarPlaza(pruebaContenedor, 2);
		puertoOrigen.añadirMuelle(añadirOrigen);
		

		pruebaContenedor.hacerViajes(pruebaContenedor, puertoOrigen, destino, destinoMuelle, "2020-11-19", "2020-12-31");
		assertTrue(pruebaContenedor.getEstado());
	}
	@Test(expected=IllegalArgumentException.class) 
	public void testHacerViajeNoEstaElContenedor() {
		Contenedor pruebaContenedor=new Contenedor("CSQU3054383","500-Kg",200.0,"100-m3",false);
		Puerto destino=new Puerto("ES-MAD");
		GPSCoordinate coordenadaMuelle=new GPSCoordinate(40.5,40.5);
		Muelle destinoMuelle=new Muelle(12,coordenadaMuelle,'O',50);
		destino.añadirMuelle(destinoMuelle);
		
		pruebaContenedor.hacerTrayecto(destino);
		Puerto puertoOrigen=new Puerto("ES-VAL");
		GPSCoordinate coordenada=new GPSCoordinate(40.5,40.5);
		Muelle añadirOrigen=new Muelle(20,coordenada,'F',5);
		añadirOrigen.asignarPlaza(pruebaContenedor, 2);
		puertoOrigen.añadirMuelle(añadirOrigen);
		
		Contenedor contenedorNoEsta=new Contenedor("TTNU9843220","500-Kg",200.0,"100-m3",false);
		

		pruebaContenedor.hacerViajes(contenedorNoEsta, puertoOrigen, destino, destinoMuelle, "2020-11-19", "2020-12-31");
		assertTrue(pruebaContenedor.getEstado());
	}
}
