package com.company.util;


import static com.company.util.CRC.crc;
import static com.company.util.Converter.asciiToHex;

public class Builder {

    private static final String PREAMBLE = "00000000";
    private static final String CODEC = "0C";
    private static final String QUANTITY_OF_COMMANDS = "01";
    private static final String COMMAND_TYPE = "05";
    private static final String COMMAND_END_SYMBOL = "0D0A";

    /**
     * GPRS cmd builder for Teltonika geo device Codec 12
     * SRC: https://wiki.teltonika.lt/view/Codec#Codec_12
     *
     * @param cmd
     * @return gprs cmd hex String
     */
    public static String gprsCmd(String cmd) {

        String cmdHex, cmdSize, crc, packetLength;

        cmdHex = asciiToHex(cmd);
        cmdHex += COMMAND_END_SYMBOL;
        cmdSize = String.format("%08X", cmdHex.length() / 2);
        cmdHex = CODEC + QUANTITY_OF_COMMANDS + COMMAND_TYPE + cmdSize + cmdHex + QUANTITY_OF_COMMANDS;

        crc = crc(cmdHex);

        packetLength = String.format("%08X", cmdHex.length() / 2);

        cmdHex = PREAMBLE + packetLength + cmdHex + crc;

        return cmdHex;
    }

}
