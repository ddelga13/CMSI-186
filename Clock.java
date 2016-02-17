class Clock {
 private double slice;
 private double givenAngle;
 private double second;
 private double minute;
 private double hour;

 public Clock (double hourHand, double minuteHand, double second, double slice){
  this.hour = hourHand;
  this.minute = minuteHand;
  this.second = second;
  this.slice = slice;
  //minuteHand = 360 degrees an hour = 6 degrees per minute
  //hourHand = 30 degrees an hour = 1/2 degree per minute
  //hourHand moves 1/12 the rate of the minuteHand!
 }
 
  public Clock (double hourHand, double minuteHand, double second, double slice, double givenAngle){
  this.hour = hourHand;
  this.minute = minuteHand;
  this.second = second;
  this.slice = slice;
  this.givenAngle = givenAngle;
 }
 
 public double getMinute () {
  return minute;
 }

 public double getHour () {
  return hour;
 }
 
 public void tick (){
  this.second += slice;
  if (this.second >= 60){
   this.minute += (int)this.second/60;
   this.second = this.second % 60;
  }
  if (this.minute >= 60){
   this.hour += (int)this.minute/60;
   this.minute = this.minute % 60;
  }
  if (this.hour >= 12){
   this.hour = this.hour % 12;
  }
 }

 public double getMinuteAngle(){
  return (this.minute + (this.second/60)) * 6;
 }
 public double getHourAngle(){
  return (this.hour + ((this.minute/60) + (this.second/3600))) * 30;
 }

 public double getAngleBetween (){
  return Math.abs(this.getMinuteAngle() - this.getHourAngle());
 }

 public String toString (){
  return (int)this.hour + ":" + (int)this.minute + ":" + this.second;
 }
}
