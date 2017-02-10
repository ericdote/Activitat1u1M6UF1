package exercici1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class NombresPrimers {

    File fitxer = new File("C:\\Users\\Eric\\Desktop\\DAM\\M6\\UF1\\Ficheros\\Exercici1");
    RandomAccessFile raf;
    /**
     * Constructor de la clase que inicializa el raf
     * @throws FileNotFoundException 
     */
    public NombresPrimers() throws FileNotFoundException {
        this.raf = new RandomAccessFile(fitxer, "rw");
    }
    /**
     * Metode que afegeix els numeros primers
     * @throws IOException 
     */
    public void generarNombre() throws IOException {
        if (fitxer.length() != 0) {
            raf.seek(fitxer.length() - 4);
            int num = raf.readInt();
            int nextNum = calculNumeroPrimer(num);
            raf.seek(fitxer.length());
            raf.writeInt(nextNum);
        }
    }
    /**
     * Metode que calcula els numeros primers
     * @param lastNum
     * @return 
     */
    public int calculNumeroPrimer(int lastNum) {
        boolean next = true;
        int num = 0;
        do {
            if ((lastNum + 1) % 2 == 0) {
                num = lastNum + 1;
                next = false;
            }
            lastNum++;
        } while (next);
        return num;
    }
    /**
     * Metode que torna el total de numeros que tenim al fitxer
     * @return 
     */
    public long totalNumeros() {
        long nums = fitxer.length() / 4;
        return nums;
    }
    /**
     * Metode que retorna una llista amb els numeros que estan entre 2 valors
     * @param num1
     * @param num2
     * @return
     * @throws IOException 
     */
    public ArrayList cercaNumeros(int num1, int num2) throws IOException {
        
        ArrayList numeros = new ArrayList<>();
        boolean numTrobat = true;
        raf.seek(0);
        while(numTrobat){
            int numero = raf.readInt();
            if(numero >= num1 && numero <= num2){
                numeros.add(numero);
            } else if(numero > num2){
                numTrobat = false;
            }       
        }
        raf.close();
        return numeros;
    }
    /**
     * Metode que retorna l'utlim numero del fitxer
     * @return
     * @throws IOException 
     */
    public int ultimNumero() throws IOException{
        int numero;
        raf.seek(raf.length() - 4);
        numero = raf.readInt();
        raf.close();
        return numero;
    }
    /**
     * Metode que retorna el numero de una posicio del fitxer
     * @param posicio
     * @return
     * @throws IOException 
     */
    public int numeroPosicio(int posicio) throws IOException{
        int numero;
        raf.seek((posicio * 4) - 4);
        numero = raf.readInt();
        raf.close();
        return numero;
    }
}
