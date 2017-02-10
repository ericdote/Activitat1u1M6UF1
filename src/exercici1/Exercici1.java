package exercici1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercici1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        NombresPrimers np = new NombresPrimers();
        for (int i = 0; i < 10; i++) {
            np.generarNombre();
        }        
        System.out.println(np.totalNombres());
        System.out.println(np.nombrePosicio(4));
        System.out.println(np.utlimNombre());
        System.out.println(np.cercaNombres(2, 20));
    }

}
