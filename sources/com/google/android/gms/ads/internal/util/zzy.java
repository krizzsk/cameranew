package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@TargetApi(19)
/* loaded from: classes2.dex */
public class zzy extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzv, com.google.android.gms.ads.internal.util.zzr
    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Override // com.google.android.gms.ads.internal.util.zzr
    public final ViewGroup.LayoutParams zzzd() {
        return new ViewGroup.LayoutParams(-1, -1);
    }
}
