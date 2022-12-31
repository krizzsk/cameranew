package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcw;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzcy;
import com.google.android.gms.internal.measurement.zzcz;
import com.google.android.gms.internal.measurement.zzdp;
import com.google.android.gms.internal.measurement.zzdq;
import com.google.android.gms.internal.measurement.zzdr;
import com.google.android.gms.internal.measurement.zzds;
import com.google.android.gms.internal.measurement.zzlo;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class x9 {
    private String a;
    private boolean b;
    private zzdq c;

    /* renamed from: d  reason: collision with root package name */
    private BitSet f3986d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f3987e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, Long> f3988f;

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, List<Long>> f3989g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ ca f3990h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x9(ca caVar, String str, zzdq zzdqVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, w9 w9Var) {
        this.f3990h = caVar;
        this.a = str;
        this.f3986d = bitSet;
        this.f3987e = bitSet2;
        this.f3988f = map;
        this.f3989g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f3989g.put(num, arrayList);
        }
        this.b = false;
        this.c = zzdqVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ x9(ca caVar, String str, w9 w9Var) {
        this.f3990h = caVar;
        this.a = str;
        this.b = true;
        this.f3986d = new BitSet();
        this.f3987e = new BitSet();
        this.f3988f = new ArrayMap();
        this.f3989g = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BitSet c(x9 x9Var) {
        return x9Var.f3986d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(@NonNull aa aaVar) {
        int a = aaVar.a();
        Boolean bool = aaVar.c;
        if (bool != null) {
            this.f3987e.set(a, bool.booleanValue());
        }
        Boolean bool2 = aaVar.f3750d;
        if (bool2 != null) {
            this.f3986d.set(a, bool2.booleanValue());
        }
        if (aaVar.f3751e != null) {
            Map<Integer, Long> map = this.f3988f;
            Integer valueOf = Integer.valueOf(a);
            Long l2 = map.get(valueOf);
            long longValue = aaVar.f3751e.longValue() / 1000;
            if (l2 == null || longValue > l2.longValue()) {
                this.f3988f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (aaVar.f3752f != null) {
            Map<Integer, List<Long>> map2 = this.f3989g;
            Integer valueOf2 = Integer.valueOf(a);
            List<Long> list = map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList<>();
                this.f3989g.put(valueOf2, list);
            }
            if (aaVar.b()) {
                list.clear();
            }
            zzlo.zzb();
            e x = this.f3990h.a.x();
            String str = this.a;
            w2<Boolean> w2Var = x2.b0;
            if (x.u(str, w2Var) && aaVar.c()) {
                list.clear();
            }
            zzlo.zzb();
            if (this.f3990h.a.x().u(this.a, w2Var)) {
                Long valueOf3 = Long.valueOf(aaVar.f3752f.longValue() / 1000);
                if (list.contains(valueOf3)) {
                    return;
                }
                list.add(valueOf3);
                return;
            }
            list.add(Long.valueOf(aaVar.f3752f.longValue() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final zzcx b(int i2) {
        ArrayList arrayList;
        List list;
        zzcw zzh = zzcx.zzh();
        zzh.zza(i2);
        zzh.zzd(this.b);
        zzdq zzdqVar = this.c;
        if (zzdqVar != null) {
            zzh.zzc(zzdqVar);
        }
        zzdp zzk = zzdq.zzk();
        zzk.zzc(j9.B(this.f3986d));
        zzk.zza(j9.B(this.f3987e));
        Map<Integer, Long> map = this.f3988f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f3988f.keySet()) {
                int intValue = num.intValue();
                Long l2 = this.f3988f.get(Integer.valueOf(intValue));
                if (l2 != null) {
                    zzcy zze = zzcz.zze();
                    zze.zza(intValue);
                    zze.zzb(l2.longValue());
                    arrayList2.add(zze.zzaA());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzk.zze(arrayList);
        }
        Map<Integer, List<Long>> map2 = this.f3989g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f3989g.keySet()) {
                zzdr zzf = zzds.zzf();
                zzf.zza(num2.intValue());
                List<Long> list2 = this.f3989g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzf.zzb(list2);
                }
                arrayList3.add((zzds) zzf.zzaA());
            }
            list = arrayList3;
        }
        zzk.zzg(list);
        zzh.zzb(zzk);
        return zzh.zzaA();
    }
}
