package tw.edu.au.csie.ucan.bee;

class enc {
  public static void main(String[] args) {
    BeeJNI bee = new BeeJNI();
    int len = bee.fenc("./mypk","./data.txt","jackie and s > 100","default");
    System.out.print("ENC SUCCESS(JNI): " + len + "\n");
  }	
}
