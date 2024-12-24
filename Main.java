import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Define matrix size
        int rows = 4, cols = 4;
        char[][] matrix = generateMatrix(rows, cols);
        printMatrix(matrix, "Initial Matrix:");

        // Perform addition on the matrix
        char[][] resultMatrix = performAddition(matrix);
        printMatrix(resultMatrix, "After Addition on Matrix:");

        // Calculate the sum of the smallest elements in each row
        double result = calculateSumOfSmallestRowElements(resultMatrix);
        System.out.println(
            "Sum of the smallest elements in each row: " + result
        );
    }

    /**
     * Generates a matrix of random characters (A-Z).
     *
     * @param rows Number of rows in the matrix.
     * @param cols Number of columns in the matrix.
     * @return A 2D array of characters.
     */
    private static char[][] generateMatrix(int rows, int cols) {
        Random random = new Random();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (char) (random.nextInt(26) + 'A'); // Generate random letters
            }
        }
        return matrix;
    }

    /**
     * Prints the matrix with a given message.
     *
     * @param matrix  The matrix to be printed.
     * @param message A message to display before printing the matrix.
     */
    private static void printMatrix(char[][] matrix, String message) {
        System.out.println(message);
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Performs addition on the matrix by incrementing each character by 1.
     *
     * @param matrix The input matrix.
     * @return A new matrix after the addition operation.
     */
    private static char[][] performAddition(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        char[][] resultMatrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = (char) ('A' +
                    ((matrix[i][j] - 'A' + 1) % 26));
            }
        }
        return resultMatrix;
    }

    /**
     * Calculates the sum of the smallest elements in each row of the matrix.
     *
     * @param matrix The input matrix.
     * @return The sum of the smallest elements in each row.
     */
    private static double calculateSumOfSmallestRowElements(char[][] matrix) {
        int rows = matrix.length;
        double result = 0;

        for (int i = 0; i < rows; i++) {
            char min = Character.MAX_VALUE;
            for (char value : matrix[i]) {
                if (value < min) {
                    min = value;
                }
            }
            result += min;
        }
        return result;
    }
}
