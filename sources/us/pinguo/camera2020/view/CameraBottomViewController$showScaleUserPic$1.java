package us.pinguo.camera2020.view;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.content.ContextCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.widget.AfterCaptureCircleImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraBottomViewController.kt */
@DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$showScaleUserPic$1", f = "CameraBottomViewController.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class CameraBottomViewController$showScaleUserPic$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ CameraBottomViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraBottomViewController.kt */
    @DebugMetadata(c = "us.pinguo.camera2020.view.CameraBottomViewController$showScaleUserPic$1$1", f = "CameraBottomViewController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.camera2020.view.CameraBottomViewController$showScaleUserPic$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ Bitmap $scaleBitmap;
        int label;
        final /* synthetic */ CameraBottomViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Bitmap bitmap, CameraBottomViewController cameraBottomViewController, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$scaleBitmap = bitmap;
            this.this$0 = cameraBottomViewController;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$scaleBitmap, this.this$0, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AfterCaptureCircleImageView afterCaptureCircleImageView;
            AfterCaptureCircleImageView afterCaptureCircleImageView2;
            boolean z;
            boolean z2;
            AfterCaptureCircleImageView afterCaptureCircleImageView3;
            AfterCaptureCircleImageView afterCaptureCircleImageView4;
            AfterCaptureCircleImageView afterCaptureCircleImageView5;
            AfterCaptureCircleImageView afterCaptureCircleImageView6;
            String str;
            AfterCaptureCircleImageView afterCaptureCircleImageView7;
            AfterCaptureCircleImageView afterCaptureCircleImageView8;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                if (this.$scaleBitmap != null) {
                    z2 = this.this$0.C;
                    if (z2) {
                        afterCaptureCircleImageView7 = this.this$0.f9289h;
                        afterCaptureCircleImageView8 = this.this$0.f9289h;
                        afterCaptureCircleImageView7.setBorderColor(ContextCompat.getColor(afterCaptureCircleImageView8.getContext(), R.color.viewfinder_bottom_album_border_color_dark));
                    } else {
                        afterCaptureCircleImageView3 = this.this$0.f9289h;
                        afterCaptureCircleImageView4 = this.this$0.f9289h;
                        afterCaptureCircleImageView3.setBorderColor(ContextCompat.getColor(afterCaptureCircleImageView4.getContext(), R.color.viewfinder_bottom_album_border_color_light));
                    }
                    afterCaptureCircleImageView5 = this.this$0.f9289h;
                    afterCaptureCircleImageView5.setDefaultImageView(null);
                    afterCaptureCircleImageView6 = this.this$0.f9289h;
                    afterCaptureCircleImageView6.setImageBitmap(this.$scaleBitmap);
                    CameraBottomViewController cameraBottomViewController = this.this$0;
                    str = cameraBottomViewController.F;
                    cameraBottomViewController.G = str;
                } else {
                    afterCaptureCircleImageView = this.this$0.f9289h;
                    afterCaptureCircleImageView.setDefaultImageView(Boxing.boxBoolean(true));
                    afterCaptureCircleImageView2 = this.this$0.f9289h;
                    z = this.this$0.C;
                    afterCaptureCircleImageView2.setImageResource(z ? R.drawable.ic_album_icon : R.drawable.ic_album_light);
                    this.this$0.G = null;
                }
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraBottomViewController$showScaleUserPic$1(CameraBottomViewController cameraBottomViewController, Continuation<? super CameraBottomViewController$showScaleUserPic$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraBottomViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new CameraBottomViewController$showScaleUserPic$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((CameraBottomViewController$showScaleUserPic$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            str = this.this$0.F;
            Context b = us.pinguo.foundation.e.b();
            kotlin.jvm.internal.s.g(b, "getAppContext()");
            Bitmap w = us.pinguo.util.e.w(str, us.pinguo.util.g.a(b, 32.0f), 1, true);
            kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(w, this.this$0, null);
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
