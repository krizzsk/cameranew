package us.pinguo.webview;

import android.content.Context;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
/* compiled from: PGWebInit.java */
/* loaded from: classes6.dex */
public final class c {
    private static Context a;
    private static String b;

    public static Context a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        throw new IllegalArgumentException("authority should init in App OnCreate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        return "content://" + b() + "/";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        return Constants.HTTP_PROTOCOL_PREFIX + b() + "/";
    }

    public static void e(Context context, String str) {
        a = context;
        b = str;
    }
}
