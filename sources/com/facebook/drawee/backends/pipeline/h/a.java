package com.facebook.drawee.backends.pipeline.h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: ForwardingImageOriginListener.java */
/* loaded from: classes.dex */
public class a implements b {
    private final List<b> a;

    public a(b... bVarArr) {
        ArrayList arrayList = new ArrayList(bVarArr.length);
        this.a = arrayList;
        Collections.addAll(arrayList, bVarArr);
    }

    @Override // com.facebook.drawee.backends.pipeline.h.b
    public synchronized void a(String str, int i2, boolean z, @Nullable String str2) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.a.get(i3);
            if (bVar != null) {
                try {
                    bVar.a(str, i2, z, str2);
                } catch (Exception e2) {
                    com.facebook.common.logging.a.i("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e2);
                }
            }
        }
    }

    public synchronized void b(b bVar) {
        this.a.add(bVar);
    }

    public synchronized void c(b bVar) {
        this.a.remove(bVar);
    }
}
