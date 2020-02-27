package controlador;
import java.util.ArrayList;

import objetos.Carro;
import objetos.Huevo;
import objetos.Kromi;
import objetos.Caguanos;
import objetos.Trupalla;

public class Tablero{

    /*
    *  VARIABLES DE INSTANCIA 
    */

    private String[][] boardCarros = new String[15][15];
    
    private String[][] boardHuevos = new String[15][15];
    
    private ArrayList<Carro> carros = new ArrayList<Carro>();

    private ArrayList<Huevo> huevos = new ArrayList<Huevo>();

	private int contadorKromis;

	private int contadorCaguanos;

	private int contadorTrupallas;

    /*
    * CONSTRUCTORES 
    */
    public Tablero(){
        super();
        this.contadorKromis=0;
        this.contadorTrupallas=0;
        this.contadorCaguanos=0;
    }

    public Tablero(String[][] boardCarros, String[][] boardHuevos , ArrayList<Carro> carros, ArrayList<Huevo> huevos){
    	
        super();
        this.boardCarros = boardCarros;
        this.boardHuevos = boardHuevos; 
        this.carros = carros;
        this.huevos = huevos;
    }

    /*
    * METODOS ESPECIFICOS 
    */
    
    private boolean crearKromi() {
    	
    	boolean respuesta;
    	
    	Kromi kromi;
		/* 
		 *  El metodo generar� aleatoriamente:
		 *  - La fecha
		 *  - La cantidad de ocupantes
		 *  - El a�o de fabricaci�n
		 *  - La marca
		 */
		String dia = Integer.toString((int)(Math.random() * ((31 - 1) + 1)) + 1);
		String mes = Integer.toString((int)(Math.random() * ((12 - 1) + 1)) + 1);
		String ano = Integer.toString((int)(Math.random() * ((2020 - 1990) + 1)) + 1990);
		
		String fecha = (dia+"/"+mes+"/"+ano);
		
		int cantOcupantes = (int)(Math.random() * ((46 - 1) + 1)) + 1;
		
		int anoFabricacion = (int)(Math.random() * ((2019 - 1960) + 1)) + 1960;
		
		int marcaAux = (int)(Math.random() * ((4 - 1) + 1)) + 1;
		
		String marca = "";
		
		switch(marcaAux) {
		
		case 1: marca = "FORD";
				break;
			
		case 2: marca = "MERCEDES BENZ";
				break;
			
		case 3: marca = "TOYOTA";
				break;
			
		case 4: marca = "CHEVROLET";
				break;
			
		}
		
		try {
			
			int posX =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			int posY =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			
			int orientacionAux = (int)(Math.random() * ((2 - 1) + 1)) + 1;
			
			char orientacion = '-';
			
			switch (orientacionAux) {
			
			case 1: 
					if(boardCarros[posY][posX]==null & boardCarros[posY-1][posX]==null & boardCarros[posY-2][posX]==null) {
						orientacion = 'N';
						
						kromi = new Kromi(posX, posY, orientacion, cantOcupantes, fecha, anoFabricacion, marca);
						
						carros.add(kromi);
						
						boardCarros[kromi.getPosY()][kromi.getPosX()]="K";
						boardCarros[kromi.getPosY()-1][kromi.getPosX()]="K";
						boardCarros[kromi.getPosY()-2][kromi.getPosX()]="K";
						
						respuesta = true;
						break;

					}
					else {
						throw new Exception();
					}
			
			case 2: 
					if(boardCarros[posY][posX]==null & boardCarros[posY+1][posX]==null & boardCarros[posY+2][posX]==null) {
						orientacion = 'S';
						kromi = new Kromi(posX, posY, orientacion, cantOcupantes, fecha, anoFabricacion, marca);
						
						carros.add(kromi);
						
						boardCarros[kromi.getPosY()][kromi.getPosX()]="K";
						boardCarros[kromi.getPosY()+1][kromi.getPosX()]="K";
						boardCarros[kromi.getPosY()+2][kromi.getPosX()]="K";
						
						respuesta = true;
						break;
					}
					
					else {
						throw new Exception();
					}
			
			default: 
					respuesta = false;
					break;
				
			}
				
		}
		catch(Exception e) {
			
			respuesta = false;
			
		}
		return respuesta;
    }

