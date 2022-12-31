package us.pinguo.advconfigdata.Utils;

import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes3.dex */
public class AdvLog {
    public static boolean mbLog = true;

    public static void Log(String str, String str2) {
        if (!mbLog || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e(str, str2);
    }

    public static void Log(String str) {
        if (!mbLog || TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("test", str);
    }
}
