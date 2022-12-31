package us.pinguo.advsdk.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: AdvFileUtils.java */
/* loaded from: classes3.dex */
public final class a {
    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static void b(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void c(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }

    public static byte[] d(File file) throws IOException {
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] f2 = f(bufferedInputStream2);
                b(bufferedInputStream2);
                return f2;
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                b(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] e(String str) throws IOException {
        return d(new File(str));
    }

    public static byte[] f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream2.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream2.flush();
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        c(byteArrayOutputStream2);
                        return byteArray;
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                c(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void g(byte[] bArr, String str) throws IOException {
        if (bArr == null) {
            throw new IOException("data is null");
        }
        if (str != null) {
            File parentFile = new File(str).getParentFile();
            if (a(parentFile)) {
                BufferedOutputStream bufferedOutputStream = null;
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(str));
                    try {
                        bufferedOutputStream2.write(bArr);
                        c(bufferedOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        c(bufferedOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
            }
        } else {
            throw new IOException("path is null");
        }
    }
}
