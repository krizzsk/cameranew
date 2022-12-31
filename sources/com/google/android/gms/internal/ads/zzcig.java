package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(19)
/* loaded from: classes2.dex */
public final class zzcig {
    @Nullable
    private Context context;
    @Nullable
    private PopupWindow zzgkf;

    private static PopupWindow zzd(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzazk.zzdy("Displaying the 1x1 popup off the screen.");
        try {
            View decorView = window.getDecorView();
            popupWindow.showAtLocation(decorView, 0, -1, -1);
            VdsAgent.showAtLocation(popupWindow, decorView, 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void zzapr() {
        Context context = this.context;
        if (context == null || this.zzgkf == null) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
            this.context = null;
            this.zzgkf = null;
            return;
        }
        if (this.zzgkf.isShowing()) {
            this.zzgkf.dismiss();
        }
        this.context = null;
        this.zzgkf = null;
    }

    public final void zzc(Context context, View view) {
        if (!o.f() || o.h()) {
            return;
        }
        PopupWindow zzd = zzd(context, view);
        this.zzgkf = zzd;
        if (zzd == null) {
            context = null;
        }
        this.context = context;
    }
}
