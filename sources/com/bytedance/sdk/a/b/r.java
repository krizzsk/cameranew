package com.bytedance.sdk.a.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
/* compiled from: Headers.java */
/* loaded from: classes.dex */
public final class r {
    private final String[] a;

    r(a aVar) {
        List<String> list = aVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        return a(this.a, str);
    }

    public String b(int i2) {
        return this.a[(i2 * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).a, this.a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }

    /* compiled from: Headers.java */
    /* loaded from: classes.dex */
    public static final class a {
        final List<String> a = new ArrayList(20);

        private void d(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i2 = 0; i2 < length; i2++) {
                    char charAt = str.charAt(i2);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                    }
                }
                if (str2 != null) {
                    int length2 = str2.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        char charAt2 = str2.charAt(i3);
                        if ((charAt2 <= 31 && charAt2 != '\t') || charAt2 >= 127) {
                            throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt2), Integer.valueOf(i3), str, str2));
                        }
                    }
                    return;
                }
                throw new NullPointerException("value for name " + str + " == null");
            }
            throw new IllegalArgumentException("name is empty");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return b("", str.substring(1));
            }
            return b("", str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a b(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.a.size()) {
                if (str.equalsIgnoreCase(this.a.get(i2))) {
                    this.a.remove(i2);
                    this.a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            d(str, str2);
            return b(str, str2);
        }

        public r a() {
            return new r(this);
        }
    }

    public int a() {
        return this.a.length / 2;
    }

    public List<String> b(String str) {
        int a2 = a();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < a2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public String a(int i2) {
        return this.a[i2 * 2];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }
}
