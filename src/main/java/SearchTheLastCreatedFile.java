import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SearchTheLastCreatedFile
{
    public static void main(String[] args)
    {
        SearchTheLastCreatedFile obj = new SearchTheLastCreatedFile();
        obj.searchTheLastFile("C:\\cygwin","txt");
    }
    public void searchTheLastFile(String path, String extension)
    {
        File file = new File(path);
        File[] matchingFiles = file.listFiles(new FilenameFilter() {
            public boolean accept(File path, String name) {
                return name.endsWith(extension);
            }
        });
        boolean flag = false;
        long min = 0;
        ArrayList<Long> times = new ArrayList<>();
        Map<String, Long> names = new HashMap<>();
        for (int i=0;i < matchingFiles.length;i++)
        {
            String path1 = matchingFiles[i].getPath();
            path1 =  path1.replace("\\", "\\\\");
            Path tempPath = Paths.get(path1);
            BasicFileAttributes attr;
            try {
                attr = Files.readAttributes(tempPath, BasicFileAttributes.class);
                long seconds = attr.creationTime().to(TimeUnit.SECONDS);
                times.add(seconds);
                if (!flag)
                {
                    flag = true;
                    min = times.get(0);
                }
                if(min <= seconds)
                {
                    String filename = matchingFiles[i].toString();
                    int sep = filename.lastIndexOf('\\');
                    filename = filename.substring(sep+1);
                    names.put(filename,seconds);
                    min = seconds;
                }
            } catch (IOException e) {
                System.out.println("Ошибка!" + e.getMessage());
            }

        }

        for (Map.Entry entry : names.entrySet())
        {
            String temp = entry.getValue().toString();
            long l = Long.parseLong(temp);
            if( (min-l) < 10)
            {
                System.out.println("Имя файла: " + entry.getKey());
            }
            else
            {
                continue;
            }
        }
    }
}
