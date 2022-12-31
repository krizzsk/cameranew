package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class b {
    public static String a(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static String b(String str) {
        if ("com.google.android.gms".equals(str)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static List<String> c(@Nullable List<String> list) {
        if (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) {
            return null;
        }
        return list;
    }
}
