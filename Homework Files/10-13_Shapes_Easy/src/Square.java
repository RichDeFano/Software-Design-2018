/***
 * Class Square implements all 2D methods, specific to square formulas.
 */
public class Square implements twoDimensionalShape {
    /***
     * Double variable sideLength controls the squares side length.
     */
    private final double sideLength;

    /***
     * Constructor Square sets the side length at object creation.
     * @param l is the side Length.
     */
    public Square(double l){
        sideLength = l;
    }

    /***
     * Overrided method getArea returns the area of the square,
     * @return area.
     */
    @Override
    public double getArea(){
        double area = (sideLength)*(sideLength);
        return area;
    }

    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Two Dimensional.");
        System.out.println("Type: Square");
        System.out.println("Side Length = " + sideLength);
        System.out.println("Area = " + getArea());
    }
}
