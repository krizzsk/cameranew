package us.pinguo.inspire.module.profile;

import android.os.Handler;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import rx.functions.Action1;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.profile.GeoManager;
/* loaded from: classes4.dex */
public class GeoManager {
    public static final int TIME_OUT = 15000;

    /* loaded from: classes4.dex */
    public interface GeoResultListener {
        void onError(Throwable th);

        void onResult(GeoResp geoResp);
    }

    /* loaded from: classes4.dex */
    public interface LocationResult {
        void onError(Throwable th);

        void onResult(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(boolean[] zArr, LocationResult locationResult) {
        us.pinguo.common.log.a.m("FK", "time out execute........", new Object[0]);
        if (zArr[0]) {
            return;
        }
        zArr[0] = true;
        if (locationResult != null) {
            locationResult.onError(new Throwable("time out"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(GeoResultListener geoResultListener, Throwable th) {
        Inspire.f(th);
        us.pinguo.common.log.a.f(th);
        if (geoResultListener != null) {
            geoResultListener.onError(th);
        }
    }

    public static void getCurrentGeo(final GeoResultListener geoResultListener) {
        getCurrentLocation(new LocationResult() { // from class: us.pinguo.inspire.module.profile.GeoManager.2
            @Override // us.pinguo.inspire.module.profile.GeoManager.LocationResult
            public void onError(Throwable th) {
                us.pinguo.common.log.a.f(th);
                GeoResultListener geoResultListener2 = GeoResultListener.this;
                if (geoResultListener2 != null) {
                    geoResultListener2.onError(th);
                }
            }

            @Override // us.pinguo.inspire.module.profile.GeoManager.LocationResult
            public void onResult(String str, String str2) {
                GeoManager.getGeo(str, str2, GeoResultListener.this);
            }
        });
    }

    public static synchronized void getCurrentLocation(final LocationResult locationResult) {
        synchronized (GeoManager.class) {
            String[] c = us.pinguo.user.s0.getInstance().c();
            us.pinguo.librouter.b.c.f e2 = us.pinguo.location.d.c().e();
            if (e2 == null) {
                if (c != null && c.length != 0) {
                    String str = c[1];
                    String str2 = c[0];
                    if (locationResult != null) {
                        locationResult.onResult(str2, str);
                    }
                }
                final Handler handler = new Handler();
                final boolean[] zArr = {false};
                final Runnable runnable = new Runnable() { // from class: us.pinguo.inspire.module.profile.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        GeoManager.a(zArr, locationResult);
                    }
                };
                handler.postDelayed(runnable, 15000L);
                us.pinguo.librouter.b.b.b().getInterface().a(new us.pinguo.librouter.b.c.g() { // from class: us.pinguo.inspire.module.profile.GeoManager.1
                    @Override // us.pinguo.librouter.b.c.g
                    public void locationError(String str3) {
                        us.pinguo.common.log.a.m("FK", "location error", new Object[0]);
                        if (zArr[0]) {
                            return;
                        }
                        handler.removeCallbacks(runnable);
                        zArr[0] = true;
                        LocationResult locationResult2 = locationResult;
                        if (locationResult2 != null) {
                            locationResult2.onError(new Throwable(str3));
                        }
                    }

                    @Override // us.pinguo.librouter.b.c.g
                    public void locationReceived(us.pinguo.librouter.b.c.f fVar) {
                        us.pinguo.common.log.a.m("FK", "location success", new Object[0]);
                        if (zArr[0]) {
                            return;
                        }
                        handler.removeCallbacks(runnable);
                        zArr[0] = true;
                        LocationResult locationResult2 = locationResult;
                        if (locationResult2 != null) {
                            locationResult2.onResult(String.valueOf(fVar.c()), String.valueOf(fVar.d()));
                        }
                    }
                });
            } else if (locationResult != null) {
                locationResult.onResult(String.valueOf(e2.c()), String.valueOf(e2.d()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void getGeo(String str, String str2, final GeoResultListener geoResultListener) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Double.parseDouble(str) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        if (Double.parseDouble(str2) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        us.pinguo.foundation.utils.g0.a(new UserInfoLoader().getCurrentLocation(str, str2).subscribe(new Action1<GeoResp>() { // from class: us.pinguo.inspire.module.profile.GeoManager.3
            @Override // rx.functions.Action1
            public void call(GeoResp geoResp) {
                GeoResultListener geoResultListener2 = GeoResultListener.this;
                if (geoResultListener2 != null) {
                    geoResultListener2.onResult(geoResp);
                }
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.profile.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GeoManager.b(GeoManager.GeoResultListener.this, (Throwable) obj);
            }
        }));
    }

    public static void unsubscription() {
        us.pinguo.foundation.utils.g0.b();
    }
}
