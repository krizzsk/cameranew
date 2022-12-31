package com.google.android.gms.internal.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.b;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzzt extends ContentProvider {
    @Nullable
    private static Bundle getMetadata(Context context) {
        try {
            return b.a(context).c(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e2) {
            zzazk.zzc("Failed to load metadata: Package name not found.", e2);
            return null;
        } catch (NullPointerException e3) {
            zzazk.zzc("Failed to load metadata: Null pointer exception.", e3);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        Bundle metadata = getMetadata(context);
        zzamz zzut = zzamz.zzut();
        if (metadata == null) {
            zzazk.zzev("Metadata was null.");
        } else {
            try {
                String str = (String) metadata.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    Boolean bool = (Boolean) metadata.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        Boolean bool2 = (Boolean) metadata.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            String str2 = (String) metadata.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (str != null && !str.matches("^/\\d+~.+$")) {
                                if (str.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                    String valueOf = String.valueOf(str);
                                    zzazk.zzdy(valueOf.length() != 0 ? "Publisher provided Google AdMob App ID in manifest: ".concat(valueOf) : new String("Publisher provided Google AdMob App ID in manifest: "));
                                    if (bool2 == null || !bool2.booleanValue()) {
                                        zzut.zzc(context, str);
                                    }
                                } else {
                                    throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                                }
                            } else if (bool == null || !bool.booleanValue()) {
                                if (!TextUtils.isEmpty(str2)) {
                                    String valueOf2 = String.valueOf(str2);
                                    zzazk.zzdy(valueOf2.length() != 0 ? "The Google Mobile Ads SDK is integrated by ".concat(valueOf2) : new String("The Google Mobile Ads SDK is integrated by "));
                                } else {
                                    throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                }
                            }
                        } catch (ClassCastException e2) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", e2);
                        }
                    } catch (ClassCastException e3) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", e3);
                    }
                } catch (ClassCastException e4) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", e4);
                }
            } catch (ClassCastException e5) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", e5);
            }
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public final int delete(@NonNull Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Uri insert(@NonNull Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public final Cursor query(@NonNull Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(@NonNull Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
