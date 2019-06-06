package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.company.util.Builder.gprsCmd;

public class Main {

    public static void main(String[] args) {

        // args = setdigout 1? 120 0

        String arguments = Arrays.asList(args).stream().collect(Collectors.joining(" "));

        String cmd = gprsCmd(arguments);

        System.out.println(cmd);

    }

}
