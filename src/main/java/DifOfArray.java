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
        List<String> arr1 = new ArrayList<String>();
        arr1.add("Alex");
        arr1.add("Dima");
        arr1.add("Kate");
        arr1.add("Galina");
        arr1.add("Ivan");

        List<String> arr2 = new ArrayList<String>();
        arr2.add("Dima");
        arr2.add("Ivan");
        arr2.add("Kate");

        ArrayList<String> resArr = new ArrayList<String>();
        resArr.addAll(0,arr1);

        int sizeOfArray1 = arr1.size();
        int sizeOfArray2 = arr2.size();
        for (int i=0; i < sizeOfArray1; i++)
        {
            for (int j = 0; j < sizeOfArray2; j++)
            {
                if (arr1.get(i).equals(arr2.get(j)))
                {
                    resArr.remove(arr1.get(i));
                }
            }
        }

        System.out.println("Полученный массив с использованием коллекций: " + resArr);
    }

    public void compareTwoArraysWithoutCollections()
    {
        String [] arr1 = new String[] {"Alex", "Dima", "Kate", "Galina", "Ivan"};
        String [] arr2 = new String[] {"Dima", "Ivan", "Kate"};
        String [] resArr = new String[]{};
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
