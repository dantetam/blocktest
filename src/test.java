
import processing.core.*;

public class test extends PApplet {

	public void setup()
	{
		size(500,500,P3D);
	}

	public void draw()
	{
		translate(width/2, height/2, 0);
		rotateX(45);
		//rotateY(angle2);
		scale(100);
		beginShape();
		vertex(-1, -1, -1);
		vertex( 1, -1, -1);
		vertex( 0,  0,  1);

		vertex( 1, -1, -1);
		vertex( 1,  1, -1);
		vertex( 0,  0,  1);

		vertex( 1, 1, -1);
		vertex(-1, 1, -1);
		vertex( 0, 0,  1);

		vertex(-1,  1, -1);
		vertex(-1, -1, -1);
		vertex( 0,  0,  1);
		endShape();
	}

}
