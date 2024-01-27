package org.andrew;

import lombok.extern.log4j.Log4j2;
import org.andrew.Services.GameFieldInit;


@Log4j2
public class Main {
    public static void main(String[] args) {
        GameFieldInit.getInstance();
    }
}