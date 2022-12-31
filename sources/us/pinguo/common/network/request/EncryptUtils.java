package us.pinguo.common.network.request;

import android.util.Base64;
import android.util.Log;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Marker;
import us.pinguo.common.network.common.header.PGTransHeader;
import us.pinguo.common.network.encrypt.HmacSHA256;
/* loaded from: classes4.dex */
public class EncryptUtils {
    private static final String CIPHER_NAME = "AES/CBC/PKCS5Padding";
    private static final boolean DEBUG_LOG = true;
    private static final String KEY_NAME = "AES";
    private static final String TAG = "EncryptRequest";
    private static final String SO_KEY_STR = "ngzCfE1a/LcxJiA2SnleBg==";
    private static final byte[] SO_KEY = Base64.decode(SO_KEY_STR, 0);

    private static byte[] aesDecrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KEY_NAME);
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
        return cipher.doFinal(bArr);
    }

    private static byte[] aesEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KEY_NAME);
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
        return cipher.doFinal(bArr);
    }

    private static boolean checkHash(byte[] bArr, byte[] bArr2) throws InvalidKeyException, NoSuchAlgorithmException {
        return Arrays.equals(bArr, HmacSHA256.hash(bArr2, SO_KEY));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] decryptContent(byte[] bArr, byte[] bArr2) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeySpecException, NoSuchPaddingException {
        if (bArr != null && bArr.length >= 32) {
            byte[] bArr3 = new byte[32];
            System.arraycopy(bArr, 0, bArr3, 0, 32);
            int length = bArr.length - 32;
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, 32, bArr4, 0, length);
            if (checkHash(bArr3, bArr4)) {
                byte[] doDecryptContent = doDecryptContent(bArr4, bArr2);
                String str = new String(doDecryptContent);
                Log.d(TAG, "解密数据：" + str);
                return doDecryptContent;
            }
            Log.e(TAG, "Check error, ignore content!");
        }
        return null;
    }

    public static byte[] decryptForExternal(String str, String str2) {
        try {
            return decryptContent(Base64.decode(str, 0), Base64.decode(recoverUrlSafe(str2), 0));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static byte[] doDecryptContent(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        return aesDecrypt(bArr, SO_KEY, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encodeUrlSafe(String str) {
        return str.replaceAll("/", "_").replaceAll("\\+", PGTransHeader.CONNECTOR);
    }

    public static Object[] encryptForExternal(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        new SecureRandom().nextBytes(bArr2);
        String encodeUrlSafe = encodeUrlSafe(Base64.encodeToString(bArr2, 0));
        Log.d(TAG, "requestIvHeader：" + encodeUrlSafe);
        return new Object[]{bArr2, makeAesEncryptBody(bArr, bArr2)};
    }

    private static byte[] joinByteArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] makeAesEncryptBody(byte[] bArr, byte[] bArr2) {
        try {
            String str = new String(bArr);
            Log.d(TAG, "加密数据：" + str);
            byte[] bArr3 = SO_KEY;
            byte[] aesEncrypt = aesEncrypt(bArr, bArr3, bArr2);
            String encodeToString = Base64.encodeToString(aesEncrypt, 0);
            Log.d(TAG, "加密数据Base64：" + encodeToString);
            return joinByteArray(HmacSHA256.hash(aesEncrypt, bArr3), aesEncrypt);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String recoverUrlSafe(String str) {
        return str.replaceAll("_", "/").replaceAll(PGTransHeader.CONNECTOR, Marker.ANY_NON_NULL_MARKER);
    }
}
