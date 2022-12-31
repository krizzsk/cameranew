package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* renamed from: com.facebook.ads.redexgen.X.8u  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06888u implements SensorEventListener {
    public C06888u() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] unused = C06898v.A0A = sensorEvent.values;
        C06898v.A07();
    }
}
