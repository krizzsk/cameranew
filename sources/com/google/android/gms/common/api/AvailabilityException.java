package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {
    private final ArrayMap<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> zaba;

    public AvailabilityException(ArrayMap<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> arrayMap) {
        this.zaba = arrayMap;
    }

    @NonNull
    public ConnectionResult getConnectionResult(c<? extends a.d> cVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> a = cVar.a();
        boolean z = this.zaba.get(a) != null;
        String a2 = a.a();
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 58);
        sb.append("The given API (");
        sb.append(a2);
        sb.append(") was not part of the availability request.");
        q.b(z, sb.toString());
        return this.zaba.get(a);
    }

    @Override // java.lang.Throwable
    @NonNull
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (com.google.android.gms.common.api.internal.b<?> bVar : this.zaba.keySet()) {
            ConnectionResult connectionResult = this.zaba.get(bVar);
            if (connectionResult.U()) {
                z = false;
            }
            String a = bVar.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final ArrayMap<com.google.android.gms.common.api.internal.b<?>, ConnectionResult> zaj() {
        return this.zaba;
    }

    @NonNull
    public ConnectionResult getConnectionResult(d<? extends a.d> dVar) {
        com.google.android.gms.common.api.internal.b<? extends a.d> a = dVar.a();
        boolean z = this.zaba.get(a) != null;
        String a2 = a.a();
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 58);
        sb.append("The given API (");
        sb.append(a2);
        sb.append(") was not part of the availability request.");
        q.b(z, sb.toString());
        return this.zaba.get(a);
    }
}
