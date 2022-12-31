package us.pinguo.edit2020.fragment;

import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.controller.EditController;
import us.pinguo.edit2020.controller.EditFilterController;
import us.pinguo.edit2020.controller.b3;
import us.pinguo.edit2020.controller.d3;
import us.pinguo.edit2020.view.FacePointView;
import us.pinguo.edit2020.viewmodel.EditViewModel;
import us.pinguo.u3dengine.PgUnityPlayer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
public final class EditFragment$initGesture$1 extends Lambda implements kotlin.jvm.b.l<MotionEvent, Boolean> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$initGesture$1(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    @Override // kotlin.jvm.b.l
    public final Boolean invoke(MotionEvent it) {
        EditViewModel j1;
        b3 b3Var;
        d3 d3Var;
        EditController editController;
        EditFilterController editFilterController;
        EditViewModel j12;
        kotlin.jvm.internal.s.h(it, "it");
        j1 = this.this$0.j1();
        if (j1.p()) {
            EditFragment editFragment = this.this$0;
            int i2 = R.id.clLottieForAreaProtect;
            ConstraintLayout clLottieForAreaProtect = (ConstraintLayout) editFragment._$_findCachedViewById(i2);
            kotlin.jvm.internal.s.g(clLottieForAreaProtect, "clLottieForAreaProtect");
            if (clLottieForAreaProtect.getVisibility() == 0) {
                ((LottieAnimationView) this.this$0._$_findCachedViewById(R.id.lottieViewForAreaProtect)).f();
                ConstraintLayout clLottieForAreaProtect2 = (ConstraintLayout) this.this$0._$_findCachedViewById(i2);
                kotlin.jvm.internal.s.g(clLottieForAreaProtect2, "clLottieForAreaProtect");
                clLottieForAreaProtect2.setVisibility(8);
                VdsAgent.onSetViewVisibility(clLottieForAreaProtect2, 8);
            }
            b3Var = this.this$0.f10514j;
            if (b3Var != null) {
                b3Var.o(it);
                ((FacePointView) this.this$0._$_findCachedViewById(R.id.facePointView)).i(it);
                d3Var = this.this$0.f10511g;
                if (d3Var != null) {
                    d3Var.b(it);
                    editController = this.this$0.f10513i;
                    if (editController != null) {
                        editController.r(it);
                    }
                    editFilterController = this.this$0.x;
                    if (editFilterController != null) {
                        editFilterController.b(it);
                    }
                    j12 = this.this$0.j1();
                    if (j12.l().M()) {
                        PgUnityPlayer pgUnityPlayer = PgUnityPlayer.getInstance();
                        if (pgUnityPlayer != null) {
                            pgUnityPlayer.injectEvent(it);
                        }
                    } else {
                        MotionEvent obtain = MotionEvent.obtain(it);
                        obtain.setAction(3);
                        PgUnityPlayer pgUnityPlayer2 = PgUnityPlayer.getInstance();
                        if (pgUnityPlayer2 != null) {
                            pgUnityPlayer2.injectEvent(obtain);
                        }
                        obtain.recycle();
                    }
                } else {
                    kotlin.jvm.internal.s.z("bottomTabBeautyController");
                    throw null;
                }
            } else {
                kotlin.jvm.internal.s.z("faceCurveController");
                throw null;
            }
        }
        return Boolean.TRUE;
    }
}
