package us.pinguo.camera2020.fragment;

import android.content.Context;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.z0;
import us.pinguo.camera2020.view.CameraBottomViewController;
import us.pinguo.edit2020.activity.EditActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewFinderFragment.kt */
@DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$gotoEdit$1", f = "ViewFinderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class ViewFinderFragment$gotoEdit$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ Context $cxt;
    final /* synthetic */ int $ori;
    final /* synthetic */ String $path;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ViewFinderFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewFinderFragment.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.fragment.ViewFinderFragment$gotoEdit$1$1", f = "ViewFinderFragment.kt", i = {}, l = {3193}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.fragment.ViewFinderFragment$gotoEdit$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ Context $cxt;
        final /* synthetic */ String $path;
        int label;
        final /* synthetic */ ViewFinderFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ViewFinderFragment viewFinderFragment, Context context, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = viewFinderFragment;
            this.$cxt = context;
            this.$path = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$cxt, this.$path, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.j.b(obj);
                CameraBottomViewController cameraBottomViewController = this.this$0.n;
                if (cameraBottomViewController != null) {
                    cameraBottomViewController.s0();
                    EditActivity.a.b(this.$cxt, this.$path, true, null, us.pinguo.camera2020.i.a.a.f());
                    this.this$0.W = true;
                    this.label = 1;
                    if (DelayKt.b(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    kotlin.jvm.internal.s.z("cameraBottomController");
                    throw null;
                }
            } else if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                kotlin.j.b(obj);
            }
            this.this$0.z1(false, false);
            return kotlin.u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFinderFragment$gotoEdit$1(String str, int i2, ViewFinderFragment viewFinderFragment, Context context, Continuation<? super ViewFinderFragment$gotoEdit$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.$ori = i2;
        this.this$0 = viewFinderFragment;
        this.$cxt = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        ViewFinderFragment$gotoEdit$1 viewFinderFragment$gotoEdit$1 = new ViewFinderFragment$gotoEdit$1(this.$path, this.$ori, this.this$0, this.$cxt, continuation);
        viewFinderFragment$gotoEdit$1.L$0 = obj;
        return viewFinderFragment$gotoEdit$1;
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ViewFinderFragment$gotoEdit$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        byte[] a;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            kotlinx.coroutines.m0 m0Var = (kotlinx.coroutines.m0) this.L$0;
            if (new File(this.$path).exists()) {
                if (this.$ori != 0) {
                    us.pinguo.image.saver.e.a aVar = new us.pinguo.image.saver.e.a(null);
                    aVar.l(this.$ori);
                    a = kotlin.io.g.a(new File(this.$path));
                    try {
                        us.pinguo.util.j.a(a, this.$path, aVar.d());
                    } catch (Exception unused) {
                    }
                }
                us.pinguo.foundation.c.e("gotoEdit");
                kotlinx.coroutines.l.d(m0Var, z0.c(), null, new AnonymousClass1(this.this$0, this.$cxt, this.$path, null), 2, null);
                return kotlin.u.a;
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
