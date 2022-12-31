package us.pinguo.foundation.n;

import android.content.Context;
import android.os.Environment;
import java.io.File;
/* compiled from: ImageCache.java */
/* loaded from: classes4.dex */
public class a {
    public static File a(Context context, String str) {
        String path;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            path = b(context).getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        return new File(path + File.separator + str);
    }

    public static File b(Context context) {
        return context.getExternalCacheDir();
    }
}
