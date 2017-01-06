import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Yevgen Goliuk
 */
public class CreateFile {

    public static void main(String[] args) {

        String path = "ParseToRPN";
        File file = new File("src/file.txt").getAbsoluteFile();
        try {
            byte [] data = new byte[1000000];
            for (int i = 0; i < data.length; i++) {
                data[i] = 1;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0L);
            randomAccessFile.write(data);
            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){

        }

        for (int index = 0; index<100; index++) {
            System.out.println((byte) (Math.random()*2));
        }

    }
//public static final Logger log = LogManager.getLogger(CreateFile.class);
}
