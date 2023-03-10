package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public abstract class RemoteCreator<T> {
    private final String zza;
    private T zzb;

    /* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
    /* loaded from: classes2.dex */
    public static class RemoteCreatorException extends Exception {
        public RemoteCreatorException(String str) {
            super(str);
        }

        public RemoteCreatorException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RemoteCreator(String str) {
        this.zza = str;
    }

    protected abstract T getRemoteCreator(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    public final T getRemoteCreatorInstance(Context context) throws RemoteCreatorException {
        if (this.zzb == null) {
            q.j(context);
            Context d2 = com.google.android.gms.common.c.d(context);
            if (d2 != null) {
                try {
                    this.zzb = getRemoteCreator((IBinder) d2.getClassLoader().loadClass(this.zza).newInstance());
                } catch (ClassNotFoundException e2) {
                    throw new RemoteCreatorException("Could not load creator class.", e2);
                } catch (IllegalAccessException e3) {
                    throw new RemoteCreatorException("Could not access creator.", e3);
                } catch (InstantiationException e4) {
                    throw new RemoteCreatorException("Could not instantiate creator.", e4);
                }
            } else {
                throw new RemoteCreatorException("Could not get remote context.");
            }
        }
        return this.zzb;
    }
}
