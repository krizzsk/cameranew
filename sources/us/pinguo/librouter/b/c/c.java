package us.pinguo.librouter.b.c;

import android.app.Activity;
import android.content.Intent;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: LocationDefaultInterface.java */
/* loaded from: classes5.dex */
public class c implements e {
    @Override // us.pinguo.librouter.b.c.e
    public void a(g gVar) {
    }

    @Override // us.pinguo.librouter.b.c.e
    public void b() {
    }

    @Override // us.pinguo.librouter.b.c.e
    public f c(Activity activity, Intent intent) {
        return new f();
    }

    @Override // us.pinguo.librouter.b.c.e
    public void d(boolean z) {
    }

    @Override // us.pinguo.librouter.b.c.e
    public Intent e(Activity activity, double d2, double d3) {
        return new Intent();
    }

    @Override // us.pinguo.librouter.b.c.e
    public f getLocation() {
        return new f(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }
}
