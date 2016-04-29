public class Circle extends Shape {

  public Circle (Point center, Double radius){
    this.center = center;
    this.radius = radius;
  }

  public double getCenter(){
    return this.center;
  }

  public double getRadius(){
    return this.radius;
  }

  public getArea(){
    return (Math.PI * this.radius * this.radius);
  }

  public boolean isPointIn(Point p){
    if (this.radius > (sqrt(Math.pow(x.this.center - x.this.p,2) + (Math.pow(y.this.center - y.this.p,2))))){
      return false;
    }
    else if return true;
  }


}
