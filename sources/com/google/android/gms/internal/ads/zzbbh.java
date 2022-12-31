package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import javax.annotation.concurrent.GuardedBy;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final class zzbbh implements SensorEventListener {
    private final SensorManager zzekw;
    private final Display zzeky;
    @GuardedBy("sensorThreadLock")
    private float[] zzelb;
    private Handler zzelc;
    private zzbbj zzeld;
    private final float[] zzekz = new float[9];
    private final float[] zzela = new float[9];
    private final Object zzekx = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbbh(Context context) {
        this.zzekw = (SensorManager) context.getSystemService("sensor");
        this.zzeky = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzl(int i2, int i3) {
        float[] fArr = this.zzela;
        float f2 = fArr[i2];
        fArr[i2] = fArr[i3];
        fArr[i3] = f2;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzekx) {
            if (this.zzelb == null) {
                this.zzelb = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zzekz, fArr);
        int rotation = this.zzeky.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.zzekz, 2, 129, this.zzela);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.zzekz, 129, 130, this.zzela);
        } else if (rotation != 3) {
            System.arraycopy(this.zzekz, 0, this.zzela, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.zzekz, 130, 1, this.zzela);
        }
        zzl(1, 3);
        zzl(2, 6);
        zzl(5, 7);
        synchronized (this.zzekx) {
            System.arraycopy(this.zzela, 0, this.zzelb, 0, 9);
        }
        zzbbj zzbbjVar = this.zzeld;
        if (zzbbjVar != null) {
            zzbbjVar.zzwa();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void start() {
        if (this.zzelc != null) {
            return;
        }
        Sensor defaultSensor = this.zzekw.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzazk.zzev("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzdvl zzdvlVar = new zzdvl(handlerThread.getLooper());
        this.zzelc = zzdvlVar;
        if (this.zzekw.registerListener(this, defaultSensor, 0, zzdvlVar)) {
            return;
        }
        zzazk.zzev("SensorManager.registerListener failed.");
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzelc == null) {
            return;
        }
        this.zzekw.unregisterListener(this);
        this.zzelc.post(new zzbbk(this));
        this.zzelc = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbbj zzbbjVar) {
        this.zzeld = zzbbjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzekx) {
            float[] fArr2 = this.zzelb;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            return true;
        }
    }
}
