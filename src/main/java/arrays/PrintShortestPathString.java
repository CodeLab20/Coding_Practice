package arrays;

/**
 * Print shortest path to print a string on screen
 * Given a screen containing alphabets from A-Z, we can go from one character to another characters using a remote.
 * The remote contains left, right, top and bottom keys.
 *
 * Find shortest possible path to type all characters of given string using the remote.
 * Initial position is top left and all characters of input string should be printed in order.
 *
 * Screen:
 *
 * A B C D E
 * F G H I J
 * K L M N O
 * P Q R S T
 * U V W X Y
 * Z
 * Example:
 *
 * Input: “GEEK”
 * Output:
 * Move Down
 * Move Right
 * Press OK
 * Move Up
 * Move Right
 * Move Right
 * Move Right
 * Press OK
 * Press OK
 * Move Left
 * Move Left
 * Move Left
 * Move Left
 * Move Down
 * Move Down
 * Press OK

 * The idea is to consider screen as 2D-matrix of characters.
 * Then we consider all characters of given string one by one and print out the shortest path
 * between current character and next character in the matrix. In order to find shortest path,
 * we consider the coordinates of current character and next character in the matrix.
 * Based on the difference between x and y values of current and next character’s coordinates,
 * we move left, right, top or bottom. i.e.
 *
 * If row difference is negative, we move up
 * If row difference is positive, we move down
 * If column difference is negative, we go left
 * If column difference is positive, we go right
 */

public class PrintShortestPathString {
    // Function to print shortest possible path to
    // type all characters of given string using a remote
    static String arr[][] = new String[][]
            {
                {"A", "B", "C", "D", "E"},
                {"F", "G", "H", "I", "J"},
                {"K", "L", "M", "N", "O"},
                {"P", "Q", "R", "S", "T"},
                {"U", "V", "W", "X", "Y"},
                {"Z"}
            };

    static void printPath(String str)
    {
        int i = 0;
        // start from character 'A' present at position (0, 0)
        int curX = 0, curY = 0;
        while (i < str.length())
        {
            // find cordinates of next character
            int nextX = (str.charAt(i) - 'A') / 5;
            int nextY = (str.charAt(i) - 'A' ) % 5;

            // Move Up if destination is above
            while (curX > nextX)
            {
                System.out.println("Move Up");
                curX--;
            }

            // Move Left if destination is to the left
            while (curY > nextY)
            {
                System.out.println("Move Left");
                curY--;
            }

            // Move down if destination is below
            while (curX < nextX)
            {
                System.out.println("Move Down");
                curX++;
            }

            // Move Right if destination is to the right
            while (curY < nextY)
            {
                System.out.println("Move Right");
                curY++;
            }

            // At this point, destination is reached
            System.out.println("Press OK. " + arr[curX][curY] );
            i++;
        }
    }

    public static void main(String[] args) {
        String str = "COZY";
        printPath(str);
    }
}
