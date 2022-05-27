package ToyRobotChallenge;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Unit test for Direction enum functions
 * @author Mark
 *
 */
public class DirectionTest {

	@Test
	public void testParse() {
		assertEquals(Direction.NORTH, Direction.parseString("NORTH"));
		assertEquals(Direction.EAST, Direction.parseString("EAST"));
		assertEquals(Direction.WEST, Direction.parseString("WEST"));
		assertEquals(Direction.SOUTH, Direction.parseString("SOUTH"));
		
		//Test the case the user tries to input a invalid direction as a string
		try {
			Direction.parseString("afgbrfd");
			fail();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertEquals("Invalid input...", e.getMessage());
		}
	}
	
	@Test
	public void testFaceLeft() {
		assertEquals(Direction.WEST, Direction.faceLeft(Direction.NORTH));
		assertEquals(Direction.NORTH, Direction.faceLeft(Direction.EAST));
		assertEquals(Direction.EAST, Direction.faceLeft(Direction.SOUTH));
		assertEquals(Direction.SOUTH, Direction.faceLeft(Direction.WEST));
	}
	
	@Test
	public void testFaceRight() {
		assertEquals(Direction.EAST, Direction.faceRight(Direction.NORTH));
		assertEquals(Direction.SOUTH, Direction.faceRight(Direction.EAST));
		assertEquals(Direction.WEST, Direction.faceRight(Direction.SOUTH));
		assertEquals(Direction.NORTH, Direction.faceRight(Direction.WEST));
	}

}
