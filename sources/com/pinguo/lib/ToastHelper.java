package com.pinguo.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
import us.pinguo.foundation.e;
/* loaded from: classes3.dex */
public class ToastHelper {
    private static Context context = e.b();
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(int i2) {
        Toast makeText = Toast.makeText(context, i2, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    public static void show(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        mHandler.post(new Runnable() { // from class: com.pinguo.lib.c
            @Override // java.lang.Runnable
            public final void run() {
                ToastHelper.a(str);
            }
        });
    }

    public static void show(final int i2) {
        mHandler.post(new Runnable() { // from class: com.pinguo.lib.b
            @Override // java.lang.Runnable
            public final void run() {
                ToastHelper.b(i2);
            }
        });
    }
}
