class ClockSolver2 {
 public static void main(String[] args) throws Exception {
  double slice = 60;
  double givenAngle = 180;
  try {
   slice = Double.parseDouble(args[0]);
   givenAngle = Double.parseDouble(args[1]);
  } catch (Exception e) {
   System.out.println("no argument given.");
  }
  Clock clock = new Clock(0.0, 0.0, 0.0, slice, givenAngle);
  System.out.println("slice: " + slice + "s");
  System.out.println("Current time: " + clock);
  System.out.println("Given angle: " + givenAngle + " degrees");
  Boolean alreadyPrinted = true;
  for (int i = 0; i < 60 * 60 * 12 / slice; i++) {
   clock.tick();
   if (Math.abs(clock.getAngleBetween() - givenAngle) < (slice / 20)) {
    if (alreadyPrinted) {
     System.out.println("Current time: " + clock + " Current angle: " + clock.getAngleBetween());
    }
    alreadyPrinted = false;
   } else {
    alreadyPrinted = true;
   }
  }
 }
}
