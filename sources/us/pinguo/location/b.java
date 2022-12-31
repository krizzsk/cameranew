package us.pinguo.location;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import us.pinguo.librouter.b.c.e;
import us.pinguo.librouter.b.c.f;
import us.pinguo.librouter.b.c.g;
/* compiled from: LocationInterfaceImpl.java */
/* loaded from: classes5.dex */
public class b implements e {
    private boolean a = false;

    @Override // us.pinguo.librouter.b.c.e
    public void a(g gVar) {
        if (this.a) {
            d.c().h(gVar);
        } else if (gVar != null) {
            gVar.locationError("location disable");
        }
    }

    @Override // us.pinguo.librouter.b.c.e
    public void b() {
        d.c().i();
    }

    @Override // us.pinguo.librouter.b.c.e
    public f c(Activity activity, Intent intent) {
        com.google.android.gms.location.places.a c = com.google.android.gms.location.places.ui.b.c(intent, activity);
        if (c == null) {
            return new f(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        LatLng t = c.t();
        if (t == null) {
            return new f(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        return new f(t.latitude, t.longitude);
    }

    @Override // us.pinguo.librouter.b.c.e
    public void d(boolean z) {
        this.a = z;
    }

    @Override // us.pinguo.librouter.b.c.e
    public Intent e(Activity activity, double d2, double d3) {
        b.a aVar = new b.a();
        if (d2 > -89.97989654541016d && d2 < 89.97989654541016d && d3 > -179.9799041748047d && d2 < 179.9799041748047d) {
            aVar.b(new LatLngBounds(new LatLng(d2 - 0.019999999552965164d, d3 - 0.019999999552965164d), new LatLng(d2 + 0.019999999552965164d, d3 + 0.019999999552965164d)));
        }
        try {
            return aVar.a(activity);
        } catch (GooglePlayServicesNotAvailableException e2) {
            e2.printStackTrace();
            return null;
        } catch (GooglePlayServicesRepairableException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // us.pinguo.librouter.b.c.e
    public f getLocation() {
        return d.c().e();
    }
}
