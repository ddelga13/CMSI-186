public class RandonizedAreaEstimator {
  public shape [];
  public static void main(String[] args){
  	//parse the input, make the shapes
  	for(int i = 0; i < args.length; i++){
  		if( rectangle) {
  			Rectangle rect = new Rectangle(new Point(Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]))
  										 , new Point(Double.parseDouble(args[i + 3]), Double.parseDouble(args[i + 4]));
  		}
  	}
  }
  
}


//shape [] = {triangle, circle circle}
//Rectangle.getBigBox (smallest x, smallest y, biggest x, biggest y) (use forloop to manually find these)

//generate a million points in big getBigBox (two math.random's)
//intersecting
//check if the point is in the shape, for each shape in the array
//then, 
//output area of just the intersection
//output area of all the non intersection (union)
//output area of everything
//output area of just circle
//output area of just triangle

//intersection if (if point is in ALL shapes) {
//then store in intersecting double
//}

//non-intersecting if (in point is in ONE shape)
//then store in non-intersecting double

//union if (point is in ANY shape)
//then store in union double

//shape if (point is in shape)
//store in individual shape instance (class)


//triangle-- do it the vector way
//circle-- is the distance bw point and center > or < than radius?
