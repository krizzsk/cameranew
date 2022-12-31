package us.pinguo.edit2020.viewmodel.module;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.j;
import kotlin.jvm.b.l;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.repository2020.entity.SelfDefMakeup;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditMakeupModule.kt */
@DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$2", f = "EditMakeupModule.kt", i = {}, l = {320, 324}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditMakeupModule$renderEditSelfDefMakeup$2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ int $faceIndex;
    final /* synthetic */ l<Boolean, u> $renderAction;
    final /* synthetic */ SelfDefMakeup $selfDefMakeup;
    int label;
    final /* synthetic */ EditMakeupModule this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMakeupModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$2$1", f = "EditMakeupModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$2$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ l<Boolean, u> $renderAction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(l<? super Boolean, u> lVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$renderAction = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$renderAction, continuation);
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
                l<Boolean, u> lVar = this.$renderAction;
                if (lVar == null) {
                    return null;
                }
                lVar.invoke(Boxing.boxBoolean(true));
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditMakeupModule.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$2$2", f = "EditMakeupModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.viewmodel.module.EditMakeupModule$renderEditSelfDefMakeup$2$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ l<Boolean, u> $renderAction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(l<? super Boolean, u> lVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$renderAction = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$renderAction, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                j.b(obj);
                l<Boolean, u> lVar = this.$renderAction;
                if (lVar == null) {
                    return null;
                }
                lVar.invoke(Boxing.boxBoolean(false));
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EditMakeupModule$renderEditSelfDefMakeup$2(EditMakeupModule editMakeupModule, SelfDefMakeup selfDefMakeup, int i2, l<? super Boolean, u> lVar, Continuation<? super EditMakeupModule$renderEditSelfDefMakeup$2> continuation) {
        super(2, continuation);
        this.this$0 = editMakeupModule;
        this.$selfDefMakeup = selfDefMakeup;
        this.$faceIndex = i2;
        this.$renderAction = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new EditMakeupModule$renderEditSelfDefMakeup$2(this.this$0, this.$selfDefMakeup, this.$faceIndex, this.$renderAction, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((EditMakeupModule$renderEditSelfDefMakeup$2) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String M;
        SelfDefMakeup[] selfDefMakeupArr;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            j.b(obj);
            if (this.this$0.V(this.$selfDefMakeup)) {
                SelfDefMakeup[][] x = this.this$0.x();
                if (x != null && (selfDefMakeupArr = x[this.this$0.o()]) != null) {
                    selfDefMakeupArr[this.this$0.C()] = this.$selfDefMakeup;
                }
                EditMakeupModule editMakeupModule = this.this$0;
                int i3 = this.$faceIndex;
                M = editMakeupModule.M(this.$selfDefMakeup);
                editMakeupModule.Z(i3, M, this.$selfDefMakeup);
                g2 c = z0.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$renderAction, null);
                this.label = 1;
                if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                g2 c2 = z0.c();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$renderAction, null);
                this.label = 2;
                if (kotlinx.coroutines.j.g(c2, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i2 != 1 && i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            j.b(obj);
        }
        return u.a;
    }
}
