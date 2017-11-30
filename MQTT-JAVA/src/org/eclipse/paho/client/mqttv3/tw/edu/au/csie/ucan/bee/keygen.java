package tw.edu.au.csie.ucan.bee;

class keygen {
  public static void main(String[] args) {
    BeeJNI bee = new BeeJNI();
    int len = bee.keygen("./mypk","./mymk","./mysk_ok",4,"jackie","boy","a = 12","s = 1000");
    System.out.print("OK KEYGEN SUCCESS(JNI): " + len + "\n");
    len = bee.keygen("./mypk","./mymk","./mysk_ng",4,"jackies","boy","a = 12","s = 1000");
    System.out.print("NG KEYGEN SUCCESS(JNI): " + len + "\n");
  }	
}
