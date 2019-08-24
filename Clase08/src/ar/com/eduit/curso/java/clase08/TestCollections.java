package ar.com.eduit.curso.java.clase08;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class TestCollections {
    public static void main(String[] args) {
        Auto[] autos=new Auto[4];
        autos[0]=new Auto("Ford","Ka","Negro");
        autos[1]=new Auto("Fiat","Idea","Rojo");
        autos[2]=new Auto("Renault","Kangoo","Bordo");
        autos[3]=new Auto("Peugeot","3008","Verde");
        
        //recorrido con indices
        //for(int a=0;a<autos.length;a++) System.out.println(autos[a]);
        
        //Recorrido foreach  jdk 5 o superior
        for(Auto auto:autos) System.out.println(auto);
        
        //Framework Collection
        //Interface List
        List lista=new ArrayList();
        lista.add(new Auto("WV","UP","Blanco"));
        lista.add(new Auto("Citroen","C4","Blanco"));
        lista.add("hola");
        lista.add(34);
        
        //copiar los autos del vector auto a lista
        for(Auto a:autos) lista.add(a);
        
        System.out.println("*************************************************");
        //Recorrido con indices
        //for(int a=0;a<lista.size();a++) System.out.println(lista.get(a));
        
        //Recorrido foreach
        //for(Object o:lista) System.out.println(o);
        
        //método default jdk 8 o sup.
        //lista.forEach(item->System.out.println(item));
        
        //lista.forEach(item->{
        //    System.out.println(item);
        //});
        
        //item implicito
        lista.forEach(System.out::println);
        
        //Uso de Generics <E> jdk 5 o superior
        List<Auto>lista2=new LinkedList();
        lista2.add(new Auto("Fiat","Mobi","Azul"));
        lista2.add(new Auto("WV","Gol","Negro"));
        
        Auto auto1=(Auto)lista.get(0);
        Auto auto2=lista2.get(0);
        
        //Copiar autos de lista a lista2
        lista.forEach(item->{
            if(item instanceof Auto) lista2.add((Auto)item);
        });
        
        System.out.println("*************************************************");
        lista2.forEach(System.out::println);
        
        
        //Interfaz Set
        Set<String>set;
        
        //Implementación HashSet: es la más veloz no garantiza el orden de los elementos
        //set=new HashSet();
        
        //Implementación LinkedHashSet: almacena elementos en una lista enlazada por 
        // orden de ingreso.
        //set=new LinkedHashSet();
        
        //Implementación TreeSet: almacena los elementos en un arbol por orden natural.
        set=new TreeSet();
        
        set.add("Lunes");
        set.add("Martes");
        set.add("Lunes");
        set.add("Miércoles");
        set.add("Jueves");
        set.add("Viernes");
        set.add("Viernes");
        set.add("Sábado");
        set.add("Domingo");
        set.forEach(System.out::println);
        
        
        //Set<Auto>setAutos=new LinkedHashSet();
        Set<Auto>setAutos=new TreeSet();
        setAutos.addAll(lista2);
        setAutos.add(new Auto("Peugeot","3008","Verde"));
        
        System.out.println("*************************************************");
        setAutos.forEach(item->System.out.println(item+"\t"+item.hashCode()));
        
        //Clase Stack (Pila)
        Stack<Auto>pilaAutos=new Stack();
        //.push() Apilar un objeto
        pilaAutos.push(new Auto("Mercedes","Clase a","Gris"));
        pilaAutos.addAll(lista2);
        System.out.println("*************************************************");
        pilaAutos.forEach(System.out::println);
        System.out.println("Longitud de pila: "+pilaAutos.size());
        while(!pilaAutos.isEmpty()){
            System.out.println(pilaAutos.pop());
            //.pop(); desapila un objeto
        }
        System.out.println("Longitud de pila: "+pilaAutos.size());
        
        //Clase ArrayDeque (Cola)
        ArrayDeque<Auto>colaAutos=new ArrayDeque();
        //.offer() encolar un objeto
        
        colaAutos.addAll(lista2);
        colaAutos.offer(new Auto("Fiat","Uno","Rojo"));
        
        System.out.println("*************************************************");
        colaAutos.forEach(System.out::println);
        
        System.out.println("Longitud de cola: "+colaAutos.size());
        while(!colaAutos.isEmpty()){
            //.poll() descola un auto
            System.out.println(colaAutos.poll());
        }
        System.out.println("Longitud de cola: "+colaAutos.size());
        
    }
}
