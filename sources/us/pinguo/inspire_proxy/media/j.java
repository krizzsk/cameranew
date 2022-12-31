package us.pinguo.inspire_proxy.media;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import androidx.annotation.NonNull;
import java.io.File;
import us.pinguo.foundation.utils.m;
/* compiled from: PushUtils.java */
/* loaded from: classes4.dex */
public class j {
    @NonNull
    public static File a(Context context) {
        return new File(b(context));
    }

    @NonNull
    public static String b(Context context) {
        File externalStorageDirectory;
        String str = "/sdcard/Android/data/" + context.getPackageName() + "/cache/";
        if (m.a(context)) {
            if (Build.VERSION.SDK_INT >= 8) {
                File externalCacheDir = context.getExternalCacheDir();
                return externalCacheDir != null ? externalCacheDir.getAbsolutePath() : str;
            }
            String str2 = "/Android/data/" + context.getPackageName() + "/cache/";
            if (Environment.getExternalStorageDirectory() == null) {
                return str;
            }
            return externalStorageDirectory.getAbsolutePath() + str2;
        }
        return str;
    }
}
