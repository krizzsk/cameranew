package com.bytedance.sdk.openadsdk.h;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* compiled from: Urls.java */
/* loaded from: classes.dex */
public class l {
    private static final Set<String> a = new HashSet();
    private static final Set<String> b = new HashSet();
    private final ArrayList<a> c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2068d;

    /* renamed from: e  reason: collision with root package name */
    private int f2069e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f2070f;

    /* renamed from: g  reason: collision with root package name */
    private final int f2071g;

    /* compiled from: Urls.java */
    /* loaded from: classes.dex */
    public class a {
        final String a;
        int b;

        a(String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            l.a.add(this.a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b() {
            l.b.add(this.a);
        }

        public String toString() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(@NonNull List<String> list) {
        int i2;
        if (!list.isEmpty()) {
            int size = list.size();
            this.f2068d = size;
            this.c = new ArrayList<>(size);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.c.addAll(arrayList2);
            }
            Integer num = e.f2039i;
            if (num != null && num.intValue() > 0) {
                i2 = num.intValue();
            } else {
                i2 = this.f2068d >= 2 ? 1 : 2;
            }
            this.f2071g = i2;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2070f < this.f2071g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b() {
        if (a()) {
            int i2 = this.f2069e + 1;
            if (i2 >= this.f2068d - 1) {
                this.f2069e = -1;
                this.f2070f++;
            } else {
                this.f2069e = i2;
            }
            a aVar = this.c.get(i2);
            aVar.b = (this.f2070f * this.f2068d) + this.f2069e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(@NonNull String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.c = arrayList;
        arrayList.add(new a(str));
        this.f2068d = 1;
        this.f2071g = 1;
    }
}
