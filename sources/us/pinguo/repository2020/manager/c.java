package us.pinguo.repository2020.manager;

import java.util.Comparator;
import us.pinguo.repository2020.database.filter.FilterParamsTable;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class c implements Comparator {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int B;
        B = FilterLocalDataManager.B((FilterParamsTable) obj, (FilterParamsTable) obj2);
        return B;
    }
}
