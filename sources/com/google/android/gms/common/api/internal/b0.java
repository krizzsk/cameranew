package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.internal.f;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
final class b0 implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ f.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(f.c cVar, ConnectionResult connectionResult) {
        this.b = cVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b bVar;
        a.f fVar;
        a.f fVar2;
        a.f fVar3;
        Map map = f.this.f3612i;
        bVar = this.b.b;
        f.a aVar = (f.a) map.get(bVar);
        if (aVar == null) {
            return;
        }
        if (this.a.U()) {
            this.b.f3626e = true;
            fVar = this.b.a;
            if (fVar.requiresSignIn()) {
                this.b.g();
                return;
            }
            try {
                fVar2 = this.b.a;
                fVar3 = this.b.a;
                fVar2.getRemoteService(null, fVar3.getScopesForConnectionlessNonSignIn());
                return;
            } catch (SecurityException e2) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                aVar.onConnectionFailed(new ConnectionResult(10));
                return;
            }
        }
        aVar.onConnectionFailed(this.a);
    }
}
