package us.pinguo.common.filter.controller;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.b.p;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.common.filter.view.FilterPackageListView;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
/* loaded from: classes4.dex */
public final class FilterController$3$1 extends Lambda implements kotlin.jvm.b.l<Boolean, u> {
    final /* synthetic */ FilterPackageListView $this_apply;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$3$1$1", f = "FilterController.kt", i = {}, l = {344, 345}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.controller.FilterController$3$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        int label;
        final /* synthetic */ FilterController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FilterController.kt */
        @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$3$1$1$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.common.filter.controller.FilterController$3$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03781 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            final /* synthetic */ boolean $isTemplateFilterAdjust;
            int label;
            final /* synthetic */ FilterController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03781(boolean z, FilterController filterController, Continuation<? super C03781> continuation) {
                super(2, continuation);
                this.$isTemplateFilterAdjust = z;
                this.this$0 = filterController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new C03781(this.$isTemplateFilterAdjust, this.this$0, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((C03781) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    kotlin.j.b(obj);
                    if (this.$isTemplateFilterAdjust) {
                        this.this$0.v0().S(true);
                    } else {
                        this.this$0.v0().P(true);
                    }
                    return u.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FilterController filterController, FilterEntry filterEntry, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = filterController;
            this.$entry = filterEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$entry, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                CameraFilterModule cameraFilterModule = this.this$0.b;
                FilterEntry filterEntry = this.$entry;
                this.label = 1;
                obj = cameraFilterModule.Z(filterEntry, this);
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
            boolean booleanValue = ((Boolean) obj).booleanValue();
            g2 c = z0.c();
            C03781 c03781 = new C03781(booleanValue, this.this$0, null);
            this.label = 2;
            if (kotlinx.coroutines.j.g(c, c03781, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$3$1$2", f = "FilterController.kt", i = {}, l = {359, BaseBlurEffect.ROTATION_360}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.controller.FilterController$3$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ FilterPackageListView $this_apply;
        int label;
        final /* synthetic */ FilterController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FilterController.kt */
        @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$3$1$2$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.common.filter.controller.FilterController$3$1$2$1  reason: invalid class name */
        /* loaded from: classes4.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
            final /* synthetic */ boolean $isTemplateFilterAdjust;
            final /* synthetic */ FilterPackageListView $this_apply;
            int label;
            final /* synthetic */ FilterController this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z, FilterController filterController, FilterPackageListView filterPackageListView, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$isTemplateFilterAdjust = z;
                this.this$0 = filterController;
                this.$this_apply = filterPackageListView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$isTemplateFilterAdjust, this.this$0, this.$this_apply, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
                return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(u.a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
                if (r4.getVisibility() == 0) goto L22;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
                r4 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
                r4 = false;
             */
            /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
                if (r4.getVisibility() == 0) goto L22;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r4) {
                /*
                    r3 = this;
                    kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r0 = r3.label
                    if (r0 != 0) goto L93
                    kotlin.j.b(r4)
                    boolean r4 = r3.$isTemplateFilterAdjust
                    r0 = 1
                    r1 = 0
                    if (r4 == 0) goto L2a
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    int r2 = us.pinguo.commonui.R.id.groupSeekBar
                    android.view.View r4 = r4.a(r2)
                    androidx.constraintlayout.widget.Group r4 = (androidx.constraintlayout.widget.Group) r4
                    java.lang.String r2 = "filterPanelView.groupSeekBar"
                    kotlin.jvm.internal.s.g(r4, r2)
                    int r4 = r4.getVisibility()
                    if (r4 != 0) goto L45
                    goto L43
                L2a:
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    int r2 = us.pinguo.commonui.R.id.filterSeekBar
                    android.view.View r4 = r4.a(r2)
                    us.pinguo.ui.widget.StickySeekBar r4 = (us.pinguo.ui.widget.StickySeekBar) r4
                    java.lang.String r2 = "filterPanelView.filterSeekBar"
                    kotlin.jvm.internal.s.g(r4, r2)
                    int r4 = r4.getVisibility()
                    if (r4 != 0) goto L45
                L43:
                    r4 = 1
                    goto L46
                L45:
                    r4 = 0
                L46:
                    if (r4 == 0) goto L64
                    us.pinguo.common.filter.view.FilterPackageListView r4 = r3.$this_apply
                    r4.setSeekbarHiddenByPackageVisible(r0)
                    boolean r4 = r3.$isTemplateFilterAdjust
                    if (r4 == 0) goto L5b
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    r4.S(r1)
                    goto L64
                L5b:
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    r4.P(r1)
                L64:
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    int r2 = us.pinguo.commonui.R.id.filterItemView
                    android.view.View r4 = r4.a(r2)
                    us.pinguo.common.filter.view.FilterPanelItemView r4 = (us.pinguo.common.filter.view.FilterPanelItemView) r4
                    java.lang.String r2 = "filterPanelView.filterItemView"
                    kotlin.jvm.internal.s.g(r4, r2)
                    int r4 = r4.getVisibility()
                    if (r4 != 0) goto L7f
                    r4 = 1
                    goto L80
                L7f:
                    r4 = 0
                L80:
                    if (r4 == 0) goto L90
                    us.pinguo.common.filter.view.FilterPackageListView r4 = r3.$this_apply
                    r4.setFilterItemHiddenByPackageVisible(r0)
                    us.pinguo.common.filter.controller.FilterController r4 = r3.this$0
                    us.pinguo.common.filter.view.FilterPanelView r4 = r4.v0()
                    r4.setFilterItemViewVisible(r1)
                L90:
                    kotlin.u r4 = kotlin.u.a
                    return r4
                L93:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r4.<init>(r0)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: us.pinguo.common.filter.controller.FilterController$3$1.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FilterController filterController, FilterPackageListView filterPackageListView, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = filterController;
            this.$this_apply = filterPackageListView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(m0Var, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                CameraFilterModule cameraFilterModule = this.this$0.b;
                this.label = 1;
                obj = cameraFilterModule.Z(this.this$0.b.y().getValue(), this);
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
            boolean booleanValue = ((Boolean) obj).booleanValue();
            g2 c = z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(booleanValue, this.this$0, this.$this_apply, null);
            this.label = 2;
            if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$3$1(FilterPackageListView filterPackageListView, FilterController filterController) {
        super(1);
        this.$this_apply = filterPackageListView;
        this.this$0 = filterController;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return u.a;
    }

    public final void invoke(boolean z) {
        ConstraintLayout x0;
        if (!z) {
            kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass2(this.this$0, this.$this_apply, null), 3, null);
        } else {
            if (this.$this_apply.z()) {
                kotlinx.coroutines.l.d(n0.a(z0.b()), null, null, new AnonymousClass1(this.this$0, this.this$0.b.y().getValue(), null), 3, null);
            }
            if (this.$this_apply.v()) {
                this.this$0.v0().setFilterItemViewVisible(true);
            }
        }
        if (z || (x0 = this.this$0.x0()) == null) {
            return;
        }
        x0.setVisibility(8);
        VdsAgent.onSetViewVisibility(x0, 8);
    }
}
