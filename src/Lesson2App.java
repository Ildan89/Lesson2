import exception.MyArrayDataException;
import exception.MyArraySizeException;
import java.util.Arrays;

public class Lesson2App {
    public static final int ROWS_NUM = 4;
    public static final int COLUMNS_NUM = 4;

    public static void main(String[] args) {
        String[][] strArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            System.out.println("сумма элементов массива: " + sumArrayElements(strArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Не удалось вычислить сумму: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int sumArrayElements (String[][] array) throws MyArraySizeException, MyArrayDataException {
        if(isSizeOk(array)) {
            return mathSum(array);
        } else {
            throw new MyArraySizeException(String.format("Размер массива не равен %s x %s", ROWS_NUM, COLUMNS_NUM));
        }
    }

    private static int mathSum(String[][] array) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format(
                            "Данные в ячейке [%s][%s] не могут быть преобразованы в int: \"%s\"", i, j, array[i][j]));
                }
            }
        }
        return sum;
    }

    private static boolean isSizeOk(String[][] array){
        if(array.length == ROWS_NUM) {
            //строки могут иметь разную длину, проверим, что размерность всех строк одинакова
            for (int i = 0; i < ROWS_NUM; i++) {
                if(array[i].length != COLUMNS_NUM) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
