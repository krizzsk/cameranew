package us.pinguo.loc;

import android.content.Context;
import android.os.HandlerThread;
import java.io.File;
/* compiled from: LocWorkThread.java */
/* loaded from: classes5.dex */
public class w extends HandlerThread {
    public static File a(Context context) {
        File file = new File(context.getCacheDir(), "loc_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
