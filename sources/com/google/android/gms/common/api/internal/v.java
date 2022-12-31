package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.f;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class v {
    public final int a;

    public v(int i2) {
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status a(RemoteException remoteException) {
        StringBuilder sb = new StringBuilder();
        if (com.google.android.gms.common.util.o.b() && (remoteException instanceof TransactionTooLargeException)) {
            sb.append("TransactionTooLargeException: ");
        }
        sb.append(remoteException.getLocalizedMessage());
        return new Status(8, sb.toString());
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(f.a<?> aVar) throws DeadObjectException;

    public abstract void d(@NonNull r rVar, boolean z);

    public abstract void e(@NonNull Exception exc);
}
