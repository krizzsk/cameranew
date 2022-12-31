package com.ironsource.sdk.service.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.growingio.android.sdk.autoburry.VdsAgent;
import org.json.JSONObject;
import us.pinguo.inspire.module.feeds.model.PortalFollowFeeds;
/* compiled from: BroadcastReceiverStrategy.java */
/* loaded from: classes2.dex */
public class a implements c {
    private final d a;
    private BroadcastReceiver b = new C0220a();

    /* compiled from: BroadcastReceiverStrategy.java */
    /* renamed from: com.ironsource.sdk.service.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0220a extends BroadcastReceiver {
        C0220a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            String b = d.e.c.b.b(context);
            if (b.equals(PortalFollowFeeds.TYPE_NONE)) {
                a.this.a.a();
            } else {
                a.this.a.c(b, new JSONObject());
            }
        }
    }

    public a(d dVar) {
        this.a = dVar;
    }

    @Override // com.ironsource.sdk.service.b.c
    public JSONObject a(Context context) {
        return new JSONObject();
    }

    @Override // com.ironsource.sdk.service.b.c
    public void b(Context context) {
        try {
            context.registerReceiver(this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.sdk.service.b.c
    public void c(Context context) {
        try {
            context.unregisterReceiver(this.b);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e2);
        }
    }

    @Override // com.ironsource.sdk.service.b.c
    public void release() {
        this.b = null;
    }
}
