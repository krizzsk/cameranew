package us.pinguo.repository2020.manager;

import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.database.EffectDbManager;
import us.pinguo.repository2020.entity.FilterPackage;
/* compiled from: FilterUpdateManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterUpdateManager$processUpdatedDetail$1", f = "FilterUpdateManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FilterUpdateManager$processUpdatedDetail$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ List<FilterPackage> $updatedPkgList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterUpdateManager$processUpdatedDetail$1(List<FilterPackage> list, Continuation<? super FilterUpdateManager$processUpdatedDetail$1> continuation) {
        super(2, continuation);
        this.$updatedPkgList = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-4  reason: not valid java name */
    public static final void m200invokeSuspend$lambda4(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FilterPackage filterPackage = (FilterPackage) it.next();
            us.pinguo.repository2020.database.filter.e y = us.pinguo.repository2020.database.a.a().y();
            y.c(y.d(filterPackage.getKey()));
            us.pinguo.repository2020.database.filter.a w = us.pinguo.repository2020.database.a.a().w();
            w.c(w.d(filterPackage.getKey()));
            us.pinguo.repository2020.database.a.a().x().c(filterPackage.getPackageBean());
            String packageMd5 = filterPackage.getPackageBean().getPackageMd5();
            if (packageMd5 != null) {
                us.pinguo.util.l.j(us.pinguo.common.filter.util.a.a.b(packageMd5));
            }
            String displayMd5 = filterPackage.getPackageBean().getDisplayMd5();
            if (displayMd5 != null) {
                us.pinguo.util.l.j(us.pinguo.common.filter.util.a.a.b(displayMd5));
            }
            us.pinguo.common.log.a.c("need update package:" + filterPackage.getKey() + ",name:" + filterPackage.getName(), new Object[0]);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterUpdateManager$processUpdatedDetail$1(this.$updatedPkgList, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterUpdateManager$processUpdatedDetail$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            try {
                EffectDbManager a = us.pinguo.repository2020.database.a.a();
                final List<FilterPackage> list = this.$updatedPkgList;
                a.runInTransaction(new Runnable() { // from class: us.pinguo.repository2020.manager.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilterUpdateManager$processUpdatedDetail$1.m200invokeSuspend$lambda4(list);
                    }
                });
                return u.a;
            } catch (Exception e2) {
                e2.printStackTrace();
                throw e2;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
