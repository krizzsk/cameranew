package us.pinguo.camera2020.view;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.AfterCaptureCircleImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBottomViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$updateAlbumIcon$1", f = "CameraBottomViewController.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraBottomViewController$updateAlbumIcon$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ CameraBottomViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraBottomViewController.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$updateAlbumIcon$1$1", f = "CameraBottomViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.view.CameraBottomViewController$updateAlbumIcon$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ String $lastPic;
        int label;
        final /* synthetic */ CameraBottomViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, CameraBottomViewController cameraBottomViewController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lastPic = str;
            this.this$0 = cameraBottomViewController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$lastPic, this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AfterCaptureCircleImageView afterCaptureCircleImageView;
            boolean z;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                String str = this.$lastPic;
                if (str == null) {
                    afterCaptureCircleImageView = this.this$0.f9289h;
                    z = this.this$0.C;
                    afterCaptureCircleImageView.setImageResource(z ? R.drawable.ic_album_icon : R.drawable.ic_album_light);
                } else {
                    this.this$0.F = str;
                    this.this$0.K0();
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBottomViewController$updateAlbumIcon$1(CameraBottomViewController cameraBottomViewController, Continuation<? super CameraBottomViewController$updateAlbumIcon$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraBottomViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new CameraBottomViewController$updateAlbumIcon$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((CameraBottomViewController$updateAlbumIcon$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String Q;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            Q = this.this$0.Q();
            kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(Q, this.this$0, null);
            this.label = 1;
            if (kotlinx.coroutines.j.g(c, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            kotlin.j.b(obj);
        }
        return kotlin.u.a;
    }
}
