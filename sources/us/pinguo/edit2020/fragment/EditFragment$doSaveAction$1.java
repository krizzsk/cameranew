package us.pinguo.edit2020.fragment;

import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.appevents.AppEventsLogger;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.EditViewModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$doSaveAction$1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EditFragment.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.fragment.EditFragment$doSaveAction$1$1", f = "EditFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.fragment.EditFragment$doSaveAction$1$1  reason: invalid class name */
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
            boolean z;
            EditViewModel j1;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                this.this$0.n1();
                z = this.this$0.o;
                if (!z) {
                    j1 = this.this$0.j1();
                    j1.h().n().l();
                    this.this$0.H1();
                } else {
                    boolean z2 = false;
                    Toast makeText = Toast.makeText(us.pinguo.util.v.a(), R.string.pic_save_success, 0);
                    makeText.show();
                    VdsAgent.showToast(makeText);
                    FragmentActivity activity = this.this$0.getActivity();
                    if (activity != null && !activity.isFinishing()) {
                        z2 = true;
                    }
                    if (z2) {
                        this.this$0.h1();
                    }
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$doSaveAction$1(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
        invoke2(str);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        kotlinx.coroutines.l.d(LifecycleOwnerKt.getLifecycleScope(this.this$0), kotlinx.coroutines.z0.c(), null, new AnonymousClass1(this.this$0, null), 2, null);
        us.pinguo.foundation.statistics.h.a.h("save");
        AppEventsLogger.i(us.pinguo.foundation.e.b()).g("active");
    }
}
