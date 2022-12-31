package us.pinguo.edit2020.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* compiled from: EditFilterController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$hide$1", f = "EditFilterController.kt", i = {}, l = {553, 557}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
final class EditFilterController$hide$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ EditFilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFilterController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$hide$1$1", f = "EditFilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.EditFilterController$hide$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ int $filterDefaultOpacity;
        final /* synthetic */ int $value;
        int label;
        final /* synthetic */ EditFilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditFilterController editFilterController, int i2, int i3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editFilterController;
            this.$value = i2;
            this.$filterDefaultOpacity = i3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$value, this.$filterDefaultOpacity, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            EditFilterModule editFilterModule;
            FilterPanelView v0;
            FilterPanelView v02;
            FilterPanelView v03;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                editFilterModule = this.this$0.v;
                if (!editFilterModule.P()) {
                    v03 = this.this$0.v0();
                    v03.h0(this.$value);
                } else {
                    v0 = this.this$0.v0();
                    v0.h0(this.$filterDefaultOpacity);
                }
                v02 = this.this$0.v0();
                v02.setSeekBarVisible(true);
                this.this$0.f1(false);
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFilterController$hide$1(EditFilterController editFilterController, Continuation<? super EditFilterController$hide$1> continuation) {
        super(2, continuation);
        this.this$0 = editFilterController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFilterController$hide$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFilterController$hide$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        EditFilterModule editFilterModule;
        EditFilterModule editFilterModule2;
        EditFilterModule editFilterModule3;
        EditFilterModule editFilterModule4;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            editFilterModule = this.this$0.v;
            FilterEntry value = editFilterModule.y().getValue();
            editFilterModule2 = this.this$0.v;
            String itemId = value == null ? null : value.getItemId();
            this.label = 1;
            obj = editFilterModule2.q(itemId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return kotlin.u.a;
        } else {
            kotlin.j.b(obj);
        }
        int intValue = ((Number) obj).intValue();
        editFilterModule3 = this.this$0.v;
        editFilterModule3.s().postValue(Boxing.boxInt(intValue));
        editFilterModule4 = this.this$0.v;
        editFilterModule4.v().postValue(Boxing.boxInt(100));
        kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, 100, intValue, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return kotlin.u.a;
    }
}
