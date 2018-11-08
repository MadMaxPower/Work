import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifOfArray
{
    public static void main(String [] args)
    {
        DifOfArray difOfArray = new DifOfArray();
        difOfArray.compareTwoArraysWithCollections();
        difOfArray.compareTwoArraysWithoutCollections();
    }

    public void compareTwoArraysWithCollections()
    {
        ArrayList arr1 = new ArrayList<>();
        arr1.add(2);
        arr1.add("Dima");
        arr1.add("Maxim");
        arr1.add("Kate");
        arr1.add("Galina");
        arr1.add('l');
        arr1.add(2.5);

        ArrayList arr2 = new ArrayList<>();
        arr2.add("Dima");
        arr2.add("Ivan");
        arr2.add("Kate");
        arr2.add("Maxim");
        arr2.add(2);

        ArrayList resArr = new ArrayList<>();
        arr1.removeAll(arr2);
        //System.out.println(arr1);
        System.out.println("Полученный массив с использованием коллекций: " + arr1);
    }

    public void compareTwoArraysWithoutCollections()
    {
        String [] arr1 = new String[] {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String [] arr2 = new String[] {"Dima", "Ivan", "Kate"};
        String [] resArr;
        String resString = "";
        for (int i=0; i < arr1.length; i++)
        {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++)
            {
                if (arr1[i].equals(arr2[j]))
                {
                    flag = true;
                }
            }
            if (!flag)
            {
                resString += arr1[i] + " ";
            }
        }

        resString = resString.substring(0,resString.length() - 1);
        resArr = resString.split(" ");
        System.out.println("Полученный массив без использования коллекций: " + Arrays.asList(resArr));
    }
}
