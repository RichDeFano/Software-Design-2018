/***
 * Class Cube implements methods from all 3D shapes, with formulas specific to cubes.
 */
public class Cube implements threeDimensionalShape {
    /***
     * Double variable sideLength controls the cubes side length.
     */
    private final double sideLength;

    /***
     * Constructor Cube sets the side length at object creation.
     * @param r is the sideLength.
     */
    public Cube(double r){
        sideLength = r;
    }

    /***
     * Overrided method getArea returns the surface area of the cube.
     * @return surface area
     */
    @Override
    public double getArea(){
        double area = (6)*(sideLength)*(sideLength);
        return area;
    }

    /***
     * Overrided method getVolume returns the volume of the cube.
     * @return volume
     */
    @Override
    public double getVolume(){
        double volume = (sideLength)*(sideLength)*(sideLength);
        return volume;
    }

    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Three Dimensional.");
        System.out.println("Type: Cube");
        System.out.println("Side Length = " + sideLength);
        System.out.println("Surface Area = " + getArea());
        System.out.println("Volume = " + getVolume());
    }
}
