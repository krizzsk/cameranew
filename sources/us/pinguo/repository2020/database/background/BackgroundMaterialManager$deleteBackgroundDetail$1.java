package us.pinguo.repository2020.database.background;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.utils.h;
import us.pinguo.util.FileUtils;
/* compiled from: BackgroundMaterialManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.database.background.BackgroundMaterialManager$deleteBackgroundDetail$1", f = "BackgroundMaterialManager.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BackgroundMaterialManager$deleteBackgroundDetail$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ String $id;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackgroundMaterialManager$deleteBackgroundDetail$1(String str, Continuation<? super BackgroundMaterialManager$deleteBackgroundDetail$1> continuation) {
        super(2, continuation);
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BackgroundMaterialManager$deleteBackgroundDetail$1(this.$id, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BackgroundMaterialManager$deleteBackgroundDetail$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ConcurrentHashMap concurrentHashMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            concurrentHashMap = BackgroundMaterialManager.f11834f;
            concurrentHashMap.remove(this.$id);
            String q = s.q(h.a(), this.$id);
            this.label = 1;
            if (FileUtils.l(q, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
