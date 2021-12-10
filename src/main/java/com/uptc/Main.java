package com.uptc;

import com.uptc.controller.ExecuteProcess;
import com.uptc.models.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static File file = new File("test.txt");
    static Scanner input = new Scanner(System.in);
    static PrintWriter printWriter = new PrintWriter(System.out);

    public static void main(String[] args) throws FileNotFoundException {
        ExecuteProcess executeProcess = new ExecuteProcess();
        int timeCPU = input.nextInt();
        int numProcess = input.nextInt();
        for (int i = 0; i < numProcess; i++) {
            executeProcess.addProcessToQueue(new Process(input.next(), input.nextInt(), input.nextBoolean()));
        }
        executeProcess.init(timeCPU);
        executeProcess.reports(printWriter);
        input.close();
        printWriter.close();
    }

}
