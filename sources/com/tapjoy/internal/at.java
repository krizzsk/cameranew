package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;
/* loaded from: classes3.dex */
public abstract class at extends AbstractQueue implements ax {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: com.tapjoy.internal.at.1
            private int b = 0;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.b < at.this.size();
            }

            @Override // java.util.Iterator
            public final Object next() {
                at atVar = at.this;
                int i2 = this.b;
                this.b = i2 + 1;
                return atVar.a(i2);
            }

            @Override // java.util.Iterator
            public final void remove() {
                if (this.b == 1) {
                    at.this.b(1);
                    this.b = 0;
                    return;
                }
                throw new UnsupportedOperationException("For the first element only");
            }
        };
    }
}
