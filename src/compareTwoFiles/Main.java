package compareTwoFiles;

import java.io.*;
import java.util.zip.CRC32;

/**
 * @author yevgen
 */
public class Main {
//public static final Logger log = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        String workPath = "/home/yevgen/IdeaProjects/Fake/src/compareTwoFiles/resources/";
        String homePath = "C:\\Users\\yevge_000\\IdeaProjects\\Fake\\src\\compareTwoFiles\\resources\\";
//        File firstFile = new File(workPath+"firstFile.bmp");
//        File secondFile = new File(workPath+"secondFile.bmp");
//        File thirdFile = new File(workPath+"file.bmp");
//        File wrongFile = new File(workPath+"wrongFile.bmp");
        File firstFile = new File(homePath+"firstFile.bmp");
        File secondFile = new File(homePath+"secondFile.bmp");
        File thirdFile = new File(homePath+"file.bmp");
        File wrongFile = new File(homePath+"wrongFile.bmp");

        System.out.println(compareFileSize(firstFile, secondFile));
        System.out.println(compareFileSize(firstFile, thirdFile));
        System.out.println(compareFileSize(firstFile, wrongFile));

//        System.out.println(firstFile.hashCode() == secondFile.hashCode());

        byte[] firstFileBytesArray = new byte[(int)firstFile.length()];
        byte[] secondFileBytesArray = new byte[(int)secondFile.length()];
        byte[] thirdFileBytesArray = new byte[(int)thirdFile.length()];
        byte[] wrongFileBytesArray = new byte[(int)wrongFile.length()];
        try {
            firstFileBytesArray = getBytesFromFile(firstFile);
            secondFileBytesArray = getBytesFromFile(secondFile);
            thirdFileBytesArray = getBytesFromFile(thirdFile);
            wrongFileBytesArray = getBytesFromFile(wrongFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(firstFileBytesArray.length);
        System.out.println(secondFileBytesArray.length);
        System.out.println(thirdFileBytesArray.length);
        System.out.println(wrongFileBytesArray.length);
        System.out.println("Result => " + compareBytesArray(firstFileBytesArray, secondFileBytesArray));
        System.out.println("Result => " + compareBytesArray(firstFileBytesArray, thirdFileBytesArray));
        System.out.println("Result => " + compareBytesArray(firstFileBytesArray, wrongFileBytesArray));

//        try {
//            RandomAccessFile fileAccessor = new RandomAccessFile(firstFile, "r");
//            int resultRead = fileAccessor.read();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException i){
//            i.printStackTrace();
//        }

        //        CRC32 crc1 = new CRC32();
//        CRC32 crc2 = new CRC32();
//        crc1.update(a1);
//        crc2.update(a2);
//        if (crc1.getValue() != crc2.getValue()){
//            System.out.println("CRC Failed");
//        }
    }

//    public static String md5Apache(String st) {
//        String md5Hex = DigestUtils.md5Hex(st);
//
//        return md5Hex;
//    }



    public static boolean compareFileSize(final File first, final File second){
        boolean result = false;
        if (first.length() == second.length()) result = true;
        return result;
    }

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            return null;
        }

        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    public static boolean compareBytesArray(final byte[] first, final byte[] second){
        boolean result = true;
        if (first.length != second.length) return false;
        for (int index = 0; index<first.length; index++) {
            if (first[index]!=second[index]){
                return false;
            }
        }
        return result;
    }


}