    private boolean crearCaguanos() {
    	boolean respuesta;
    	
    	Caguanos caguano;
		/* 
		 *  El metodo generar� aleatoriamente:
		 *  - La fecha
		 *  - La cantidad de ocupantes
		 *  - El alcance de tiro
		 *  - El color del confetti
		 */
		String dia = Integer.toString((int)(Math.random() * ((31 - 1) + 1)) + 1);
		String mes = Integer.toString((int)(Math.random() * ((12 - 1) + 1)) + 1);
		String ano = Integer.toString((int)(Math.random() * ((2020 - 1990) + 1)) + 1990);
		
		String fecha = (dia+"/"+mes+"/"+ano);
		
		int cantOcupantes = (int)(Math.random() * ((46 - 1) + 1)) + 1;
		
		int alcanceTiro = (int)(Math.random() * ((100 - 50) + 1)) + 50;
		
		int colorConfettiAux = (int)(Math.random() * ((4 - 1) + 1)) + 1;
		
		String colorConfetti = "";
		
		switch(colorConfettiAux) {
		
		case 1: colorConfetti = "ROJO";
				break;
			
		case 2: colorConfetti = "AZUL";
				break;
			
		case 3: colorConfetti = "AMARILLO";
				break;
			
		case 4: colorConfetti = "VERDE";
				break;
			
		}
		
		try {
			
			int posX =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			int posY =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			
			int orientacionAux = (int)(Math.random() * ((2 - 1) + 1)) + 1;
			
			char orientacion = '-';
			
			switch (orientacionAux) {
			
			case 1: 
				if(boardCarros[posY][posX]==null & boardCarros[posY][posX-1]==null) {
					orientacion = 'O';

					caguano = new Caguanos(posX, posY, orientacion, cantOcupantes, fecha, alcanceTiro, colorConfetti);
					
					carros.add(caguano);
					
					boardCarros[caguano.getPosY()][caguano.getPosX()]="C";
					boardCarros[caguano.getPosY()][caguano.getPosX()-1]="C";

					
					respuesta = true;
					break;
				}
				
				else {
					throw new Exception();
				}
			
			case 2: 
				if(boardCarros[posY][posX]==null & boardCarros[posY][posX+1]==null) {
					orientacion = 'E';

					caguano = new Caguanos(posX, posY, orientacion, cantOcupantes, fecha, alcanceTiro, colorConfetti);
					
					carros.add(caguano);
					
					boardCarros[caguano.getPosY()][caguano.getPosX()]="C";
					boardCarros[caguano.getPosY()][caguano.getPosX()+1]="C";
					
					respuesta = true;
					break;
				}
				
				else {
					throw new Exception();
				}
				
			default: 
					respuesta = false;
					break;
				
			}
				
		}
		catch(Exception e) {
			
			respuesta = false;
			
		}
		return respuesta;
	}

	private boolean crearTrupalla() {
    	boolean respuesta;
    	
    	Trupalla trupalla;
		/* 
		 *  El metodo generar� aleatoriamente:
		 *  - La fecha
		 *  - La cantidad de ocupantes
		 *  - El nivel de armadura
		 *  - El nombre del controlador
		 */
		String dia = Integer.toString((int)(Math.random() * ((31 - 1) + 1)) + 1);
		String mes = Integer.toString((int)(Math.random() * ((12 - 1) + 1)) + 1);
		String ano = Integer.toString((int)(Math.random() * ((2020 - 1990) + 1)) + 1990);
		
		String fecha = (dia+"/"+mes+"/"+ano);
		
		int cantOcupantes = (int)(Math.random() * ((46 - 1) + 1)) + 1;
		
		int nivelArmadura = (int)(Math.random() * ((5 - 1) + 1)) + 1;
		
		int nombreAux = (int)(Math.random() * ((4 - 1) + 1)) + 1;
		
		String nombreControlador = "";
		
		switch(nombreAux) {
		
		case 1: nombreControlador = "TENIENTE CAVIERES";
				break;
			
		case 2: nombreControlador = "BELENCITA";
				break;
			
		case 3: nombreControlador = "VALDERRAMA";
				break;
			
		case 4: nombreControlador = "GENERAL ROZAS";
				break;
			
		}
		
		try {
			
			int posX =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			int posY =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
			
			int orientacionAux = (int)(Math.random() * ((4 - 1) + 1)) + 1;
			
			char orientacion = '-';
			
			switch (orientacionAux) {
			
			case 1: 
					if(boardCarros[posY][posX]==null) {
						orientacion = 'N';
						
						trupalla = new Trupalla(posX, posY, orientacion, cantOcupantes, fecha, nivelArmadura, nombreControlador);
						
						carros.add(trupalla);
						
						boardCarros[trupalla.getPosY()][trupalla.getPosX()]="T";

						
						respuesta = true;
						break;

					}
					else {
						throw new Exception();
					}
			
			case 2: 
				if(boardCarros[posY][posX]==null) {
					orientacion = 'S';
					
					trupalla = new Trupalla(posX, posY, orientacion, cantOcupantes, fecha, nivelArmadura, nombreControlador);
					
					carros.add(trupalla);
					
					boardCarros[trupalla.getPosY()][trupalla.getPosX()]="T";

					
					respuesta = true;
					break;

				}
				else {
					throw new Exception();
				}
			case 3: 
				if(boardCarros[posY][posX]==null) {
					orientacion = 'O';
					
					trupalla = new Trupalla(posX, posY, orientacion, cantOcupantes, fecha, nivelArmadura, nombreControlador);
					
					carros.add(trupalla);
					
					boardCarros[trupalla.getPosY()][trupalla.getPosX()]="T";

					
					respuesta = true;
					break;

				}
				else {
					throw new Exception();
				}
			
			case 4: 
				if(boardCarros[posY][posX]==null) {
					orientacion = 'E';
					
					trupalla = new Trupalla(posX, posY, orientacion, cantOcupantes, fecha, nivelArmadura, nombreControlador);
					
					carros.add(trupalla);
					
					boardCarros[trupalla.getPosY()][trupalla.getPosX()]="T";

					
					respuesta = true;
					break;

				}
				else {
					throw new Exception();
				}
				
			default: 
					respuesta = false;
					break;
				
			}
				
		}
		catch(Exception e) {
			
			respuesta = false;
			
		}
		return respuesta;
	}
	
