/***
 * Class Sphere implements methods for all 3D shapes, with formulas specific to Spheres.
 */
public class Sphere implements threeDimensionalShape {
    /***
     * Double variable radius is the radius of the sphere.
     */
    private final double radius;

    /***
     * Constructor Sphere sets the objects radius at creation.
     * @param r is the radius.
     */
    public Sphere(double r){
        radius = r;
    }

    /***
     * Overrided method getArea returns the area of the sphere
     * @return surface area
     */
    @Override
    public double getArea(){
        double area = (4)*(3.1415)*(radius)*(radius);
        return area;
    }

    /***
     * Overrided method getVolume returns the volume of the sphere.
     * @return volume.
     */
    @Override
    public double getVolume(){
        double volume = (1.3333)*(3.1415)*(radius)*(radius)*(radius);
        return volume;
    }

    /***
     * Overrided method printInformation prints all information about the shape to the console.
     */
    @Override
    public void printInformation(){
        System.out.println("---------------------------");
        System.out.println("Dimension: Three Dimensional.");
        System.out.println("Type: Sphere");
        System.out.println("Radius = " + radius);
        System.out.println("Surface Area = " + getArea());
        System.out.println("Volume = " + getVolume());
    }
}
