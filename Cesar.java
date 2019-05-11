package cesardesce; //Nombre del proyecto
import java.util.Arrays;
public class Cesar{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //String[] args1 = { "-d", "-a", "nombre.txt", "-k", "clave.txt"}; //Esto se usó para prueba
        //System.out.println(args1[0]);
        String[] valores = {"-c", "-k", "-d"};
         algoritmo analisis = new algoritmo(); //Este es un alias de la clase Algoritmo
         
        if(args.length==5){ //Se definieron 5 argumentos de entrada
        if ((args[1].equals("-a"))) {
            
            //Valido que venga el -d y -k comparando el arreglo args que tien la entrada del usuario
            // con el arreglo valores que tiene mis valores permitidos
            if ((Arrays.stream(valores).anyMatch(args[0]::equals)) && (Arrays.stream(valores).anyMatch(args[3]::equals))) { 
               // for (int i = 0; i < args1.length; i++) {
                    //System.out.println(i);
                    if (args[0].equals("-c")) {
                       
                           analisis.cifrar(args[2], args[4], 1); //llamo la clase algoritmo tmb llamada analisis
                            System.out.println("Proceso de cifado terminado");
                            

                    }else if(args[0].equals("-d")){ 
                            analisis.descifrar(args[2], args[4], 2);
                             System.out.println("Proceso de descifrado terminado");
                            

                    }else{
                     System.out.println("java -jar CESAR.jar <accion> -a <archivo.txt> -k <clave.txt>");
                    }
                //}

            } else {
                System.out.println("java -jar CESAR.jar <accion> -a <archivo.txt> -k <clave.txt>");

            }

        } else {
            System.out.println("java -jar CESAR.jar <accion> -a <archivo.txt> -k <clave.txt>");
        }

    }else{
        System.out.println("<< BIENVENIDO AL CIFRADO POR ALGORITMO DE CESAR >>");
        //System.out.println("donde podra cifrar y descifrar sus mensajes>>");
        //System.out.println("Para usar el programa deberá usar el siguiente comando:");
        System.out.println("\n");
        System.out.println("Para usar el programa deberá usar el siguiente comando:");
        System.out.println("\n");
        System.out.println("Sintaxis:  java -jar CESAR.jar <accion> -a <archivo.txt> -k <clave.txt>");
        //System.out.println("Donde:"); 
        System.out.println("\n");
        System.out.println("...:::Inicio de la Ayuda:::...\n"+
                "\n"+
                "<accion>: -c cifrar -d descifrar\n"+
                "<archivo.txt>: es el nombre del archivo .txt que contiene el texto claro que se desea cifrar\n"+
                "<clave.txt>: es el nombre del archivo .txt que contiene la clave con la que se cifrara y descifrara.\n"+
                "La clave puede ir en letra de la A-Z o en numero del 0 al 26.\n"+
                "\n"+
                "Nota: los archivos deben estar en la misma ubicacion donde esta el archivo Cesar.jar, la salida de la\n"+
                "informacion quedara en la misma ruta.\n"+
                "\n"+
                "...:::Fin de la Ayuda:::..."); 
        }
    }
        // TODO code application logic here
         
}
