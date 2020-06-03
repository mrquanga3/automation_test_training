package java;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
public class Tinhtong {
	static float sum(float a, float b) {;
	return  a+b;
	}
@Test
public void Testsum () {
	float result = java.Tinhtong.sum(3.5f, 4.8f);
	assertTrue(result == 8.3f);

}
}