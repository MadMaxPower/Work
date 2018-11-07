import java.io.*;
import java.util.ArrayList;

public class Text {

    public static void main(String[] args) throws IOException {
        Text obj = new Text();
        String res = obj.selectCases("C:\\IdeaProjects\\HomeWork\\src\\main\\java\\file.txt",2);
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
        ArrayList<String> list = new ArrayList<>();
        File file = new File(path);
        File file1 = new File(pathToResultFile);
        File file3 = new File(path);
        FileWriter writer = new FileWriter(file1);
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
            file.delete();
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

        FileWriter writer3 = new FileWriter(file3);
        for (int i=0;i< list.size();i++)
        {
            line2 += list.get(i) + '\n';
        }
        writer3.write(line2);
        writer3.close();
        return file1.getPath();
    }
}
