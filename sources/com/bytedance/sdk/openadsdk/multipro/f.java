package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: TTProviderManager.java */
/* loaded from: classes.dex */
public class f implements a {
    private static volatile f a;
    private static WeakReference<Context> b;
    private static List<a> c;

    static {
        List<a> synchronizedList = Collections.synchronizedList(new ArrayList());
        c = synchronizedList;
        synchronizedList.add(new com.bytedance.sdk.openadsdk.multipro.d.c());
        c.add(new com.bytedance.sdk.openadsdk.multipro.a.b());
        c.add(new com.bytedance.sdk.openadsdk.multipro.c.b());
        c.add(new com.bytedance.sdk.openadsdk.multipro.c.a());
        for (a aVar : c) {
            aVar.b();
        }
    }

    private f() {
    }

    public static f b(Context context) {
        if (context != null) {
            b = new WeakReference<>(context.getApplicationContext());
        }
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    private boolean c(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        for (a aVar : c) {
            aVar.a(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, strArr, str, strArr2, str2);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider query error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    private a b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!c(uri)) {
            o.b("TTProviderManager", "uri is error1");
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            o.b("TTProviderManager", "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            o.b("TTProviderManager", "uri is error3");
            return null;
        }
        for (a aVar : c) {
            if (str.equals(aVar.a())) {
                return aVar;
            }
        }
        o.b("TTProviderManager", "uri is error4");
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, contentValues);
            }
            return null;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, contentValues, str, strArr);
            }
            return 0;
        } catch (Throwable th) {
            o.a("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }
}
