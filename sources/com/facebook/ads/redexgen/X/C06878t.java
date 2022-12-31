package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
/* renamed from: com.facebook.ads.redexgen.X.8t  reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C06878t implements SensorEventListener {
    public C06878t() {
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        C06898v.A0D(sensorEvent.values);
        C06898v.A04();
    }
}
