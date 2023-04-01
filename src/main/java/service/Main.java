package service;

import pao.application.Gallery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {
            Gallery gallery = Gallery.getInstance();
            gallery.intro();

            if ("quit".equals(scanner.next())) {
                break;
            }
        }
    }
}