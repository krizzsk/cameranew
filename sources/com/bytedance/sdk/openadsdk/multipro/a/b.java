package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.e;
import com.bytedance.sdk.openadsdk.utils.o;
/* compiled from: DBMultiProviderImpl.java */
/* loaded from: classes.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {
    private static final Object b = new Object();
    private Context a;

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            o.b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        Context context = this.a;
        return context == null ? com.bytedance.sdk.openadsdk.core.o.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        o.b("DBMultiProviderImpl", "query: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null && split.length >= 4) {
                String str3 = split[2];
                String str4 = split[3];
                if ("ttopensdk.db".equals(str3)) {
                    return e.a(c()).a().a(str4, strArr, str, strArr2, null, null, str2);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        o.b("DBMultiProviderImpl", "getType: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null && split.length >= 5) {
                String str = split[2];
                String str2 = split[3];
                String str3 = split[4];
                if ("ttopensdk.db".equals(str)) {
                    if ("execSQL".equals(str3)) {
                        String queryParameter = uri.getQueryParameter("sql");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            e.a(c()).a().a(Uri.decode(queryParameter));
                        }
                    } else if ("transactionBegin".equals(str3)) {
                        e.a(c()).a().a();
                    } else if ("transactionSetSuccess".equals(str3)) {
                        e.a(c()).a().b();
                    } else if ("transactionEnd".equals(str3)) {
                        e.a(c()).a().c();
                    }
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        o.b("DBMultiProviderImpl", "insert: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return null;
            }
            String[] split = uri.getPath().split("/");
            if (split != null && split.length >= 4) {
                String str = split[2];
                String str2 = split[3];
                if ("ttopensdk.db".equals(str)) {
                    e.a(c()).a().a(str2, (String) null, contentValues);
                }
                return null;
            }
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        o.b("DBMultiProviderImpl", "delete: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split("/");
            if (split != null && split.length >= 4) {
                String str2 = split[2];
                String str3 = split[3];
                if ("ttopensdk.db".equals(str2)) {
                    return e.a(c()).a().a(str3, str, strArr);
                }
                return 0;
            }
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        o.b("DBMultiProviderImpl", "update: " + String.valueOf(uri));
        synchronized (b) {
            if (b(uri)) {
                return 0;
            }
            String[] split = uri.getPath().split("/");
            if (split != null && split.length >= 4) {
                String str2 = split[2];
                String str3 = split[3];
                if ("ttopensdk.db".equals(str2)) {
                    return e.a(c()).a().a(str3, contentValues, str, strArr);
                }
                return 0;
            }
            return 0;
        }
    }
}
