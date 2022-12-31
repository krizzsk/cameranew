package us.pinguo.common.network.encrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class Aes {
    private static final String KEY_NAME = "AES";
    private static final String NAME = "AES/CBC/PKCS5Padding";

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(padding(bArr2, 16), KEY_NAME);
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(2, secretKeySpec, new IvParameterSpec(padding(bArr2, 16)));
        return cipher.doFinal(bArr);
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(padding(bArr2, 16), KEY_NAME);
        Cipher cipher = Cipher.getInstance(NAME);
        cipher.init(1, secretKeySpec, new IvParameterSpec(padding(bArr2, 16)));
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
