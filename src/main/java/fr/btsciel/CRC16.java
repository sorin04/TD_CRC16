package fr.btsciel;

public class CRC16 {


    public static int stdPoly = 0xA001;
    public static int initialValue = 0xffff;

    public static void main(String[] args) {
        String tramHex ="0103";
        byte[] octets = hexStringEnByteArray(tramHex);

        int crcValue =calculCrc16(octets,initialValue,stdPoly);

        System.out.println("Le CRC16 de la trame   "+ tramHex+ " est: "+Integer.toHexString(crcValue).toUpperCase());





    }
     static int calculCrc16(byte[]octects, int valeurInitiale, int polynome){
         int crc = valeurInitiale;
         for (byte octet : octects) {
             crc ^= (octet & 0xFF);
             for (int i = 0; i < 8; i++) {
                 if ((crc & 0x0001) != 0) {
                     crc = (crc >> 1) ^ polynome;
                 } else {
                     crc >>= 1;
                 }
             }
         }
         return crc;
     }



    static byte[] hexStringEnByteArray (String message){
        int size = message.length();
        byte[] data = new byte[size/2];
        for (int i = 0; i < size; i+=2) {
            data [i/2]=(byte) ((Character.digit(message.charAt(i),16)<<4)+
                    Character.digit(message.charAt(i+1),16));

        }
        return data;
    }

}