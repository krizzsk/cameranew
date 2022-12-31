package com.tapjoy.internal;

import com.tapjoy.internal.ij;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public final class hh implements cf {
    public final gz a;
    private final Map c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d  reason: collision with root package name */
    private final Map f7616d = ju.a();
    Set b = null;

    public hh(gz gzVar) {
        this.a = gzVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tapjoy.internal.cf
    public void a(ca caVar, ij.a aVar) {
        if (caVar instanceof ij) {
            List list = aVar.b;
            if (list != null) {
                synchronized (this) {
                    this.b = list instanceof Collection ? new HashSet(js.a(list)) : jv.a(list.iterator());
                }
            }
            ij ijVar = (ij) caVar;
            String str = ijVar.c;
            boolean z = ijVar.f7703d;
            this.f7616d.remove(str);
            if (!z) {
                this.c.put(str, aVar.a);
            }
            hg hgVar = aVar.a;
            ha haVar = this.a.p;
            if (hgVar instanceof hf) {
                gw.a("No content for \"{}\"", str);
                haVar.a(str);
                return;
            }
            gw.a("New content for \"{}\" is ready", str);
            if (z) {
                hgVar.a(haVar, new fw());
                return;
            } else {
                haVar.b(str);
                return;
            }
        }
        throw new IllegalStateException(caVar.getClass().getName());
    }

    @Override // com.tapjoy.internal.cf
    public final void a(ca caVar) {
        a(caVar, new ij.a(new hf(), null));
    }
}
