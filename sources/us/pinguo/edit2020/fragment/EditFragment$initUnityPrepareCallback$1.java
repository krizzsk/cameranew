package us.pinguo.edit2020.fragment;

import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.DelayKt;
import us.pinguo.edit2020.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$initUnityPrepareCallback$1 extends Lambda implements kotlin.jvm.b.a<kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$initUnityPrepareCallback$1$1", f = "EditFragment.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$initUnityPrepareCallback$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        int label;
        final /* synthetic */ EditFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EditFragment editFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = editFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            MutableLiveData mutableLiveData;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.this$0._$_findCachedViewById(R.id.showOriginPicBt);
                if (appCompatImageView != null) {
                    appCompatImageView.setClickable(true);
                }
                this.label = 1;
                if (DelayKt.b(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            EditFragment editFragment = this.this$0;
            int i3 = R.id.ivOriginalPicture;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) editFragment._$_findCachedViewById(i3);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) this.this$0._$_findCachedViewById(i3);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setAlpha(1.0f);
            }
            FrameLayout frameLayout = (FrameLayout) this.this$0._$_findCachedViewById(R.id.unityContainer);
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
                VdsAgent.onSetViewVisibility(frameLayout, 4);
            }
            mutableLiveData = this.this$0.s;
            mutableLiveData.postValue(Boxing.boxBoolean(true));
            this.this$0.q = true;
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$initUnityPrepareCallback$1(EditFragment editFragment) {
        super(0);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.a
    public /* bridge */ /* synthetic */ kotlin.u invoke() {
        invoke2();
        return kotlin.u.a;
    }

    @Override // kotlin.jvm.b.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean z;
        z = this.this$0.q;
        if (z) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
        kotlin.jvm.internal.s.g(viewLifecycleOwner, "viewLifecycleOwner");
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(this.this$0, null), 2, null);
    }
}
