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
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilterController.kt */
@DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$seekbarEnable$1", f = "FilterController.kt", i = {}, l = {1342, 1343}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class FilterController$seekbarEnable$1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
    final /* synthetic */ boolean $enable;
    final /* synthetic */ FilterEntry $entry;
    int label;
    final /* synthetic */ FilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FilterController.kt */
    @DebugMetadata(c = "us.pinguo.common.filter.controller.FilterController$seekbarEnable$1$1", f = "FilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.common.filter.controller.FilterController$seekbarEnable$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<m0, Continuation<? super u>, Object> {
        final /* synthetic */ boolean $enable;
        final /* synthetic */ boolean $isTemplateFilterAdjust;
        int label;
        final /* synthetic */ FilterController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, FilterController filterController, boolean z2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isTemplateFilterAdjust = z;
            this.this$0 = filterController;
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
                    this.this$0.v0().S(this.$enable);
                } else {
                    this.this$0.v0().P(this.$enable);
                }
                return u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterController$seekbarEnable$1(FilterController filterController, FilterEntry filterEntry, boolean z, Continuation<? super FilterController$seekbarEnable$1> continuation) {
        super(2, continuation);
        this.this$0 = filterController;
        this.$entry = filterEntry;
        this.$enable = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FilterController$seekbarEnable$1(this.this$0, this.$entry, this.$enable, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(m0 m0Var, Continuation<? super u> continuation) {
        return ((FilterController$seekbarEnable$1) create(m0Var, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        boolean z = true;
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
        z = (((Boolean) obj).booleanValue() && this.this$0.c) ? false : false;
        g2 c = z0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(z, this.this$0, this.$enable, null);
        this.label = 2;
        if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return u.a;
    }
}
