package service;

import pao.application.Gallery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gallery gallery = Gallery.getInstance();
        gallery.intro(scanner);
//        while (true) {
//
//
//            if ("quit".equals(scanner.next())) {
//                break;
//            }
//        }

    }
}