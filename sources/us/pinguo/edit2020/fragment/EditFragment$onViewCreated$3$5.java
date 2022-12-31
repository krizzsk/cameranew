package us.pinguo.edit2020.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.growingio.android.sdk.autoburry.VdsAgent;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* compiled from: EditFragment.kt */
/* loaded from: classes4.dex */
final class EditFragment$onViewCreated$3$5 extends Lambda implements kotlin.jvm.b.l<Bitmap, kotlin.u> {
    final /* synthetic */ EditFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditFragment$onViewCreated$3$5(EditFragment editFragment) {
        super(1);
        this.this$0 = editFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m94invoke$lambda2(final EditFragment this$0, Bitmap it) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator withEndAction;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha2;
        ViewPropertyAnimator withEndAction2;
        ViewPropertyAnimator duration2;
        kotlin.jvm.internal.s.h(this$0, "this$0");
        kotlin.jvm.internal.s.h(it, "$it");
        int i2 = R.id.previewMask;
        ImageView imageView = (ImageView) this$0._$_findCachedViewById(i2);
        if (imageView != null) {
            imageView.setImageBitmap(it);
        }
        ImageView previewMask = (ImageView) this$0._$_findCachedViewById(i2);
        kotlin.jvm.internal.s.g(previewMask, "previewMask");
        previewMask.setVisibility(0);
        VdsAgent.onSetViewVisibility(previewMask, 0);
        ImageView imageView2 = (ImageView) this$0._$_findCachedViewById(i2);
        if (imageView2 != null && (animate2 = imageView2.animate()) != null && (alpha2 = animate2.alpha(1.0f)) != null && (withEndAction2 = alpha2.withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.f0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment$onViewCreated$3$5.m95invoke$lambda2$lambda0(EditFragment.this);
            }
        })) != null && (duration2 = withEndAction2.setDuration(200L)) != null) {
            duration2.start();
        }
        ImageView imageView3 = (ImageView) this$0._$_findCachedViewById(i2);
        if (imageView3 == null || (animate = imageView3.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (withEndAction = alpha.withEndAction(new Runnable() { // from class: us.pinguo.edit2020.fragment.e0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment$onViewCreated$3$5.m96invoke$lambda2$lambda1(EditFragment.this);
            }
        })) == null || (duration = withEndAction.setDuration(1000L)) == null) {
            return;
        }
        duration.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-0  reason: not valid java name */
    public static final void m95invoke$lambda2$lambda0(EditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ImageView previewMask = (ImageView) this$0._$_findCachedViewById(R.id.previewMask);
        kotlin.jvm.internal.s.g(previewMask, "previewMask");
        previewMask.setVisibility(0);
        VdsAgent.onSetViewVisibility(previewMask, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-2$lambda-1  reason: not valid java name */
    public static final void m96invoke$lambda2$lambda1(EditFragment this$0) {
        kotlin.jvm.internal.s.h(this$0, "this$0");
        ImageView previewMask = (ImageView) this$0._$_findCachedViewById(R.id.previewMask);
        kotlin.jvm.internal.s.g(previewMask, "previewMask");
        previewMask.setVisibility(8);
        VdsAgent.onSetViewVisibility(previewMask, 8);
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ kotlin.u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return kotlin.u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(final Bitmap it) {
        Handler handler;
        kotlin.jvm.internal.s.h(it, "it");
        handler = this.this$0.m;
        final EditFragment editFragment = this.this$0;
        handler.post(new Runnable() { // from class: us.pinguo.edit2020.fragment.d0
            @Override // java.lang.Runnable
            public final void run() {
                EditFragment$onViewCreated$3$5.m94invoke$lambda2(EditFragment.this, it);
            }
        });
    }
}
