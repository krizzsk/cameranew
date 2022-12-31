package us.pinguo.edit2020.controller;

import android.graphics.PointF;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.HashMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.view.FilterGestureView;
import us.pinguo.edit2020.viewmodel.module.EditFilterModule;
import us.pinguo.repository2020.entity.FilterEntry;
import us.pinguo.u3dengine.edit.UnityEditCaller;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFilterController.kt */
@DebugMetadata(c = "us.pinguo.edit2020.controller.EditFilterController$onSkyPrepared$1", f = "EditFilterController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes4.dex */
public final class EditFilterController$onSkyPrepared$1 extends SuspendLambda implements kotlin.jvm.b.p<kotlinx.coroutines.m0, Continuation<? super kotlin.u>, Object> {
    final /* synthetic */ float $cx;
    final /* synthetic */ float $cy;
    final /* synthetic */ float $height;
    final /* synthetic */ String $uid;
    final /* synthetic */ float $width;
    int label;
    final /* synthetic */ EditFilterController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFilterController$onSkyPrepared$1(EditFilterController editFilterController, float f2, float f3, float f4, float f5, String str, Continuation<? super EditFilterController$onSkyPrepared$1> continuation) {
        super(2, continuation);
        this.this$0 = editFilterController;
        this.$cx = f2;
        this.$cy = f3;
        this.$width = f4;
        this.$height = f5;
        this.$uid = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
        return new EditFilterController$onSkyPrepared$1(this.this$0, this.$cx, this.$cy, this.$width, this.$height, this.$uid, continuation);
    }

    @Override // kotlin.jvm.b.p
    public final Object invoke(kotlinx.coroutines.m0 m0Var, Continuation<? super kotlin.u> continuation) {
        return ((EditFilterController$onSkyPrepared$1) create(m0Var, continuation)).invokeSuspend(kotlin.u.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EditFilterModule editFilterModule;
        ConstraintLayout constraintLayout;
        EditFilterModule editFilterModule2;
        HashMap hashMap;
        ConstraintLayout constraintLayout2;
        int i2;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        ConstraintLayout constraintLayout5;
        ConstraintLayout constraintLayout6;
        HashMap hashMap2;
        HashMap hashMap3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            kotlin.j.b(obj);
            editFilterModule = this.this$0.v;
            us.pinguo.edit2020.bean.u0 value = editFilterModule.q0().L().getValue();
            if (value == null) {
                return kotlin.u.a;
            }
            float e2 = value.e();
            float d2 = value.d();
            constraintLayout = this.this$0.u;
            int i3 = R.id.filterGestureView;
            FilterGestureView filterGestureView = (FilterGestureView) constraintLayout.findViewById(i3);
            EditFilterController editFilterController = this.this$0;
            float f2 = this.$cx;
            float f3 = this.$cy;
            float f4 = this.$width;
            float f5 = this.$height;
            String str = this.$uid;
            editFilterModule2 = editFilterController.v;
            FilterEntry value2 = editFilterModule2.y().getValue();
            String itemId = value2 == null ? null : value2.getItemId();
            if (itemId != null) {
                filterGestureView.setDrawRect(false);
                filterGestureView.h().s("");
                hashMap = editFilterController.C;
                us.pinguo.edit2020.view.k0 k0Var = (us.pinguo.edit2020.view.k0) hashMap.get(itemId);
                if (k0Var == null) {
                    constraintLayout4 = editFilterController.u;
                    int i4 = R.id.unityContainer;
                    constraintLayout5 = editFilterController.u;
                    PointF n = filterGestureView.n(((FrameLayout) constraintLayout4.findViewById(i4)).getWidth(), ((FrameLayout) constraintLayout5.findViewById(i4)).getHeight(), f2, f3);
                    float f6 = e2 * f4;
                    float f7 = d2 * f5;
                    float min = Math.min(f6, f7);
                    constraintLayout6 = editFilterController.u;
                    float i5 = ((FilterGestureView) constraintLayout6.findViewById(i3)).i();
                    if (min < i5) {
                        float f8 = i5 / min;
                        f6 *= f8;
                        f7 *= f8;
                    }
                    float f9 = n.x;
                    float f10 = f6 * 0.5f;
                    float f11 = f9 - f10;
                    float f12 = n.y;
                    float f13 = f7 * 0.5f;
                    float f14 = f12 - f13;
                    float f15 = f9 + f10;
                    float f16 = f12 + f13;
                    filterGestureView.setVertices(new PointF(f11, f14), new PointF(f15, f14), new PointF(f15, f16), new PointF(f11, f16));
                    us.pinguo.edit2020.view.k0 h2 = filterGestureView.h();
                    hashMap2 = editFilterController.C;
                    hashMap2.put(itemId, h2);
                    hashMap3 = editFilterController.D;
                    hashMap3.put(itemId, filterGestureView.a());
                    UnityEditCaller.Filter.setEditFilterObjectTransformData(str, f2, f3, f4, f5, h2.a());
                } else {
                    filterGestureView.setRectInfo(k0Var, false);
                    constraintLayout2 = editFilterController.u;
                    float width = ((FrameLayout) constraintLayout2.findViewById(R.id.unityContainer)).getWidth();
                    constraintLayout3 = editFilterController.u;
                    PointF o = filterGestureView.o(width, ((FrameLayout) constraintLayout3.findViewById(i2)).getHeight(), (k0Var.f().x + k0Var.g().x + k0Var.h().x + k0Var.i().x) * 0.25f, (k0Var.f().y + k0Var.g().y + k0Var.h().y + k0Var.i().y) * 0.25f);
                    UnityEditCaller.Filter.setEditFilterObjectTransformData(str, o.x, o.y, f4, f5, k0Var.a());
                }
                filterGestureView.h().s("");
            }
            return kotlin.u.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
