package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.i;
import java.util.Arrays;
import java.util.Collection;
/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class c<T> implements f<T> {
    private final Collection<? extends f<T>> a;
    private String b;

    @SafeVarargs
    public c(f<T>... fVarArr) {
        if (fVarArr.length >= 1) {
            this.a = Arrays.asList(fVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.f
    public i<T> a(i<T> iVar, int i2, int i3) {
        i<T> iVar2 = iVar;
        for (f<T> fVar : this.a) {
            i<T> a = fVar.a(iVar2, i2, i3);
            if (iVar2 != null && !iVar2.equals(iVar) && !iVar2.equals(a)) {
                iVar2.recycle();
            }
            iVar2 = a;
        }
        return iVar2;
    }

    @Override // com.bumptech.glide.load.f
    public String getId() {
        if (this.b == null) {
            StringBuilder sb = new StringBuilder();
            for (f<T> fVar : this.a) {
                sb.append(fVar.getId());
            }
            this.b = sb.toString();
        }
        return this.b;
    }
}
