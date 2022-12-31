package com.bytedance.sdk.openadsdk.multipro.c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
/* compiled from: FrequentCallProviderImpl.java */
/* loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {
    private Context a;

    public static boolean a(String str) {
        if (o.a() == null) {
            return false;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                return "true".equals(e2.getType(Uri.parse(f() + "checkFrequency?rit=" + String.valueOf(str))));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean c() {
        if (o.a() == null) {
            return false;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                return "true".equals(e2.getType(Uri.parse(f() + "isSilent")));
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String d() {
        if (o.a() == null) {
            return null;
        }
        try {
            ContentResolver e2 = e();
            if (e2 != null) {
                return e2.getType(Uri.parse(f() + "maxRit"));
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static ContentResolver e() {
        try {
            if (o.a() != null) {
                return o.a().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String f() {
        return e.b + "/t_frequent/";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_frequent";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        com.bytedance.sdk.openadsdk.utils.o.b("FrequentCallProviderImpl", "get type uri: " + String.valueOf(uri));
        String str = uri.getPath().split("/")[2];
        if ("checkFrequency".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().a(uri.getQueryParameter("rit")) ? "true" : "false";
        } else if ("isSilent".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().b() ? "true" : "false";
        } else if ("maxRit".equals(str)) {
            return com.bytedance.sdk.openadsdk.core.b.a.a().c();
        } else {
            return null;
        }
    }
}
