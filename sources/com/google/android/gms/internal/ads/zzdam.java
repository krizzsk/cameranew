package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdam implements zzdfi<zzdan> {
    private final Context context;
    private final zzdnp zzfwy;
    private final zzdzv zzhah;
    private final View zzhai;

    public zzdam(zzdzv zzdzvVar, Context context, zzdnp zzdnpVar, @Nullable ViewGroup viewGroup) {
        this.zzhah = zzdzvVar;
        this.context = context;
        this.zzfwy = zzdnpVar;
        this.zzhai = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdan> zzasy() {
        return this.zzhah.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdap
            private final zzdam zzhal;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhal = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhal.zzasz();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdan zzasz() throws Exception {
        Context context = this.context;
        zzvs zzvsVar = this.zzfwy.zzbpo;
        ArrayList arrayList = new ArrayList();
        View view = this.zzhai;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzdan(context, zzvsVar, arrayList);
    }
}
