public class ShapesMain {

    public static void main(String args[])
    {
        //Create an array holding different shapes.
        Shapes[] shapeArray = new Shapes[6];
        shapeArray[0] = new Circle(3.0);
        shapeArray[1] = new Square(4.0);
        shapeArray[2] = new Triangle(5.0,5.0);
        shapeArray[3] = new Sphere(4.0);
        shapeArray[4] = new Cube(5.0);
        shapeArray[5] = new Tetrahedron(3.0);

        //For all shapes, print out the required information on them.
        for (int i = 0; i < 6; i++)
        {
            Shapes tempShape = shapeArray[i];
            tempShape.printInformation();
        }

    }
}
