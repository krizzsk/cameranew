package us.pinguo.common.filter.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.m0;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$showFilterGuide$1", f = "FilterController.kt", i = {}, l = {1473}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilterController$showFilterGuide$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$showFilterGuide$1(FilterController filterController, Continuation<? super FilterController$showFilterGuide$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$showFilterGuide$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$showFilterGuide$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.j.b(r9)
            goto L2e
        Lf:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L17:
            kotlin.j.b(r9)
            boolean r9 = us.pinguo.foundation.utils.p0.c()
            if (r9 == 0) goto L23
            r3 = 1000(0x3e8, double:4.94E-321)
            goto L25
        L23:
            r3 = 450(0x1c2, double:2.223E-321)
        L25:
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r3, r8)
            if (r9 != r0) goto L2e
            return r0
        L2e:
            us.pinguo.common.filter.controller.FilterController r9 = r8.this$0
            us.pinguo.common.filter.view.FilterPanelView r9 = r9.v0()
            int r0 = us.pinguo.commonui.R.id.packageListView
            android.view.View r9 = r9.a(r0)
            us.pinguo.common.filter.view.FilterPackageListView r9 = (us.pinguo.common.filter.view.FilterPackageListView) r9
            int r0 = us.pinguo.commonui.R.id.filterPackageRecyclerView
            android.view.View r9 = r9.a(r0)
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            us.pinguo.common.filter.controller.FilterController r0 = r8.this$0
            int r0 = r0.u0()
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r9.findViewHolderForAdapterPosition(r0)
            if (r9 != 0) goto L53
            kotlin.u r9 = kotlin.u.a
            return r9
        L53:
            us.pinguo.common.filter.controller.FilterController r0 = r8.this$0
            us.pinguo.common.filter.guide.c r1 = new us.pinguo.common.filter.guide.c
            us.pinguo.common.filter.controller.FilterController r3 = r8.this$0
            us.pinguo.common.filter.view.FilterPanelView r3 = r3.v0()
            android.content.Context r3 = r3.getContext()
            boolean r4 = r3 instanceof android.app.Activity
            if (r4 == 0) goto L68
            android.app.Activity r3 = (android.app.Activity) r3
            goto L69
        L68:
            r3 = 0
        L69:
            if (r3 != 0) goto L6e
            kotlin.u r9 = kotlin.u.a
            return r9
        L6e:
            r1.<init>(r3)
            us.pinguo.common.filter.controller.FilterController r3 = r8.this$0
            android.view.View r4 = r9.itemView
            int r5 = us.pinguo.commonui.R.id.redPoint
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r5 = 0
            if (r4 == 0) goto L91
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L87
            goto L88
        L87:
            r2 = 0
        L88:
            if (r2 == 0) goto L91
            r2 = 12
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            goto L95
        L91:
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
        L95:
            int r2 = us.pinguo.common.widget.i.a.a(r2)
            android.view.View r9 = r9.itemView
            java.lang.String r4 = "firstItemView.itemView"
            kotlin.jvm.internal.s.g(r9, r4)
            us.pinguo.common.filter.guide.f r4 = new us.pinguo.common.filter.guide.f
            r6 = 8
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            int r6 = us.pinguo.common.widget.i.a.a(r6)
            r4.<init>(r5, r5, r6, r2)
            r1.g(r9, r4)
            kotlin.jvm.b.l r9 = r3.w0()
            if (r9 != 0) goto Lb9
            goto Lbc
        Lb9:
            r9.invoke(r1)
        Lbc:
            us.pinguo.repository2020.utils.o r2 = us.pinguo.repository2020.utils.o.a
            r4 = 1
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r3 = "guide_displayed"
            us.pinguo.repository2020.utils.o.n(r2, r3, r4, r5, r6, r7)
            us.pinguo.common.filter.controller.FilterController$showFilterGuide$1$1$1 r9 = new us.pinguo.common.filter.controller.FilterController$showFilterGuide$1$1$1
            r9.<init>(r1)
            r1.d(r9)
            us.pinguo.common.filter.controller.FilterController.f0(r0, r1)
            kotlin.u r9 = kotlin.u.a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController$showFilterGuide$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
