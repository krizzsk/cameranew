package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeni {
    private final ArrayDeque<zzejr> zziuc;

    private zzeni() {
        this.zziuc = new ArrayDeque<>();
    }

    public static /* synthetic */ zzejr zza(zzeni zzeniVar, zzejr zzejrVar, zzejr zzejrVar2) {
        return zzeniVar.zzc(zzejrVar, zzejrVar2);
    }

    private final void zzam(zzejr zzejrVar) {
        zzejr zzejrVar2;
        while (!zzejrVar.zzbgn()) {
            if (zzejrVar instanceof zzeng) {
                zzeng zzengVar = (zzeng) zzejrVar;
                zzejrVar2 = zzengVar.zzitw;
                zzam(zzejrVar2);
                zzejrVar = zzengVar.zzitx;
            } else {
                String valueOf = String.valueOf(zzejrVar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzhs = zzhs(zzejrVar.size());
        int zzhr = zzeng.zzhr(zzhs + 1);
        if (!this.zziuc.isEmpty() && this.zziuc.peek().size() < zzhr) {
            int zzhr2 = zzeng.zzhr(zzhs);
            zzejr pop = this.zziuc.pop();
            while (!this.zziuc.isEmpty() && this.zziuc.peek().size() < zzhr2) {
                pop = new zzeng(this.zziuc.pop(), pop, null);
            }
            zzeng zzengVar2 = new zzeng(pop, zzejrVar, null);
            while (!this.zziuc.isEmpty()) {
                if (this.zziuc.peek().size() >= zzeng.zzhr(zzhs(zzengVar2.size()) + 1)) {
                    break;
                }
                zzengVar2 = new zzeng(this.zziuc.pop(), zzengVar2, null);
            }
            this.zziuc.push(zzengVar2);
            return;
        }
        this.zziuc.push(zzejrVar);
    }

    public final zzejr zzc(zzejr zzejrVar, zzejr zzejrVar2) {
        zzam(zzejrVar);
        zzam(zzejrVar2);
        zzejr pop = this.zziuc.pop();
        while (!this.zziuc.isEmpty()) {
            pop = new zzeng(this.zziuc.pop(), pop, null);
        }
        return pop;
    }

    private static int zzhs(int i2) {
        int binarySearch = Arrays.binarySearch(zzeng.zzitu, i2);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    public /* synthetic */ zzeni(zzenf zzenfVar) {
        this();
    }
}
