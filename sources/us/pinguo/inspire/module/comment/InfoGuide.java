package us.pinguo.inspire.module.comment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import us.pinguo.inspire.Inspire;
import us.pinguo.inspire.module.comment.cell.BaseInfoCell;
import us.pinguo.inspire.module.comment.cell.ContentInfoCell;
import us.pinguo.inspire.module.comment.widget.FlingDownViewPager;
import us.pinguo.user.util.f;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class InfoGuide {
    private static boolean sCameraGuideShowed;
    private static boolean sFlowerGuideShowed;
    private static boolean sShowGuide;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void cancelGuide() {
        sShowGuide = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkShowGuide(final View view, final FeedsInfoFragment feedsInfoFragment) {
        boolean z = Inspire.c().getBoolean("show_scroll_guide", true);
        boolean z2 = Inspire.c().getBoolean("show_like_guide", true);
        if (z || z2) {
            return;
        }
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.b1
            @Override // java.lang.Runnable
            public final void run() {
                InfoGuide.checkShowGuideImpl(view, feedsInfoFragment);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkShowGuideFirst(final View view, final f.b bVar) {
        sShowGuide = true;
        if (view.findViewById(R.id.info_guide_layout) != null) {
            view.findViewById(R.id.info_guide_layout).setVisibility(8);
        }
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.d1
            @Override // java.lang.Runnable
            public final void run() {
                InfoGuide.showScrollGuide(view);
            }
        }, 2000L);
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.f1
            @Override // java.lang.Runnable
            public final void run() {
                InfoGuide.showLikeGuide(view, bVar);
            }
        }, 6000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkShowGuideImpl(View view, final FeedsInfoFragment feedsInfoFragment) {
        if (sFlowerGuideShowed) {
            return;
        }
        final BaseInfoCell currentCell = feedsInfoFragment.getCurrentCell();
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.comment.h1
            @Override // java.lang.Runnable
            public final void run() {
                InfoGuide.d(BaseInfoCell.this, feedsInfoFragment);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(BaseInfoCell baseInfoCell, FeedsInfoFragment feedsInfoFragment) {
        if (baseInfoCell == feedsInfoFragment.getCurrentCell() && (baseInfoCell instanceof ContentInfoCell)) {
            showFlowerToast((ContentInfoCell) baseInfoCell);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dismiss(final View view) {
        if ((view.getTag() instanceof ValueAnimator) && ((ValueAnimator) view.getTag()).isStarted()) {
            ((ValueAnimator) view.getTag()).cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.addListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.InfoGuide.3
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        view.setTag(ofFloat);
        ofFloat.setStartDelay(3000L);
        ofFloat.start();
    }

    public static void showCameraToast(ContentInfoCell contentInfoCell) {
        if (contentInfoCell == null || contentInfoCell.getMViewHolder() == null || contentInfoCell.getMViewHolder().b == null || contentInfoCell.getMViewHolder().a(R.id.info_bottom_camera_img).getVisibility() != 0) {
            return;
        }
        boolean z = contentInfoCell.getData().taskInfo != null && contentInfoCell.getData().taskInfo.taskType == 5;
        String str = z ? "info_photo_movie_guide" : "info_camera_guide";
        int i2 = Inspire.c().getInt(str, 0);
        if (i2 >= 3) {
            return;
        }
        View view = contentInfoCell.getMViewHolder().b;
        View findViewById = view.findViewById(R.id.info_camera_guide);
        if (findViewById == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.info_camera_guide_stub);
            if (viewStub == null) {
                return;
            }
            findViewById = viewStub.inflate();
        }
        if (findViewById == null) {
            return;
        }
        if (z) {
            ((TextView) findViewById).setText(R.string.info_photo_movie_guide);
        }
        sCameraGuideShowed = true;
        Inspire.c().edit().putInt(str, i2 + 1).apply();
        findViewById.setAlpha(0.0f);
        findViewById.setVisibility(0);
        findViewById.animate().alpha(1.0f).setDuration(400L).start();
        dismiss(findViewById);
    }

    public static void showFlowerToast(final ContentInfoCell contentInfoCell) {
        int i2;
        if (sCameraGuideShowed || contentInfoCell == null || contentInfoCell.getMViewHolder() == null || contentInfoCell.getMViewHolder().b == null || (i2 = Inspire.c().getInt("info_flower_guide", 0)) >= 3) {
            return;
        }
        View view = contentInfoCell.getMViewHolder().b;
        View findViewById = view.findViewById(R.id.info_flower_guide);
        if (findViewById == null) {
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.info_flower_guide_stub);
            if (viewStub == null) {
                return;
            }
            findViewById = viewStub.inflate();
        }
        if (findViewById == null) {
            return;
        }
        Inspire.c().edit().putInt("info_flower_guide", i2 + 1).apply();
        findViewById.setAlpha(0.0f);
        findViewById.setVisibility(0);
        findViewById.animate().alpha(1.0f).setDuration(400L).setListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.InfoGuide.4
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ContentInfoCell.this.fakeFlowerAnim();
            }
        }).start();
        sFlowerGuideShowed = true;
        dismiss(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showLikeGuide(View view, final f.b bVar) {
        if (sShowGuide && Inspire.c().getBoolean("show_like_guide", true)) {
            Inspire.c().edit().putBoolean("show_like_guide", false).apply();
            final View findViewById = view.findViewById(R.id.info_guide_layout);
            if (findViewById == null) {
                findViewById = ((ViewStub) view.findViewById(R.id.info_guide_stub)).inflate();
            }
            if (findViewById.getTag() instanceof ValueAnimator) {
                ((ValueAnimator) findViewById.getTag()).cancel();
            }
            findViewById.setVisibility(0);
            findViewById.setAlpha(1.0f);
            final us.pinguo.user.util.f fVar = new us.pinguo.user.util.f();
            final f.b bVar2 = new f.b() { // from class: us.pinguo.inspire.module.comment.InfoGuide.2
                @Override // us.pinguo.user.util.f.b
                public void onDoubleClick(View view2) {
                    f.b.this.onDoubleClick(view2);
                }

                @Override // us.pinguo.user.util.f.b
                public void onSingleClick(View view2) {
                    InfoGuide.dismiss(findViewById);
                }
            };
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.e1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    us.pinguo.user.util.f.this.d(view2, bVar2);
                }
            });
            ((TextView) findViewById.findViewById(R.id.info_guide_txt1)).setVisibility(8);
            ((TextView) findViewById.findViewById(R.id.info_guide_txt2)).setText(R.string.info_guide_like);
            ImageView imageView = (ImageView) findViewById.findViewById(R.id.info_guide_anim);
            imageView.setImageResource(R.drawable.info_like_guide);
            ((AnimationDrawable) imageView.getDrawable()).start();
            dismiss(findViewById);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showScrollGuide(final View view) {
        if (sShowGuide && Inspire.c().getBoolean("show_scroll_guide", true)) {
            Inspire.c().edit().putBoolean("show_scroll_guide", false).apply();
            final View findViewById = view.findViewById(R.id.info_guide_layout);
            if (findViewById == null) {
                findViewById = ((ViewStub) view.findViewById(R.id.info_guide_stub)).inflate();
            }
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: us.pinguo.inspire.module.comment.c1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    InfoGuide.dismiss(findViewById);
                }
            });
            ((AnimationDrawable) ((ImageView) findViewById.findViewById(R.id.info_guide_anim)).getDrawable()).start();
            final GestureDetector gestureDetector = new GestureDetector(findViewById.getContext(), new GestureDetector.OnGestureListener() { // from class: us.pinguo.inspire.module.comment.InfoGuide.1
                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    if (f3 < -100.0f) {
                        findViewById.setVisibility(8);
                        FlingDownViewPager flingDownViewPager = (FlingDownViewPager) view.findViewById(R.id.feeds_detail_viewpager);
                        if (flingDownViewPager.getChildCount() > 1) {
                            flingDownViewPager.setCurrentItem(flingDownViewPager.getCurrentItem() + 1, true);
                            return false;
                        }
                        return false;
                    }
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                    return false;
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                }

                @Override // android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return false;
                }
            });
            findViewById.setOnTouchListener(new View.OnTouchListener() { // from class: us.pinguo.inspire.module.comment.g1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean onTouchEvent;
                    onTouchEvent = gestureDetector.onTouchEvent(motionEvent);
                    return onTouchEvent;
                }
            });
            dismiss(findViewById);
        }
    }
}
