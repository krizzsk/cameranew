package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzei;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class d implements View.OnTouchListener {
    private final /* synthetic */ zzl a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(zzl zzlVar) {
        this.a = zzlVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        zzei zzeiVar;
        zzei zzeiVar2;
        zzeiVar = this.a.f3514h;
        if (zzeiVar != null) {
            zzeiVar2 = this.a.f3514h;
            zzeiVar2.zza(motionEvent);
            return false;
        }
        return false;
    }
}
