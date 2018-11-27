/***
 * Class triangle implements methods from 2D shapes, specific to triangles.
 */
public class Triangle implements twoDimensionalShape {
    /***
     * Double variable base controls the triangles base size.
     */
    private final double base;
    /***
     * Double variable height controls the triangles height.
     */
    private final double height;


    /***
     * Constructor Triangle sets the base and height sizes at object creation.
     * @param l1 user inputted base.
     * @param l2 user inputted height.
     */
    public Triangle(double l1, double l2){
        base = l1;
        height = l2;
    }

    /***
     * Overrided method getArea returns the calculated area.
     * @return area.
     */
    @Override
    public double getArea(){
        double area = (0.5)*(base)*(height);
        return area;
    }


    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Two Dimensional.");
        System.out.println("Type: Triangle");
        System.out.println("Base = " + base);
        System.out.println("Height = " + height);
        System.out.println("Area = " + getArea());
    }
}
