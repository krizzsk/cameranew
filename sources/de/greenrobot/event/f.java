package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* loaded from: classes3.dex */
final class f {

    /* renamed from: d  reason: collision with root package name */
    private static final List<f> f8626d = new ArrayList();
    Object a;
    k b;
    f c;

    private f(Object obj, k kVar) {
        this.a = obj;
        this.b = kVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(k kVar, Object obj) {
        List<f> list = f8626d;
        synchronized (list) {
            int size = list.size();
            if (size > 0) {
                f remove = list.remove(size - 1);
                remove.a = obj;
                remove.b = kVar;
                remove.c = null;
                return remove;
            }
            return new f(obj, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(f fVar) {
        fVar.a = null;
        fVar.b = null;
        fVar.c = null;
        List<f> list = f8626d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(fVar);
            }
        }
    }
}
