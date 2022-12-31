package us.pinguo.common.network.encrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes4.dex */
public class Des3 {
    private static final String KEY_NAME = "DESede";
    private static final String NAME = "DESede/CBC/PKCS5Padding";

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_NAME).generateSecret(new DESedeKeySpec(padding(bArr2, 24)));
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(2, generateSecret, new IvParameterSpec(padding(bArr2, 8)));
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKey generateSecret = SecretKeyFactory.getInstance(KEY_NAME).generateSecret(new DESedeKeySpec(padding(bArr2, 24)));
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(1, generateSecret, new IvParameterSpec(padding(bArr2, 8)));
        return cipher.doFinal(bArr);
    }

    private static byte[] padding(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        if (i2 > bArr.length) {
            System.arraycopy(bArr, 0, bArr2, i2 - bArr.length, bArr.length);
        } else {
            System.arraycopy(bArr, bArr.length - i2, bArr2, 0, i2);
        }
        return bArr2;
    }
}
