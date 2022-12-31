package us.pinguo.foundation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: AssetsUtils.java */
/* loaded from: classes4.dex */
public class e {
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b1: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:26:0x00b1 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b4: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x00b4 */
    public static boolean a(Context context, String str, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        us.pinguo.common.log.a.k("copy from asserts: " + str + " to: " + file.getAbsolutePath(), new Object[0]);
        AssetManager assets = context.getAssets();
        File parentFile = file.getParentFile();
        if (parentFile != null && !us.pinguo.util.l.e(parentFile)) {
            throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!, isDirectory = " + parentFile.isDirectory() + ", mkdir result = " + parentFile.mkdirs());
        }
        BufferedOutputStream bufferedOutputStream3 = null;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(assets.open(str, 3));
                    try {
                        BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read != -1) {
                                    bufferedOutputStream4.write(bArr, 0, read);
                                } else {
                                    bufferedOutputStream4.flush();
                                    us.pinguo.util.f.a(bufferedInputStream);
                                    us.pinguo.util.f.a(bufferedOutputStream4);
                                    us.pinguo.util.f.a(bufferedInputStream);
                                    return false;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream3 = bufferedOutputStream4;
                            us.pinguo.util.f.a(bufferedOutputStream3);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                    us.pinguo.common.log.a.f(e);
                    throw e;
                }
            } catch (Throwable unused) {
                us.pinguo.util.f.a(bufferedOutputStream3);
                return false;
            }
        } catch (IOException e3) {
            e = e3;
            bufferedOutputStream3 = bufferedOutputStream2;
            us.pinguo.common.log.a.f(e);
            throw e;
        } catch (Throwable unused2) {
            bufferedOutputStream3 = bufferedOutputStream;
            us.pinguo.util.f.a(bufferedOutputStream3);
            return false;
        }
    }

    public static String b(Context context, String str) throws IOException {
        return new String(c(context, str), "UTF-8");
    }

    public static byte[] c(Context context, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(context.getAssets().open(str, 3));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] f2 = us.pinguo.util.k.f(bufferedInputStream);
            us.pinguo.util.f.a(bufferedInputStream);
            return f2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            us.pinguo.util.f.a(bufferedInputStream2);
            throw th;
        }
    }
}
