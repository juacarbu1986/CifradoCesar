package cesardesce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class algoritmo {

    public void cifrar(String cadena, String clave, int tipo) {
        final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        File archivo = null;
        File clave_ar = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
                System.out.println("<<CIFRADO INICIADO...");
           archivo = new File(cadena);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String texto;
            texto = br.readLine();
            String cadena_cal = "";
            String cadena_temp;
            texto = texto.toUpperCase();
             System.out.println("LEYENDO ARCHIVOS DE ENTRADA...");
            clave_ar = new File(clave);
            fr1 = new FileReader(clave_ar);
            br1 = new BufferedReader(fr1);
            String clave_int;
            int numero;
            clave_int = br1.readLine();
            clave_int = clave_int.replace(",", "");
            numero = validar_clave(clave_int); //Aquí se llama el método de abajo para validar si la clave viene en int o char
            //numero = Integer.parseInt(clave_int);

            String cifrado = "";
            for (int i = 0; i < texto.length(); i++) {
                int posicion = alfabeto.indexOf(texto.charAt(i));
                if (posicion >= 0) {
                    cifrado += alfabeto.charAt((posicion + numero) % alfabeto.length());
                    // SE UTILIZA LA OPERACION MODULO PARA VOLVER AL INICIO DEL
                    // ALFABETO CUANDO SE SALE POR EL FINAL
                } else {
                    cifrado += texto.charAt(i);
                    // System.out.println(cifrado);
                }
            }
            System.out.println("CREANDO ARCHIVO DE SALIDA...");
            String[] parts = cadena.split("txt");
            File file = new File(parts[0] + "cif");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar informaciÃ³n al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(cifrado);
            bw.close();
            fw.close();
System.out.println("ARCHIVO CIFRADO CREADO>>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void descifrar(String cadena, String clave, int tipo) {
        final String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        File archivo = null;
        File clave_ar = null;
        FileReader fr1 = null;
        BufferedReader br1 = null;
        FileReader fr = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        int oper = 0;
        int oper_tem = 0;
        try {
            
            System.out.println("<<PROCESO DE DESCIFRADO INICIADO...");
            archivo = new File(cadena);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String texto;
            texto = br.readLine();
            String cadena_cal = "";
            String cadena_temp;
            texto = texto.toUpperCase();
             System.out.println("LEYENDO ARCHIVOS...");
           
            clave_ar = new File(clave);
            fr1 = new FileReader(clave_ar);
            br1 = new BufferedReader(fr1);
            String clave_int;
            int numero;
            clave_int = br1.readLine();
            clave_int = clave_int.replace(",", "");
             numero = validar_clave(clave_int);

            String cifrado = "";
            System.out.println("PROCESANDO CRIPTOGRAMA");
            for (int i = 0; i < texto.length(); i++) {
                
                int posicion = alfabeto.indexOf(texto.charAt(i));
                oper_tem=0;
                if (posicion >= 0) {
                    oper = posicion - numero;
                    //System.err.println(oper);
                    if ((oper >= 0)) {
                        cifrado += alfabeto.charAt((posicion - numero) % alfabeto.length());
                      //   System.err.println(cifrado);
                        //valor_letra = alfabeto_val.get(calculo);
                    } else {
                        oper_tem = (26 + oper) + 1;//--30
                        while (oper_tem < 0) {
                            oper_tem = (26 + oper_tem) + 1;//-4
                        }
                        cifrado += alfabeto.charAt(oper_tem);
                    }

                    // SE UTILIZA LA OPERACION MODULO PARA VOLVER AL INICIO DEL
                    // ALFABETO CUANDO SE SALE POR EL FINAL
                } else {
                    cifrado += texto.charAt(i);
                    // System.out.println(cifrado);
                }
            }
             System.out.println("CREANDO ARCHIVO DE TEXTO CLARO");
            String[] parts = cadena.split("txt");
            File file = new File(parts[0] + "des");
            // Si el archivo no existe, se crea!
            if (!file.exists()) {
                file.createNewFile();
            }
            // flag true, indica adjuntar informaciÃ³n al archivo.
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(cifrado); //guarda el archivo descifrado en el compu
            bw.close();
            fw.close();
            System.out.println("ARCHIVO CREADO>>");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
      public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    public static int validar_clave(String clave) {
        String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String clave_temp=clave;
        int valor=0;
        if(isNumeric(clave)){
            //clave= clave.toUpperCase();
           valor=Integer.parseInt(clave_temp);
        }else{
             //clave= clave.toUpperCase();
           valor=alfabeto.indexOf(clave_temp.toUpperCase());
        }
       return valor;
    }

}
