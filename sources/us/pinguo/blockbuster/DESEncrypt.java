package us.pinguo.blockbuster;

import android.util.Base64;
import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
/* loaded from: classes3.dex */
public class DESEncrypt {
    public static final String ENCRYPT_PWD = "d9877ff9a0f61f1cd9782298";
    private static final String encoding = "utf-8";
    private static final String iv = "d9877ff9";

    public static String decrypt(String str, String str2) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("des").generateSecret(new DESKeySpec(str2.getBytes()));
        Cipher cipher = Cipher.getInstance("des/CBC/PKCS5Padding");
        cipher.init(2, generateSecret, new IvParameterSpec(iv.getBytes()));
        return new String(cipher.doFinal(Base64.decode(str, 2)), encoding);
    }

    public static String encrypt(String str, String str2) throws Exception {
        SecretKey generateSecret = SecretKeyFactory.getInstance("des").generateSecret(new DESKeySpec(str2.getBytes()));
        Cipher cipher = Cipher.getInstance("des/CBC/PKCS5Padding");
        cipher.init(1, generateSecret, new IvParameterSpec(iv.getBytes()));
        return Base64.encodeToString(cipher.doFinal(str.getBytes(encoding)), 2);
    }

    public static void main(String[] strArr) {
        if (strArr.length < 2) {
            System.out.println("Missing parameters: use DESEncrypt stringToEncode key");
            return;
        }
        String str = strArr[0];
        String str2 = strArr[1];
        PrintStream printStream = System.out;
        printStream.print("encodeFilePath=" + str + ", key=" + str2 + "\n");
        String read = read(str);
        PrintStream printStream2 = System.out;
        printStream2.print("stringToEncode=" + read + "\n");
        try {
            String encrypt = encrypt(read, str2);
            PrintStream printStream3 = System.out;
            printStream3.print("base64ToAes=" + encrypt + "\n");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_encrypt");
            write(sb.toString(), encrypt);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & Draft_75.END_OF_FRAME);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i2 = 0; i2 < str.length() / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 1;
            bArr[i2] = (byte) ((Integer.parseInt(str.substring(i3, i4), 16) * 16) + Integer.parseInt(str.substring(i4, i3 + 2), 16));
        }
        return bArr;
    }

    private static String read(String str) {
        String str2 = "";
        try {
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = str2 + readLine;
                }
                inputStreamReader.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    private static void write(String str, String str2) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
