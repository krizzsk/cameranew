package us.pinguo.inspire.module.challenge.videomusic;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import us.pinguo.widget.discreteseekbar.DiscreteSeekBar;
import vStudio.Android.Camera360.R;
/* compiled from: VideoEditAnim.kt */
/* loaded from: classes9.dex */
public final class VideoEditAnim {
    private final VideoEdit2Activity activity;
    private boolean isVolumnLayoutDismissing;
    private View volumnLayout;
    private final int volumnLayoutHeight;

    public VideoEditAnim(VideoEdit2Activity activity) {
        kotlin.jvm.internal.s.h(activity, "activity");
        this.activity = activity;
        this.volumnLayoutHeight = activity.getResources().getDimensionPixelSize(R.dimen.video_edit_volumn_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: showVolumnLayout$lambda-1$lambda-0  reason: not valid java name */
    public static final void m113showVolumnLayout$lambda1$lambda0(View view) {
    }

    public final void dispatchTouchEvent(MotionEvent ev) {
        kotlin.jvm.internal.s.h(ev, "ev");
        View view = this.volumnLayout;
        boolean z = false;
        if (view != null && view.getVisibility() == 0) {
            z = true;
        }
        if (z && ev.getAction() == 0) {
            int[] iArr = new int[2];
            View view2 = this.volumnLayout;
            if (view2 != null) {
                view2.getLocationInWindow(iArr);
            }
            if (ev.getRawY() <= iArr[1]) {
                hideVolumnLayout();
            }
        }
    }

    public final VideoEdit2Activity getActivity() {
        return this.activity;
    }

    public final View getVolumnLayout() {
        return this.volumnLayout;
    }

    public final void hideVolumnLayout() {
        final View view;
        if (this.isVolumnLayoutDismissing || (view = this.volumnLayout) == null) {
            return;
        }
        view.animate().translationY(this.volumnLayoutHeight).setListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.challenge.videomusic.VideoEditAnim$hideVolumnLayout$1$1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(8);
                VideoEditAnim.this.isVolumnLayoutDismissing = false;
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                VideoEditAnim.this.isVolumnLayoutDismissing = true;
            }
        }).setDuration(500L).start();
    }

    public final void setVolumnLayout(View view) {
        this.volumnLayout = view;
    }

    public final void showVolumnLayout(boolean z, boolean z2) {
        if (this.volumnLayout == null) {
            this.volumnLayout = ((ViewStub) this.activity.findViewById(R.id.video_edit_volumn_stub)).inflate();
        }
        View view = this.volumnLayout;
        if (view == null) {
            return;
        }
        view.setOnClickListener(i0.a);
        view.setTranslationY(this.volumnLayoutHeight);
        view.setVisibility(0);
        view.animate().translationY(0.0f).setDuration(500L).setListener(null).start();
        DiscreteSeekBar discreteSeekBar = (DiscreteSeekBar) view.findViewById(R.id.video_deit_volumn_music);
        DiscreteSeekBar discreteSeekBar2 = (DiscreteSeekBar) view.findViewById(R.id.video_deit_volumn_ori);
        discreteSeekBar2.setEnabled(z);
        discreteSeekBar.setEnabled(z2);
        int color = getActivity().getResources().getColor(us.pinguo.ui.R.color.challenge_red);
        if (z2) {
            discreteSeekBar.setScrubberColor(color);
            discreteSeekBar.setThumbColor(color, color);
        } else {
            discreteSeekBar.setScrubberColor(-7829368);
            discreteSeekBar.setThumbColor(-7829368, -7829368);
        }
        if (z) {
            discreteSeekBar2.setScrubberColor(color);
            discreteSeekBar2.setThumbColor(color, color);
            return;
        }
        discreteSeekBar2.setScrubberColor(-7829368);
        discreteSeekBar2.setThumbColor(-7829368, -7829368);
    }
}
