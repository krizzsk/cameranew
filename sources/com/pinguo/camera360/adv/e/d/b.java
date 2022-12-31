package com.pinguo.camera360.adv.e.d;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import us.pinguo.ui.widget.ShimmerFrameLayout;
import vStudio.Android.Camera360.R;
/* compiled from: AlbumTopNormalNativeLayout.java */
/* loaded from: classes3.dex */
public class b extends com.pinguo.camera360.adv.e.c.b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AlbumTopNormalNativeLayout.java */
    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        final /* synthetic */ ShimmerFrameLayout a;

        a(b bVar, ShimmerFrameLayout shimmerFrameLayout) {
            this.a = shimmerFrameLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.u();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public b(Activity activity, us.pinguo.advsdk.a.b bVar, ViewGroup viewGroup) {
        super(activity, bVar, viewGroup);
    }

    private void u(ViewGroup viewGroup, ShimmerFrameLayout shimmerFrameLayout) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        alphaAnimation.setAnimationListener(new a(this, shimmerFrameLayout));
        viewGroup.startAnimation(alphaAnimation);
    }

    @Override // com.pinguo.camera360.adv.e.c.c
    public int g() {
        return R.layout.album_gift_fulladv_baselayout;
    }

    @Override // com.pinguo.camera360.adv.e.c.b
    public void q() {
        super.q();
        u(this.f6163k, (ShimmerFrameLayout) this.f6163k.findViewById(R.id.shimmer_view_container));
        if (us.pinguo.foundation.t.b.a.h(this.f6163k.getContext()) < 1280) {
            ((RelativeLayout.LayoutParams) ((RelativeLayout) this.f6163k.findViewById(R.id.layout_image)).getLayoutParams()).setMargins(0, us.pinguo.foundation.t.b.a.a(this.f6163k.getContext(), 60.0f), 0, 0);
        }
    }
}
