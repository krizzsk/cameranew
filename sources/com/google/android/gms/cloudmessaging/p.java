package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
abstract class p<T> {
    final int a;
    final com.google.android.gms.tasks.h<T> b = new com.google.android.gms.tasks.h<>();
    final int c;

    /* renamed from: d  reason: collision with root package name */
    final Bundle f3589d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.c = i3;
        this.f3589d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzpVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.b(zzpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.b.c(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public String toString() {
        int i2 = this.c;
        int i3 = this.a;
        boolean d2 = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }
}
