package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* compiled from: Objects.java */
/* loaded from: classes.dex */
public final class g {

    /* compiled from: Objects.java */
    /* loaded from: classes.dex */
    public static final class b {
        private final String a;
        private final a b;
        private a c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2404d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Objects.java */
        /* loaded from: classes.dex */
        public static final class a {
            @Nullable
            String a;
            @Nullable
            Object b;
            @Nullable
            a c;

            private a() {
            }
        }

        private a d() {
            a aVar = new a();
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        private b e(String str, @Nullable Object obj) {
            a d2 = d();
            d2.b = obj;
            h.g(str);
            d2.a = str;
            return this;
        }

        public b a(String str, int i2) {
            e(str, String.valueOf(i2));
            return this;
        }

        public b b(String str, @Nullable Object obj) {
            e(str, obj);
            return this;
        }

        public b c(String str, boolean z) {
            e(str, String.valueOf(z));
            return this;
        }

        public String toString() {
            boolean z = this.f2404d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.b.c; aVar != null; aVar = aVar.c) {
                Object obj = aVar.b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        sb.append(obj);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        private b(String str) {
            a aVar = new a();
            this.b = aVar;
            this.c = aVar;
            this.f2404d = false;
            h.g(str);
            this.a = str;
        }
    }

    @CheckReturnValue
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
