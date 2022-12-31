package us.pinguo.repository2020.manager;

import java.util.Comparator;
import us.pinguo.repository2020.entity.BaseFilter;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class b implements Comparator {
    public static final /* synthetic */ b a = new b();

    private /* synthetic */ b() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int g2;
        g2 = FilterLocalDataManager.g((BaseFilter) obj, (BaseFilter) obj2);
        return g2;
    }
}
