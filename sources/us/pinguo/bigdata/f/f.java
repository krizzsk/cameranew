package us.pinguo.bigdata.f;

import android.content.Context;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants;
import java.io.File;
/* compiled from: Paths.java */
/* loaded from: classes3.dex */
public class f {
    private static String a;
    private static String b;
    private static String c;

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = d(context) + File.separator + TJAdUnitConstants.String.VIDEO_COMPLETE;
        }
        return b;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            c = d(context) + File.separator + "current.log";
        }
        return c;
    }

    public static String c() {
        return "current.log";
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = context.getFilesDir().getAbsolutePath() + File.separator + "log";
        }
        return a;
    }
}
