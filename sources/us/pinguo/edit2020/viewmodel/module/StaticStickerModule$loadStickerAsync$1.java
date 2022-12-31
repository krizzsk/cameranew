package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* compiled from: StaticStickerModule.kt */
/* loaded from: classes4.dex */
final class StaticStickerModule$loadStickerAsync$1 extends Lambda implements l<Exception, u> {
    final /* synthetic */ l<Exception, u> $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StaticStickerModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.StaticStickerModule$loadStickerAsync$1$1", f = "StaticStickerModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.StaticStickerModule$loadStickerAsync$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ l<Exception, u> $callback;
        final /* synthetic */ Exception $it;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(l<? super Exception, u> lVar, Exception exc, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = lVar;
            this.$it = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, this.$it, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                l<Exception, u> lVar = this.$callback;
                if (lVar != null) {
                    lVar.invoke(this.$it);
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StaticStickerModule$loadStickerAsync$1(l<? super Exception, u> lVar) {
        super(1);
        this.$callback = lVar;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Exception exc) {
        invoke2(exc);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Exception exc) {
        kotlinx.coroutines.l.d(n0.a(z0.c()), null, null, new AnonymousClass1(this.$callback, exc, null), 3, null);
    }
}
