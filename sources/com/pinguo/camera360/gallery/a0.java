package com.pinguo.camera360.gallery;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.ArrayList;
/* compiled from: OrientationManager.java */
/* loaded from: classes3.dex */
public class a0 implements com.pinguo.album.common.c {
    private Activity a;
    private b c;

    /* renamed from: d  reason: collision with root package name */
    private int f6307d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6308e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f6309f = 0;
    private ArrayList<a> b = new ArrayList<>();

    /* compiled from: OrientationManager.java */
    /* loaded from: classes3.dex */
    public interface a {
        void g();
    }

    /* compiled from: OrientationManager.java */
    /* loaded from: classes3.dex */
    private class b extends OrientationEventListener {
        public b(Context context) {
            super(context);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i2) {
            if (i2 == -1) {
                return;
            }
            a0 a0Var = a0.this;
            a0Var.f6307d = a0.n(i2, a0Var.f6307d);
            if (a0.this.f6308e) {
                a0.this.o();
            }
        }
    }

    public a0(Activity activity) {
        this.a = activity;
        this.c = new b(activity);
    }

    private static int i(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 1) {
            if (rotation != 2) {
                if (rotation != 3) {
                    return 0;
                }
                return BaseBlurEffect.ROTATION_270;
            }
            return BaseBlurEffect.ROTATION_180;
        }
        return 90;
    }

    private void j() {
        synchronized (this.b) {
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.b.get(i2).g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i2, int i3) {
        boolean z = true;
        if (i3 != -1) {
            int abs = Math.abs(i2 - i3);
            if (Math.min(abs, 360 - abs) < 50) {
                z = false;
            }
        }
        return z ? (((i2 + 45) / 90) * 90) % BaseBlurEffect.ROTATION_360 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        int i2;
        int i3 = this.f6307d;
        if (i3 == -1 || this.f6309f == (i2 = (i3 + i(this.a)) % BaseBlurEffect.ROTATION_360)) {
            return;
        }
        this.f6309f = i2;
        j();
    }

    @Override // com.pinguo.album.common.c
    public int a() {
        return this.f6309f;
    }

    @Override // com.pinguo.album.common.c
    public int b() {
        return i(this.a);
    }

    public void h(a aVar) {
        synchronized (this.b) {
            this.b.add(aVar);
        }
    }

    public void k() {
        this.c.disable();
    }

    public void l(a aVar) {
        synchronized (this.b) {
            this.b.remove(aVar);
        }
    }

    public void m() {
        Settings.System.getInt(this.a.getContentResolver(), "accelerometer_rotation", 0);
        this.c.enable();
    }
}
