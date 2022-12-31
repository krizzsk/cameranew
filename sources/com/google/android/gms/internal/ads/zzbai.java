package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbai {
    public static void zza(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        new zzbah(view, onGlobalLayoutListener).attach();
    }

    public static void zza(View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        new zzbak(view, onScrollChangedListener).attach();
    }
}
