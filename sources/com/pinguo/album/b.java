package com.pinguo.album;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.Display;
import android.view.WindowManager;
/* compiled from: EyePosition.java */
/* loaded from: classes3.dex */
public class b {
    private static final float m;
    private static final float n;
    private static final float o;
    private Context a;
    private InterfaceC0230b b;
    private Display c;

    /* renamed from: d  reason: collision with root package name */
    private float f6006d;

    /* renamed from: e  reason: collision with root package name */
    private float f6007e;

    /* renamed from: f  reason: collision with root package name */
    private float f6008f;

    /* renamed from: g  reason: collision with root package name */
    private final float f6009g;

    /* renamed from: h  reason: collision with root package name */
    private final float f6010h;

    /* renamed from: j  reason: collision with root package name */
    private Sensor f6012j;

    /* renamed from: i  reason: collision with root package name */
    private long f6011i = -1;

    /* renamed from: k  reason: collision with root package name */
    private c f6013k = new c();

    /* renamed from: l  reason: collision with root package name */
    private int f6014l = 0;

    /* compiled from: EyePosition.java */
    /* renamed from: com.pinguo.album.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0230b {
        void e(float f2, float f3, float f4);
    }

    /* compiled from: EyePosition.java */
    /* loaded from: classes3.dex */
    private class c implements SensorEventListener {
        private c() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                b bVar = b.this;
                float[] fArr = sensorEvent.values;
                bVar.c(fArr[0], fArr[1], fArr[2]);
            } else if (type != 4) {
            } else {
                b bVar2 = b.this;
                float[] fArr2 = sensorEvent.values;
                bVar2.d(fArr2[0], fArr2[1], fArr2[2]);
            }
        }
    }

    static {
        float radians = (float) Math.toRadians(10.0d);
        m = radians;
        n = (float) Math.cos(radians);
        o = (float) Math.sin(radians);
    }

    public b(Context context, InterfaceC0230b interfaceC0230b) {
        this.a = context;
        this.b = interfaceC0230b;
        float m2 = com.pinguo.album.j.c.m(context, 0.3f);
        this.f6009g = m2;
        this.f6010h = m2 * 0.5f;
        this.c = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(float f2, float f3, float f4) {
        float f5;
        int rotation = this.c.getRotation();
        if (rotation != 1) {
            if (rotation == 2) {
                f2 = -f2;
                f3 = -f3;
            } else if (rotation == 3) {
                f2 = -f2;
            }
            float f6 = (f2 * f2) + (f3 * f3) + (f4 * f4);
            float f7 = (-f3) / f6;
            float f8 = f7 * f2;
            float f9 = (f7 * f3) - 1.0f;
            float f10 = f7 * f4;
            float sqrt = (float) Math.sqrt((f8 * f8) + (f9 * f9) + (f10 * f10));
            float sqrt2 = (float) Math.sqrt(f6);
            float f11 = n;
            float f12 = o;
            float f13 = (((f2 * f11) / sqrt2) + ((f8 * f12) / sqrt)) * this.f6009g;
            float f14 = this.f6010h;
            this.f6006d = com.pinguo.album.j.a.d(f13, -f14, f14);
            float f15 = (((f3 * f11) / sqrt2) + ((f9 * f12) / sqrt)) * this.f6009g;
            float f16 = this.f6010h;
            this.f6007e = -com.pinguo.album.j.a.d(f15, -f16, f16);
            float f17 = this.f6009g;
            float f18 = this.f6006d;
            float f19 = -((float) Math.sqrt(((f17 * f17) - (f18 * f18)) - (f5 * f5)));
            this.f6008f = f19;
            this.b.e(this.f6006d, this.f6007e, f19);
        }
        f3 = -f3;
        float f20 = f3;
        f3 = f2;
        f2 = f20;
        float f62 = (f2 * f2) + (f3 * f3) + (f4 * f4);
        float f72 = (-f3) / f62;
        float f82 = f72 * f2;
        float f92 = (f72 * f3) - 1.0f;
        float f102 = f72 * f4;
        float sqrt3 = (float) Math.sqrt((f82 * f82) + (f92 * f92) + (f102 * f102));
        float sqrt22 = (float) Math.sqrt(f62);
        float f112 = n;
        float f122 = o;
        float f132 = (((f2 * f112) / sqrt22) + ((f82 * f122) / sqrt3)) * this.f6009g;
        float f142 = this.f6010h;
        this.f6006d = com.pinguo.album.j.a.d(f132, -f142, f142);
        float f152 = (((f3 * f112) / sqrt22) + ((f92 * f122) / sqrt3)) * this.f6009g;
        float f162 = this.f6010h;
        this.f6007e = -com.pinguo.album.j.a.d(f152, -f162, f162);
        float f172 = this.f6009g;
        float f182 = this.f6006d;
        float f192 = -((float) Math.sqrt(((f172 * f172) - (f182 * f182)) - (f5 * f5)));
        this.f6008f = f192;
        this.b.e(this.f6006d, this.f6007e, f192);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f2, float f3, float f4) {
        float f5;
        float f6;
        float f7;
        float d2;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        float f8 = (f2 > 0.0f ? f2 : -f2) + (f3 > 0.0f ? f3 : -f3);
        if (f8 >= 0.15f && f8 <= 10.0f && this.f6014l <= 0) {
            float f9 = (((float) (elapsedRealtime - this.f6011i)) / 1000.0f) * this.f6009g * (-this.f6008f);
            this.f6011i = elapsedRealtime;
            float f10 = -f3;
            float f11 = -f2;
            int rotation = this.c.getRotation();
            if (rotation == 1) {
                f2 = f11;
            } else if (rotation == 2) {
                f3 = f2;
                f2 = f3;
            } else if (rotation != 3) {
                f2 = f10;
                f3 = f11;
            } else {
                f3 = f10;
            }
            float f12 = this.f6006d;
            float f13 = this.f6010h;
            this.f6006d = com.pinguo.album.j.a.d((float) (f12 + ((f2 * f9) / Math.hypot(this.f6008f, f12))), -f13, f13) * 0.995f;
            float f14 = this.f6007e;
            float f15 = this.f6010h;
            this.f6007e = com.pinguo.album.j.a.d((float) (f14 + ((f3 * f9) / Math.hypot(this.f6008f, f14))), -f15, f15) * 0.995f;
            float f16 = this.f6009g;
            float f17 = this.f6006d;
            float f18 = -((float) Math.sqrt(((f16 * f16) - (f17 * f17)) - (d2 * d2)));
            this.f6008f = f18;
            this.b.e(this.f6006d, this.f6007e, f18);
            return;
        }
        this.f6014l--;
        this.f6011i = elapsedRealtime;
        float f19 = this.f6009g / 20.0f;
        float f20 = this.f6006d;
        if (f20 <= f19) {
            float f21 = -f19;
            if (f20 >= f21) {
                float f22 = this.f6007e;
                if (f22 <= f19 && f22 >= f21) {
                    return;
                }
            }
        }
        this.f6006d = f20 * 0.995f;
        this.f6007e = this.f6007e * 0.995f;
        float f23 = (float) (-Math.sqrt(((f5 * f5) - (f6 * f6)) - (f7 * f7)));
        this.f6008f = f23;
        this.b.e(this.f6006d, this.f6007e, f23);
    }

    public void e() {
        if (this.f6012j != null) {
            ((SensorManager) this.a.getSystemService("sensor")).unregisterListener(this.f6013k);
        }
    }

    public void f() {
        this.f6011i = -1L;
        this.f6007e = 0.0f;
        this.f6006d = 0.0f;
        float f2 = -this.f6009g;
        this.f6008f = f2;
        this.b.e(0.0f, 0.0f, f2);
    }

    public void g() {
        if (this.f6012j != null) {
            ((SensorManager) this.a.getSystemService("sensor")).registerListener(this.f6013k, this.f6012j, 1);
        }
        this.f6011i = -1L;
        this.f6014l = 15;
        this.f6007e = 0.0f;
        this.f6006d = 0.0f;
        float f2 = -this.f6009g;
        this.f6008f = f2;
        this.b.e(0.0f, 0.0f, f2);
    }
}
