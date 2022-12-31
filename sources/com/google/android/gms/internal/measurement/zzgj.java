package com.google.android.gms.internal.measurement;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.util.Comparator;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
final class zzgj implements Comparator<zzgs> {
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzgs zzgsVar, zzgs zzgsVar2) {
        zzgs zzgsVar3 = zzgsVar;
        zzgs zzgsVar4 = zzgsVar2;
        zzgi zzgiVar = new zzgi(zzgsVar3);
        zzgi zzgiVar2 = new zzgi(zzgsVar4);
        while (zzgiVar.hasNext() && zzgiVar2.hasNext()) {
            int compare = Integer.compare(zzgiVar.zza() & Draft_75.END_OF_FRAME, zzgiVar2.zza() & Draft_75.END_OF_FRAME);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgsVar3.zzc(), zzgsVar4.zzc());
    }
}
