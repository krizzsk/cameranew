package us.pinguo.repository2020.manager;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.database.makeup.MaterialDetailTable;
import us.pinguo.repository2020.entity.StyleMakeupUpdateData;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BeautyDataManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1", f = "BeautyDataManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ CopyOnWriteArrayList<String> $installedIds;
    final /* synthetic */ StyleMakeupUpdateData[] $styleMakeupUpdateList;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1(StyleMakeupUpdateData[] styleMakeupUpdateDataArr, CopyOnWriteArrayList<String> copyOnWriteArrayList, Continuation<? super BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1> continuation) {
        super(2, continuation);
        this.$styleMakeupUpdateList = styleMakeupUpdateDataArr;
        this.$installedIds = copyOnWriteArrayList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1(this.$styleMakeupUpdateList, this.$installedIds, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyDataManager$updateStyleMakeupDetail$request$1$onResponse$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            ArrayList arrayList = new ArrayList();
            StyleMakeupUpdateData[] styleMakeupUpdateDataArr = this.$styleMakeupUpdateList;
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.$installedIds;
            int i2 = 0;
            int length = styleMakeupUpdateDataArr.length;
            while (i2 < length) {
                StyleMakeupUpdateData styleMakeupUpdateData = styleMakeupUpdateDataArr[i2];
                i2++;
                if (styleMakeupUpdateData.getPid() != null) {
                    us.pinguo.repository2020.database.makeup.a z = us.pinguo.repository2020.database.a.a().z();
                    String pid = styleMakeupUpdateData.getPid();
                    s.e(pid);
                    MaterialDetailTable b = z.b(pid);
                    if (b != null && (!s.c(b.getDisplayMd5(), styleMakeupUpdateData.getDisplay_zip_md5()) || !s.c(b.getPackageMd5(), styleMakeupUpdateData.getPackage_zip_md5()))) {
                        copyOnWriteArrayList.remove(b.getId());
                        arrayList.add(b.getId());
                        BeautyDataManager.a.q().remove(b.getId());
                    }
                }
            }
            if (arrayList.size() > 0) {
                us.pinguo.repository2020.database.a.a().z().c(arrayList);
                us.pinguo.repository2020.database.a.a().A().b(arrayList);
            }
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
