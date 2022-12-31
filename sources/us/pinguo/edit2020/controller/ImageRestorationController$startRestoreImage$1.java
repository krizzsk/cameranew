package us.pinguo.edit2020.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tapjoy.TJAdUnitConstants;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import us.pinguo.common.widget.ScrollCenterLayoutManager;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.adapter.g0;
import us.pinguo.edit2020.view.ImageCompareAdjustView;
import us.pinguo.edit2020.view.d0;
import us.pinguo.libdeepvision.callback.ResultImageCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageRestorationController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1", f = "ImageRestorationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ImageRestorationController$startRestoreImage$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ ImageRestorationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageRestorationController.kt */
    /* renamed from: us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends Lambda implements kotlin.jvm.b.l<String, kotlin.u> {
        final /* synthetic */ List<List<PointF>> $facePoints;
        final /* synthetic */ us.pinguo.facedetector.c $faceResult;
        final /* synthetic */ ImageRestorationController this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ImageRestorationController.kt */
        @DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1$1$1", f = "ImageRestorationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C03851 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
            final /* synthetic */ String $restorationImagePath;
            int label;
            final /* synthetic */ ImageRestorationController this$0;

            /* compiled from: ImageRestorationController.kt */
            /* renamed from: us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1$1$1$a */
            /* loaded from: classes4.dex */
            public static final class a implements g0.b {
                final /* synthetic */ ImageRestorationController a;

                a(ImageRestorationController imageRestorationController) {
                    this.a = imageRestorationController;
                }

                @Override // us.pinguo.edit2020.adapter.g0.b
                public void a(View view, int i2, us.pinguo.edit2020.bean.z zVar) {
                    us.pinguo.edit2020.view.d0 d0Var;
                    ScrollCenterLayoutManager scrollCenterLayoutManager;
                    Context context;
                    d0Var = this.a.f10377f;
                    if (d0Var != null) {
                        d0.b.a(d0Var, i2, 0.0f, 2, null);
                    }
                    scrollCenterLayoutManager = this.a.f10380i;
                    if (scrollCenterLayoutManager == null) {
                        return;
                    }
                    context = this.a.c;
                    scrollCenterLayoutManager.a(context, i2, 100.0f);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C03851(ImageRestorationController imageRestorationController, String str, Continuation<? super C03851> continuation) {
                super(2, continuation);
                this.this$0 = imageRestorationController;
                this.$restorationImagePath = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                return new C03851(this.this$0, this.$restorationImagePath, continuation);
            }

            @Override // kotlin.jvm.b.p
            public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
                return ((C03851) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                ImageCompareAdjustView imageCompareAdjustView;
                us.pinguo.edit2020.view.d0 d0Var;
                us.pinguo.edit2020.view.d0 d0Var2;
                us.pinguo.edit2020.adapter.g0 g0Var;
                us.pinguo.edit2020.viewmodel.module.a aVar;
                ViewGroup viewGroup;
                ImageCompareAdjustView imageCompareAdjustView2;
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    kotlin.j.b(obj);
                    this.this$0.H();
                    imageCompareAdjustView = this.this$0.f10378g;
                    if (imageCompareAdjustView.getParent() == null) {
                        viewGroup = this.this$0.a;
                        imageCompareAdjustView2 = this.this$0.f10378g;
                        ((FrameLayout) viewGroup.findViewById(R.id.flCanvasContainer)).addView(imageCompareAdjustView2);
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    Bitmap decodeFile = BitmapFactory.decodeFile(this.$restorationImagePath, options);
                    d0Var = this.this$0.f10377f;
                    if (d0Var != null) {
                        d0Var.setImageRestorationBitmap(decodeFile);
                    }
                    d0Var2 = this.this$0.f10377f;
                    if (d0Var2 != null) {
                        aVar = this.this$0.b;
                        d0Var2.setRate(aVar.g());
                    }
                    g0Var = this.this$0.f10379h;
                    if (g0Var != null) {
                        g0Var.j(new a(this.this$0));
                    }
                    return kotlin.u.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(ImageRestorationController imageRestorationController, List<? extends List<? extends PointF>> list, us.pinguo.facedetector.c cVar) {
            super(1);
            this.this$0 = imageRestorationController;
            this.$facePoints = list;
            this.$faceResult = cVar;
        }

        @Override // kotlin.jvm.b.l
        public /* bridge */ /* synthetic */ kotlin.u invoke(String str) {
            invoke2(str);
            return kotlin.u.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            long j2;
            Bitmap bitmap;
            Bitmap bitmap2;
            us.pinguo.edit2020.viewmodel.module.a aVar;
            us.pinguo.edit2020.viewmodel.module.a aVar2;
            LifecycleCoroutineScope D;
            Context context;
            us.pinguo.edit2020.viewmodel.module.a aVar3;
            if (str == null) {
                context = this.this$0.c;
                us.pinguo.foundation.utils.j0.d(context.getResources().getString(R.string.image_over_size));
                aVar3 = this.this$0.b;
                kotlin.jvm.b.l<Boolean, kotlin.u> a = aVar3.a();
                if (a == null) {
                    return;
                }
                a.invoke(Boolean.TRUE);
                return;
            }
            boolean z = true;
            if (str.length() == 0) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            j2 = this.this$0.f10383l;
            long j3 = currentTimeMillis - j2;
            bitmap = this.this$0.f10382k;
            int width = bitmap == null ? 0 : bitmap.getWidth();
            bitmap2 = this.this$0.f10382k;
            int height = bitmap2 == null ? 0 : bitmap2.getHeight();
            List<List<PointF>> list = this.$facePoints;
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (z) {
                us.pinguo.foundation.statistics.i iVar = us.pinguo.foundation.statistics.h.b;
                StringBuilder sb = new StringBuilder();
                sb.append(width);
                sb.append('*');
                sb.append(height);
                iVar.S("picture", sb.toString(), String.valueOf(j3), TJAdUnitConstants.String.VIDEO_COMPLETE);
            } else {
                us.pinguo.foundation.statistics.i iVar2 = us.pinguo.foundation.statistics.h.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(width);
                sb2.append('*');
                sb2.append(height);
                iVar2.S("face_n_picture", sb2.toString(), String.valueOf(j3), TJAdUnitConstants.String.VIDEO_COMPLETE);
            }
            us.pinguo.foundation.statistics.i iVar3 = us.pinguo.foundation.statistics.h.b;
            aVar = this.this$0.b;
            List<List<PointF>> d2 = aVar.d(this.$faceResult);
            iVar3.e(String.valueOf(d2 != null ? d2.size() : 0));
            iVar3.R(TJAdUnitConstants.String.VIDEO_COMPLETE);
            aVar2 = this.this$0.b;
            aVar2.l(str);
            D = this.this$0.D();
            if (D == null) {
                return;
            }
            kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.c(), null, new C03851(this.this$0, str, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationController$startRestoreImage$1(ImageRestorationController imageRestorationController, Continuation<? super ImageRestorationController$startRestoreImage$1> continuation) {
        super(2, continuation);
        this.this$0 = imageRestorationController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ImageRestorationController$startRestoreImage$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ImageRestorationController$startRestoreImage$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        us.pinguo.edit2020.viewmodel.module.a aVar;
        us.pinguo.edit2020.viewmodel.module.a aVar2;
        View view;
        List<List<PointF>> list;
        us.pinguo.common.helper.b bVar;
        us.pinguo.edit2020.viewmodel.module.a aVar3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            aVar = this.this$0.b;
            String b = aVar.b();
            aVar2 = this.this$0.b;
            us.pinguo.facedetector.c e2 = aVar2.e();
            view = this.this$0.f10376e;
            if (((SwitchCompat) view.findViewById(R.id.switchFace)).isChecked()) {
                aVar3 = this.this$0.b;
                list = aVar3.d(e2);
            } else {
                list = null;
            }
            bVar = this.this$0.f10381j;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, list, e2);
            final ImageRestorationController imageRestorationController = this.this$0;
            bVar.e(b, list, anonymousClass1, new ResultImageCallback() { // from class: us.pinguo.edit2020.controller.ImageRestorationController$startRestoreImage$1.2
                @Override // us.pinguo.libdeepvision.callback.ResultImageCallback
                public void progress(float f2) {
                    LifecycleCoroutineScope D;
                    D = ImageRestorationController.this.D();
                    if (D != null) {
                        kotlinx.coroutines.l.d(D, kotlinx.coroutines.z0.c(), null, new ImageRestorationController$startRestoreImage$1$2$progress$1(ImageRestorationController.this, f2, null), 2, null);
                    }
                    us.pinguo.common.log.a.e(kotlin.jvm.internal.s.q("DeepVision:progress:", Float.valueOf(f2)), new Object[0]);
                }
            });
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
