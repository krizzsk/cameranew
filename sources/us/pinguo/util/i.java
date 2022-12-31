package us.pinguo.util;

import com.adjust.sdk.Constants;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.CRC32;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.x;
/* compiled from: EncryptUtils.kt */
/* loaded from: classes6.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    public static final String a(File file) {
        kotlin.jvm.internal.s.h(file, "file");
        if (file.isFile()) {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                FileInputStream fileInputStream = new FileInputStream(file);
                for (int read = fileInputStream.read(bArr, 0, 1024); read != -1; read = fileInputStream.read(bArr, 0, 1024)) {
                    messageDigest.update(bArr, 0, read);
                }
                fileInputStream.close();
                i iVar = a;
                byte[] digest = messageDigest.digest();
                kotlin.jvm.internal.s.g(digest, "digest.digest()");
                String lowerCase = iVar.f(digest).toLowerCase();
                kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase()");
                return lowerCase;
            } catch (Exception e2) {
                us.pinguo.common.log.a.f(e2);
                return null;
            }
        }
        return null;
    }

    public static final synchronized long b(byte[] bArr) {
        synchronized (i.class) {
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    CRC32 crc32 = new CRC32();
                    crc32.reset();
                    crc32.update(bArr);
                    return crc32.getValue();
                }
            }
            return 0L;
        }
    }

    public static final synchronized long c(String filename) {
        synchronized (i.class) {
            kotlin.jvm.internal.s.h(filename, "filename");
            try {
                File file = new File(filename);
                if (file.exists()) {
                    CRC32 crc32 = new CRC32();
                    crc32.reset();
                    byte[] bArr = new byte[8192];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                    try {
                        for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                            crc32.update(bArr, 0, read);
                        }
                        kotlin.u uVar = kotlin.u.a;
                        kotlin.io.b.a(bufferedInputStream, null);
                        return crc32.getValue();
                    } finally {
                    }
                }
            } catch (IOException unused) {
            }
            return 0L;
        }
    }

    private static final byte[] e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.reset();
            Charset forName = Charset.forName("UTF-8");
            kotlin.jvm.internal.s.g(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            kotlin.jvm.internal.s.g(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            kotlin.jvm.internal.s.g(digest, "messageDigest.digest()");
            return digest;
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return new byte[0];
        }
    }

    private final String f(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            byte b = bArr[i2];
            i2++;
            String hex = Integer.toHexString(b & Draft_75.END_OF_FRAME);
            if (hex.length() == 1) {
                kotlin.jvm.internal.s.g(hex, "hex");
                hex = '0' + hex;
            }
            kotlin.jvm.internal.s.g(hex, "hex");
            String upperCase = hex.toUpperCase();
            kotlin.jvm.internal.s.g(upperCase, "this as java.lang.String).toUpperCase()");
            sb.append(upperCase);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "sb.toString()");
        return sb2;
    }

    public static final String g(String password) {
        kotlin.jvm.internal.s.h(password, "password");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            kotlin.jvm.internal.s.g(messageDigest, "getInstance(\"MD5\")");
            Charset forName = Charset.forName("UTF-8");
            kotlin.jvm.internal.s.g(forName, "forName(charsetName)");
            byte[] bytes = password.getBytes(forName);
            kotlin.jvm.internal.s.g(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int length = digest.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                x xVar = x.a;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(digest[i2])}, 1));
                kotlin.jvm.internal.s.g(format, "format(format, *args)");
                stringBuffer.append(format);
                i2 = i3;
            }
            String stringBuffer2 = stringBuffer.toString();
            kotlin.jvm.internal.s.g(stringBuffer2, "sb.toString()");
            Charset forName2 = Charset.forName("UTF-8");
            kotlin.jvm.internal.s.g(forName2, "forName(charsetName)");
            byte[] bytes2 = stringBuffer2.getBytes(forName2);
            kotlin.jvm.internal.s.g(bytes2, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes2);
            StringBuffer stringBuffer3 = new StringBuffer();
            byte[] digest2 = messageDigest.digest();
            int length2 = digest2.length;
            int i4 = 0;
            while (i4 < length2) {
                int i5 = i4 + 1;
                x xVar2 = x.a;
                String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(digest2[i4])}, 1));
                kotlin.jvm.internal.s.g(format2, "format(format, *args)");
                stringBuffer3.append(format2);
                i4 = i5;
            }
            return stringBuffer3.toString();
        } catch (Exception e2) {
            us.pinguo.common.log.a.f(e2);
            return null;
        }
    }

    public static final String h(String original, String str) {
        kotlin.jvm.internal.s.h(original, "original");
        byte[] e2 = e(original);
        if (str != null) {
            if (!(str.length() == 0)) {
                byte[] bytes = str.getBytes(kotlin.text.d.a);
                kotlin.jvm.internal.s.g(bytes, "this as java.lang.String).getBytes(charset)");
                int length = bytes.length;
                StringBuffer stringBuffer = new StringBuffer();
                int length2 = e2.length;
                int i2 = 0;
                while (i2 < length2) {
                    int i3 = i2 + 1;
                    byte b = e2[i2];
                    byte b2 = bytes[i2 % length];
                    x xVar = x.a;
                    String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf((byte) (b2 ^ b))}, 1));
                    kotlin.jvm.internal.s.g(format, "format(format, *args)");
                    stringBuffer.append(format);
                    i2 = i3;
                }
                String stringBuffer2 = stringBuffer.toString();
                kotlin.jvm.internal.s.g(stringBuffer2, "sb.toString()");
                return stringBuffer2;
            }
        }
        StringBuilder sb = new StringBuilder();
        int length3 = e2.length;
        int i4 = 0;
        while (i4 < length3) {
            byte b3 = e2[i4];
            i4++;
            x xVar2 = x.a;
            String format2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b3)}, 1));
            kotlin.jvm.internal.s.g(format2, "format(format, *args)");
            sb.append(format2);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "sb.toString()");
        return sb2;
    }

    public final String d(String data, String key) {
        kotlin.jvm.internal.s.h(data, "data");
        kotlin.jvm.internal.s.h(key, "key");
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.s.g(forName, "forName(charsetName)");
        byte[] bytes = key.getBytes(forName);
        kotlin.jvm.internal.s.g(bytes, "this as java.lang.String).getBytes(charset)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        Charset forName2 = Charset.forName("UTF-8");
        kotlin.jvm.internal.s.g(forName2, "forName(charsetName)");
        byte[] bytes2 = data.getBytes(forName2);
        kotlin.jvm.internal.s.g(bytes2, "this as java.lang.String).getBytes(charset)");
        byte[] signData = mac.doFinal(bytes2);
        StringBuilder sb = new StringBuilder();
        kotlin.jvm.internal.s.g(signData, "signData");
        int length = signData.length;
        int i2 = 0;
        while (i2 < length) {
            byte b = signData[i2];
            i2++;
            String hexString = Integer.toHexString((b & Draft_75.END_OF_FRAME) | 256);
            kotlin.jvm.internal.s.g(hexString, "toHexString((item.toInt() and 0xFF) or 0x100)");
            String substring = hexString.substring(1, 3);
            kotlin.jvm.internal.s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "sb.toString()");
        String lowerCase = sb2.toLowerCase();
        kotlin.jvm.internal.s.g(lowerCase, "this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
