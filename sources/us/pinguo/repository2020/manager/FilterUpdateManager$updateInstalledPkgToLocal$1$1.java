package us.pinguo.repository2020.manager;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.repository2020.entity.OnUpdateDetailListener;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterUpdateManager.kt */
/* loaded from: classes6.dex */
public final class FilterUpdateManager$updateInstalledPkgToLocal$1$1 extends Lambda implements kotlin.jvm.b.a<u> {
    public static final FilterUpdateManager$updateInstalledPkgToLocal$1$1 INSTANCE = new FilterUpdateManager$updateInstalledPkgToLocal$1$1();

    FilterUpdateManager$updateInstalledPkgToLocal$1$1() {
        super(0);
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ u invoke() {
        invoke2();
        return u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ArrayList<OnUpdateDetailListener> arrayList;
        FilterUpdateManager filterUpdateManager = FilterUpdateManager.a;
        arrayList = FilterUpdateManager.c;
        filterUpdateManager.h(arrayList);
    }
}
