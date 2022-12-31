package us.pinguo.edit2020.controller;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.appcompat.widget.SwitchCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.ImageRestorationController$initFaceData$1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageRestorationController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$initFaceData$1", f = "ImageRestorationController.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class ImageRestorationController$initFaceData$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    int label;
    final /* synthetic */ ImageRestorationController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageRestorationController.kt */
    @DebugMetadata(c = "us.pinguo.edit2020.controller.ImageRestorationController$initFaceData$1$1", f = "ImageRestorationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: us.pinguo.edit2020.controller.ImageRestorationController$initFaceData$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
        final /* synthetic */ us.pinguo.facedetector.c $faceResult;
        final /* synthetic */ String $path;
        int label;
        final /* synthetic */ ImageRestorationController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ImageRestorationController imageRestorationController, us.pinguo.facedetector.c cVar, String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = imageRestorationController;
            this.$faceResult = cVar;
            this.$path = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
        public static final void m90invokeSuspend$lambda0(ImageRestorationController imageRestorationController, CompoundButton compoundButton, boolean z) {
            us.pinguo.edit2020.viewmodel.module.a aVar;
            VdsAgent.lambdaOnCheckedChangedCompoundButton(compoundButton, z);
            aVar = imageRestorationController.b;
            us.pinguo.facedetector.c e2 = aVar.e();
            boolean z2 = false;
            if (e2 != null && e2.h()) {
                z2 = true;
            }
            if (z2) {
                imageRestorationController.Y();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$faceResult, this.$path, continuation);
        }

        @Override // kotlin.jvm.b.p
        public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
            return ((AnonymousClass1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            View view;
            View view2;
            View view3;
            int b;
            Bitmap q;
            Bitmap bitmap;
            Bitmap bitmap2;
            View view4;
            us.pinguo.edit2020.adapter.g0 g0Var;
            ViewGroup viewGroup;
            us.pinguo.edit2020.view.d0 d0Var;
            ViewGroup viewGroup2;
            View view5;
            View view6;
            us.pinguo.facedetector.b[] d2;
            us.pinguo.edit2020.viewmodel.module.a aVar;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                kotlin.j.b(obj);
                view = this.this$0.f10376e;
                int i2 = R.id.switchFace;
                SwitchCompat switchCompat = (SwitchCompat) view.findViewById(i2);
                us.pinguo.facedetector.c cVar = this.$faceResult;
                switchCompat.setChecked(cVar != null && cVar.h());
                view2 = this.this$0.f10376e;
                final ImageRestorationController imageRestorationController = this.this$0;
                ((SwitchCompat) view2.findViewById(i2)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: us.pinguo.edit2020.controller.u1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        ImageRestorationController$initFaceData$1.AnonymousClass1.m90invokeSuspend$lambda0(ImageRestorationController.this, compoundButton, z);
                    }
                });
                ArrayList arrayList = new ArrayList();
                BitmapFactory.Options options = new BitmapFactory.Options();
                ArrayList arrayList2 = new ArrayList();
                view3 = this.this$0.f10376e;
                if (((SwitchCompat) view3.findViewById(i2)).isChecked()) {
                    q = us.pinguo.util.e.a.e(this.$path, options, new ExifInterface(this.$path).getRotationDegrees());
                    us.pinguo.facedetector.c cVar2 = this.$faceResult;
                    if (cVar2 != null && (d2 = cVar2.d()) != null) {
                        ImageRestorationController imageRestorationController2 = this.this$0;
                        for (us.pinguo.facedetector.b bVar : d2) {
                            arrayList2.add(new Rect(bVar.g().left * options.inSampleSize, bVar.g().top * options.inSampleSize, bVar.g().right * options.inSampleSize, bVar.g().bottom * options.inSampleSize));
                            aVar = imageRestorationController2.b;
                            Bitmap c = aVar.c(q, bVar.g());
                            if (c != null) {
                                arrayList.add(new us.pinguo.edit2020.bean.z(c, false));
                            }
                        }
                    }
                    view6 = this.this$0.f10376e;
                    ((SwitchCompat) view6.findViewById(R.id.switchFace)).setEnabled(true);
                } else {
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.$path, options);
                    int i3 = R.dimen.paint_material_img_size;
                    b = kotlin.y.c.b(Math.min(options.outWidth / us.pinguo.edit2020.utils.d.i(i3), options.outHeight / us.pinguo.edit2020.utils.d.i(i3)));
                    options.inSampleSize = b;
                    options.inJustDecodeBounds = false;
                    q = us.pinguo.util.e.q(this.$path, options);
                }
                bitmap = this.this$0.f10382k;
                int width = bitmap == null ? 0 : bitmap.getWidth();
                bitmap2 = this.this$0.f10382k;
                arrayList2.add(0, new Rect(0, 0, width, bitmap2 == null ? 0 : bitmap2.getHeight()));
                arrayList.add(0, new us.pinguo.edit2020.bean.z(q, true));
                this.this$0.f10379h = new us.pinguo.edit2020.adapter.g0(arrayList);
                view4 = this.this$0.f10376e;
                g0Var = this.this$0.f10379h;
                ((RecyclerView) view4.findViewById(R.id.rvImageRestoration)).setAdapter(g0Var);
                viewGroup = this.this$0.a;
                int i4 = R.id.flSecondMenuContainer;
                if (((FrameLayout) viewGroup.findViewById(i4)).getChildCount() == 0) {
                    viewGroup2 = this.this$0.a;
                    view5 = this.this$0.f10376e;
                    ((FrameLayout) viewGroup2.findViewById(i4)).addView(view5);
                }
                d0Var = this.this$0.f10377f;
                if (d0Var != null) {
                    d0Var.setFaceRectList(arrayList2);
                }
                this.this$0.Y();
                return kotlin.u.a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageRestorationController$initFaceData$1(ImageRestorationController imageRestorationController, Continuation<? super ImageRestorationController$initFaceData$1> continuation) {
        super(2, continuation);
        this.this$0 = imageRestorationController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new ImageRestorationController$initFaceData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((ImageRestorationController$initFaceData$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        us.pinguo.edit2020.viewmodel.module.a aVar;
        us.pinguo.edit2020.viewmodel.module.a aVar2;
        us.pinguo.edit2020.viewmodel.module.a aVar3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.j.b(obj);
            aVar = this.this$0.b;
            String b = aVar.b();
            int rotationDegrees = new ExifInterface(b).getRotationDegrees();
            aVar2 = this.this$0.b;
            aVar2.k(us.pinguo.edit2020.manager.e.a.a(b, rotationDegrees));
            aVar3 = this.this$0.b;
            us.pinguo.facedetector.c e2 = aVar3.e();
            kotlinx.coroutines.g2 c = kotlinx.coroutines.z0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, e2, b, null);
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
