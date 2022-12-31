package us.pinguo.edit2020.fragment;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.filter.CameraFilterModule;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$startRenderSkyChange$3 extends Lambda implements kotlin.jvm.b.l<Boolean, kotlin.u> {
    final /* synthetic */ FilterEntry $entry;
    final /* synthetic */ String $itemId;
    final /* synthetic */ String $pkgId;
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$3$1", f = "EditFragment.kt", i = {}, l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE, TypedValues.MotionType.TYPE_EASING}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$startRenderSkyChange$3$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ FilterEntry $entry;
        final /* synthetic */ boolean $isSuccess;
        final /* synthetic */ String $itemId;
        final /* synthetic */ String $pkgId;
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, EditFragment editFragment, String str, String str2, FilterEntry filterEntry, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$isSuccess = z;
            this.this$0 = editFragment;
            this.$pkgId = str;
            this.$itemId = str2;
            this.$entry = filterEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$isSuccess, this.this$0, this.$pkgId, this.$itemId, this.$entry, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            EditViewModel j1;
            Object v2;
            EditViewModel j12;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                if (this.$isSuccess) {
                    j1 = this.this$0.j1();
                    EditFilterModule i3 = j1.i();
                    String str = this.$pkgId;
                    String str2 = this.$itemId;
                    this.label = 1;
                    if (CameraFilterModule.K(i3, str, str2, null, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return kotlin.u.a;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    kotlin.j.b(obj);
                    j12 = this.this$0.j1();
                    j12.i().j0(true);
                    return kotlin.u.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            EditFragment editFragment = this.this$0;
            FilterEntry filterEntry = this.$entry;
            this.label = 2;
            v2 = editFragment.v2(filterEntry, this);
            if (v2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            j12 = this.this$0.j1();
            j12.i().j0(true);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$startRenderSkyChange$3(EditFragment editFragment, String str, String str2, FilterEntry filterEntry) {
        super(1);
        this.this$0 = editFragment;
        this.$pkgId = str;
        this.$itemId = str2;
        this.$entry = filterEntry;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return kotlin.u.a;
    }

    public final void invoke(boolean z) {
        EditFilterController editFilterController;
        editFilterController = this.this$0.x;
        if (editFilterController != null) {
            editFilterController.l1(z);
        }
        kotlinx.coroutines.l.d(kotlinx.coroutines.n0.a(kotlinx.coroutines.z0.b()), null, null, new AnonymousClass1(z, this.this$0, this.$pkgId, this.$itemId, this.$entry, null), 3, null);
    }
}
