package com.facebook.cache.disk;

import com.facebook.cache.disk.c;
/* compiled from: DefaultEntryEvictionComparatorSupplier.java */
/* loaded from: classes.dex */
public class a implements g {

    /* compiled from: DefaultEntryEvictionComparatorSupplier.java */
    /* renamed from: com.facebook.cache.disk.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0085a implements f {
        C0085a(a aVar) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c.a aVar, c.a aVar2) {
            long a = aVar.a();
            long a2 = aVar2.a();
            if (a < a2) {
                return -1;
            }
            return a2 == a ? 0 : 1;
        }
    }

    @Override // com.facebook.cache.disk.g
    public f get() {
        return new C0085a(this);
    }
}
