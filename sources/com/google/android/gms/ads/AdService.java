package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzanf;
import com.google.android.gms.internal.ads.zzazk;
import com.google.android.gms.internal.ads.zzwr;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        try {
            zzwr.zzqo().zzb(this, new zzanf()).zzc(intent);
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
            sb.append("RemoteException calling handleNotificationIntent: ");
            sb.append(valueOf);
            zzazk.zzev(sb.toString());
        }
    }
}