	public void lanzarHuevo(){
		
		int posX =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
		int posY =  (int)(Math.random() * ((14 - 0) + 1)) + 0;
		int puntaje;
		
		if(this.boardCarros[posY][posX]!=null) {
			
			switch(this.boardCarros[posY][posX]) {
			
			case "K": puntaje = 3;
					  break;
			
			case "C": puntaje = 2;
					  break;
				
			case "T": puntaje = 1;
					  break;
				
			default:  puntaje = 0;
					  break;
			
			}
			
			Huevo huevo = new Huevo(posX, posY, puntaje);
			
			this.huevos.add(huevo);
			
			this.boardHuevos[posY][posX]="H";
		}
		
		else {
			
			puntaje = 0;
			
			Huevo huevo = new Huevo(posX, posY, puntaje);
			
			this.huevos.add(huevo);
			
		}

    }
       
    public void generarMapa() {
    	
    	do {
    	
        	try {
        		
        		int random = (int)(Math.random() * ((3 - 1) + 1)) + 1;
        		
        		switch(random) {
        		
        		case 1: 
        				if(this.contadorKromis<3) {
        					if(crearKromi()) {
        						this.contadorKromis++;
        						break;
        					}
        					else {
        						break;
        					}
        				}
        				else {
        					break;
        				}

        			
        		case 2: 
    					if(this.contadorCaguanos<5) {
        					if(crearCaguanos()) {
        						this.contadorCaguanos++;
        						break;
        					}
        					else {
        						break;
        					}
    					}
    					else {
    						break;
    					}
        		case 3: 
    					if(this.contadorTrupallas<10) {
        					if(crearTrupalla()) {
        						this.contadorTrupallas++;
        						break;
        					}
        					else {
        						break;
        					}
    					}
    					else {
    						break;
    					}
        		}
        	}
    	
    	catch(Exception e) {
    			System.out.println("Hay un error");
    		}
    	}while(carros.size()<18);
    }

    public void revelarMatriz(){
    	
        for(int ext = 0; ext < this.boardCarros.length; ext++) {
        	
        	System.out.println(" ");
        	
        	for(int inter = 0; inter < this.boardCarros[ext].length; inter++) {
        		
        		String posicionAux = this.boardCarros[ext][inter];
        		
        		if(this.boardCarros[ext][inter]==null) {
        			
        			posicionAux = " ";
        			System.out.printf("%-2s %-2s", "|",posicionAux);
        		}
        		
        		else {
        			
        			System.out.printf("%-2s %-2s", "|",this.boardCarros[ext][inter]);
        		}
        	}
        }
    }

    public void mostrarMapaHuevos() {
    	
        for(int ext = 0; ext < this.boardHuevos.length; ext++) {
        	
        	System.out.println(" ");
        	
        	for(int inter = 0; inter < this.boardHuevos[ext].length; inter++) {
        		
        		String posicionAux = this.boardHuevos[ext][inter];
        		
        		if(this.boardHuevos[ext][inter]==null) {
        			
        			posicionAux = " ";
        			System.out.printf("%-2s %-2s", "|",posicionAux);
        		}
        		
        		else {
        			
        			System.out.printf("%-2s %-2s", "|",this.boardHuevos[ext][inter]);
        		}
        	}
        }
    }
    
    public static void calcularPuntaje(){

    }


    /*
    * GETTERS Y SETTERS 
    */

    public String[][] getBoard(){
        return this.boardCarros;
    }

    public ArrayList<Carro> getCarros(){
        return this.carros;
    }

    public ArrayList<Huevo> getHuevos(){
        return this.huevos;
    }

    public void setBoard(String [][] boardCarros){
        this.boardCarros  = boardCarros;
    }

    public void setCarros(ArrayList<Carro> carros){
        this.carros = carros;
    }

    public void setHuevos(ArrayList<Huevo> huevos){
        this.huevos = huevos;
    }
    
	public int getContadorKromis() {
		return contadorKromis;
	}

	public void setContadorKromis(int contadorKromis) {
		this.contadorKromis = contadorKromis;
	}

	public int getContadorCaguanos() {
		return contadorCaguanos;
	}

	public void setContadorCaguanos(int contadorCaguanos) {
		this.contadorCaguanos = contadorCaguanos;
	}

	public int getContadorTrupallas() {
		return contadorTrupallas;
	}

	public void setContadorTrupallas(int contadorTrupallas) {
		this.contadorTrupallas = contadorTrupallas;
	}

    public String toString(){
    	String string = "";
        return string;
    }

}