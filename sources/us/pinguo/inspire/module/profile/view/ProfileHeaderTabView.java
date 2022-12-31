package us.pinguo.inspire.module.profile.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.timepicker.TimeModel;
import us.pinguo.foundation.statistics.h;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ProfileHeaderTabView extends LinearLayout implements View.OnClickListener {
    private int clickColor;
    private TextView mAttentionCount;
    private View mAttentionView;
    private TextView mFansCount;
    private View mFansView;
    private TextView mFlowerCount;
    private TextView mFlowerTxt;
    private View mFlowerView;
    private TextView mLikeCount;
    private TextView mLikeText;
    private View mLikeView;
    private OnTabViewSelectListener mOnTabViewSelectListener;
    private State mState;
    private TextView mStoryCount;
    private TextView mStoryText;
    private View mStoryView;
    private int normalColor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: us.pinguo.inspire.module.profile.view.ProfileHeaderTabView$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$us$pinguo$inspire$module$profile$view$ProfileHeaderTabView$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$us$pinguo$inspire$module$profile$view$ProfileHeaderTabView$State = iArr;
            try {
                iArr[State.STORY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfileHeaderTabView$State[State.LIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$us$pinguo$inspire$module$profile$view$ProfileHeaderTabView$State[State.FLOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface OnTabViewSelectListener {
        void onTabSelect(View view, State state);
    }

    /* loaded from: classes9.dex */
    public enum State {
        STORY,
        LIKE,
        FLOWER,
        ATTENTION,
        FANS
    }

    public ProfileHeaderTabView(Context context) {
        super(context);
        init(context);
    }

    private void makeStorySelect(State state) {
        int i2 = AnonymousClass1.$SwitchMap$us$pinguo$inspire$module$profile$view$ProfileHeaderTabView$State[state.ordinal()];
        if (i2 == 1) {
            this.mStoryCount.setTextColor(this.clickColor);
            this.mStoryText.setTextColor(this.clickColor);
            this.mLikeCount.setTextColor(this.normalColor);
            this.mLikeText.setTextColor(this.normalColor);
            this.mFlowerCount.setTextColor(this.normalColor);
            this.mFlowerTxt.setTextColor(this.normalColor);
            this.mLikeCount.setTypeface(Typeface.DEFAULT);
            this.mFlowerCount.setTypeface(Typeface.DEFAULT);
            this.mStoryCount.setTypeface(Typeface.DEFAULT_BOLD);
        } else if (i2 == 2) {
            this.mStoryCount.setTextColor(this.normalColor);
            this.mStoryText.setTextColor(this.normalColor);
            this.mLikeCount.setTextColor(this.clickColor);
            this.mLikeText.setTextColor(this.clickColor);
            this.mFlowerCount.setTextColor(this.normalColor);
            this.mFlowerTxt.setTextColor(this.normalColor);
            this.mLikeCount.setTypeface(Typeface.DEFAULT_BOLD);
            this.mFlowerCount.setTypeface(Typeface.DEFAULT);
            this.mStoryCount.setTypeface(Typeface.DEFAULT);
        } else if (i2 != 3) {
        } else {
            this.mStoryCount.setTextColor(this.normalColor);
            this.mStoryText.setTextColor(this.normalColor);
            this.mLikeCount.setTextColor(this.normalColor);
            this.mLikeText.setTextColor(this.normalColor);
            this.mFlowerCount.setTextColor(this.clickColor);
            this.mFlowerTxt.setTextColor(this.clickColor);
            this.mLikeCount.setTypeface(Typeface.DEFAULT);
            this.mFlowerCount.setTypeface(Typeface.DEFAULT_BOLD);
            this.mStoryCount.setTypeface(Typeface.DEFAULT);
        }
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.profile_header_tab_view, (ViewGroup) this, true);
        this.mStoryView = inflate.findViewById(R.id.tab_story_layout);
        this.mLikeView = inflate.findViewById(R.id.tab_like_layouts);
        this.mAttentionView = inflate.findViewById(R.id.tab_attention_layout);
        this.mFansView = inflate.findViewById(R.id.tab_fans_layout);
        this.mFlowerView = inflate.findViewById(R.id.tab_flower_layout);
        this.mStoryText = (TextView) inflate.findViewById(R.id.tab_story_text);
        this.mLikeText = (TextView) inflate.findViewById(R.id.tab_like_text);
        this.mFlowerCount = (TextView) inflate.findViewById(R.id.tab_flower_count);
        this.mFlowerTxt = (TextView) inflate.findViewById(R.id.tab_flower_txt);
        this.mStoryCount = (TextView) inflate.findViewById(R.id.tab_story_count);
        this.mLikeCount = (TextView) inflate.findViewById(R.id.tab_like_count);
        this.mAttentionCount = (TextView) inflate.findViewById(R.id.tab_attention_count);
        this.mFansCount = (TextView) inflate.findViewById(R.id.tab_fans_count);
        this.normalColor = context.getResources().getColor(R.color.tab_normal_color);
        this.clickColor = context.getResources().getColor(R.color.tab_click_color);
        this.mStoryView.setOnClickListener(this);
        this.mLikeView.setOnClickListener(this);
        this.mAttentionView.setOnClickListener(this);
        this.mFansView.setOnClickListener(this);
        this.mFlowerView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mStoryView) {
            State state = State.STORY;
            this.mState = state;
            makeStorySelect(state);
        } else if (view == this.mLikeView) {
            State state2 = State.LIKE;
            this.mState = state2;
            makeStorySelect(state2);
        } else if (view == this.mAttentionView) {
            this.mState = State.ATTENTION;
        } else if (view == this.mFansView) {
            this.mState = State.FANS;
        } else if (view == this.mFlowerView) {
            State state3 = State.FLOWER;
            this.mState = state3;
            makeStorySelect(state3);
            h.a.w("profile_send_flowers_btn", "click");
        }
        OnTabViewSelectListener onTabViewSelectListener = this.mOnTabViewSelectListener;
        if (onTabViewSelectListener != null) {
            onTabViewSelectListener.onTabSelect(view, this.mState);
        }
    }

    public void setAttentionCount(int i2) {
        this.mAttentionCount.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    public void setCurrentState(State state) {
        this.mState = state;
    }

    public void setFansCount(int i2) {
        this.mFansCount.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    public void setFlowerCount(int i2) {
        this.mFlowerCount.setText(String.valueOf(i2));
    }

    public void setLikeCount(int i2) {
        this.mLikeCount.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    public void setOnTabViewSelectListener(OnTabViewSelectListener onTabViewSelectListener) {
        this.mOnTabViewSelectListener = onTabViewSelectListener;
    }

    public void setSelectTabFromState(State state) {
        State state2 = State.STORY;
        if (state == state2) {
            makeStorySelect(state2);
            return;
        }
        State state3 = State.LIKE;
        if (state == state3) {
            makeStorySelect(state3);
            return;
        }
        State state4 = State.FLOWER;
        if (state == state4) {
            makeStorySelect(state4);
        }
    }

    public void setStoryCount(int i2) {
        this.mStoryCount.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
    }

    public ProfileHeaderTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ProfileHeaderTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    @TargetApi(21)
    public ProfileHeaderTabView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(context);
    }
}
