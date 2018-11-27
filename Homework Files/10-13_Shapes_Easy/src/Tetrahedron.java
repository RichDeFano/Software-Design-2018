/***
 * Class Tetrahedron implements all 3D methods, specific to formulas for tetrahedrons.
 */
public class Tetrahedron implements threeDimensionalShape {
    /***
     * Double variable sideLength controls the sideLength of the tetrahedron.
     */
    private final double sideLength;

    /***
     * Constructor Tetrahedron sets the side length at object creation.
     * @param r is the sideLength.
     */
    public Tetrahedron(double r){
        sideLength = r;
    }

    /***
     * Overrided method getArea returns the area of the sphere
     * @return surface area
     */
    @Override
    public double getArea(){
        double area = (Math.sqrt(3))*(sideLength)*(sideLength);
        return area;
    }

    /***
     * Overrided method getVolume returns the volume of the sphere.
     * @return volume.
     */
    @Override
    public double getVolume(){
        double volume = ((sideLength)*(sideLength)*(sideLength))/((6)*(Math.sqrt(2)));
        return volume;
    }

    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Three Dimensional.");
        System.out.println("Type: Tetrahedron");
        System.out.println("Side Length = " + sideLength);
        System.out.println("Surface Area = " + getArea());
        System.out.println("Volume = " + getVolume());
    }
}