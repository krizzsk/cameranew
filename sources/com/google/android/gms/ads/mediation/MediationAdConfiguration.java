package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String a;
    private final Bundle b;
    private final Bundle c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f3525d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3526e;

    /* renamed from: f  reason: collision with root package name */
    private final Location f3527f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3528g;

    /* renamed from: h  reason: collision with root package name */
    private final int f3529h;

    /* renamed from: i  reason: collision with root package name */
    private final String f3530i;

    /* renamed from: j  reason: collision with root package name */
    private final String f3531j;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i2, int i3, @Nullable String str2, String str3) {
        this.a = str;
        this.b = bundle;
        this.c = bundle2;
        this.f3525d = context;
        this.f3526e = z;
        this.f3527f = location;
        this.f3528g = i2;
        this.f3529h = i3;
        this.f3530i = str2;
        this.f3531j = str3;
    }

    public String getBidResponse() {
        return this.a;
    }

    public Context getContext() {
        return this.f3525d;
    }

    public Location getLocation() {
        return this.f3527f;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.f3530i;
    }

    public Bundle getMediationExtras() {
        return this.c;
    }

    public Bundle getServerParameters() {
        return this.b;
    }

    public String getWatermark() {
        return this.f3531j;
    }

    public boolean isTestRequest() {
        return this.f3526e;
    }

    public int taggedForChildDirectedTreatment() {
        return this.f3528g;
    }

    public int taggedForUnderAgeTreatment() {
        return this.f3529h;
    }
}
