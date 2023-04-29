package files;

import java.io.*;

public class FileWorker{

    public void writeFile(String fileName, String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))) {
            writer.write(text);
        } catch (Exception ex) {
            throw new IOException("File was not written!");
        }
    }
    public String readFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null){
                result.append(line);
            }
            return result.toString();
        } catch (Exception ex) {
            throw new IOException("File was not read!");
        }
    }
}
