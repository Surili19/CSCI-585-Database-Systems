public class Spiro {
    public static void main (String args[]) {
    double R = 8, r = 1, a = 4;
    double t = 0;
    double max_t = 16 * Math.PI;
    double x = 0, y = 0;
    System.out.print("[");
    while(t <= max_t) {
      x =  (-118.28538432401638 + (0.0001*(R + r)) * Math.cos((r / R) * t) - 0.0001 *a * Math.cos((1 + r / R) * t));
      y =  (34.0205622506377 + (0.0001*(R + r)) * Math.sin((r / R) * t) - 0.0001*a * Math.sin((1 + r / R) * t));
      System.out.printf("{\"loc\" :[ %.5f,%.5f", x, y);
      System.out.printf("]},\n");
      
      t += 0.1;
    }
    System.out.printf("]");
  }
    
}
