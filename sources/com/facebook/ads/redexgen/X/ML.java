package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.widget.Toast;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: assets/audience_network.dex */
public final class ML implements SensorEventListener {
    public static byte[] A0A;
    public long A04;
    public long A05;
    public long A06;
    @Nullable
    public SensorManager A07;
    public final XT A08;
    public int A03 = 0;
    public float A00 = -1.0f;
    public float A01 = -1.0f;
    public float A02 = -1.0f;
    public final Set<MK> A09 = new CopyOnWriteArraySet();

    static {
        A02();
    }

    public static String A00(int i2, int i3, int i4) {
        byte[] copyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i3);
        for (int i5 = 0; i5 < copyOfRange.length; i5++) {
            copyOfRange[i5] = (byte) ((copyOfRange[i5] ^ i4) ^ 79);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A0A = new byte[]{119, 65, 74, 87, 75, 86, 87, 4, 74, 75, 80, 4, 87, 81, 84, 84, 75, 86, 80, 65, 64, 17, 42, 35, 41, 43, 44, 37, 98, 44, 45, 54, 98, 49, 55, 50, 50, 45, 48, 54, 39, 38, 21, 3, 8, 21, 9, 20};
    }

    public ML(XT xt) {
        this.A08 = xt;
    }

    private void A01() {
        SensorManager sensorManager;
        this.A07 = (SensorManager) this.A08.getSystemService(A00(42, 6, 41));
        if (this.A07 == null) {
            Toast.makeText(this.A08, A00(0, 21, 107), 1).show();
        }
        boolean z = false;
        try {
            z = this.A07.registerListener(this, this.A07.getDefaultSensor(1), 3);
        } catch (Exception unused) {
            Toast.makeText(this.A08, A00(21, 21, 13), 1).show();
        }
        if (!z && (sensorManager = this.A07) != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public final void A03(MK mk) {
        if (this.A09.isEmpty()) {
            A01();
        } else if (this.A09.contains(mk)) {
            return;
        }
        this.A09.add(mk);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != 1) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long now = this.A04;
        if (elapsedRealtime - now > 500) {
            this.A03 = 0;
        }
        long j2 = this.A06;
        if (elapsedRealtime - j2 > 100) {
            long now2 = elapsedRealtime - j2;
            float speed = (Math.abs(((((sensorEvent.values[0] + sensorEvent.values[1]) + sensorEvent.values[2]) - this.A00) - this.A01) - this.A02) / ((float) now2)) * 10000.0f;
            if (speed > 800.0f) {
                int i2 = this.A03 + 1;
                this.A03 = i2;
                if (i2 >= 3) {
                    long now3 = this.A05;
                    if (elapsedRealtime - now3 > 1000) {
                        this.A05 = elapsedRealtime;
                        this.A03 = 0;
                        for (MK mk : this.A09) {
                            mk.AC3();
                        }
                    }
                }
                this.A04 = elapsedRealtime;
            }
            this.A06 = elapsedRealtime;
            this.A00 = sensorEvent.values[0];
            this.A01 = sensorEvent.values[1];
            this.A02 = sensorEvent.values[2];
        }
    }
}
