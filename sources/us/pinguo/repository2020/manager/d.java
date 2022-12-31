package us.pinguo.repository2020.manager;

import java.util.Comparator;
import us.pinguo.repository2020.entity.FilterPackage;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class d implements Comparator {
    public static final /* synthetic */ d a = new d();

    private /* synthetic */ d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int p;
        p = FilterLocalDataManager.p((FilterPackage) obj, (FilterPackage) obj2);
        return p;
    }
}
