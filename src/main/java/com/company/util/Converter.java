package com.company.util;

public class Converter {

    /**
     * Convert from hex String to byte array
     *
     * @param hexString
     * @return byte array
     */
    public static byte[] hexString2ByteArray(String hexString) {
        int textLength = hexString.length() / 2;
        byte[] byteArray = new byte[textLength];
        for (int i = 0; i < byteArray.length; i++) {
            int index = i * 2;
            int v = Integer.parseInt(hexString.substring(index, index + 2), 16);
            byteArray[i] = (byte) v;
        }
        return byteArray;
    }

    /**
     * Convert from ascii String to hex String
     *
     * @param toConvert
     * @return String
     */
    public static String asciiToHex(String toConvert) {

        // Step-1 - Convert ASCII string to char array
        char[] ch = toConvert.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char c : ch) {
            // Step-2 Use %H to format character to Hex
            String hexCode = String.format("%H", c);
            builder.append(hexCode);
        }

        return builder.toString();
    }

}
