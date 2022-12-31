package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.zhy.android.percent.support.PercentLayoutHelper;
/* loaded from: classes3.dex */
public class LocationHelper {
    private DeviceHelper deviceHelper;
    private boolean gpsRequesting;
    private int gpsTimeoutSec;
    private Handler handler = MobHandlerThread.newHandler(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, newCallback());
    private LocationListener listener;
    private LocationManager lm;
    private boolean networkRequesting;
    private int networkTimeoutSec;
    private Location res;

    public LocationHelper() {
        newLocationListener();
    }

    private Handler.Callback newCallback() {
        return new Handler.Callback() { // from class: com.mob.tools.utils.LocationHelper.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    if (!LocationHelper.this.deviceHelper.checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
                        LocationHelper.this.quit();
                        return false;
                    } else if (message.what == 0) {
                        LocationHelper.this.onRequest();
                        return false;
                    } else if (LocationHelper.this.gpsRequesting) {
                        LocationHelper.this.onGPSTimeout();
                        return false;
                    } else if (LocationHelper.this.networkRequesting) {
                        if (LocationHelper.this.lm != null) {
                            LocationHelper.this.lm.removeUpdates(LocationHelper.this.listener);
                        }
                        LocationHelper.this.quit();
                        return false;
                    } else {
                        return false;
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                    LocationHelper.this.quit();
                    return false;
                }
            }
        };
    }

    private void newLocationListener() {
        this.listener = new LocationListener() { // from class: com.mob.tools.utils.LocationHelper.2
            @Override // android.location.LocationListener
            @Instrumented
            public void onLocationChanged(Location location) {
                VdsAgent.onLocationChanged(this, location);
                try {
                    synchronized (LocationHelper.this) {
                        LocationHelper.this.lm.removeUpdates(this);
                        LocationHelper.this.res = location;
                        LocationHelper.this.notifyAll();
                    }
                    LocationHelper.this.handler.getLooper().quit();
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
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
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGPSTimeout() {
        this.lm.removeUpdates(this.listener);
        this.gpsRequesting = false;
        if ((this.networkTimeoutSec != 0) && this.lm.isProviderEnabled("network")) {
            this.networkRequesting = true;
            this.lm.requestLocationUpdates("network", 1000L, 0.0f, this.listener);
            int i2 = this.networkTimeoutSec;
            if (i2 > 0) {
                this.handler.sendEmptyMessageDelayed(1, i2 * 1000);
                return;
            }
            return;
        }
        quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRequest() {
        boolean z = this.gpsTimeoutSec != 0;
        boolean z2 = this.networkTimeoutSec != 0;
        LocationManager locationManager = this.lm;
        if (locationManager != null) {
            if (z && locationManager.isProviderEnabled("gps")) {
                this.gpsRequesting = true;
                try {
                    this.lm.requestLocationUpdates("gps", 1000L, 0.0f, this.listener);
                    int i2 = this.gpsTimeoutSec;
                    if (i2 > 0) {
                        this.handler.sendEmptyMessageDelayed(1, i2 * 1000);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    this.handler.sendEmptyMessage(1);
                    return;
                }
            } else if (z2 && this.lm.isProviderEnabled("network")) {
                this.networkRequesting = true;
                try {
                    this.lm.requestLocationUpdates("network", 1000L, 0.0f, this.listener);
                    int i3 = this.networkTimeoutSec;
                    if (i3 > 0) {
                        this.handler.sendEmptyMessageDelayed(1, i3 * 1000);
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    MobLog.getInstance().w(th2);
                    this.handler.sendEmptyMessage(1);
                    return;
                }
            }
        }
        quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void quit() {
        try {
            synchronized (this) {
                notifyAll();
            }
            this.handler.getLooper().quit();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public Location getLocation(Context context) throws Throwable {
        return getLocation(context, 0);
    }

    public Location getLocation(Context context, int i2) throws Throwable {
        return getLocation(context, i2, 0);
    }

    public Location getLocation(Context context, int i2, int i3) throws Throwable {
        return getLocation(context, i2, i3, true);
    }

    public Location getLocation(Context context, int i2, int i3, boolean z) throws Throwable {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(context);
        this.deviceHelper = deviceHelper;
        this.gpsTimeoutSec = i2;
        this.networkTimeoutSec = i3;
        LocationManager locationManager = (LocationManager) deviceHelper.getSystemServiceSafe(FirebaseAnalytics.Param.LOCATION);
        this.lm = locationManager;
        if (locationManager == null) {
            return null;
        }
        synchronized (this) {
            this.handler.sendEmptyMessageDelayed(0, 50L);
            wait();
        }
        if (this.res == null && z) {
            Location lastKnownLocation = this.lm.getLastKnownLocation("gps");
            this.res = lastKnownLocation;
            if (lastKnownLocation == null) {
                this.res = this.lm.getLastKnownLocation("network");
            }
        }
        return this.res;
    }
}
