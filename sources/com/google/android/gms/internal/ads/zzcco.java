package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcco {
    public static final zzcco zzgfe = new zzccq().zzaor();
    @Nullable
    private final zzafs zzgex;
    @Nullable
    private final zzafr zzgey;
    @Nullable
    private final zzagg zzgez;
    @Nullable
    private final zzagf zzgfa;
    @Nullable
    private final zzakb zzgfb;
    private final SimpleArrayMap<String, zzafy> zzgfc;
    private final SimpleArrayMap<String, zzafx> zzgfd;

    private zzcco(zzccq zzccqVar) {
        this.zzgex = zzccqVar.zzgex;
        this.zzgey = zzccqVar.zzgey;
        this.zzgez = zzccqVar.zzgez;
        this.zzgfc = new SimpleArrayMap<>(zzccqVar.zzgfc);
        this.zzgfd = new SimpleArrayMap<>(zzccqVar.zzgfd);
        this.zzgfa = zzccqVar.zzgfa;
        this.zzgfb = zzccqVar.zzgfb;
    }

    @Nullable
    public final zzafs zzaoj() {
        return this.zzgex;
    }

    @Nullable
    public final zzafr zzaok() {
        return this.zzgey;
    }

    @Nullable
    public final zzagg zzaol() {
        return this.zzgez;
    }

    @Nullable
    public final zzagf zzaom() {
        return this.zzgfa;
    }

    @Nullable
    public final zzakb zzaon() {
        return this.zzgfb;
    }

    public final ArrayList<String> zzaoo() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzgez != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzgex != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzgey != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzgfc.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzgfb != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzaop() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzgfc.size());
        for (int i2 = 0; i2 < this.zzgfc.size(); i2++) {
            arrayList.add(this.zzgfc.keyAt(i2));
        }
        return arrayList;
    }

    @Nullable
    public final zzafy zzga(String str) {
        return this.zzgfc.get(str);
    }

    @Nullable
    public final zzafx zzgb(String str) {
        return this.zzgfd.get(str);
    }
}
