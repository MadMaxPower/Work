import java.io.*;
import java.util.ArrayList;

public class Text {

    public static void main(String[] args) throws IOException {
        Text obj = new Text();
        String res = obj.selectCases("C:\\IdeaProjects\\HomeWork\\src\\main\\java\\file.txt",9);
        System.out.println(res);
    }

    public String selectCases(String path, int countOfLines) throws IOException {
        String line = " ";
        String line2 = "";
        String header = " ";
        String pathtofile = path.substring(0,path.lastIndexOf("\\"));
        String filename = path.substring(path.lastIndexOf("\\")+1);
        String extension = filename.substring(filename.lastIndexOf("."),filename.length());
        filename = filename.substring(0, filename.lastIndexOf('.'));
        String pathToResultFile = pathtofile + "\\" + filename + "_res" + extension;
        String pathToResultFile2 = pathtofile + "\\" + filename + "2" + extension;
        ArrayList<String> list = new ArrayList<>();
        File file = new File(path);
        File file1 = new File(pathToResultFile);
        File file2 = new File(pathToResultFile2);
        FileWriter writer = new FileWriter(file1);
        FileWriter writer2 = new FileWriter(file2);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            header = line;
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0;i<countOfLines;i++)
        {
            line += list.get(1) + '\n';
            list.remove(1);
        }

        line = line.replace("null",header + '\n');
        writer.write(line);
        writer.flush();
        writer.close();

        for (int i=0;i< list.size();i++)
        {
            line2 += list.get(i) + '\n';
        }
        writer2.write(line2);
        writer2.close();
        return file1.getPath();
    }
}
