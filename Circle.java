public class Circle {

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


}
