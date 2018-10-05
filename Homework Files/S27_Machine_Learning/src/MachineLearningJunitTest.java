/*

import org.jboss.arquillian.test.spi.annotation.TestScoped;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


class MachineLearningJUnitTest {

    //////////////////////////////////Cosine Similarity Tests 1-5//////////////////////////////////
    @Test
    void cosineSimilarityTest1(){
        List<Integer> listOne = Arrays.asList(1,2,3);
        List<Integer> listTwo = Arrays.asList(2,6,3);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.cosineSimilarity();
        assertTrue(0.878,printTotal);

    }

    @Test
    void cosineSimilarityTest2(){
        List<Integer> listOne = Arrays.asList(1,2,3,4,5);
        List<Integer> listTwo = Arrays.asList(2,6,3,8,4);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.cosineSimilarity();
        assertTrue(0.890,printTotal); //0.8903998199255586

    }

    @Test
    void cosineSimilarityTest3(){
        List<Integer> listOne = Arrays.asList(1,1,1,1);
        List<Integer> listTwo = Arrays.asList(2,2,2,2);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.cosineSimilarity();
        assertTrue(1,printTotal);

    }

    @Test
    void cosineSimilarityTest4(){
        List<Integer> listOne = Arrays.asList(1,2,3,2,1);
        List<Integer> listTwo = Arrays.asList(2,6,3,6,2);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.cosineSimilarity();
        assertTrue(0.900,printTotal);

    }

    @Test
    void cosineSimilarityTest5(){
        List<Integer> listOne = Arrays.asList(9,9,9,9,9);
        List<Integer> listTwo = Arrays.asList(9,9,9,9,9);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.cosineSimilarity();
        assertTrue(1,printTotal);

    }
    //////////////////////////////////Euclidean Distance Tests 1-5//////////////////////////////////
    @Test
    void euclideanDistanceTest1(){
        List<Integer> listOne = Arrays.asList(1,2,3);
        List<Integer> listTwo = Arrays.asList(2,6,3);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.euclideanDistance();
        assertTrue(4.123,printTotal);

    }

    @Test
    void euclideanDistanceTest2(){
        List<Integer> listOne = Arrays.asList(1,2,3,4,5);
        List<Integer> listTwo = Arrays.asList(2,6,3,8,4);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.euclideanDistance();
        assertTrue(5.831,printTotal);

    }

    @Test
    void euclideanDistanceTest3(){
        List<Integer> listOne = Arrays.asList(1,1,1,1);
        List<Integer> listTwo = Arrays.asList(2,2,2,2);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.euclideanDistance();
        assertTrue(2,printTotal);

    }

    @Test
    void euclideanDistanceTest4(){
        List<Integer> listOne = Arrays.asList(1,2,3,2,1);
        List<Integer> listTwo = Arrays.asList(2,6,3,6,2);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.euclideanDistance();
        assertTrue(5.831,printTotal);

    }

    @Test
    void euclideanDistanceTest5(){
        List<Integer> listOne = Arrays.asList(9,9,9,9,9);
        List<Integer> listTwo = Arrays.asList(9,9,9,9,9);
        double printTotal = 0;

        vectorMath vectors = new vectorMath(listOne,listTwo);
        printTotal = vectors.euclideanDistance();
        assertTrue(0,printTotal);

    }
    //////////////////////////////////Hamming Distance Tests 1-5//////////////////////////////////
    @Test
    void hammingDistanceTest1(){
        String binCode1 = "0110101";
        String binCode2 = "1110010";
        double printTotal = 0;

        vectorMath code = new vectorMath(binCode1,binCode2);
        printTotal = code.hammingDistance();
        assertTrue(4,printTotal);

    }

    @Test
    void hammingDistanceTest2(){
        String binCode1 = "0";
        String binCode2 = "1";
        double printTotal = 0;

        vectorMath code = new vectorMath(binCode1,binCode2);
        printTotal = code.hammingDistance();
        assertTrue(1,printTotal);

    }

    @Test
    void hammingDistanceTest3(){
        String binCode1 = "010";
        String binCode2 = "111";
        double printTotal = 0;

        vectorMath code = new vectorMath(binCode1,binCode2);
        printTotal = code.hammingDistance();
        assertTrue(2,printTotal);

    }

    @Test
    void hammingDistanceTest14(){
        String binCode1 = "0110101011011010";
        String binCode2 = "1110010111100110";
        double printTotal = 0;

        vectorMath code = new vectorMath(binCode1,binCode2);
        printTotal = code.hammingDistance();
        assertTrue(10,printTotal);

    }

    @Test
    void hammingDistanceTest5(){
        String binCode1 = "11111111";
        String binCode2 = "00000000";
        double printTotal = 0;

        vectorMath code = new vectorMath(binCode1,binCode2);
        printTotal = code.hammingDistance();
        assertTrue(8,printTotal);

    }


}

*/

