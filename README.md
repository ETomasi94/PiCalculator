# PiCalculator
A Pi calculator by means of Leibniz Formula

Author : Enrico Tomasi

-----OVERVIEW----
Given a decimal value representing the calculation accuracy and an integer number representing the time limit by which we want the result to be returned, this program calculates an approximation of Pi and stops when the difference between the value estimated by the program and the value Math.PI given by Java.Math class is smaller than accuracy value previously given in input or when the time limit has expired.

----FILES----

PiCalculator.Java : The main class of the program, implements the main thread and handles the occurring exceptions.

T.Java : Implements the calculation task given to the main thread.

----INSTRUCTIONS----
Output is written in italian, so here is a simple explanation of how this program works :

1 - "Inserire il grado di precisione desiderato" -> Insert the required accuracy (e.g : 0,01 means that whe can tolerate an error of 1 in the second decimal digit)

2 - "Inserire il tempo massimo entro cui terminare il calcolo" -> Insert the required time limitby which the program receives a timeout

The program will either find an accurated approximation of Pi or terminate within the time limit.



WRITTEN BY : Enrico Tomasi ON DATE : 3/10/2019
