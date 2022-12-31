package us.pinguo.smaatoapi.d;

import android.content.Context;
/* compiled from: DisplayUtils.java */
/* loaded from: classes6.dex */
public class a {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
