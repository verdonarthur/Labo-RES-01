package ch.heigvd.res.io.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by verdo on 02.03.2016.
 */
public class StatsCSV {
    String FILENAME = "stats.csv";

    File f;
    FileWriter fw;

    public StatsCSV() {
        f = new File(FILENAME);

        try {
            fw = new FileWriter(f);
            fw.append("operation,strategy,blockSize,fileSizeInBytes,durationInMs");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addData(String operation, String strategy, int blockSize, int fileSizeIntBytes, int DurationInMs) {
        try {
            fw.append(operation+","+strategy+","+blockSize+","+fileSizeIntBytes+","+DurationInMs+"\n");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void close(){
        try {
            fw.flush();
            fw.close();
        }catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
