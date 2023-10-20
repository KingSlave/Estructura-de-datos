import java.util.Scanner;

public class Doble {
    
    private static final int demo[] = {4,6,8,9,10};
    private static Nodo lista; 
    private static Nodo inicio;

    public static void main(String[] args) {
        for(;;){
       System.out.println("Menú");
       System.out.println("1. Agregar"); 
       System.out.println("2. Consultar Izq -> Der");
       System.out.println("3. Consultar Der -> Izq");
       System.out.println("4. Modificar");
       System.out.println("5. Eliminar");
       System.out.println("6. Salir");
       int opcion = new Scanner(System.in).nextInt();
            switch(opcion){
                case 1:
                    for (int dato : demo) {
                        agregar(dato);
                    }    
                    //agregar();                
                break;
                case 2:
                    consultarIzq();
                break;
                case 3:
                    consultarDer();
                break;
                case 4:
                    
                break;
                case 5:
                    eliminar();
                break;
                case 6:
                    System.exit(0);
                break;
            }
       }

    }

    public static void agregar(int dato){
        if(lista==null){ // Es el primer nodo
            lista = new Nodo();
            inicio = lista; 
            lista.dato=dato;
        }else{
            lista.sig = new Nodo();
            lista.sig.dato = dato;
            Nodo temp = lista;
            lista = lista.sig;
            lista.ant = temp;
        }
        System.out.println("Número demostrativo agregado: " + dato);
    }

    public static void consultarIzq(){
        Nodo temp = inicio;
        while(temp!=null){
            System.out.println("Dato: " + temp.dato);
            temp = temp.sig;
        }
    }

    public static void consultarDer(){
        Nodo temp = lista;
        while(temp!=null){
            System.out.println("Dato: " + temp.dato);
            temp = temp.ant;
        }
    }

    public static void modificar(){
        
    }

    public static void eliminar(){
        Nodo temp = inicio;
        System.out.println("Numero que buscas eliminar: ");
        int buscado = new Scanner(System.in).nextInt();
        if(temp.dato == buscado){
            inicio = inicio.sig;
            if(inicio!=null)
            inicio.ant =null;
            else
            lista = null;
        }else{
            while(temp.sig!=null){
            if(temp.sig.dato == buscado){
                if(temp.sig==lista){
                    temp.sig=null;
                    lista.ant = null;
                    lista = temp;
                }else{
                    Nodo temp2 = temp.sig;
                    temp.sig =null;
                    temp2.ant = null;
                    temp.sig = temp2.sig;

                }
                break;
            }
                temp = temp.sig;
            }   
        }
    }

}

