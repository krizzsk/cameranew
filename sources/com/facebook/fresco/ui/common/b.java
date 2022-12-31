package com.facebook.fresco.ui.common;

import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: ControllerListener2.java */
/* loaded from: classes.dex */
public interface b<INFO> {

    /* compiled from: ControllerListener2.java */
    /* loaded from: classes.dex */
    public static class a {
        @Nullable
        public Map<String, Object> a;
        @Nullable
        public Map<String, Object> b;
        @Nullable
        public Map<String, Object> c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public Map<String, Object> f2634d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public Object f2635e;
    }

    void a(String str, @Nullable INFO info);

    void d(String str);

    void e(String str, @Nullable a aVar);

    void h(String str, @Nullable Object obj, @Nullable a aVar);

    void i(String str, @Nullable Throwable th, @Nullable a aVar);

    void j(String str, @Nullable INFO info, @Nullable a aVar);
}
