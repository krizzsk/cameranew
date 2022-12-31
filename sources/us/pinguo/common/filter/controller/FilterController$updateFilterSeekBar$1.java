package us.pinguo.common.filter.controller;

import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.Group;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlinx.coroutines.m0;
import us.pinguo.commonui.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1", f = "FilterController.kt", i = {0, 1}, l = {TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "invokeSuspend", n = {"entry", "isSelectorVisible"}, s = {"L$0", "I$0"})
/* loaded from: classes4.dex */
public final class FilterController$updateFilterSeekBar$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ boolean $isSelectorVisible;
        final /* synthetic */ Boolean $isSkyChange;
        int label;
        final /* synthetic */ FilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Boolean bool, FilterController filterController, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSkyChange = bool;
            this.this$0 = filterController;
            this.$isSelectorVisible = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSkyChange, this.this$0, this.$isSelectorVisible, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                if (s.c(this.$isSkyChange, Boxing.boxBoolean(true))) {
                    Group group = (Group) this.this$0.v0().a(R.id.groupSeekBar);
                    s.g(group, "filterPanelView.groupSeekBar");
                    group.setVisibility(8);
                    VdsAgent.onSetViewVisibility(group, 8);
                } else if (this.$isSelectorVisible) {
                    View a = this.this$0.v0().a(R.id.selectorFilter);
                    s.g(a, "filterPanelView.selectorFilter");
                    int i3 = this.$isSelectorVisible ? 0 : 8;
                    a.setVisibility(i3);
                    VdsAgent.onSetViewVisibility(a, i3);
                    View a2 = this.this$0.v0().a(R.id.selectorTemplate);
                    s.g(a2, "filterPanelView.selectorTemplate");
                    int i4 = this.$isSelectorVisible ? 0 : 8;
                    a2.setVisibility(i4);
                    VdsAgent.onSetViewVisibility(a2, i4);
                    Group group2 = (Group) this.this$0.v0().a(R.id.groupSeekBar);
                    s.g(group2, "filterPanelView.groupSeekBar");
                    i2 = this.this$0.v0().x() ? 0 : 8;
                    group2.setVisibility(i2);
                    VdsAgent.onSetViewVisibility(group2, i2);
                    if (this.this$0.b.P()) {
                        this.this$0.v0().X();
                    } else {
                        this.this$0.v0().Z();
                    }
                } else {
                    View a3 = this.this$0.v0().a(R.id.selectorFilter);
                    s.g(a3, "filterPanelView.selectorFilter");
                    int i5 = this.$isSelectorVisible ? 0 : 8;
                    a3.setVisibility(i5);
                    VdsAgent.onSetViewVisibility(a3, i5);
                    View a4 = this.this$0.v0().a(R.id.selectorTemplate);
                    s.g(a4, "filterPanelView.selectorTemplate");
                    i2 = this.$isSelectorVisible ? 0 : 8;
                    a4.setVisibility(i2);
                    VdsAgent.onSetViewVisibility(a4, i2);
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$updateFilterSeekBar$1(FilterController filterController, Continuation<? super FilterController$updateFilterSeekBar$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$updateFilterSeekBar$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$updateFilterSeekBar$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 0
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2e
            if (r1 == r6) goto L26
            if (r1 == r5) goto L20
            if (r1 != r4) goto L18
            kotlin.j.b(r11)
            goto L95
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L20:
            int r1 = r10.I$0
            kotlin.j.b(r11)
            goto L7c
        L26:
            java.lang.Object r1 = r10.L$0
            us.pinguo.repository2020.entity.FilterEntry r1 = (us.pinguo.repository2020.entity.FilterEntry) r1
            kotlin.j.b(r11)
            goto L53
        L2e:
            kotlin.j.b(r11)
            us.pinguo.common.filter.controller.FilterController r11 = r10.this$0
            us.pinguo.common.filter.CameraFilterModule r11 = us.pinguo.common.filter.controller.FilterController.Z(r11)
            us.pinguo.repository2020.u r11 = r11.y()
            java.lang.Object r11 = r11.getValue()
            r1 = r11
            us.pinguo.repository2020.entity.FilterEntry r1 = (us.pinguo.repository2020.entity.FilterEntry) r1
            us.pinguo.common.filter.controller.FilterController r11 = r10.this$0
            us.pinguo.common.filter.CameraFilterModule r11 = us.pinguo.common.filter.controller.FilterController.Z(r11)
            r10.L$0 = r1
            r10.label = r6
            java.lang.Object r11 = r11.Z(r1, r10)
            if (r11 != r0) goto L53
            return r0
        L53:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L65
            us.pinguo.common.filter.controller.FilterController r11 = r10.this$0
            boolean r11 = us.pinguo.common.filter.controller.FilterController.c0(r11)
            if (r11 == 0) goto L65
            r11 = 1
            goto L66
        L65:
            r11 = 0
        L66:
            us.pinguo.common.filter.controller.FilterController r7 = r10.this$0
            us.pinguo.common.filter.CameraFilterModule r7 = us.pinguo.common.filter.controller.FilterController.Z(r7)
            r10.L$0 = r2
            r10.I$0 = r11
            r10.label = r5
            java.lang.Object r1 = r7.W(r1, r10)
            if (r1 != r0) goto L79
            return r0
        L79:
            r9 = r1
            r1 = r11
            r11 = r9
        L7c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            kotlinx.coroutines.g2 r5 = kotlinx.coroutines.z0.c()
            us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1$1 r7 = new us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1$1
            us.pinguo.common.filter.controller.FilterController r8 = r10.this$0
            if (r1 == 0) goto L89
            r3 = 1
        L89:
            r7.<init>(r11, r8, r3, r2)
            r10.label = r4
            java.lang.Object r11 = kotlinx.coroutines.j.g(r5, r7, r10)
            if (r11 != r0) goto L95
            return r0
        L95:
            kotlin.u r11 = kotlin.u.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController$updateFilterSeekBar$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
