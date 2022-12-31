package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
final class o {
    @Nullable
    private final Messenger a;
    @Nullable
    private final zza b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.a = new Messenger(iBinder);
            this.b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.b = new zza(iBinder);
            this.a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zza zzaVar = this.b;
        if (zzaVar != null) {
            zzaVar.b(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
