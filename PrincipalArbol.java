import java.util.Scanner;
public class PrincipalArbol {
static Arbol arbol; 
public static void main(String[] args) {
    for(;;){
        System.out.println("Menú");    
        System.out.println("1. Agregar");
        System.out.println("2. Recorrer Preorden");
        System.out.println("3. Recorrer Inorden");
        System.out.println("4. Recorrer Postorden");
        System.out.println("5. Editar");
        System.out.println("6. Eliminar");
        System.out.println("7. Salir");
        int opc = new Scanner(System.in).nextInt();
        switch(opc){
            case 1:
           // System.out.println("Introduce un número: ");
           // int n = new Scanner(System.in).nextInt();

                int datos[] = {50,40,60,55,35,45,90};
                for (int n : datos) {
                        agregar(arbol,n);
                }
                        
            break;
            case 2:
                preorden(arbol);
            break;
            case 3:
                inorden(arbol);
            break;
            case 4:
                postorden(arbol);
            break;
            case 5:

            break;
            case 6:
            System.out.println("Ingrese el numero a eliminar: ");
                arbol = eliminar(arbol, new Scanner(System.in).nextInt());
            break;
            case 7:
                System.exit(0);
            break;            
        }
    }
}



public static Arbol eliminar(Arbol a,int n){
    if(a!=null && a.dato==n){
        System.out.println("Dato para eliminar encontrado " + a.dato);
        a = null;        
    }else{
        if(a!=null && n<a.dato){ //izquierda            
            System.out.println("Nodo "+ a.dato+" IZQ");
               a.izq = eliminar(a.izq,n);            
        }else{ //derecha
            if(a!=null){                
                System.out.println("Nodo "+ a.dato+" DER");
                a.der = eliminar(a.der, n);
            }
        }
    }
    return a;
}


public static void agregar(Arbol a,int n){
    if(a==null){
        a = new Arbol();
        arbol = a;
        a.dato = n;
    }else{
        if(n<a.dato){ //izquierda
            if(a.izq==null){
                a.izq = new Arbol();
                a.izq.dato=n;
            }else{ //Se mueve a la izquierda                
                agregar(a.izq,n);
            }
        }else{ //derecha
            if(a.der==null){ //¿Está libre la derecha?
                a.der= new Arbol();
                a.der.dato = n;
            }else{ //Se mueve a la derecha
                agregar(a.der, n);
            }
        }
    }
}

public static void preorden(Arbol a){
    if(a!=null){
        System.out.println("Dato: " + a.dato);
        preorden(a.izq);
        preorden(a.der);
    }
}

public static void inorden(Arbol a){
    if(a!=null){        
        inorden(a.izq);
        System.out.println("Dato: " + a.dato);
        inorden(a.der);
    }
}

public static void postorden(Arbol a){
    if(a!=null){        
        postorden(a.izq);        
        postorden(a.der);
        System.out.println("Dato: " + a.dato);
    }
}

}
