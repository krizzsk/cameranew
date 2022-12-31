package com.bytedance.sdk.openadsdk.core.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: PermissionsResultAction.java */
/* loaded from: classes.dex */
public abstract class e {
    private static final String a = "e";
    private final Set<String> b = new HashSet(1);
    private Looper c = Looper.getMainLooper();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PermissionsResultAction.java */
    /* renamed from: com.bytedance.sdk.openadsdk.core.f.e$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public abstract void a();

    public abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean a(@NonNull String str, int i2) {
        if (i2 == 0) {
            return a(str, c.GRANTED);
        }
        return a(str, c.DENIED);
    }

    public synchronized boolean b(String str) {
        String str2 = a;
        Log.d(str2, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean a(@NonNull final String str, c cVar) {
        this.b.remove(str);
        int i2 = AnonymousClass5.a[cVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e.this.a(str);
                    }
                });
                return true;
            } else if (i2 == 3) {
                if (b(str)) {
                    if (this.b.isEmpty()) {
                        new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.3
                            @Override // java.lang.Runnable
                            public void run() {
                                e.this.a();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.4
                        @Override // java.lang.Runnable
                        public void run() {
                            e.this.a(str);
                        }
                    });
                    return true;
                }
            }
        } else if (this.b.isEmpty()) {
            new Handler(this.c).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.f.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.a();
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void a(@NonNull String[] strArr) {
        Collections.addAll(this.b, strArr);
    }
}
