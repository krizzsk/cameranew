package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class q0 extends zap {
    private final /* synthetic */ o0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(o0 o0Var, Looper looper) {
        super(looper);
        this.a = o0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        o0 o0Var;
        o0 o0Var2;
        o0 o0Var3;
        int i2 = message.what;
        if (i2 != 0) {
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(70);
                sb.append("TransformationResultHandler received unknown message type: ");
                sb.append(i2);
                Log.e("TransformedResultImpl", sb.toString());
                return;
            }
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
        com.google.android.gms.common.api.e<?> eVar = (com.google.android.gms.common.api.e) message.obj;
        obj = this.a.f3634e;
        synchronized (obj) {
            if (eVar == null) {
                o0Var3 = this.a.b;
                o0Var3.k(new Status(13, "Transform returned null"));
            } else if (eVar instanceof h0) {
                o0Var2 = this.a.b;
                o0Var2.k(((h0) eVar).a());
            } else {
                o0Var = this.a.b;
                o0Var.c(eVar);
            }
        }
    }
}
