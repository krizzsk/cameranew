package com.tapjoy;

import android.content.Context;
/* loaded from: classes3.dex */
public class TapjoyGpsHelper {
    private Context a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f7278d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f7279e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7280f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f7281g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f7282h;

    public TapjoyGpsHelper(Context context) {
        this.a = context;
    }

    public void checkGooglePlayIntegration() {
        if (isGooglePlayServicesAvailable()) {
            if (!isGooglePlayManifestConfigured()) {
                throw new TapjoyIntegrationException("Failed to load manifest.xml meta-data, 'com.google.android.gms.version' not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
            }
            return;
        }
        throw new TapjoyIntegrationException("Tapjoy SDK is disabled because Google Play Services was not found. For more information about including the Google Play services client library visit http://developer.android.com/google/play-services/setup.html or http://tech.tapjoy.com/product-overview/sdk-change-log/tapjoy-and-identifiers");
    }

    public String getAdvertisingId() {
        return this.b;
    }

    public int getDeviceGooglePlayServicesVersion() {
        return this.f7278d;
    }

    public int getPackagedGooglePlayServicesVersion() {
        return this.f7279e;
    }

    public boolean isAdIdAvailable() {
        return this.f7280f;
    }

    public boolean isAdTrackingEnabled() {
        return this.c;
    }

    public boolean isGooglePlayManifestConfigured() {
        if (this.f7282h == null) {
            try {
                this.f7279e = this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getInt("com.google.android.gms.version");
                this.f7282h = Boolean.TRUE;
            } catch (Exception unused) {
                this.f7282h = Boolean.FALSE;
            }
        }
        return this.f7282h.booleanValue();
    }

    public boolean isGooglePlayServicesAvailable() {
        if (this.f7281g == null) {
            try {
                this.a.getClassLoader().loadClass("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                this.f7281g = Boolean.TRUE;
            } catch (Error unused) {
                this.f7281g = Boolean.FALSE;
            } catch (Exception unused2) {
                this.f7281g = Boolean.FALSE;
            }
        }
        return this.f7281g.booleanValue();
    }

    public void loadAdvertisingId(boolean z) {
        TapjoyLog.i("TapjoyGpsHelper", "Looking for Google Play Services...");
        if (isGooglePlayServicesAvailable() && isGooglePlayManifestConfigured()) {
            TapjoyLog.i("TapjoyGpsHelper", "Packaged Google Play Services found, fetching advertisingID...");
            TapjoyLog.i("TapjoyGpsHelper", "Packaged Google Play Services version: " + this.f7279e);
            TapjoyAdIdClient tapjoyAdIdClient = new TapjoyAdIdClient(this.a);
            this.f7280f = tapjoyAdIdClient.setupAdIdInfo();
            try {
                this.f7278d = this.a.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
                TapjoyLog.i("TapjoyGpsHelper", "Device's Google Play Services version: " + this.f7278d);
            } catch (Exception unused) {
                TapjoyLog.i("TapjoyGpsHelper", "Error getting device's Google Play Services version");
            }
            if (this.f7280f) {
                this.c = tapjoyAdIdClient.isAdTrackingEnabled();
                this.b = tapjoyAdIdClient.getAdvertisingId();
                TapjoyLog.i("TapjoyGpsHelper", "Found advertising ID: " + this.b);
                TapjoyLog.i("TapjoyGpsHelper", "Is ad tracking enabled: " + Boolean.toString(this.c));
                return;
            }
            TapjoyLog.i("TapjoyGpsHelper", "Error getting advertisingID from Google Play Services");
            if (z) {
                this.c = false;
                this.b = "00000000-0000-0000-0000-000000000000";
                this.f7280f = true;
                return;
            }
            return;
        }
        TapjoyLog.i("TapjoyGpsHelper", "Google Play Services not found");
    }
}
