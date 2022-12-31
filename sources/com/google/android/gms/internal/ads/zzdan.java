package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdan implements zzdfj<Bundle> {
    private final Context context;
    private final zzvs zzbpo;
    private final List<Parcelable> zzhaj;

    public zzdan(Context context, zzvs zzvsVar, List<Parcelable> list) {
        this.context = context;
        this.zzbpo = zzvsVar;
        this.zzhaj = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdfj
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (zzadk.zzdec.get().booleanValue()) {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.ads.internal.zzr.zzkr();
            bundle3.putString("activity", com.google.android.gms.ads.internal.util.zzj.zzap(this.context));
            Bundle bundle4 = new Bundle();
            bundle4.putInt("width", this.zzbpo.width);
            bundle4.putInt("height", this.zzbpo.height);
            bundle3.putBundle(BigAlbumStore.PhotoColumns.SIZE, bundle4);
            if (this.zzhaj.size() > 0) {
                List<Parcelable> list = this.zzhaj;
                bundle3.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle2.putBundle("view_hierarchy", bundle3);
        }
    }
}
