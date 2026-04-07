package AutomationExercise.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {

    private FilesUtils(){
        super();
    };

    public static File getLatestFile(String folderPath){
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files == null || files.length==0){
            LogsUtil.warn("No files found in the directory: " + folderPath);
            return null;
        }
        File latestFile = files[0];
        for (File file : files){
            if (file.lastModified() > latestFile.lastModified()){
                latestFile = file;
            }
        }
        return latestFile;
    }

    public static void deleteFiles(File dirpath) {
        if (dirpath == null || !dirpath.exists()) {
            LogsUtil.warn("Directory doesnot exist: " + dirpath);
            return;
        }

        File[] filesList = dirpath.listFiles();
            if (filesList == null){
                LogsUtil.warn("Failed to list files in: " + dirpath);
                return;
            }

            for (File file : filesList){
                if (file.isDirectory()){
                    deleteFiles(file);
                }else {
                    try {
                        Files.delete(file.toPath());
                    }catch (IOException e){
                        LogsUtil.error("Failed to delete file" + file);
                    }
                }
            }
        }
    }

