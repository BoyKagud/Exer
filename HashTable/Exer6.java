/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exer6;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Exer6 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.print("Input table size: ");
        int size = in.nextInt();
        
        HashTable hashT = new HashTable(size);
        
        String loop = "";
        while(!loop.equals(".")) {
            System.out.print("Enter username and password or (.) to end: ");
            loop = in.next();
            if(!loop.equals(".")) hashT.insert(loop, in.next());
        }
        hashT.displayTable();
        
    }
}
