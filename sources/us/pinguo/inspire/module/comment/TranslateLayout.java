package us.pinguo.inspire.module.comment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rockerhieu.emoji.model.LocaleUtils;
import rx.functions.Action1;
import us.pinguo.inspire.module.profile.activity.GuestProfileActivity;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
import us.pinguo.inspire.module.profile.activity.ProfileActivity;
import us.pinguo.inspire.widget.j.b;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class TranslateLayout extends RelativeLayout implements View.OnClickListener {
    private static final int DURATION = 200;
    private ValueAnimator mAnimator;
    private ViewGroup mBtnLayout;
    private TextView mBtnTxt;
    private CommentLoader mCommentLoader;
    private TextView mContentTxt;
    private String mDescLang;
    private int mDividerColor;
    private int mDividerWidth;
    private int mFrom;
    private ImageView mIconImg;
    private Paint mPaint;
    private ProgressBar mProgressBar;
    private boolean mShowDivider;
    private String mSourceId;
    private int mTo;
    private String mType;

    public TranslateLayout(Context context) {
        super(context);
        init();
    }

    private String getValue() {
        Object[] objArr = new Object[3];
        objArr[0] = "comment".equals(this.mType) ? "comment" : FirebaseAnalytics.Param.CONTENT;
        String str = this.mDescLang;
        if (str == null) {
            str = "null";
        }
        objArr[1] = str;
        objArr[2] = LocaleUtils.getDefault().toString();
        return String.format("content_type=%s,source_language=%s,dest_language=%s", objArr);
    }

    private void hideTranslate() {
        this.mFrom = this.mContentTxt.getHeight();
        this.mTo = 0;
        startAnim();
    }

    private void init() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = ofFloat;
        ofFloat.setDuration(200L);
        this.mAnimator.addListener(new us.pinguo.ui.widget.j() { // from class: us.pinguo.inspire.module.comment.TranslateLayout.1
            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                TranslateLayout.this.onAnimEnd();
            }

            @Override // us.pinguo.ui.widget.j, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                TranslateLayout.this.onAnimStart();
            }
        });
        this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.inspire.module.comment.TranslateLayout.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                TranslateLayout.this.onAnimUpdate(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mCommentLoader = new CommentLoader();
        this.mDividerColor = getResources().getColor(R.color.divider_color_res_0x7d03000b);
        this.mDividerWidth = us.pinguo.foundation.t.b.a.b(getResources(), 2.0f);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(this.mDividerColor);
        this.mPaint.setStyle(Paint.Style.FILL);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimEnd() {
        setOnClickListener(this);
        if (this.mTo == 0) {
            showDivider(false);
            this.mContentTxt.setVisibility(8);
            this.mBtnTxt.setText(R.string.translate_show);
        }
        if (this.mFrom == 0) {
            this.mPaint.setAlpha(255);
            invalidate();
            this.mContentTxt.setAlpha(1.0f);
        }
        TextView textView = this.mContentTxt;
        textView.setPadding(textView.getPaddingLeft(), 0, this.mContentTxt.getPaddingRight(), this.mContentTxt.getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimStart() {
        setOnClickListener(null);
        if (this.mFrom == 0) {
            this.mBtnTxt.setText(R.string.translate_hide);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimUpdate(float f2) {
        us.pinguo.common.log.a.m("hwLog", "rate:" + f2, new Object[0]);
        ViewGroup.LayoutParams layoutParams = this.mContentTxt.getLayoutParams();
        int i2 = this.mFrom;
        int i3 = (int) (((float) i2) + (((float) (this.mTo - i2)) * f2));
        if (i3 != layoutParams.height) {
            if (i3 < 0) {
                i3 = 0;
            }
            layoutParams.height = i3;
            this.mContentTxt.setLayoutParams(layoutParams);
        }
        int i4 = this.mTo;
        int i5 = i4 == 0 ? this.mFrom : i4;
        float f3 = i4 == 0 ? i5 * f2 : i5 * (1.0f - f2);
        TextView textView = this.mContentTxt;
        textView.setPadding(textView.getPaddingLeft(), -((int) f3), this.mContentTxt.getPaddingRight(), this.mContentTxt.getPaddingBottom());
        if (this.mTo == 0) {
            f2 = 1.0f - f2;
        }
        this.mContentTxt.setAlpha(f2);
        this.mPaint.setAlpha((int) (f2 * 255.0f));
        invalidate();
        if (this.mContentTxt.getVisibility() == 8) {
            this.mContentTxt.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTranslateError(Throwable th) {
        us.pinguo.foundation.e.e(th);
        this.mContentTxt.setVisibility(8);
        this.mProgressBar.setVisibility(8);
        this.mIconImg.setVisibility(0);
        showDivider(false);
        this.mBtnTxt.setText(R.string.translate_error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTranslateSuccess(TranslateData translateData) {
        String str;
        if (translateData == null || (str = translateData.text) == null) {
            str = "";
        } else {
            TransCache.cache(this.mSourceId, this.mType, str);
        }
        this.mProgressBar.setVisibility(8);
        this.mIconImg.setVisibility(0);
        showDivider(true);
        this.mBtnLayout.setVisibility(0);
        this.mContentTxt.setVisibility(0);
        us.pinguo.inspire.widget.j.b.f(this.mContentTxt, str, new b.c() { // from class: us.pinguo.inspire.module.comment.TranslateLayout.3
            @Override // us.pinguo.inspire.widget.j.b.c
            public void onClick(View view, us.pinguo.inspire.widget.j.b bVar, b.C0407b c0407b) {
                Intent intent = new Intent();
                if (us.pinguo.foundation.utils.f0.b(us.pinguo.user.s0.getInstance().getUserId(), c0407b.a)) {
                    intent.setClass(view.getContext(), ProfileActivity.class);
                } else {
                    intent.setClass(view.getContext(), GuestProfileActivity.class);
                    intent.putExtra(GuestProfileFragment.USER_ID, c0407b.a);
                }
                view.getContext().startActivity(intent);
            }
        });
        this.mContentTxt.measure(View.MeasureSpec.makeMeasureSpec(this.mBtnLayout.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(32767, Integer.MIN_VALUE));
        int measuredHeight = this.mContentTxt.getMeasuredHeight();
        this.mFrom = 0;
        this.mTo = measuredHeight;
        startAnim();
    }

    private void showDivider(boolean z) {
        this.mShowDivider = z;
        invalidate();
    }

    private void showProgress() {
        this.mIconImg.setVisibility(8);
        this.mProgressBar.setVisibility(0);
        this.mBtnTxt.setText(R.string.translate_translating);
        showDivider(false);
    }

    private void startAnim() {
        this.mAnimator.start();
    }

    private void startTranslate() {
        us.pinguo.foundation.statistics.l.onEvent(getContext(), "content_translate_click", getValue());
        String str = TransCache.get(this.mSourceId, this.mType);
        if (str != null) {
            TranslateData translateData = new TranslateData();
            translateData.text = str;
            onTranslateSuccess(translateData);
            return;
        }
        showProgress();
        us.pinguo.foundation.utils.h.a(this.mCommentLoader.translate(this.mSourceId, this.mType).subscribe(new Action1() { // from class: us.pinguo.inspire.module.comment.p1
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                TranslateLayout.this.onTranslateSuccess((TranslateData) obj);
            }
        }, new Action1() { // from class: us.pinguo.inspire.module.comment.q1
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                TranslateLayout.this.onTranslateError((Throwable) obj);
            }
        }));
    }

    public void initData(String str, String str2, String str3) {
        this.mSourceId = str;
        this.mType = str2;
        this.mDescLang = str3;
        reset();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this) {
            if (this.mContentTxt.getVisibility() == 8) {
                startTranslate();
            } else {
                hideTranslate();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mShowDivider && this.mContentTxt.getVisibility() == 0) {
            int width = (this.mIconImg.getWidth() / 2) - (this.mDividerWidth / 2);
            canvas.drawRect(width, this.mContentTxt.getTop(), width + this.mDividerWidth, getHeight(), this.mPaint);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mContentTxt = (TextView) findViewById(R.id.translate_content);
        this.mProgressBar = (ProgressBar) findViewById(R.id.translate_progress);
        this.mBtnTxt = (TextView) findViewById(R.id.translate_btn);
        this.mBtnLayout = (ViewGroup) findViewById(R.id.translate_btn_layout);
        this.mIconImg = (ImageView) findViewById(R.id.translate_ic);
        this.mContentTxt.setOnClickListener(this);
        setOnClickListener(this);
    }

    public void reset() {
        this.mIconImg.setVisibility(0);
        this.mProgressBar.setVisibility(8);
        this.mContentTxt.setVisibility(8);
        this.mBtnTxt.setText(R.string.translate_show);
    }

    public TranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TranslateLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
