/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;



public class Circle implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Circle c = new Circle();
	      //creating frame
	      glcanvas.addGLEventListener(c);
	      glcanvas.setSize(600, 600);
	      
	      final JFrame frame = new JFrame ("Circle");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
        @Override
   public void display(GLAutoDrawable drawable) {
	   final GL2 gl = drawable.getGL().getGL2();
	   try{
      	  File f = new File("circle.txt");
      	  Scanner sc = new Scanner(f);
     	  while (sc.hasNextLine()){
     		  gl.glBegin (GL2.GL_POINTS);//static field
     		  StringTokenizer str = new StringTokenizer(sc.nextLine());
     		  
     		  double  r = Double.parseDouble(str.nextToken());
     		  double  x_cen = Double.parseDouble(str.nextToken());
     		  double  y_cen = Double.parseDouble(str.nextToken());
     		  double x = 0.0;
     		  double y = r/100;
     		  //System.out.println("just before drawing");
     		  draw8way(gl,x,y,x_cen,y_cen);
     		 //System.out.println("just after drawing");
     		  double d = (5/4)-r;
     		  while (x<y){
     			  if (d<0){//de
     				  d+=(2*x*1000+3);
     				  x=x+0.001;
     			  }
     			  else {//dse
     				  d+=(2*x*1000-2*y*1000+5);
     				  x=x+0.001;
     				  y=y-0.001;
     			  }
     			  draw8way(gl,x,y,x_cen,y_cen);
     		  }
     		  	 	
     	  }
          gl.glEnd();
          }
          
          catch(Exception e){
              System.out.println(e);
               }
	   
   }
   private  void draw8way(GL2 gl, double x, double y, double x_cen, double y_cen){
		  //gl.glBegin(GL2.GL_POINTS);
	   //System.out.println("actual drawing");  
	   	gl.glVertex2d(x+x_cen,y+y_cen);
	    //System.out.println("nxt1 drawing");
		  gl.glVertex2d(y+x_cen,x+y_cen);
		  //System.out.println("nxt 2 drawing");
		  gl.glVertex2d(-y+x_cen,x+y_cen);
		  gl.glVertex2d(-x+x_cen,y+y_cen);
		  gl.glVertex2d(-x+x_cen,-y+y_cen);
		  gl.glVertex2d(-y+x_cen,-x+y_cen);
		  gl.glVertex2d(y+x_cen,-x+y_cen);
		  gl.glVertex2d(x+x_cen,-y+y_cen);
		  //System.out.println("afta actual drawing");
		  //gl.glEnd();
		   }
        @Override
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
        @Override
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
        @Override
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of class import javax.media.opengl.GL2;


