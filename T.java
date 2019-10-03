/*
ASSIGNMENT NUMERO 1 LABORATORIO DI RETI A.A 2019-2020
Classe : T.java

Autore : Enrico Tomasi
Numero Matricola : 503527
*/

package picalculator;
import java.util.*;
import java.lang.Math.*;
import java.lang.Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


/*
    CLASS T
    @OVERVIEW : Classe che implementa il task di calcolo del Pigreco con la serie di Leibniz
*/
public class T implements Callable<Double> 
{
    private final double accuracy;
    private final int timeout;
    String message = "Tempo di calcolo scaduto\n";
    
    public T(double acc, int t)
    {
        this.accuracy = acc;
        this.timeout = t;
    }
   
    /*
        METHOD CALL
        @OVERVIEW : Metodo di calcolo del Pigreco chiamato da un thread
    */
    @Override
    public Double call() throws InterruptedException, ExecutionException, TimeoutException
    {   

        boolean flag = true;
        
        double i = 0.0;
        
        double numerator;
        double denominator;
        double factor;
        double difference;
        double res = 0;

            while(flag)
            {
                //TEST DI INTERRUZIONE PER GARANTIRE LA TERMINAZIONE NEL CASI ARRIVINO
                if(Thread.interrupted())
                {
                    break;
                }
                
                numerator = Math.pow(-1,i);
                denominator = ((2*i)+1);

                factor = (numerator/denominator);

                res += factor;

                difference = Math.abs((res*4)-(Math.PI));

                i++;     

                flag = ((difference >= (this.accuracy))); 
            }
            
         //N.B : Nella serie di Leibniz "la somma infinita a segni alterni
         // di tutti i reciproci dei numeri naturali dispari, partendo da 
         // più uno, è uguale a un quarto del pi greco." (Citazione Wikipedia)
         return (res*4);

    }
}
    
    
