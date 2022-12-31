package us.pinguo.common.filter.controller;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.view.FilterPanelView;
import us.pinguo.common.widget.FilterLayerOpacityAdjustSelector;
import us.pinguo.commonui.R;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.ui.widget.StickySeekBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$4$1", f = "FilterController.kt", i = {}, l = {393, 394}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilterController$4$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ FilterLayerOpacityAdjustSelector $selectorFilter;
    final /* synthetic */ FilterLayerOpacityAdjustSelector $selectorTemplate;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$4$1$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.controller.FilterController$4$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ int $defaultValue;
        final /* synthetic */ FilterLayerOpacityAdjustSelector $selectorFilter;
        final /* synthetic */ FilterLayerOpacityAdjustSelector $selectorTemplate;
        int label;
        final /* synthetic */ FilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FilterController filterController, FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector, FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector2, int i2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = filterController;
            this.$selectorFilter = filterLayerOpacityAdjustSelector;
            this.$selectorTemplate = filterLayerOpacityAdjustSelector2;
            this.$defaultValue = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$selectorFilter, this.$selectorTemplate, this.$defaultValue, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int intValue;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                this.this$0.b.g0(true);
                FilterLayerOpacityAdjustSelector.setIsSelected$default(this.$selectorFilter, this.this$0.b.P(), false, 2, null);
                FilterLayerOpacityAdjustSelector.setIsSelected$default(this.$selectorTemplate, true ^ this.this$0.b.P(), false, 2, null);
                FilterPanelView v0 = this.this$0.v0();
                int i2 = R.id.filterSeekBar;
                StickySeekBar stickySeekBar = (StickySeekBar) v0.a(i2);
                Integer value = this.this$0.b.s().getValue();
                if (value == null) {
                    intValue = this.$defaultValue;
                } else {
                    intValue = value.intValue();
                }
                stickySeekBar.setProgress(intValue);
                ((StickySeekBar) this.this$0.v0().a(i2)).setDefaultProgress(this.$defaultValue);
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$4$1(FilterController filterController, FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector, FilterLayerOpacityAdjustSelector filterLayerOpacityAdjustSelector2, Continuation<? super FilterController$4$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
        this.$selectorFilter = filterLayerOpacityAdjustSelector;
        this.$selectorTemplate = filterLayerOpacityAdjustSelector2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$4$1(this.this$0, this.$selectorFilter, this.$selectorTemplate, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$4$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            FilterEntry value = this.this$0.b.y().getValue();
            String itemId = value == null ? null : value.getItemId();
            CameraFilterModule cameraFilterModule = this.this$0.b;
            this.label = 1;
            obj = cameraFilterModule.q(itemId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.j.b(obj);
            return u.a;
        } else {
            kotlin.j.b(obj);
        }
        int intValue = ((Number) obj).intValue();
        g2 c = z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$selectorFilter, this.$selectorTemplate, intValue, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
