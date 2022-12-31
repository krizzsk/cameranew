package com.google.android.gms.common.data;

import java.util.NoSuchElementException;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class f<T> extends c<T> {
    private T c;

    public f(b<T> bVar) {
        super(bVar);
    }

    @Override // com.google.android.gms.common.data.c, java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == 0) {
                T t = this.a.get(0);
                this.c = t;
                if (!(t instanceof d)) {
                    String valueOf = String.valueOf(this.c.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 44);
                    sb.append("DataBuffer reference of type ");
                    sb.append(valueOf);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                ((d) this.c).b(i2);
            }
            return this.c;
        }
        int i3 = this.b;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i3);
        throw new NoSuchElementException(sb2.toString());
    }
}
