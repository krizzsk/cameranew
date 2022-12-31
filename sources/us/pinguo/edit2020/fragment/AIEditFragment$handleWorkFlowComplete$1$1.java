package us.pinguo.edit2020.fragment;

import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.controller.z2;
import us.pinguo.edit2020.viewmodel.AIEditViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AIEditFragment.kt */
/* loaded from: classes4.dex */
public final class AIEditFragment$handleWorkFlowComplete$1$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ z2 $currentTab;
    final /* synthetic */ AIEditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AIEditFragment.kt */
    /* renamed from: us.pinguo.edit2020.fragment.AIEditFragment$handleWorkFlowComplete$1$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
        final /* synthetic */ z2 $currentTab;
        final /* synthetic */ String $it;
        final /* synthetic */ AIEditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(z2 z2Var, AIEditFragment aIEditFragment, String str) {
            super(0);
            this.$currentTab = z2Var;
            this.this$0 = aIEditFragment;
            this.$it = str;
        }

        @Override // kotlin.jvm.b.a
        public /* bridge */ /* synthetic */ kotlin.u invoke() {
            invoke2();
            return kotlin.u.a;
        }

        @Override // kotlin.jvm.b.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$currentTab.d();
            this.this$0.R0(this.$it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIEditFragment$handleWorkFlowComplete$1$1(AIEditFragment aIEditFragment, z2 z2Var) {
        super(1);
        this.this$0 = aIEditFragment;
        this.$currentTab = z2Var;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        AIEditViewModel m0;
        m0 = this.this$0.m0();
        m0.k(this.$currentTab.F(), new AnonymousClass1(this.$currentTab, this.this$0, str));
    }
}
