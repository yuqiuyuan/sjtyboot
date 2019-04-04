package bas;

import java.io.*;

public class FileUtils {
    public static String toString(File file) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
    public static String toString(InputStream is){
        InputStreamReader isr = new InputStreamReader(is);
        return isr.toString();
    }

    public static String byteToString(byte[] bytes) {
        return null;
    }
}
