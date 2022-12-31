package us.pinguo.camera2020.view;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
/* compiled from: AccelerationSensorController.kt */
/* loaded from: classes3.dex */
public final class AccelerationSensorController implements SensorEventListener, LifecycleObserver {
    private final SensorManager a;
    private Sensor b;
    private a c;

    /* renamed from: d  reason: collision with root package name */
    private float f9261d;

    /* renamed from: e  reason: collision with root package name */
    private float f9262e;

    /* renamed from: f  reason: collision with root package name */
    private float f9263f;

    /* renamed from: g  reason: collision with root package name */
    private int f9264g;

    /* renamed from: h  reason: collision with root package name */
    private final float f9265h;

    /* renamed from: i  reason: collision with root package name */
    private long f9266i;

    /* compiled from: AccelerationSensorController.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void r();
    }

    public AccelerationSensorController() {
        SensorManager sensorManager = (SensorManager) us.pinguo.util.v.a().getSystemService("sensor");
        this.a = sensorManager;
        this.f9264g = 4;
        this.f9265h = 3.0f;
        if (sensorManager != null) {
            this.b = sensorManager.getDefaultSensor(1);
        }
    }

    private final void b() {
        this.f9264g = 0;
        this.f9266i = 0L;
        this.f9261d = 0.0f;
        this.f9262e = 0.0f;
        this.f9263f = 0.0f;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void start() {
        SensorManager sensorManager = this.a;
        if (sensorManager == null) {
            return;
        }
        sensorManager.registerListener(this, this.b, 3);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void stop() {
        SensorManager sensorManager = this.a;
        if (sensorManager == null) {
            return;
        }
        sensorManager.unregisterListener(this, this.b);
    }

    public final void a() {
        this.f9264g = 4;
    }

    public final void c(a cameraFocusListener) {
        kotlin.jvm.internal.s.h(cameraFocusListener, "cameraFocusListener");
        this.c = cameraFocusListener;
    }

    public final void d() {
        b();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        kotlin.jvm.internal.s.h(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        kotlin.jvm.internal.s.h(event, "event");
        Sensor sensor = event.sensor;
        if (sensor == null || this.f9264g == 4 || sensor.getType() != 1) {
            return;
        }
        float[] fArr = event.values;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.f9264g == 0) {
            this.f9264g = 2;
            this.f9266i = elapsedRealtime;
            this.f9261d = f2;
            this.f9262e = f3;
            this.f9263f = f4;
        } else if (Math.abs(elapsedRealtime - this.f9266i) < 100) {
        } else {
            if (Math.abs(this.f9261d - f2) + Math.abs(this.f9262e - f3) + Math.abs(this.f9263f - f4) > this.f9265h) {
                a aVar = this.c;
                if (aVar != null) {
                    aVar.r();
                }
                a();
            }
            this.f9266i = elapsedRealtime;
            this.f9261d = f2;
            this.f9262e = f3;
            this.f9263f = f4;
        }
    }
}
