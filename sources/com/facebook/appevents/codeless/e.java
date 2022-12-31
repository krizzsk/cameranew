package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* compiled from: ViewIndexingTrigger.java */
/* loaded from: classes.dex */
class e implements SensorEventListener {
    private a a;

    /* compiled from: ViewIndexingTrigger.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public void a(a aVar) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            this.a = aVar;
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (com.facebook.internal.instrument.e.a.c(this)) {
            return;
        }
        try {
            if (this.a != null) {
                float[] fArr = sensorEvent.values;
                double d2 = fArr[0] / 9.80665f;
                double d3 = fArr[1] / 9.80665f;
                double d4 = fArr[2] / 9.80665f;
                if (Math.sqrt((d2 * d2) + (d3 * d3) + (d4 * d4)) > 2.299999952316284d) {
                    this.a.a();
                }
            }
        } catch (Throwable th) {
            com.facebook.internal.instrument.e.a.b(th, this);
        }
    }
}
