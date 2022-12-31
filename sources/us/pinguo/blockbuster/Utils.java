package us.pinguo.blockbuster;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class Utils {
    private static byte[] array;

    public static byte[] getShader(Context context) {
        BufferedInputStream bufferedInputStream;
        if (array == null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(context.getAssets().open("load_background.jpg", 3));
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                array = byteArrayOutputStream.toByteArray();
                bufferedInputStream.close();
            } catch (IOException e4) {
                e = e4;
                bufferedInputStream2 = bufferedInputStream;
                e.printStackTrace();
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                return array;
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return array;
    }
}
