package us.pinguo.libdeepvision;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: DeepVision.java */
/* loaded from: classes5.dex */
public class a {
    static {
        System.loadLibrary("DeepVision");
    }

    private static void a(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public static boolean b(Context context, String str, String str2) {
        AssetManager assets = context.getAssets();
        File file = new File(str2);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            return false;
        }
        ?? exists = parentFile.exists();
        if (exists == 0 ? !parentFile.mkdirs() : !parentFile.isDirectory()) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(assets.open(str, 3));
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream2.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream2.flush();
                                a(bufferedInputStream);
                                a(bufferedOutputStream2);
                                a(bufferedInputStream);
                                return true;
                            }
                        }
                    } catch (Exception unused) {
                        bufferedOutputStream = bufferedOutputStream2;
                        a(bufferedOutputStream);
                        a(bufferedInputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        a(bufferedOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException unused3) {
                bufferedOutputStream = exists;
                a(bufferedOutputStream);
                return false;
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = exists;
                a(bufferedOutputStream);
                throw th;
            }
        } catch (IOException unused4) {
            a(bufferedOutputStream);
            return false;
        } catch (Throwable th4) {
            th = th4;
            a(bufferedOutputStream);
            throw th;
        }
    }

    public static String c(Context context, String str) {
        return context.getExternalFilesDir("DeepVisionSDK").getAbsolutePath() + "/" + str;
    }
}
