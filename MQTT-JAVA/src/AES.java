/*
AES加解密    使用外部呼叫範例nAES.getencrypt  加密,return一個密文編碼(base64)
AES.getdecrypt  解密,return明文String回來
*/
import java.io.*;
import sun.misc.*;
import javax.crypto.*;
import java.security.*;
import javax.crypto.spec.*;
class AES
{
  public static String getencrypt(String content) throws Exception
  {
    String encrypted="";
    try{
      KeyGenerator kgen = KeyGenerator.getInstance("AES");
      kgen.init(128,new SecureRandom(content.getBytes() ) );
      SecretKey skey = kgen.generateKey();
      byte[] raw = skey.getEncoded();
      SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
      byte[] encrypt =
      cipher.doFinal( content.getBytes());
      encrypted=new BASE64Encoder().encodeBuffer(encrypt);
      //System.out.println("encrypted="+encrypted);
      }//try
      catch(Exception e){System.out.println(e);
      }
      return encrypted;  //return 密文
  }
  public static String getdecrypt(String k2,String base64) throws Exception
  {
    String decrypted="";
    try{
    byte[] b = new BASE64Decoder().decodeBuffer( base64 );
    KeyGenerator kgen2 = KeyGenerator.getInstance("AES");
    kgen2.init(128,new SecureRandom(k2.getBytes() ) );
    SecretKey skey2 = kgen2.generateKey();
    byte[] raw2 = skey2.getEncoded();
    SecretKeySpec skeySpec2 = new SecretKeySpec(raw2, "AES");
    Cipher cipher2 = Cipher.getInstance("AES");
    cipher2.init(Cipher.DECRYPT_MODE, skeySpec2);
    byte[] decrypt =
    cipher2.doFinal( b);
    decrypted=new String(decrypt);
    //System.out.println("decrypted="+decrypted);
 
    }catch(Exception e)
    {System.out.println(e);}
      return decrypted;
  }
}
