package kotlin.z;

import java.util.NoSuchElementException;
import kotlin.collections.h0;
/* compiled from: ProgressionIterators.kt */
/* loaded from: classes3.dex */
public final class c extends h0 {
    private final int a;
    private final int b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private int f8690d;

    public c(int i2, int i3, int i4) {
        this.a = i4;
        this.b = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.c = z;
        this.f8690d = z ? i2 : i3;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // kotlin.collections.h0
    public int nextInt() {
        int i2 = this.f8690d;
        if (i2 == this.b) {
            if (this.c) {
                this.c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f8690d = this.a + i2;
        }
        return i2;
    }
}
