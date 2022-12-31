package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzasm {
    @Nonnull
    private final View zzaat;
    @Nullable
    private final Map<String, WeakReference<View>> zzdto;
    @Nullable
    private final zzaxy zzdtp;

    public zzasm(zzasr zzasrVar) {
        View view;
        Map<String, WeakReference<View>> map;
        View view2;
        view = zzasrVar.zzaat;
        this.zzaat = view;
        map = zzasrVar.zzdto;
        this.zzdto = map;
        view2 = zzasrVar.zzaat;
        zzaxy zzp = zzask.zzp(view2.getContext());
        this.zzdtp = zzp;
        if (zzp == null || map == null || map.isEmpty()) {
            return;
        }
        try {
            zzp.zza(new zzasq(d.z0(view).asBinder(), d.z0(map).asBinder()));
        } catch (RemoteException unused) {
            zzazk.zzev("Failed to call remote method.");
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzaxy zzaxyVar = this.zzdtp;
        if (zzaxyVar == null) {
            zzazk.zzdy("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzaxyVar.zzan(d.z0(motionEvent));
        } catch (RemoteException unused) {
            zzazk.zzev("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdtp == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdtp.zzb(new ArrayList(Arrays.asList(uri)), d.z0(this.zzaat), new zzaso(this, updateClickUrlCallback));
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdtp == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdtp.zza(list, d.z0(this.zzaat), new zzasp(this, updateImpressionUrlsCallback));
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}
