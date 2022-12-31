package us.pinguo.repository2020.manager;

import com.pinguo.camera360.effect.model.entity.Effect;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.text.StringsKt__StringsKt;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.utils.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterRedPointManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.FilterRedPointManager$initLocalToMemory$1", f = "FilterRedPointManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class FilterRedPointManager$initLocalToMemory$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilterRedPointManager$initLocalToMemory$1(Continuation<? super FilterRedPointManager$initLocalToMemory$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterRedPointManager$initLocalToMemory$1(continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterRedPointManager$initLocalToMemory$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String i2;
        List<String> p0;
        List<String> p02;
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            o oVar = o.a;
            if (oVar.a("sp_key_init_first_server_data", false, "filterRedPointManagerFile")) {
                FilterRedPointManager filterRedPointManager = FilterRedPointManager.a;
                FilterRedPointManager.f11911d = true;
                String i3 = oVar.i("sp_key_local_category", null, "filterRedPointManagerFile");
                if (i3 != null && (i2 = oVar.i("sp_key_local_package", null, "filterRedPointManagerFile")) != null) {
                    p0 = StringsKt__StringsKt.p0(i3, new String[]{Effect.DIVIDER}, false, 0, 6, null);
                    for (String str : p0) {
                        copyOnWriteArrayList2 = FilterRedPointManager.b;
                        copyOnWriteArrayList2.add(str);
                    }
                    p02 = StringsKt__StringsKt.p0(i2, new String[]{Effect.DIVIDER}, false, 0, 6, null);
                    for (String str2 : p02) {
                        copyOnWriteArrayList = FilterRedPointManager.c;
                        copyOnWriteArrayList.add(str2);
                    }
                    return u.a;
                }
                return u.a;
            }
            FilterRedPointManager filterRedPointManager2 = FilterRedPointManager.a;
            FilterRedPointManager.f11911d = false;
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
