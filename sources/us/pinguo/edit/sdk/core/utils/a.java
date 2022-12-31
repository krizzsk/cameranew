package us.pinguo.edit.sdk.core.utils;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import us.pinguo.util.f;
import us.pinguo.util.k;
import us.pinguo.util.l;
/* compiled from: AssetsUtils.java */
/* loaded from: classes4.dex */
public class a {
    private static final String a = "a";

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0098: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:26:0x0098 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009b: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:28:0x009b */
    public static void a(Context context, String str, File file) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        String str2 = a;
        SdkLog.c(str2, "copy from asserts: " + str + " to: " + file.getAbsolutePath());
        AssetManager assets = context.getAssets();
        File parentFile = file.getParentFile();
        if (parentFile != null && !l.e(parentFile)) {
            throw new IOException("Create Folder(" + parentFile.getAbsolutePath() + ") Failed!");
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
                                    f.a(bufferedOutputStream4);
                                    f.a(bufferedInputStream);
                                    return;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream3 = bufferedOutputStream4;
                            f.a(bufferedOutputStream3);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    SdkLog.a(a, e.getMessage());
                    f.a(bufferedOutputStream3);
                }
            } catch (Throwable th3) {
                th = th3;
                f.a(bufferedOutputStream3);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            bufferedOutputStream3 = bufferedOutputStream2;
            SdkLog.a(a, e.getMessage());
            f.a(bufferedOutputStream3);
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream3 = bufferedOutputStream;
            f.a(bufferedOutputStream3);
            throw th;
        }
    }

    public static byte[] b(Context context, String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(context.getAssets().open(str, 3));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] f2 = k.f(bufferedInputStream);
            f.a(bufferedInputStream);
            return f2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            f.a(bufferedInputStream2);
            throw th;
        }
    }
}
