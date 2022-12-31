package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import com.mob.tools.MobLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Marker;
/* loaded from: classes3.dex */
public class Data {
    private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String AES128Decode(String str, byte[] bArr) throws Throwable {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes("UTF-8"), bArr), "UTF-8");
    }

    public static byte[] AES128Encode(String str, String str2) throws Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = getCipher("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes2.length)];
        cipher.doFinal(bArr2, cipher.update(bytes2, 0, bytes2.length, bArr2, 0));
        return bArr2;
    }

    public static String Base64AES(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            String encodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
            return (!TextUtils.isEmpty(encodeToString) && encodeToString.contains("\n")) ? encodeToString.replace("\n", "") : encodeToString;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String CRC32(byte[] bArr) throws Throwable {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & Draft_75.END_OF_FRAME)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & Draft_75.END_OF_FRAME)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static String MD5(String str) {
        byte[] rawMD5;
        if (str == null || (rawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return toHex(rawMD5);
    }

    public static byte[] SHA1(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    public static String base62(long j2) {
        String str = j2 == 0 ? "0" : "";
        while (j2 > 0) {
            j2 /= 62;
            str = CHAT_SET.charAt((int) (j2 % 62)) + str;
        }
        return str;
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    private static Cipher getCipher(String str, String str2) throws Throwable {
        Cipher cipher = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Provider provider = Security.getProvider(str2);
                if (provider != null) {
                    cipher = Cipher.getInstance(str, provider);
                }
            } catch (Throwable unused) {
            }
        }
        return cipher == null ? Cipher.getInstance(str, str2) : cipher;
    }

    private static byte[] hexToBytes(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static byte[] rawRSADecode(byte[] bArr, byte[] bArr2, int i2) throws Throwable {
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(2, (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2)));
        int i3 = i2 / 8;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = new BufferedByteArrayOutputStream();
        for (int i4 = 0; bArr.length - i4 > 0; i4 += i3) {
            byte[] doFinal = cipher.doFinal(bArr, i4, Math.min(bArr.length - i4, i3));
            bufferedByteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        bufferedByteArrayOutputStream.close();
        return bufferedByteArrayOutputStream.toByteArray();
    }

    public static byte[] rawRSAEncode(byte[] bArr, byte[] bArr2, int i2) throws Throwable {
        int i3 = (i2 / 8) - 11;
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(1, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i4 = 0; bArr.length - i4 > 0; i4 += i3) {
            byte[] doFinal = cipher.doFinal(bArr, i4, Math.min(bArr.length - i4, i3));
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return stringBuffer.toString();
    }

    public static String urlEncode(String str, String str2) throws Throwable {
        String encode = URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(encode) ? encode : encode.replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }

    public static String byteToHex(byte[] bArr, int i2, int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i2 < i3) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i2])));
            i2++;
        }
        return stringBuffer.toString();
    }

    public static String MD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return MD5(bArr, 0, bArr.length);
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return rawMD5(bArr, 0, bArr.length);
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
        Cipher cipher = getCipher("AES/ECB/NoPadding", "BC");
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static String MD5(byte[] bArr, int i2, int i3) {
        byte[] rawMD5;
        if (bArr == null || (rawMD5 = rawMD5(bArr, i2, i3)) == null) {
            return null;
        }
        return toHex(rawMD5);
    }

    public static byte[] SHA1(byte[] bArr) throws Throwable {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] rawMD5(byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
            byte[] rawMD5 = rawMD5(byteArrayInputStream);
            byteArrayInputStream.close();
            return rawMD5;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static String MD5(File file) {
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] rawMD5 = rawMD5(fileInputStream);
                fileInputStream.close();
                if (rawMD5 == null) {
                    return null;
                }
                return toHex(rawMD5);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }
        return null;
    }

    public static byte[] SHA1(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            int read = inputStream.read(bArr);
            while (read != -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            int read = inputStream.read(bArr);
            while (read != -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static byte[] SHA1(File file) {
        byte[] bArr = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bArr = SHA1(fileInputStream);
            fileInputStream.close();
            return bArr;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return bArr;
        }
    }

    public static byte[] AES128Encode(byte[] bArr, String str) throws Throwable {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes("UTF-8"));
    }

    public static void AES128Decode(String str, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (str == null) {
            return;
        }
        AES128Decode(str.getBytes("UTF-8"), inputStream, outputStream);
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = getCipher("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static void AES128Decode(byte[] bArr, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (bArr == null || inputStream == null || outputStream == null) {
            return;
        }
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = getCipher("AES/ECB/PKCS7Padding", "BC");
        cipher.init(2, secretKeySpec);
        CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
        byte[] bArr3 = new byte[1024];
        for (int read = cipherInputStream.read(bArr3); read != -1; read = cipherInputStream.read(bArr3)) {
            outputStream.write(bArr3, 0, read);
        }
        outputStream.flush();
    }
}
