import graphics.Graphics;

/** Demonstrates the Café Wall Illusion
 *
 * @author Jerry Won
 * @Period - Per 2
 * @Date - 10-24-2022
 *
 */
public class CafeArt {

    public static final int MORTAR = 2; //space between each row in a grid

    public static void main(String[] args) {
        Graphics.cafeWall.open();

        int drawnArea = 0;

        drawnArea += printRow(0, 0, 20, 4); //upper left
        Graphics.cafeWall.pause();
        drawnArea += printRow(50, 70, 30, 5); //mid left
        Graphics.cafeWall.pause();
        drawnArea += printGrid(10, 150, 25, 4, 8, 0); //lower left
        Graphics.cafeWall.pause();
        drawnArea += printGrid(250, 200, 25, 3, 6, 10); //lower middle
        Graphics.cafeWall.pause();
        drawnArea += printGrid(425, 180, 20, 5, 10, 10); //lower right
        Graphics.cafeWall.pause();
        drawnArea += printGrid(400, 20, 35, 2, 4, 35); //upper right
        Graphics.cafeWall.pause();

        System.out.println(Math.round(drawnArea/wallArea() * 10000) / 100.0 + "% covered");
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

    public static double wallArea() {
        return (double) Graphics.cafeWall.getWidth() * Graphics.cafeWall.getHeight();
    }

}
