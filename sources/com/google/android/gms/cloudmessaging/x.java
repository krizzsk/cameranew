package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zze;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class x extends zze {
    private final /* synthetic */ Rpc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Rpc rpc, Looper looper) {
        super(looper);
        this.a = rpc;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.a.g(message);
    }
}
