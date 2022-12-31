package com.google.android.gms.measurement.internal;

import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.measurement.zzlc;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.2 */
/* loaded from: classes2.dex */
public final class h8 extends z8 {

    /* renamed from: d  reason: collision with root package name */
    private String f3819d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3820e;

    /* renamed from: f  reason: collision with root package name */
    private long f3821f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h8(i9 i9Var) {
        super(i9Var);
    }

    @Override // com.google.android.gms.measurement.internal.z8
    protected final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    public final Pair<String, Boolean> k(String str, f fVar) {
        zzlc.zzb();
        if (this.a.x().u(null, x2.y0) && !fVar.f()) {
            return new Pair<>("", Boolean.FALSE);
        }
        return l(str);
    }

    @WorkerThread
    @Deprecated
    final Pair<String, Boolean> l(String str) {
        f();
        long a = this.a.zzax().a();
        String str2 = this.f3819d;
        if (str2 != null && a < this.f3821f) {
            return new Pair<>(str2, Boolean.valueOf(this.f3820e));
        }
        this.f3821f = a + this.a.x().q(str, x2.b);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a.zzaw());
            if (advertisingIdInfo != null) {
                this.f3819d = advertisingIdInfo.getId();
                this.f3820e = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.f3819d == null) {
                this.f3819d = "";
            }
        } catch (Exception e2) {
            this.a.a().t().b("Unable to get advertising id", e2);
            this.f3819d = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.f3819d, Boolean.valueOf(this.f3820e));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final String m(String str) {
        f();
        String str2 = (String) l(str).first;
        MessageDigest z = n9.z();
        if (z == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, z.digest(str2.getBytes())));
    }
}
