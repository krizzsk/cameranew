package us.pinguo.common.filter.view;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.repository2020.entity.FilterItem;
import us.pinguo.repository2020.entity.PackageItem;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterPanelView.kt */
@DebugMetadata(c = "us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1", f = "FilterPanelView.kt", i = {}, l = {71, 72}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilterPanelView$seekBarEnable$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $enable;
    final /* synthetic */ FilterItem $filterItem;
    final /* synthetic */ PackageItem $filterPackage;
    int label;
    final /* synthetic */ FilterPanelView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterPanelView.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1$1", f = "FilterPanelView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ boolean $enable;
        final /* synthetic */ boolean $isTemplateFilterAdjust;
        int label;
        final /* synthetic */ FilterPanelView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, FilterPanelView filterPanelView, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isTemplateFilterAdjust = z;
            this.this$0 = filterPanelView;
            this.$enable = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isTemplateFilterAdjust, this.this$0, this.$enable, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                if (this.$isTemplateFilterAdjust) {
                    this.this$0.S(this.$enable);
                } else {
                    this.this$0.P(this.$enable);
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPanelView$seekBarEnable$1(PackageItem packageItem, FilterItem filterItem, FilterPanelView filterPanelView, boolean z, Continuation<? super FilterPanelView$seekBarEnable$1> continuation) {
        super(2, continuation);
        this.$filterPackage = packageItem;
        this.$filterItem = filterItem;
        this.this$0 = filterPanelView;
        this.$enable = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterPanelView$seekBarEnable$1(this.$filterPackage, this.$filterItem, this.this$0, this.$enable, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterPanelView$seekBarEnable$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        if ((r8 != null && r8.isFromEdit()) != false) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r2) goto L14
            kotlin.j.b(r8)
            goto L81
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1c:
            kotlin.j.b(r8)
            goto L51
        L20:
            kotlin.j.b(r8)
            us.pinguo.repository2020.entity.FilterEntry r8 = new us.pinguo.repository2020.entity.FilterEntry
            us.pinguo.repository2020.entity.PackageItem r1 = r7.$filterPackage
            if (r1 != 0) goto L2b
            r1 = r3
            goto L2f
        L2b:
            java.lang.String r1 = r1.getCategoryId()
        L2f:
            us.pinguo.repository2020.entity.FilterItem r5 = r7.$filterItem
            if (r5 != 0) goto L35
            r5 = r3
            goto L39
        L35:
            java.lang.String r5 = r5.getPackageId()
        L39:
            us.pinguo.repository2020.entity.FilterItem r6 = r7.$filterItem
            if (r6 != 0) goto L3f
            r6 = r3
            goto L43
        L3f:
            java.lang.String r6 = r6.getFilterId()
        L43:
            r8.<init>(r1, r5, r6)
            us.pinguo.common.filter.view.FilterPanelView r1 = r7.this$0
            r7.label = r4
            java.lang.Object r8 = us.pinguo.common.filter.view.FilterPanelView.b(r1, r8, r7)
            if (r8 != r0) goto L51
            return r0
        L51:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            r1 = 0
            if (r8 == 0) goto L6a
            us.pinguo.repository2020.entity.PackageItem r8 = r7.$filterPackage
            if (r8 != 0) goto L60
        L5e:
            r8 = 0
            goto L67
        L60:
            boolean r8 = r8.isFromEdit()
            if (r8 != r4) goto L5e
            r8 = 1
        L67:
            if (r8 == 0) goto L6a
            goto L6b
        L6a:
            r4 = 0
        L6b:
            kotlinx.coroutines.g2 r8 = kotlinx.coroutines.z0.c()
            us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1$1 r1 = new us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1$1
            us.pinguo.common.filter.view.FilterPanelView r5 = r7.this$0
            boolean r6 = r7.$enable
            r1.<init>(r4, r5, r6, r3)
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.j.g(r8, r1, r7)
            if (r8 != r0) goto L81
            return r0
        L81:
            kotlin.u r8 = kotlin.u.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.view.FilterPanelView$seekBarEnable$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
