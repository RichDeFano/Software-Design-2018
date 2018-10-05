import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

class DataGenerator {
    // fields to hold example data
    /***
     * Variable rand creates a random occurance of whatever is called.
     */
    private Random rand;
    /***
     * Variable names is a list of names to be used in data generation.
     */
    private String[] names;
    /***
     * Variable encryption is a list of encryption types to be used in data generation.
     */
    private String[] encryption;
    /***
     * Variable videoTitles is a list of titles to be used in data generation.
     */
    private String[] videoTitles;
    /***
     * Variable filePaths is a list of file paths to be used in data generation.
     */
    private String[] filePaths;
    /***
     * Variable fileTypes is a list of file types to be used in data generation.
     */
    private String[] fileTypes;
    /***
     * Variable colors is a list of colors to be used in data generation.
     */
    private String[] colors;

    /***
     * Constructor DataGenerator sets all the private variables.
     */
    DataGenerator() {
        // initialize with example data
        this.rand = new Random();
        this.names = new String[]{"Tom", "Guadalupe", "Tina", "Markus", "Michael", "Diego", "Mr. Patel", "Alex"};
        this.encryption = new String[]{"Vigenere", "One Time Pad", "RSA", "Diffie-Hellman"};
        this.videoTitles = new String[]{"Top 10 Cutest Cat Videos", "ONE Simple Trick to Pass SWD", "Java 101", "Pythonistas Pythoning with Pythons", "P == NP?!?!?!"};
        this.filePaths = new String[]{"/Users/abpwrs/puppies", "/Users/tomc/backstroke", "/Users/swd_student/question", "/Users/cie_student/question", "/Users/student/stress"};
        this.fileTypes = new String[]{"txt", "csv", "pptx", "pdf", "hs", "gif", "png", "h5"};
        this.colors = new String[]{"red", "orange", "yellow", "green", "blue", "indigo", "violet", "egg shell"};
    }

    /***
     * Get method for returning a random name.
     * @return a randomly generated name.
     */
    private String getRandName() {
        return this.names[this.rand.nextInt(this.names.length)];
    }

    /***
     * Get method for returning a random color
     * @return a randomly generated color.
     */
    private String getRandColor() {
        return this.colors[this.rand.nextInt(this.colors.length)];
    }

    /***
     * Get method for returning a random video title.
     * @return a randomly generated video title.
     */
    private String getRandVideoTitle() {
        return this.videoTitles[this.rand.nextInt(this.videoTitles.length)];
    }

    /***
     * Get method for returning a random file type.
     * @return a randomly generated file type.
     */
    private String getRandFileType() {
        return this.fileTypes[this.rand.nextInt(this.fileTypes.length)];
    }

    /***
     * Get method for returning a random file path.
     * @return a randomly generated file path.
     */
    private String getRandFilePath() {
        return this.filePaths[this.rand.nextInt(this.filePaths.length)];
    }

    // public data generation tools

    /***
     * Get method for returning a random URL.
     * @return a randomly generated URL.
     */
    public String getRandURL() {
        return "localhost:" + (((this.rand.nextInt(9) + 1) * 1000) + this.rand.nextInt(999));
    }

    /***
     * Get method for returning a random Payment.
     * @return a randomly generated Payment.
     */
    public Payment getRandPayment() {
        return new Payment(this.getRandName(), this.rand.nextInt(10000), this.getRandName());
    }

    /***
     * Get method for returning a random UUID.
     * @return a randomly generated UUID.
     */
    public UUID getRandUUID() {
        return UUID.randomUUID();
    }

    /***
     * Get method for returning a random encryption scheme.
     * @return a randomly generated encryption scheme.
     */
    public String getRandEncryptionScheme() {
        return this.encryption[this.rand.nextInt(this.encryption.length)];
    }

    /***
     * Get method for returning a random Video.
     * @return a randomly generated Video.
     */
    public Video getRandVideo() {
        return new Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
    }

    /***
     * Get method for returning a random File.
     * @return a randomly generated File.
     */
    public File getRandFile() {
        return new File(this.getRandFilePath(), this.getRandFileType());
    }

    /***
     * Get method for formatting and returning a random Form.
     * @return a randomly generated Form.
     */
    public Form getRandForm() {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Favorite color", this.getRandColor());
        fields.put("Favorite encryption scheme", this.getRandEncryptionScheme());
        fields.put("Name", this.getRandName());
        return new Form(fields);
    }

    /***
     * Get method for returning a random IP.
     * @return a randomly generated IP.
     */
    public String getRandIP() {
        return rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256) + "." + rand.nextInt(256);
    }

}