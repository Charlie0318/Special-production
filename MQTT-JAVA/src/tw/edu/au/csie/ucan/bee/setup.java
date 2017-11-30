package tw.edu.au.csie.ucan.bee;

class setup {
  public static void main(String[] args) {
    BeeJNI bee = new BeeJNI();
    int len = bee.setup("./mypk","./mymk");
    System.out.print("SETUP SUCCESS(JNI): " + len + "\n");
  }	
}
