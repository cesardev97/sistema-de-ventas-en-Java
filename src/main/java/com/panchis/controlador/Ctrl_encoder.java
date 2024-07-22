/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.panchis.controlador;

/**
 *
 * @author JEAN
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.swing.JOptionPane;
public class Ctrl_encoder {
     private static final String SECRET_KEY = "C14v3S3cr3ta";

    public String encode(String cadena) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(SECRET_KEY.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(buf);
            return new String(base64Bytes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al encriptar");
            ex.printStackTrace();
            return null;
        }
    }

    public String decode(String cadenaEncriptada) {
        try {
            byte[] message = Base64.getDecoder().decode(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(SECRET_KEY.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            return new String(plainText, "UTF-8");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "error al desencriptar");
            ex.printStackTrace();
            return null;
        }
    }
}
