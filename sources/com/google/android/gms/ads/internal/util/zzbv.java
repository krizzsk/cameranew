package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.internal.ads.zzabp;
import com.google.android.gms.internal.ads.zzwr;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzbv {

    /* renamed from: d  reason: collision with root package name */
    private boolean f3481d;

    /* renamed from: e  reason: collision with root package name */
    private Context f3482e;
    private boolean c = false;
    @GuardedBy("this")
    private final Map<BroadcastReceiver, IntentFilter> b = new WeakHashMap();
    @GuardedBy("this")
    private final BroadcastReceiver a = new r(this);

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void b(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<BroadcastReceiver, IntentFilter> entry : this.b.entrySet()) {
            if (entry.getValue().hasAction(intent.getAction())) {
                arrayList.add(entry.getKey());
            }
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((BroadcastReceiver) obj).onReceive(context, intent);
        }
    }

    public final synchronized void initialize(Context context) {
        if (this.c) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        this.f3482e = applicationContext;
        if (applicationContext == null) {
            this.f3482e = context;
        }
        zzabp.initialize(this.f3482e);
        this.f3481d = ((Boolean) zzwr.zzqr().zzd(zzabp.zzcth)).booleanValue();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f3482e.registerReceiver(this.a, intentFilter);
        this.c = true;
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f3481d) {
            this.b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final synchronized void zza(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f3481d) {
            this.b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }
}
