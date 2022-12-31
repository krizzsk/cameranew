package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.j;
/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes2.dex */
public class a extends j.a {
    public static Account y0(j jVar) {
        Account account;
        if (jVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = jVar.zza();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
            q.j(account);
            return account;
        }
        account = null;
        q.j(account);
        return account;
    }
}
