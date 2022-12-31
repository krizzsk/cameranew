package us.pinguo.common;

import java.util.ArrayList;
import kotlin.jvm.internal.s;
/* compiled from: GestureEventManager.kt */
/* loaded from: classes4.dex */
public final class f {
    private final ArrayList<g>[] a;
    private boolean b;

    public f() {
        ArrayList<g>[] arrayListArr = new ArrayList[4];
        for (int i2 = 0; i2 < 4; i2++) {
            arrayListArr[i2] = new ArrayList<>();
        }
        this.a = arrayListArr;
    }

    public final boolean a() {
        return this.b;
    }

    public final boolean b(d event) {
        s.h(event, "event");
        if (this.b) {
            return false;
        }
        ArrayList<g>[] arrayListArr = this.a;
        int length = arrayListArr.length;
        int i2 = 0;
        while (i2 < length) {
            ArrayList<g> arrayList = arrayListArr[i2];
            i2++;
            boolean z = false;
            for (g gVar : arrayList) {
                if (gVar.E(event)) {
                    z = true;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void c(g receiver, int i2) {
        s.h(receiver, "receiver");
        boolean z = false;
        if (i2 >= 0 && i2 < this.a.length) {
            z = true;
        }
        if (z) {
            ArrayList<g> arrayList = this.a[i2];
            if (arrayList.contains(receiver)) {
                return;
            }
            arrayList.add(receiver);
        }
    }

    public final void d(boolean z) {
        this.b = z;
    }
}
