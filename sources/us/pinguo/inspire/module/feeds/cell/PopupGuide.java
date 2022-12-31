package us.pinguo.inspire.module.feeds.cell;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import us.pinguo.admobvista.StaticsAdv.IADStatisticBase;
import us.pinguo.advconfigdata.AdvConfigManager;
import us.pinguo.advconfigdata.Utils.AdvTimeUtils;
import us.pinguo.advconfigdata.database.AdvItem;
import us.pinguo.foundation.statistics.l;
import us.pinguo.inspire.Inspire;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class PopupGuide {
    public static final String ADV_INSPIRE_BUBBLE = "f0153f4df3111f2e109976805c33d669";
    private static final int DURATION = 400;
    private static Animator mHideAnimator;
    private static Animator mShowAnimator;

    private static AdvItem getPopupAdvItem() {
        return AdvConfigManager.getInstance().getItem(ADV_INSPIRE_BUBBLE);
    }

    public static void hidePopup(View view) {
        View findViewById;
        if (view == null || (findViewById = view.findViewById(R.id.feeds_publish_guide_layout)) == null || findViewById.getVisibility() == 8) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public static boolean hidePopupAnim(View view) {
        final View findViewById;
        if (view == null || (findViewById = view.findViewById(R.id.feeds_publish_guide_layout)) == null || findViewById.getVisibility() == 8) {
            return false;
        }
        Animator animator = mShowAnimator;
        if (animator != null && animator.isStarted()) {
            mShowAnimator.cancel();
        }
        Animator animator2 = mHideAnimator;
        if ((animator2 == null || !animator2.isStarted()) && findViewById.getAlpha() != 0.0f) {
            if (findViewById.getTag() instanceof AdvItem) {
                Context a = Inspire.a();
                String str = ((AdvItem) findViewById.getTag()).advId;
                if (str == null) {
                    str = "null";
                }
                l.onEvent(a, "portal_bubble_click", str);
            } else {
                l.onEvent(Inspire.a(), "portal_bubble_click", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findViewById, "alpha", findViewById.getAlpha(), 0.0f);
            mHideAnimator = ofFloat;
            ofFloat.setDuration(400L);
            mHideAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.PopupGuide.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator3) {
                    findViewById.setVisibility(8);
                    Animator unused = PopupGuide.mHideAnimator = null;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator3) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator3) {
                }
            });
            mHideAnimator.start();
            return true;
        }
        return false;
    }

    public static boolean isShowing(View view) {
        View findViewById;
        return (view == null || (findViewById = view.findViewById(R.id.feeds_publish_guide_layout)) == null || findViewById.getVisibility() == 8) ? false : true;
    }

    public static void reShowPopup(View view) {
        View findViewById;
        if (view == null || (findViewById = view.findViewById(R.id.feeds_publish_guide_layout)) == null || findViewById.getVisibility() == 0) {
            return;
        }
        findViewById.setVisibility(0);
    }

    private static void showAdPopup(final View view) {
        SharedPreferences c = Inspire.c();
        long j2 = c.getLong("show_publish_guide_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - j2 < AdvTimeUtils.MILLIS_OF_A_DAY) {
            return;
        }
        c.edit().putLong("show_publish_guide_time", currentTimeMillis).apply();
        AdvItem popupAdvItem = getPopupAdvItem();
        if (popupAdvItem == null) {
            return;
        }
        String str = popupAdvItem.content;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = view.getContext();
        String str2 = popupAdvItem.advId;
        if (str2 == null) {
            str2 = "null";
        }
        l.onEvent(context, "portal_bubble_show", str2);
        View inflate = ((ViewStub) view.findViewById(R.id.base_fragment_popup_container)).inflate();
        inflate.setAlpha(0.0f);
        inflate.setVisibility(0);
        inflate.setTag(popupAdvItem);
        ((TextView) inflate.findViewById(R.id.feeds_popup_txt)).setText(str);
        inflate.findViewById(R.id.feeds_popup_img).setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(inflate, "alpha", 0.0f, 1.0f);
        mShowAnimator = ofFloat;
        ofFloat.setDuration(400L);
        mShowAnimator.setStartDelay(2000L);
        mShowAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.PopupGuide.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator unused = PopupGuide.mShowAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        mShowAnimator.start();
        view.postDelayed(new Runnable() { // from class: us.pinguo.inspire.module.feeds.cell.PopupGuide.3
            @Override // java.lang.Runnable
            public void run() {
                PopupGuide.hidePopupAnim(view);
            }
        }, 7000L);
    }

    private static void showNewGuidePopup(View view) {
        View inflate = ((ViewStub) view.findViewById(R.id.base_fragment_popup_container)).inflate();
        inflate.setAlpha(0.0f);
        inflate.setVisibility(0);
        l.onEvent(view.getContext(), "portal_bubble_show", IADStatisticBase.VARCHAR_DEFALUT_VALUE);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(inflate, "alpha", 0.0f, 1.0f);
        mShowAnimator = ofFloat;
        ofFloat.setDuration(400L);
        mShowAnimator.setStartDelay(2000L);
        mShowAnimator.addListener(new Animator.AnimatorListener() { // from class: us.pinguo.inspire.module.feeds.cell.PopupGuide.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Animator unused = PopupGuide.mShowAnimator = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        mShowAnimator.start();
    }

    public static void tryShowPopup(View view) {
        showAdPopup(view);
    }
}
