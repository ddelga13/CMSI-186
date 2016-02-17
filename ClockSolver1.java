class ClockSolver1 {
 public static void main(String[] args) throws Exception {
  double slice = 60;
  try { // an if statement or conditional statement: if you have args[0], that is your time slice, else slice = 60
   // check for positive reals less than 1800
   slice = Double.parseDouble(args[0]);
  } catch (Exception e) {
   System.out.println("no argument given.");
  }
  Clock clock = new Clock(0.0, 0.0, 0.0, slice);
  System.out.println("slice: " + slice + "s");
  System.out.println("Current time: " + clock);
  Boolean alreadyPrinted = true;
  for (int i = 0; i < 60 * 60 * 12 / slice; i++) {
   clock.tick();
   if (Math.abs(clock.getAngleBetween() - 180) < (slice / 20)) {
    if (alreadyPrinted) {
     System.out.println("Current time: " + clock + " Current angle: " + clock.getAngleBetween());
    }
    alreadyPrinted = false;
    // System.out.println ("Minute angle: " + clock.getMinuteAngle());
   } else {
    alreadyPrinted = true;
   }
  }
 }
}
// 900 seconds = 90* traveled by minute hand, therefore all times/angle should be +/- 45* of 180*
// 60 seconds = 6* traveled by minute hand, therefore all times/angle should be +/- 3* of 180*
