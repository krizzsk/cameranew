package com.bytedance.sdk.openadsdk.core.f;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: PermissionsManager.java */
/* loaded from: classes.dex */
public class d {
    private static final String a = "d";

    /* renamed from: e  reason: collision with root package name */
    private static d f1632e;

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, Integer> f1633f = new HashMap();
    private final Set<String> b = new HashSet(1);
    private final List<WeakReference<e>> c = new ArrayList(1);

    /* renamed from: d  reason: collision with root package name */
    private final List<e> f1634d = new ArrayList(1);

    private d() {
        b();
    }

    public static d a() {
        if (f1632e == null) {
            f1632e = new d();
        }
        return f1632e;
    }

    private synchronized void b() {
        for (Field field : Manifest.permission.class.getFields()) {
            String str = null;
            try {
                str = (String) field.get("");
            } catch (IllegalAccessException e2) {
                Log.e(a, "Could not access field", e2);
            }
            this.b.add(str);
        }
    }

    @NonNull
    private List<String> c(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (this.b.contains(str)) {
                if (!a(activity, str)) {
                    arrayList.add(str);
                } else if (eVar != null) {
                    eVar.a(str, c.GRANTED);
                }
            } else if (eVar != null) {
                eVar.a(str, c.NOT_FOUND);
            }
        }
        return arrayList;
    }

    private synchronized void a(@NonNull String[] strArr, @Nullable e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.a(strArr);
        this.f1634d.add(eVar);
        this.c.add(new WeakReference<>(eVar));
    }

    private void b(@NonNull Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        boolean a2;
        for (String str : strArr) {
            if (eVar != null) {
                try {
                    if (!this.b.contains(str)) {
                        a2 = eVar.a(str, c.NOT_FOUND);
                    } else if (b.a(activity, str) != 0) {
                        a2 = eVar.a(str, c.DENIED);
                    } else {
                        a2 = eVar.a(str, c.GRANTED);
                    }
                    if (a2) {
                        break;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        a(eVar);
    }

    private synchronized void a(@Nullable e eVar) {
        Iterator<WeakReference<e>> it = this.c.iterator();
        while (it.hasNext()) {
            WeakReference<e> next = it.next();
            if (next.get() == eVar || next.get() == null) {
                it.remove();
            }
        }
        Iterator<e> it2 = this.f1634d.iterator();
        while (it2.hasNext()) {
            if (it2.next() == eVar) {
                it2.remove();
            }
        }
    }

    public synchronized boolean a(@Nullable Context context, @NonNull String str) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (u.e()) {
            if (a.a(context, str) && (b.a(context, str) == 0 || !this.b.contains(str))) {
                z = true;
            }
            return z;
        }
        return (b.a(context, str) == 0 || !this.b.contains(str)) ? true : true;
    }

    public synchronized void a(@Nullable Activity activity, @NonNull String[] strArr, @Nullable e eVar) {
        if (activity == null) {
            return;
        }
        try {
            a(strArr, eVar);
            if (Build.VERSION.SDK_INT < 23) {
                b(activity, strArr, eVar);
            } else {
                List<String> c = c(activity, strArr, eVar);
                if (c.isEmpty()) {
                    a(eVar);
                } else {
                    b.a(activity, (String[]) c.toArray(new String[c.size()]), 1);
                }
            }
        } finally {
        }
    }

    public synchronized void a(@NonNull Activity activity, @NonNull String[] strArr, @NonNull int[] iArr) {
        try {
            new ArrayList(3);
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str = strArr[i2];
                if ((iArr[i2] == -1 || (u.e() && !a.a(activity, str))) && iArr[i2] != -1) {
                    iArr[i2] = -1;
                }
            }
            a(strArr, iArr, (String[]) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(@NonNull String[] strArr, @NonNull int[] iArr, String[] strArr2) {
        int i2;
        try {
            int length = strArr.length;
            if (iArr.length < length) {
                length = iArr.length;
            }
            Iterator<WeakReference<e>> it = this.c.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                while (i2 < length) {
                    i2 = (eVar == null || eVar.a(strArr[i2], iArr[i2])) ? 0 : i2 + 1;
                    it.remove();
                    break;
                }
            }
            Iterator<e> it2 = this.f1634d.iterator();
            while (it2.hasNext()) {
                it2.next();
                it2.remove();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
