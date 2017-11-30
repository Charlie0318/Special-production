package tw.edu.au.csie.ucan.bee;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

class encdec {
  public static void main(String[] args) {
    BeeJNI bee = new BeeJNI();

    Scanner scan = new Scanner(System.in);
    String s = scan.next();

    byte[] ct = bee.enc("./mypk", s, "jackie and s > 100");
    String ct_str = new String(ct, StandardCharsets.UTF_8);
    System.out.print("ENC SUCCESS(JNI): " + ct_str + " " + ct.length + "\n");

    byte[] pt = bee.dec("./mypk", "./mysk_ok", ct);
    String pt_str = new String(pt, StandardCharsets.UTF_8);
    System.out.print("ENC SUCCESS(JNI): " + pt_str + " " + pt.length + "\n");
  }	
}
