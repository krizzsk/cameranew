package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.q;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class d {
    protected final DataHolder a;
    protected int b;
    private int c;

    public d(DataHolder dataHolder, int i2) {
        q.j(dataHolder);
        this.a = dataHolder;
        b(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str) {
        return this.a.S(str, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(int i2) {
        q.m(i2 >= 0 && i2 < this.a.getCount());
        this.b = i2;
        this.c = this.a.T(i2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (p.a(Integer.valueOf(dVar.b), Integer.valueOf(this.b)) && p.a(Integer.valueOf(dVar.c), Integer.valueOf(this.c)) && dVar.a == this.a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p.b(Integer.valueOf(this.b), Integer.valueOf(this.c), this.a);
    }
}
