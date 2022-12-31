package us.pinguo.bigalbum.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class QETag {
    private final int CHUNK_SIZE = 4194304;

    public static void main(String[] strArr) {
        if (strArr.length != 1) {
            System.out.println("Usage: qetag <filename>");
            return;
        }
        String str = strArr[0];
        try {
            System.out.println(new QETag().calcETag(str));
        } catch (IOException e2) {
            PrintStream printStream = System.err;
            printStream.println("IO Error:" + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            PrintStream printStream2 = System.err;
            printStream2.println("Unsupported algorithm:" + e3.getMessage());
        }
    }

    public String calcETag(String str) throws IOException, NoSuchAlgorithmException {
        String urlSafeBase64Encode;
        File file = new File(str);
        if (file.exists() && file.isFile() && file.canRead()) {
            long length = file.length();
            FileInputStream fileInputStream = new FileInputStream(file);
            if (length <= 4194304) {
                int i2 = (int) length;
                byte[] bArr = new byte[i2];
                fileInputStream.read(bArr, 0, i2);
                byte[] sha1 = sha1(bArr);
                int length2 = sha1.length;
                byte[] bArr2 = new byte[length2 + 1];
                System.arraycopy(sha1, 0, bArr2, 1, length2);
                bArr2[0] = 22;
                urlSafeBase64Encode = urlSafeBase64Encode(bArr2);
            } else {
                int i3 = (int) (length / 4194304);
                if (length % 4194304 != 0) {
                    i3++;
                }
                byte[] bArr3 = new byte[0];
                int i4 = 0;
                while (i4 < i3) {
                    byte[] bArr4 = new byte[4194304];
                    int read = fileInputStream.read(bArr4, 0, 4194304);
                    byte[] bArr5 = new byte[read];
                    System.arraycopy(bArr4, 0, bArr5, 0, read);
                    byte[] sha12 = sha1(bArr5);
                    byte[] bArr6 = new byte[sha12.length + bArr3.length];
                    System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
                    System.arraycopy(sha12, 0, bArr6, bArr3.length, sha12.length);
                    i4++;
                    bArr3 = bArr6;
                }
                byte[] sha13 = sha1(bArr3);
                byte[] bArr7 = new byte[sha13.length + 1];
                System.arraycopy(sha13, 0, bArr7, 1, sha13.length);
                bArr7[0] = -106;
                urlSafeBase64Encode = urlSafeBase64Encode(bArr7);
            }
            fileInputStream.close();
            return urlSafeBase64Encode;
        }
        System.err.println("Error: File not found or not readable");
        return "";
    }

    public byte[] sha1(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("sha1").digest(bArr);
    }

    public String urlSafeBase64Encode(byte[] bArr) {
        return new String(Base64.encode(bArr)).replace('+', '-').replace('/', '_');
    }
}
