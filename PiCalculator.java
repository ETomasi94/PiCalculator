/*
ASSIGNMENT NUMERO 1 LABORATORIO DI RETI A.A 2019-2020
Classe : PiCalculator.java

Autore : Enrico Tomasi
Numero Matricola : 503527
*/
package picalculator;

import java.util.concurrent.*;
import java.util.Scanner;
import java.lang.Exception;
import java.lang.Thread;

/*
    CLASS PiCalculator
    @OVERVIEW : Classe che implementa il Thread main del calcolatore
*/
public class PiCalculator extends Thread
{
    private double precision;
    private int time;
    
    public PiCalculator()
    {
    }
    
    /*
        METHOD MAIN
        @OVERVIEW : Metodo che implementa il thread principale
    */
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException
    {
        double acc;
        int tm;
        double res;
       
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserire il grado di precisione desiderato\n");
        acc = sc.nextDouble();
        System.out.println("Inserire il tempo massimo entro cui terminare il calcolo\n");
        tm = sc.nextInt();

        T calculator = new T(acc,tm);
        
        //ESECUTORE DEL TASK DEL CALCOLO DI PIGRECO CON LA SERIE DI LEIBNIZ
        ExecutorService exe = Executors.newSingleThreadExecutor();
        Future<Double> result = exe.submit(calculator);
        
        //GESTIONE DELLE INTERRUPZIONI
        try
        {
            System.out.println("CALCOLO DI PIGRECO IN CORSO : \n");
            res = result.get(tm, TimeUnit.SECONDS);
            System.out.println("RISULTATO : "+res+"");                
        }
        catch(TimeoutException te)//TIMEOUT EXCEPTION GESTITA CON TERMINAZIONE DEL THREAD
        {
            System.out.println("TEMPO DI CALCOLO SCADUTO\n");
            result.cancel(true);
        }
        catch(InterruptedException | ExecutionException e)//INTERRUPTEDEXCEPTION ED EXECUTED EXCEPTION GESTITE CON TERMINAZIONE DEL THREAD
        {
            System.out.println("PROGRAMMA INTERROTTO\n");
            result.cancel(true);
        }

        //TERMINAZIONE "NATURALE" DEL THREAD
        exe.shutdown();
    }
}
