package us.pinguo.camera360.shop.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.y;
import kotlin.jvm.internal.s;
/* compiled from: StoreFilterSortUtil.kt */
/* loaded from: classes2.dex */
public final class j {

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = kotlin.w.b.a(Long.valueOf(((h) t2).f9594d), Long.valueOf(((h) t).f9594d));
            return a;
        }
    }

    public static final void a(ArrayList<h> arrayList) {
        s.h(arrayList, "<this>");
        for (h hVar : arrayList) {
            List<g> c = hVar.c(new FilterType[0]);
            s.g(c, "filterPackage.getFilters()");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : c) {
                if (((g) obj).isCollect()) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                long collectTime = ((g) it.next()).getCollectTime();
                while (it.hasNext()) {
                    long collectTime2 = ((g) it.next()).getCollectTime();
                    if (collectTime < collectTime2) {
                        collectTime = collectTime2;
                    }
                }
                hVar.f9594d = collectTime;
            } else {
                throw new NoSuchElementException();
            }
        }
        if (arrayList.size() > 1) {
            y.p(arrayList, new a());
        }
    }
}
