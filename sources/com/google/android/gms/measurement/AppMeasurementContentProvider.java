package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.measurement.internal.o4;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.2 */
@Deprecated
/* loaded from: classes2.dex */
public class AppMeasurementContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public void attachInfo(@RecentlyNonNull Context context, @RecentlyNonNull ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if ("com.google.android.gms.measurement.google_measurement_service".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(@RecentlyNonNull Uri uri, @RecentlyNonNull String str, @RecentlyNonNull String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @RecentlyNonNull
    public String getType(@RecentlyNonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @RecentlyNonNull
    public Uri insert(@RecentlyNonNull Uri uri, @RecentlyNonNull ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        q.j(context);
        o4.f(context, null, null);
        return false;
    }

    @Override // android.content.ContentProvider
    @RecentlyNonNull
    public Cursor query(@RecentlyNonNull Uri uri, @RecentlyNonNull String[] strArr, @RecentlyNonNull String str, @RecentlyNonNull String[] strArr2, @RecentlyNonNull String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@RecentlyNonNull Uri uri, @RecentlyNonNull ContentValues contentValues, @RecentlyNonNull String str, @RecentlyNonNull String[] strArr) {
        return 0;
    }
}
