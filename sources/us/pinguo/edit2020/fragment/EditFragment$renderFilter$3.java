package us.pinguo.edit2020.fragment;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
@DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$renderFilter$3", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditFragment$renderFilter$3 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ EditFilterController $controller;
    final /* synthetic */ int $currentOpacity;
    final /* synthetic */ int $currentTemplateOpacity;
    final /* synthetic */ int $defaultOpacity;
    final /* synthetic */ int $defaultTemplateOpacity;
    int label;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$renderFilter$3(EditFragment editFragment, EditFilterController editFilterController, int i2, int i3, int i4, int i5, Continuation<? super EditFragment$renderFilter$3> continuation) {
        super(2, continuation);
        this.this$0 = editFragment;
        this.$controller = editFilterController;
        this.$currentOpacity = i2;
        this.$defaultOpacity = i3;
        this.$currentTemplateOpacity = i4;
        this.$defaultTemplateOpacity = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFragment$renderFilter$3(this.this$0, this.$controller, this.$currentOpacity, this.$defaultOpacity, this.$currentTemplateOpacity, this.$defaultTemplateOpacity, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFragment$renderFilter$3) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EditViewModel j1;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            j1 = this.this$0.j1();
            if (j1.i().P()) {
                this.$controller.B1(this.$currentOpacity);
                this.$controller.A1(this.$defaultOpacity);
            } else {
                this.$controller.B1(this.$currentTemplateOpacity);
                this.$controller.A1(this.$defaultTemplateOpacity);
            }
            if (this.$controller.L0()) {
                this.$controller.d2();
                this.this$0.G2();
                return kotlin.u.a;
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
