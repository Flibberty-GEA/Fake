import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Yevgen Goliuk
 */
public class CreateFile {

    public static void main(String[] args) {
        File file = new File("/home/yevgen/IdeaProjects/Fake/src/file.txt");
        try {
            byte [] data = new byte[1000000000];
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

    }
//public static final Logger log = LogManager.getLogger(CreateFile.class);
}
