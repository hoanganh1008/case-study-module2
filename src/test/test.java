package test;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        Data d1 = new Data(1);
        Data d2 = new Data(2);
        swap(d1, d2);
        System.out.println(d1 + ", " + d2);
    }
    static void swap(Data d1, Data d2){
        Data temp = d1;
        d1 = d2;
        d2 = temp;
}}
