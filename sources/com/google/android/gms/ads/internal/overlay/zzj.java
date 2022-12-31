package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzad;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzj extends RelativeLayout {
    private zzad a;
    boolean b;

    public zzj(Context context, String str, String str2) {
        super(context);
        zzad zzadVar = new zzad(context, str);
        this.a = zzadVar;
        zzadVar.zzu(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.b) {
            return false;
        }
        this.a.zzd(motionEvent);
        return false;
    }
}
