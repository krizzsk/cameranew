package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbeb;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzi {
    public final Context context;
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdsi;

    public zzi(zzbeb zzbebVar) throws zzg {
        this.zzdsi = zzbebVar.getLayoutParams();
        ViewParent parent = zzbebVar.getParent();
        this.context = zzbebVar.zzacs();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            this.parent = viewGroup;
            this.index = viewGroup.indexOfChild(zzbebVar.getView());
            viewGroup.removeView(zzbebVar.getView());
            zzbebVar.zzay(true);
            return;
        }
        throw new zzg("Could not get the parent of the WebView for an overlay.");
    }
}
