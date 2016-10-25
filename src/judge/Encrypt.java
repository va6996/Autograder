/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package judge;

/**
 *
 * @author Sith Lord
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

class Encrypt {

	public static String decrypt(byte[] encrypted, SecretKey myDesKey) {
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			// SecretKey myDesKey = keygenerator.generateKey();
			Cipher desCipher = Cipher.getInstance("DES");
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
			byte[] textDecrypted = desCipher.doFinal(encrypted);
			String en = new String(textDecrypted);
			System.out.println(en);

		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		}

		return encrypted.toString();
	}

	public static void main(String[] args) {

		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
			SecretKey myDesKey = keygenerator.generateKey();

			Cipher desCipher = Cipher.getInstance("DES");

			byte[] text = "Hello, world!".getBytes("UTF8");

			desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
			byte[] textEncrypted = desCipher.doFinal(text);

			String s = new String(textEncrypted);
			System.out.println(s);
			System.out.println(decrypt(textEncrypted, myDesKey));
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
		}
		/*
		 * try{ KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		 * SecretKey myDesKey = keygenerator.generateKey();
		 * 
		 * Cipher desCipher; desCipher = Cipher.getInstance("DES");
		 * 
		 * 
		 * byte[] text = "Hello,  \nworld!".getBytes("UTF8");
		 * 
		 * 
		 * desCipher.init(Cipher.ENCRYPT_MODE, myDesKey); byte[] textEncrypted =
		 * desCipher.doFinal(text);
		 * 
		 * String s = new String(textEncrypted); System.out.println(s);
		 * 
		 * desCipher.init(Cipher.DECRYPT_MODE, myDesKey); byte[] textDecrypted =
		 * desCipher.doFinal(textEncrypted);
		 * 
		 * s = new String(textDecrypted); System.out.println(s);
		 * }catch(Exception e) { System.out.println("Exception"); /*try{
		 * KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		 * SecretKey myDesKey = keygenerator.generateKey();
		 * 
		 * Cipher desCipher; desCipher = Cipher.getInstance("DES");
		 * 
		 * 
		 * byte[] text = "Hello,  \nworld!".getBytes("UTF8");
		 * 
		 * 
		 * desCipher.init(Cipher.ENCRYPT_MODE, myDesKey); byte[] textEncrypted =
		 * desCipher.doFinal(text);
		 * 
		 * String s = new String(textEncrypted); System.out.println(s);
		 * 
		 * desCipher.init(Cipher.DECRYPT_MODE, myDesKey); byte[] textDecrypted =
		 * desCipher.doFinal(textEncrypted);
		 * 
		 * s = new String(textDecrypted); System.out.println(s);
		 * }catch(Exception e) { System.out.println("Exception"); }
		 */

	}
}
