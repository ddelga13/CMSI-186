public class Triangle extends Shape {

  public Triangle (Point corner1, Point corner2, Point corner3){
    this.corner1 = corner1;
    this.corner2 = corner2;
    this.corner3 = corner3;
   
   }

  public double corner1(){
    return this.corner1;
  }

  public double corner2(){
    return this.corner2;
  }

  public double corner3(){
    return this.corner3;
  }

  public boolean isPointIn(Point p){
    
  }

/*  public double getArea(){ // 1/2 * b * h... basically half of the rectangle
    return ((this.bottomRightCorner.getX() - this.topLeftCorner.getX()) * (this.bottomRightCorner.getY() - this.topLeftCorner.getY()));
  }*/



}
