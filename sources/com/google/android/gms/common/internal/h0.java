package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.h;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public final class h0 implements Handler.Callback {
    private final /* synthetic */ g0 a;

    private h0(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i2 = message.what;
        if (i2 == 0) {
            hashMap = this.a.f3675d;
            synchronized (hashMap) {
                h.a aVar = (h.a) message.obj;
                hashMap2 = this.a.f3675d;
                i0 i0Var = (i0) hashMap2.get(aVar);
                if (i0Var != null && i0Var.h()) {
                    if (i0Var.d()) {
                        i0Var.g("GmsClientSupervisor");
                    }
                    hashMap3 = this.a.f3675d;
                    hashMap3.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            hashMap4 = this.a.f3675d;
            synchronized (hashMap4) {
                h.a aVar2 = (h.a) message.obj;
                hashMap5 = this.a.f3675d;
                i0 i0Var2 = (i0) hashMap5.get(aVar2);
                if (i0Var2 != null && i0Var2.f() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName j2 = i0Var2.j();
                    if (j2 == null) {
                        j2 = aVar2.c();
                    }
                    if (j2 == null) {
                        String b = aVar2.b();
                        q.j(b);
                        j2 = new ComponentName(b, "unknown");
                    }
                    i0Var2.onServiceDisconnected(j2);
                }
            }
            return true;
        }
    }
}
