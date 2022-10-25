import graphics.Graphics;

/** Demonstrates the Café Wall Illusion
 *
 * @author Jerry Won
 * @Period - Per 2
 * @Date - 10-24-2022
 *
 */
public class CafeArt {

    public static final int MORTAR = 5; //space between each row in a grid

    public static void main(String[] args) {
        Graphics.cafeWall.open();

        int drawnArea = 0;

        drawnArea += printGrid(50, 50, 40, 1, 8, 10);

        System.out.println(drawnArea);
        Graphics.cafeWall.pause();
        Graphics.cafeWall.close();

    }

    /** prints two squares side by side (a dark followed a light square)
     *
     * @param x - x coordinate of the top left
     * @param y - y coordinate of the top left
     * @param size - size in pixels
     * @return - The total area
     */
    public static int printTwoSquares(int x, int y, int size) {
        Graphics.cafeWall.drawDarkSquare(x, y, size);
        Graphics.cafeWall.drawBrightSquare(x + size, y, size);
        return 2 * size * size;
    }

    /** prints a row of squares pairs(calls the printTwoSquares for each pair)
     *
     * @param x- x coordinate of the top left
     * @param y - y coordinate of the top left
     * @param size - size in pixels
     * @param numPairs - The number of pairs to print
     * @return The area printed for the entire row
     */
    public static int printRow(int x, int y, int size, int numPairs) {
        int area = 0;

        for (int i = 0; i < numPairs; i++) {
            area += printTwoSquares(x + size * i * 2, y, size);
        }

        return area;
    }

    /** prints a grid of squares (using printRow)
     *
     * @param x - x coordinate of the top left
     * @param y - y coordinate of the top left
     * @param size - size in pixels
     * @param numPairs - The number of pairs to print
     * @param numRows - THe number of rows to print
     * @param offSet - The offset for alternating rows
     * @return - Area printed by the grid
     */
    public static int printGrid(int x, int y, int size, int numPairs, int numRows, int offSet ) {
        int area = 0;
        int currentY = y;

        for (int i = 0; i < numRows/2; i++) {
            area += printRow(x, currentY, size, numPairs);
            currentY += MORTAR + size;
            area += printRow(x + offSet, currentY, size, numPairs);
            currentY += MORTAR + size;
        }
        return area;
    }

}
