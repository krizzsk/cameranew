package com.bytedance.sdk.openadsdk.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.bytedance.sdk.openadsdk.utils.o;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.lang.ref.WeakReference;
/* compiled from: VolumeChangeObserver.java */
/* loaded from: classes.dex */
public class g {
    private f b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private Context f1953d;

    /* renamed from: e  reason: collision with root package name */
    private AudioManager f1954e;
    private int a = -1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1955f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1956g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f1957h = -1;

    /* compiled from: VolumeChangeObserver.java */
    /* loaded from: classes.dex */
    private static class a extends BroadcastReceiver {
        private WeakReference<g> a;

        public a(g gVar) {
            this.a = new WeakReference<>(gVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f h2;
            int g2;
            VdsAgent.onBroadcastReceiver(this, context, intent);
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction()) && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                    o.b("VolumeChangeObserver", "媒体音量改变通.......");
                    g gVar = this.a.get();
                    if (gVar == null || (h2 = gVar.h()) == null || (g2 = gVar.g()) == gVar.a()) {
                        return;
                    }
                    gVar.a(g2);
                    if (g2 >= 0) {
                        h2.b(g2);
                    }
                }
            } catch (Throwable th) {
                o.a("VolumeChangeObserver", "onVolumeChangedError: ", th);
            }
        }
    }

    public g(Context context) {
        this.f1953d = context;
        this.f1954e = (AudioManager) context.getApplicationContext().getSystemService("audio");
    }

    public int a() {
        return this.f1957h;
    }

    public int b() {
        return this.a;
    }

    public boolean c() {
        if (this.f1956g) {
            this.f1956g = false;
            return true;
        }
        return false;
    }

    public int d() {
        try {
            AudioManager audioManager = this.f1954e;
            if (audioManager != null) {
                return audioManager.getStreamMaxVolume(3);
            }
            return 15;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "getMaxMusicVolumeError: ", th);
            return 15;
        }
    }

    public void e() {
        try {
            this.c = new a(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            this.f1953d.registerReceiver(this.c, intentFilter);
            this.f1955f = true;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "registerReceiverError: ", th);
        }
    }

    public void f() {
        if (this.f1955f) {
            try {
                this.f1953d.unregisterReceiver(this.c);
                this.b = null;
                this.f1955f = false;
            } catch (Throwable th) {
                o.a("VolumeChangeObserver", "unregisterReceiverError: ", th);
            }
        }
    }

    public int g() {
        try {
            AudioManager audioManager = this.f1954e;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        } catch (Throwable th) {
            o.a("VolumeChangeObserver", "getCurrentMusicVolumeError: ", th);
            return -1;
        }
    }

    public f h() {
        return this.b;
    }

    public void a(int i2) {
        this.f1957h = i2;
    }

    public void b(int i2) {
        this.a = i2;
    }

    public void a(boolean z) {
        a(z, false);
    }

    public void a(boolean z, boolean z2) {
        if (this.f1954e == null) {
            return;
        }
        int i2 = 0;
        if (z) {
            int g2 = g();
            if (g2 != 0) {
                this.a = g2;
            }
            o.b("VolumeChangeObserver", "mute set volume to 0");
            this.f1954e.setStreamVolume(3, 0, 0);
            this.f1956g = true;
            return;
        }
        int i3 = this.a;
        if (i3 == 0) {
            i3 = d() / 15;
        } else {
            if (i3 == -1) {
                if (!z2) {
                    return;
                }
                i3 = d() / 15;
            }
            o.b("VolumeChangeObserver", "not mute set volume to " + i3 + " mLastVolume=" + this.a);
            this.a = -1;
            this.f1954e.setStreamVolume(3, i3, i2);
            this.f1956g = true;
        }
        i2 = 1;
        o.b("VolumeChangeObserver", "not mute set volume to " + i3 + " mLastVolume=" + this.a);
        this.a = -1;
        this.f1954e.setStreamVolume(3, i3, i2);
        this.f1956g = true;
    }

    public void a(f fVar) {
        this.b = fVar;
    }
}
