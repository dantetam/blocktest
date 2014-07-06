package helper;

public class Player {

	public float posX, posY, posZ;
	public float tarX, tarY, tarZ;
	public float aRotY; //angle of rotation on the y axis
	public float aRotX;
	public float sight;
	
	public int hunger, thirst, health;
	
	public Player()
	{
		sight = 1500;
		posX = 0; posY = 0; posZ = 0;
		aRotY = 0; aRotX = 0;
		hunger = 100;
		thirst = 100;
		health = 100;
	}
	
	public void calcTarByAngle()
	{
		tarX = posX + sight*(float)Math.cos(aRotY);
		tarY = posY + sight*(float)Math.sin(aRotX);
		tarZ = posZ + sight*(float)Math.sin(aRotY) - (float)(sight*Math.sin(aRotX)*Math.cos(Math.PI/2-aRotX/2));
	}
	
	public float lastX = 800, lastY = 400; //set up special case for default value
	public void updateMouse(float x, float y)
	{
		float difX = x - lastX;
		float difY = y - lastY; //do nothing for now
		lastX = x;
		lastY = y;
		aRotY -= difX/70;
		aRotX -= difY/70;
	}
	
	public void handleInput(boolean w)
	{
		if (w) 
		{
			posX += 75*(float)Math.cos(aRotY);
			posY += 75*(float)Math.sin(aRotX);
			posZ += 75*(float)Math.sin(aRotY);

		}
	}
	
}
