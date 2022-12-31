package us.pinguo.foundation.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: ToastHelper.java */
/* loaded from: classes4.dex */
public class j0 {
    private static Context a = us.pinguo.foundation.e.b();
    private static Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(CharSequence charSequence) {
        Toast makeText = Toast.makeText(a, charSequence, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(int i2) {
        Toast makeText = Toast.makeText(a, i2, 0);
        makeText.show();
        VdsAgent.showToast(makeText);
    }

    public static void c(final int i2) {
        if (i2 != 0) {
            b.post(new Runnable() { // from class: us.pinguo.foundation.utils.b
                @Override // java.lang.Runnable
                public final void run() {
                    j0.b(i2);
                }
            });
        }
    }

    public static void d(final CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        b.post(new Runnable() { // from class: us.pinguo.foundation.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                j0.a(charSequence);
            }
        });
    }
}
