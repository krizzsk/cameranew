package com.danikula.videocache;

import android.content.Context;
import android.os.Environment;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
/* compiled from: StorageUtils.java */
/* loaded from: classes.dex */
final class o {
    private static final org.slf4j.b a = org.slf4j.c.i("StorageUtils");

    private static File a(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File b = (z && "mounted".equals(str)) ? b(context) : null;
        if (b == null) {
            b = context.getCacheDir();
        }
        if (b == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            a.warn("Can't define system cache directory! '" + str2 + "%s' will be used.");
            return new File(str2);
        }
        return b;
    }

    private static File b(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), Constants.PLATFORM_ANDROID), "data"), context.getPackageName()), "cache");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        a.warn("Unable to create external cache directory");
        return null;
    }

    public static File c(Context context) {
        return new File(a(context, true), "video-cache");
    }
}
