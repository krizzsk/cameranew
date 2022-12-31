package us.pinguo.foundation.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
/* compiled from: DeviceInfo.java */
/* loaded from: classes4.dex */
public class m {
    public static boolean a(Context context) {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean b(float f2, Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return (((float) memoryInfo.totalMem) / 1024.0f) / 1024.0f <= f2;
    }
}
