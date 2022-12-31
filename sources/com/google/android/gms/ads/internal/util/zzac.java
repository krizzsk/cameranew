package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzwr;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@TargetApi(28)
/* loaded from: classes2.dex */
public final class zzac extends zzz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ WindowInsets b(Activity activity, View view, WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyt() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzf zzxs = com.google.android.gms.ads.internal.zzr.zzkv().zzxs();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat(Effect.DIVIDER);
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzxs.zzef(str);
            } else {
                com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzef("");
            }
        }
        c(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static void c(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = attributes.layoutInDisplayCutoutMode;
        int i3 = z ? 1 : 2;
        if (i3 != i2) {
            attributes.layoutInDisplayCutoutMode = i3;
            window.setAttributes(attributes);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final void zzi(final Activity activity) {
        if (((Boolean) zzwr.zzqr().zzd(zzabp.zzcpu)).booleanValue() && com.google.android.gms.ads.internal.zzr.zzkv().zzxs().zzyt() == null && !activity.isInMultiWindowMode()) {
            c(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.ads.internal.util.a
                private final Activity a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzac.b(this.a, view, windowInsets);
                }
            });
        }
    }
}
