package d.f.a.b;

import android.content.Context;
import android.os.Environment;
import com.growingio.android.sdk.collection.Constants;
import java.io.File;
import java.io.IOException;
/* compiled from: StorageUtils.java */
/* loaded from: classes3.dex */
public final class f {
    public static File a(Context context) {
        return b(context, true);
    }

    public static File b(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File c = (z && "mounted".equals(str) && e(context)) ? c(context) : null;
        if (c == null) {
            c = context.getCacheDir();
        }
        if (c == null) {
            String str2 = "/data/data/" + context.getPackageName() + "/cache/";
            d.f("Can't define system cache directory! '%s' will be used.", str2);
            return new File(str2);
        }
        return c;
    }

    private static File c(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), Constants.PLATFORM_ANDROID), "data"), context.getPackageName()), "cache");
        if (!file.exists()) {
            if (!file.mkdirs()) {
                d.f("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                d.d("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            }
        }
        return file;
    }

    public static File d(Context context) {
        File a = a(context);
        File file = new File(a, "uil-images");
        return (file.exists() || file.mkdir()) ? file : a;
    }

    private static boolean e(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
