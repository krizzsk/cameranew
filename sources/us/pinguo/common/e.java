package us.pinguo.common;

import java.util.ArrayList;
import java.util.List;
/* compiled from: EventsCache.java */
/* loaded from: classes4.dex */
public class e {
    private final List<j> a = new ArrayList();

    private j b(String str) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.a.get(i2);
            if (jVar.b().equals(str)) {
                return jVar;
            }
        }
        return null;
    }

    private j[] c() {
        return (j[]) this.a.toArray(new j[this.a.size()]);
    }

    public void a(String str, String str2) {
        j b = b(str);
        if (b == null) {
            this.a.add(new j(str, str2));
        } else {
            b.d(str2);
        }
    }

    public void d(String str, String str2) {
        a(str, str2);
    }

    public void onEvent(int i2, String str) {
        l.a().c(i2, str, c());
    }
}
