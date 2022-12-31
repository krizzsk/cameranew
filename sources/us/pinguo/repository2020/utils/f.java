package us.pinguo.repository2020.utils;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.jvm.internal.s;
import kotlin.text.t;
/* compiled from: AssetsUtils.kt */
/* loaded from: classes6.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    public final boolean a(Context context, String assetFileName, String destFileName) {
        boolean m;
        s.h(context, "context");
        s.h(assetFileName, "assetFileName");
        s.h(destFileName, "destFileName");
        try {
            InputStream open = context.getAssets().open(assetFileName);
            s.g(open, "context.assets.open(assetFileName)");
            File file = new File(destFileName);
            if (file.isDirectory()) {
                m = t.m(destFileName, "zip", false, 2, null);
                if (!m) {
                    return false;
                }
            }
            if (file.exists()) {
                file.delete();
            }
            if (file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (open.read(bArr) != -1) {
                    fileOutputStream.write(bArr);
                }
                fileOutputStream.flush();
                open.close();
                fileOutputStream.close();
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
