package com.adam.logger.oracle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author adam
 * 创建于 2018-03-12 21:00.
 */
public class ConsoleLoggerOracleDbMain {
    public static void main(String[] args) throws IOException {
        int count = 0;
        final String recordLineFirst,recordLineTitle,recordLineStatement,recordLineResult,recordResult;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream("./log");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

        recordLineFirst = "#Record ";
        recordLineTitle = "---Title---\n";
        recordLineStatement = "---Statement---\n";
        recordLineResult = "---ResultLine---\n";
        recordResult = "---Result---";
        final String QUIT = "quit";
        final String QUIT_INFO = "退出程序.";
        String title,statement;
        List<String> results = new ArrayList<>();
        String input;

        while(true) {
            System.out.println(recordLineFirst + (++count));
            System.out.print(recordLineTitle + ">>");
            input = reader.readLine();
            if(input.equalsIgnoreCase(QUIT)) {
                System.out.println(QUIT_INFO);
                break;
            } else {
                title = input;
            }
            System.out.print(recordLineStatement + ">>");
            input = reader.readLine();
            if(input.equalsIgnoreCase(QUIT)) {
                System.out.println(QUIT_INFO);
                break;
            } else {
                statement = input;
            }
            System.out.print(recordLineResult + ">>");
            input = reader.readLine();
            while(!input.equalsIgnoreCase("finish") && !input.equalsIgnoreCase(QUIT)) {
                results.add(input);
                input = reader.readLine();
            }
            if(input.equalsIgnoreCase(QUIT)) {
                System.out.println(QUIT_INFO);
                break;
            }
            System.out.println();

            outputStreamWriter.write("-------------------------\n");
            outputStreamWriter.write(recordLineFirst + count + "\n");
            outputStreamWriter.write(recordLineTitle + title + "\n");
            outputStreamWriter.write(recordLineStatement + statement + "\n");
            outputStreamWriter.write(recordResult + "\n");
            for(String line:results) {
                outputStreamWriter.write(line + "\n");
            }
            outputStreamWriter.write("\n");
        }
        reader.close();
        outputStreamWriter.close();  //必须要在这里close，否则可能不写入
    }
}
