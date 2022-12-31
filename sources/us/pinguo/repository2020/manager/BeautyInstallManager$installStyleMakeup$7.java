package us.pinguo.repository2020.manager;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.MaterialDetail;
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: BeautyInstallManager.kt */
@DebugMetadata(c = "us.pinguo.repository2020.manager.BeautyInstallManager$installStyleMakeup$7", f = "BeautyInstallManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class BeautyInstallManager$installStyleMakeup$7 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ q<Boolean, MaterialDetail, String, u> $installAction;
    final /* synthetic */ MaterialDetail $materialDetail;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/b/q<-Ljava/lang/Boolean;-Lus/pinguo/repository2020/entity/MaterialDetail;-Ljava/lang/String;Lkotlin/u;>;TT;Lkotlin/coroutines/Continuation<-Lus/pinguo/repository2020/manager/BeautyInstallManager$installStyleMakeup$7;>;)V */
    public BeautyInstallManager$installStyleMakeup$7(q qVar, MaterialDetail materialDetail, Continuation continuation) {
        super(2, continuation);
        this.$installAction = qVar;
        this.$materialDetail = materialDetail;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BeautyInstallManager$installStyleMakeup$7(this.$installAction, this.$materialDetail, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((BeautyInstallManager$installStyleMakeup$7) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            this.$installAction.invoke(Boxing.boxBoolean(true), this.$materialDetail, "");
            return u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
