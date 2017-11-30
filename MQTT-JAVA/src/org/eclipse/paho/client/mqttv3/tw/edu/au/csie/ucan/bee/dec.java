package tw.edu.au.csie.ucan.bee;

class dec {
  public static void main(String[] args) {
    BeeJNI bee = new BeeJNI();
    int len = bee.fdec("./mypk","./mysk_ng","./data.txt.cpabe");
    System.out.print("DEC NG(JNI): " + len + "\n");
    len = bee.fdec("./mypk","./mysk_ok","./data.txt.cpabe");
    System.out.print("DEC SUCCESS(JNI): " + len + "\n");
  }	
}
