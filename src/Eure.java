

import processing.core.*;
import helper.Player;

import java.awt.Robot;
import java.awt.event.*;
import java.util.ArrayList;

public class Eure extends PApplet {

	public Player e; //e for eure
	public static int width = 1200;
	public static int height = 800;
	public ArrayList<Entity> occupants = new ArrayList<Entity>();
	
	public Eure()
	{
		e = new Player();
	}

	public void setup()
	{
		size(width,height,P3D);
		//ortho();
		frameRate(30);
		noCursor();
		Data.setupColors();
		/*addMouseWheelListener(new MouseWheelListener() { 
			public void mouseWheelMoved(MouseWheelEvent mwe) { 
				mouseWheel(mwe.getWheelRotation());
			}
		});*/
		//smooth(2);
		showModel("someisland.txt",0,0,0);
	}
	
	public void draw()
	{
		//lights();
		background(255);
		camera(e.posX,e.posY,e.posZ,e.tarX,e.tarY,e.tarZ,0,-1,0);
		perspective((float)3.14/2, 2F, 1, 10000);
		//perspective();
		e.updateMouse(mouseX,mouseY);
		e.handleInput(wPressed);
		e.calcTarByAngle();
		/*pushMatrix();
		translate(e.tarX,e.tarY,e.tarZ);
		box(5,5,5);
		popMatrix();*/
		//lights();
		//ambient(0,0,0);
		//System.out.println("Position: " + e.posX + "," + e.posY  + "," + e.posZ);
		
		for (int i = 0; i < occupants.size(); i++)
		{
			Entity data = occupants.get(i);
			
			pushMatrix();
			translate(data.posX,data.posY,data.posZ);
			
			rotateX(data.rotX);
			rotateY(data.rotY);
			rotateZ(data.rotZ);
			fill(data.colorR, data.colorG, data.colorB);
			box(data.sizeX, data.sizeY, data.sizeZ); 
			popMatrix();
		}
		
	}
	
	public void showModel(String fileName, double x, double y, double z)
	{	
		String[] temp = loadStrings("/models/" + fileName);

		for (int i = 2; i < temp.length; i++) //first two indices are not part of data
		{
			if (!temp[i].startsWith("//"))
			{
				String[] stringData = split(temp[i],',');
				float[] data = new float[stringData.length];
				for (int j = 0; j < data.length; j++) 
				{
					data[j] = Float.parseFloat(stringData[j]);
				}

				Entity en = new Entity();

				en.posX = data[0];
				en.posY = data[1];
				en.posZ = data[2];
				
				en.rotX = data[3];
				en.rotY = data[4];
				en.rotZ = data[5];
				
				Color color = Data.brickColorMap.get((int)data[9]);
				en.colorR = (float)color.r;
				en.colorG = (float)color.g;
				en.colorB = (float)color.b;

				en.sizeX = data[6];
				en.sizeY = data[7];
				en.sizeZ = data[8];
			
				occupants.add(en);
			}
		}
	}
	
	public boolean wPressed = false;
	public void keyPressed()
	{
		if (key == 'w')
		{
			wPressed = true;
		}
	}
	
	public void keyReleased()
	{
		if (key == 'w')
		{
			wPressed = false;
		}
	}

}
