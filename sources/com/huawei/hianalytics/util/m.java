package com.huawei.hianalytics.util;

import android.content.Context;
import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.Deflater;
/* loaded from: classes2.dex */
public final class m {
    public static String a(InputStream inputStream, int i2) {
        b bVar = new b(i2);
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            bVar.a(bArr, read);
        }
        return bVar.a() == 0 ? "" : new String(bVar.b(), "UTF-8");
    }

    public static String a(String str, Context context) {
        Pair<byte[], String> b = d.b(str);
        return d.b(a.a(context).a(), (byte[]) b.first, (String) b.second);
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
                com.huawei.hianalytics.b.b.c("StreamUtil", "closeStream(): IOException: close InputStream error!");
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                com.huawei.hianalytics.b.b.c("StreamUtil", "closeStream(): IOException: close OutputStream error!");
            }
        }
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        a(byteArrayOutputStream);
        return byteArray;
    }

    public static String b(String str, Context context) {
        a a = a.a(context);
        byte[] c = d.c();
        return d.a(c, d.a(a.a(), c, str));
    }
}
