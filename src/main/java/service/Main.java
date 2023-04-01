package service;

import pao.application.Gallery;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Gallery gallery = Gallery.getInstance();
            gallery.intro(scanner);

            if ("quit".equals(scanner.next())) {
                break;
            }
        }

    }
}