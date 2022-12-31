package us.pinguo.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import us.pinguo.librouter.b.c.f;
import us.pinguo.librouter.b.c.g;
/* compiled from: PGGpLocation.java */
/* loaded from: classes5.dex */
public class c implements us.pinguo.location.a, LocationListener {
    private g a;
    private f c = null;
    private LocationManager b = (LocationManager) d.c().d().getSystemService(FirebaseAnalytics.Param.LOCATION);

    /* renamed from: d  reason: collision with root package name */
    private Handler f11555d = new a();

    /* compiled from: PGGpLocation.java */
    /* loaded from: classes5.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                c.this.d("time out");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.locationError(str);
            this.a = null;
        }
    }

    private void e(f fVar) {
        g gVar = this.a;
        if (gVar != null) {
            gVar.locationReceived(fVar);
            this.a = null;
        }
    }

    @Override // us.pinguo.location.a
    public void a(g gVar) {
        this.a = gVar;
        LocationManager locationManager = this.b;
        boolean z = false;
        if (locationManager != null) {
            try {
                if (locationManager.isProviderEnabled("gps")) {
                    this.b.requestLocationUpdates("gps", 60000L, 5.0f, this);
                    z = true;
                }
                if (this.b.isProviderEnabled("network")) {
                    this.b.requestLocationUpdates("network", 60000L, 5.0f, this);
                    z = true;
                }
            } catch (SecurityException | Exception unused) {
            }
        }
        f fVar = this.c;
        if (fVar != null) {
            e(fVar);
        } else if (z) {
            this.f11555d.sendEmptyMessageDelayed(1, 90000L);
        } else {
            d("not support location");
        }
    }

    @Override // us.pinguo.location.a
    public void b() {
        this.f11555d.removeMessages(1);
        LocationManager locationManager = this.b;
        if (locationManager != null) {
            try {
                locationManager.removeUpdates(this);
            } catch (SecurityException unused) {
            }
        }
    }

    @Override // android.location.LocationListener
    @Instrumented
    public void onLocationChanged(Location location) {
        VdsAgent.onLocationChanged(this, location);
        this.f11555d.removeMessages(1);
        if (location != null) {
            f fVar = new f(location.getLatitude(), location.getLongitude());
            if (location.hasAltitude()) {
                fVar.h(location.getAltitude());
            }
            fVar.k(location.getTime());
            this.c = fVar;
            e(fVar);
            return;
        }
        d("error location");
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i2, Bundle bundle) {
    }
}
