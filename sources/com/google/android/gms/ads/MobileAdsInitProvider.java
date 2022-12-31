package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzzt;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzzt a = new zzzt();

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.a.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, String str, String[] strArr) {
        return this.a.delete(uri, str, strArr);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return this.a.getType(uri);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return this.a.insert(uri, contentValues);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return this.a.onCreate();
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.a.query(uri, strArr, str, strArr2, str2);
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.a.update(uri, contentValues, str, strArr);
    }
}
