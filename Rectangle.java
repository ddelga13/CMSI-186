public class Rectangle {

  public Rectangle (Point topLeftCorner, Point bottomRightCorner){
  	this.topLeftCorner = topLeftCorner;//top left (ymax,xmin)
  	this.bottomRightCorner = bottomRightCorner;//bottom right (ymin,xmax)
   
   }

  public double getTopLeftCorner(){
  	return this.topLeftCorner;
  }

  public double getBottomRightCorner(){
  	return this.bottomRightCorner;
  }

  public double getArea(){
    return ((this.bottomRightCorner.getX() - this.topLeftCorner.getX()) * (this.topLeftCorner.getY() - this.bottomRightCorner.getY()));
  }



}
