package us.pinguo.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import java.io.File;
/* compiled from: PushUtils.java */
/* loaded from: classes6.dex */
public class j {
    @TargetApi(8)
    public static File a(Context context) {
        File externalStorageDirectory;
        if (b()) {
            if (Build.VERSION.SDK_INT >= 8) {
                return context.getExternalCacheDir();
            }
            String str = "/Android/data/" + context.getPackageName() + "/cache/";
            if (Environment.getExternalStorageDirectory() == null) {
                return null;
            }
            return new File(externalStorageDirectory.getAbsolutePath() + str);
        }
        return null;
    }

    private static boolean b() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
