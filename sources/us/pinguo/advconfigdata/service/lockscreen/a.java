package us.pinguo.advconfigdata.service.lockscreen;

import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.SPUtils;
import us.pinguo.advconfigdata.service.lockscreen.BroadcastListener;
import us.pinguo.androidsdk.PGImageSDK;
/* compiled from: LockScreenService.java */
/* loaded from: classes3.dex */
public class a implements us.pinguo.advconfigdata.service.b {
    private BroadcastListener a;
    private KeyguardManager b;
    private KeyguardManager.KeyguardLock c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9030d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9031e = false;

    /* renamed from: f  reason: collision with root package name */
    private Context f9032f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LockScreenService.java */
    /* renamed from: us.pinguo.advconfigdata.service.lockscreen.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0355a implements BroadcastListener.d {
        C0355a() {
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void a() {
            if (a.this.f9030d && !a.this.f9031e) {
                AdvConfigManager advConfigManager = AdvConfigManager.getInstance();
                Boolean bool = Boolean.FALSE;
                Boolean valueOf = Boolean.valueOf(advConfigManager.GetOpenKey("enableLockScreen", bool));
                Boolean bool2 = (Boolean) SPUtils.getMultiProcess(a.this.f9032f, "key_lockscreen_switch", bool);
                if (valueOf.booleanValue() && bool2.booleanValue()) {
                    a.this.k();
                }
            }
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void b() {
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.d
        public void c() {
            if (!a.this.f9031e && a.this.f9030d) {
                a.this.l();
                AdvConfigManager advConfigManager = AdvConfigManager.getInstance();
                Boolean bool = Boolean.TRUE;
                Boolean valueOf = Boolean.valueOf(advConfigManager.GetOpenKey("enableLockScreen", bool));
                Boolean bool2 = (Boolean) SPUtils.getMultiProcess(a.this.f9032f, "key_lockscreen_switch", bool);
                if (valueOf.booleanValue() && bool2.booleanValue()) {
                    Intent intent = new Intent("launch.lockscreen");
                    intent.addFlags(PGImageSDK.SDK_STATUS_CREATE);
                    a.this.f9032f.startActivity(intent);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LockScreenService.java */
    /* loaded from: classes3.dex */
    public class b implements BroadcastListener.b {
        b() {
        }

        @Override // us.pinguo.advconfigdata.service.lockscreen.BroadcastListener.b
        public void a(boolean z, int i2, int i3) {
            a.this.f9030d = z;
        }
    }

    public a(us.pinguo.advconfigdata.service.a aVar) {
        this.f9032f = aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void k() {
        if (this.b == null) {
            KeyguardManager keyguardManager = (KeyguardManager) this.f9032f.getSystemService("keyguard");
            this.b = keyguardManager;
            this.c = keyguardManager.newKeyguardLock("IN");
        }
        if (Build.VERSION.SDK_INT >= 16 || !this.b.isKeyguardSecure()) {
            this.c.disableKeyguard();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void l() {
        KeyguardManager.KeyguardLock keyguardLock;
        KeyguardManager keyguardManager;
        if ((Build.VERSION.SDK_INT >= 16 || (keyguardManager = this.b) == null || !keyguardManager.isKeyguardSecure()) && (keyguardLock = this.c) != null) {
            keyguardLock.reenableKeyguard();
        }
    }

    private void m() {
        if (this.a == null) {
            BroadcastListener broadcastListener = new BroadcastListener(this.f9032f);
            this.a = broadcastListener;
            broadcastListener.i(new C0355a());
            this.a.h(new b());
        }
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void a(Intent intent, int i2) {
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void b(Intent intent) {
    }

    @Override // us.pinguo.advconfigdata.service.b
    public boolean c(Intent intent) {
        return false;
    }

    @Override // us.pinguo.advconfigdata.service.b
    public int d(Intent intent, int i2, int i3) {
        return 0;
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void onCreate() {
        m();
        AdvConfigManager.getInstance().setIsInited(Boolean.TRUE);
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void onDestroy() {
        this.a.f();
        this.a = null;
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void onLowMemory() {
    }

    @Override // us.pinguo.advconfigdata.service.b
    public void onTrimMemory(int i2) {
    }
}
