package us.pinguo.inspire.module.guide;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import us.pinguo.inspire.module.guide.GuideBuilder;
/* loaded from: classes9.dex */
public class Guide implements View.OnKeyListener, View.OnClickListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Component[] mComponents;
    private Configuration mConfiguration;
    private MaskView mMaskView;
    private GuideBuilder.OnVisibilityChangedListener mOnVisibilityChangedListener;
    private boolean mShouldCheckLocInWindow = true;

    private MaskView onCreateView(Activity activity, String str) {
        MaskView maskView = new MaskView(activity, str);
        maskView.setFullingColor(activity.getResources().getColor(this.mConfiguration.mFullingColorId));
        maskView.setFullingAlpha(this.mConfiguration.mAlpha);
        maskView.setHighTargetCorner(this.mConfiguration.mCorner);
        maskView.setPadding(this.mConfiguration.mPadding);
        maskView.setPaddingLeft(this.mConfiguration.mPaddingLeft);
        maskView.setPaddingTop(this.mConfiguration.mPaddingTop);
        maskView.setPaddingRight(this.mConfiguration.mPaddingRight);
        maskView.setPaddingBottom(this.mConfiguration.mPaddingBottom);
        maskView.setHighTargetGraphStyle(this.mConfiguration.mGraphStyle);
        maskView.setOverlayTarget(this.mConfiguration.mOverlayTarget);
        maskView.setOnKeyListener(this);
        int[] iArr = new int[2];
        ((ViewGroup) activity.findViewById(16908290)).getLocationInWindow(iArr);
        int i2 = iArr[1];
        if (this.mShouldCheckLocInWindow && i2 == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                i2 = activity.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Configuration configuration = this.mConfiguration;
        View view = configuration.mTargetView;
        if (view != null) {
            maskView.setTargetRect(Common.getViewAbsRect(view, 0, i2));
        } else {
            View findViewById = activity.findViewById(configuration.mTargetViewId);
            if (findViewById != null) {
                maskView.setTargetRect(Common.getViewAbsRect(findViewById, 0, i2));
            }
        }
        View findViewById2 = activity.findViewById(this.mConfiguration.mFullingViewId);
        if (findViewById2 != null) {
            maskView.setFullingRect(Common.getViewAbsRect(findViewById2, 0, i2));
        }
        if (this.mConfiguration.mOutsideTouchable) {
            maskView.setClickable(false);
        } else {
            maskView.setOnClickListener(this);
        }
        for (Component component : this.mComponents) {
            maskView.addView(Common.componentToView(activity.getLayoutInflater(), component));
        }
        return maskView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDestroy() {
        this.mConfiguration = null;
        this.mComponents = null;
        this.mOnVisibilityChangedListener = null;
        this.mMaskView.removeAllViews();
        this.mMaskView = null;
    }

    public void dismiss() {
        final ViewGroup viewGroup;
        MaskView maskView = this.mMaskView;
        if (maskView == null || (viewGroup = (ViewGroup) maskView.getParent()) == null) {
            return;
        }
        if (this.mConfiguration.mExitAnimationId != -1) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.mMaskView.getContext(), this.mConfiguration.mExitAnimationId);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: us.pinguo.inspire.module.guide.Guide.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.removeView(Guide.this.mMaskView);
                    if (Guide.this.mOnVisibilityChangedListener != null) {
                        Guide.this.mOnVisibilityChangedListener.onDismiss();
                    }
                    Guide.this.onDestroy();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mMaskView.startAnimation(loadAnimation);
            return;
        }
        viewGroup.removeView(this.mMaskView);
        GuideBuilder.OnVisibilityChangedListener onVisibilityChangedListener = this.mOnVisibilityChangedListener;
        if (onVisibilityChangedListener != null) {
            onVisibilityChangedListener.onDismiss();
        }
        onDestroy();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Configuration configuration = this.mConfiguration;
        if (configuration == null || !configuration.mAutoDismiss) {
            return;
        }
        dismiss();
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        Configuration configuration;
        if (i2 == 4 && keyEvent.getAction() == 1 && (configuration = this.mConfiguration) != null && configuration.mAutoDismiss) {
            dismiss();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCallback(GuideBuilder.OnVisibilityChangedListener onVisibilityChangedListener) {
        this.mOnVisibilityChangedListener = onVisibilityChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setComponents(Component[] componentArr) {
        this.mComponents = componentArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setConfiguration(Configuration configuration) {
        this.mConfiguration = configuration;
    }

    public void setShouldCheckLocInWindow(boolean z) {
        this.mShouldCheckLocInWindow = z;
    }

    public void show(Activity activity, String str) {
        if (this.mMaskView == null) {
            this.mMaskView = onCreateView(activity, str);
        }
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (this.mMaskView.getParent() == null) {
            viewGroup.addView(this.mMaskView);
            int i2 = this.mConfiguration.mEnterAnimationId;
            if (i2 != -1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(activity, i2);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: us.pinguo.inspire.module.guide.Guide.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        if (Guide.this.mOnVisibilityChangedListener != null) {
                            Guide.this.mOnVisibilityChangedListener.onShown();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                this.mMaskView.startAnimation(loadAnimation);
                return;
            }
            GuideBuilder.OnVisibilityChangedListener onVisibilityChangedListener = this.mOnVisibilityChangedListener;
            if (onVisibilityChangedListener != null) {
                onVisibilityChangedListener.onShown();
            }
        }
    }
}
