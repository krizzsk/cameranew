package com.facebook.fresco.ui.common;

import android.util.Log;
import com.facebook.fresco.ui.common.b;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
/* compiled from: ForwardingControllerListener2.java */
/* loaded from: classes.dex */
public class d<I> extends a<I> {
    private final List<b<I>> a = new ArrayList(2);

    private synchronized void n(String str, Throwable th) {
        Log.e("FwdControllerListener2", str, th);
    }

    @Override // com.facebook.fresco.ui.common.b
    public void e(String str, @Nullable b.a aVar) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                b<I> bVar = this.a.get(i2);
                if (bVar != null) {
                    bVar.e(str, aVar);
                }
            } catch (Exception e2) {
                n("ForwardingControllerListener2 exception in onRelease", e2);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.b
    public void h(String str, @Nullable Object obj, @Nullable b.a aVar) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                b<I> bVar = this.a.get(i2);
                if (bVar != null) {
                    bVar.h(str, obj, aVar);
                }
            } catch (Exception e2) {
                n("ForwardingControllerListener2 exception in onSubmit", e2);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.b
    public void i(String str, @Nullable Throwable th, @Nullable b.a aVar) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                b<I> bVar = this.a.get(i2);
                if (bVar != null) {
                    bVar.i(str, th, aVar);
                }
            } catch (Exception e2) {
                n("ForwardingControllerListener2 exception in onFailure", e2);
            }
        }
    }

    @Override // com.facebook.fresco.ui.common.b
    public void j(String str, @Nullable I i2, @Nullable b.a aVar) {
        int size = this.a.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                b<I> bVar = this.a.get(i3);
                if (bVar != null) {
                    bVar.j(str, i2, aVar);
                }
            } catch (Exception e2) {
                n("ForwardingControllerListener2 exception in onFinalImageSet", e2);
            }
        }
    }

    public synchronized void m(b<I> bVar) {
        this.a.add(bVar);
    }

    public synchronized void o(b<I> bVar) {
        int indexOf = this.a.indexOf(bVar);
        if (indexOf != -1) {
            this.a.remove(indexOf);
        }
    }
}
