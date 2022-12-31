package us.pinguo.advconfigdata.service.lockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.growingio.android.sdk.autoburry.VdsAgent;
/* loaded from: classes3.dex */
public class BroadcastListener {
    private final Context a;
    private d c;

    /* renamed from: d  reason: collision with root package name */
    private b f9027d;

    /* renamed from: e  reason: collision with root package name */
    private e f9028e;

    /* renamed from: f  reason: collision with root package name */
    private int f9029f = 0;
    private final c b = new c();

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        private String a;

        private c() {
            this.a = null;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            VdsAgent.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            this.a = action;
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                if (BroadcastListener.this.c == null) {
                    return;
                }
                BroadcastListener.this.c.a();
            } else if ("android.intent.action.SCREEN_OFF".equals(this.a)) {
                if (BroadcastListener.this.c == null) {
                    return;
                }
                BroadcastListener.this.c.c();
            } else if ("android.intent.action.USER_PRESENT".equals(this.a)) {
                if (BroadcastListener.this.c == null) {
                    return;
                }
                BroadcastListener.this.c.b();
            } else if ("android.intent.action.BATTERY_CHANGED".equals(this.a)) {
                if (BroadcastListener.this.f9027d == null) {
                    return;
                }
                int intExtra = intent.getIntExtra("status", -1);
                boolean z = true;
                boolean z2 = intExtra == 2 || intExtra == 5;
                BroadcastListener.this.f9029f = intent.getIntExtra("plugged", -1);
                boolean z3 = BroadcastListener.this.f9029f == 2;
                boolean z4 = BroadcastListener.this.f9029f == 1;
                if (!z2 || (!z3 && !z4)) {
                    z = false;
                }
                BroadcastListener.this.f9027d.a(z, intent.getIntExtra("level", 0), BroadcastListener.this.f9029f);
            } else if (!"android.intent.action.TIME_TICK".equals(this.a) || BroadcastListener.this.f9028e == null) {
            } else {
                BroadcastListener.this.f9028e.a();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();
    }

    public BroadcastListener(Context context) {
        this.a = context;
        j();
    }

    private void g() {
        if (((PowerManager) this.a.getSystemService("power")).isScreenOn()) {
            d dVar = this.c;
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        d dVar2 = this.c;
        if (dVar2 != null) {
            dVar2.c();
        }
    }

    private void j() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.NEW_OUTGOING_CALL");
        intentFilter.addAction("android.intent.action.TIME_TICK");
        this.a.registerReceiver(this.b, intentFilter);
    }

    private void k() {
        this.a.unregisterReceiver(this.b);
    }

    public void f() {
        k();
    }

    public void h(b bVar) {
        this.f9027d = bVar;
    }

    public void i(d dVar) {
        this.c = dVar;
        g();
    }
}
