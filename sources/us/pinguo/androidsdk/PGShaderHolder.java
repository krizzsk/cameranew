package us.pinguo.androidsdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class PGShaderHolder {
    public static byte[] array;

    public static synchronized byte[] getShaderFile(Context context) {
        BufferedInputStream bufferedInputStream;
        synchronized (PGShaderHolder.class) {
            if (array == null) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        bufferedInputStream = new BufferedInputStream(context.getAssets().open("load_background.jpg", 3));
                    } catch (IOException e2) {
                        e = e2;
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
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                        return array;
                    }
                } catch (IOException e4) {
                    e = e4;
                    bufferedInputStream2 = bufferedInputStream;
                    e.printStackTrace();
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                            e = e5;
                            e.printStackTrace();
                            return array;
                        }
                    }
                    return array;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
        return array;
    }
}
