package com.google.android.gms.internal.ads;

import android.view.View;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzcdt implements zzaif {
    static final zzaif zzdhv = new zzcdt();

    private zzcdt() {
    }

    @Override // com.google.android.gms.internal.ads.zzaif
    public final void zza(Object obj, Map map) {
        zzazk.zzdy("Show native ad policy validator overlay.");
        View view = ((zzbeb) obj).getView();
        view.setVisibility(0);
        VdsAgent.onSetViewVisibility(view, 0);
    }
}
