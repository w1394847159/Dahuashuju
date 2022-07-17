package com.wufan;

import java.util.Random;

public class hello {

    public static void main(String[] args) {


        int random = new Random().nextInt( 10000000 ) + 999999;
        //int ac = random / 10;

        String aa = "12103132";
        float  ab = (float) Integer.parseInt(aa) / 100;
        System.out.println(random);

    }
}
