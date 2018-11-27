/***
 * Class Circle is implementing methods for all 2D shapes and inputting the correct circle formulas.
 */
public class Circle implements twoDimensionalShape {
    /***
     * Double variable radius controls the radius of the circle.
     */
    private final double radius;

    /***
     * Constructor Circle sets the radius of the circle at object creation.
     * @param r is the inputted radius.
     */
    public Circle(double r){
        radius = r;
    }

    /***
     * Overrided method getArea returns the area calculated with the objects radius.
     * @return the area.
     */
    @Override
    public double getArea(){
        double area = (3.1415)*(radius)*(radius);
        return area;
    }

    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Two Dimensional.");
        System.out.println("Type: Circle");
        System.out.println("Radius = " + radius);
        System.out.println("Area = " + getArea());
    }
}
