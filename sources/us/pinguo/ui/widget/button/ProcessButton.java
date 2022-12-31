package us.pinguo.ui.widget.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.R;
/* loaded from: classes6.dex */
public abstract class ProcessButton extends FlatButton {

    /* renamed from: f  reason: collision with root package name */
    private int f12274f;

    /* renamed from: g  reason: collision with root package name */
    private int f12275g;

    /* renamed from: h  reason: collision with root package name */
    private int f12276h;

    /* renamed from: i  reason: collision with root package name */
    private GradientDrawable f12277i;

    /* renamed from: j  reason: collision with root package name */
    private GradientDrawable f12278j;

    /* renamed from: k  reason: collision with root package name */
    private GradientDrawable f12279k;

    /* renamed from: l  reason: collision with root package name */
    private CharSequence f12280l;
    private CharSequence m;
    private CharSequence n;
    private ColorStateList o;
    private ColorStateList p;
    private ColorStateList q;

    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mProgress;

        /* loaded from: classes6.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.mProgress);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mProgress = parcel.readInt();
        }
    }

    public ProcessButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k(context, attributeSet);
    }

    private void k(Context context, AttributeSet attributeSet) {
        this.f12276h = 0;
        this.f12275g = 100;
        GradientDrawable gradientDrawable = (GradientDrawable) f(R.drawable.process_button_rect_progress).mutate();
        this.f12277i = gradientDrawable;
        gradientDrawable.setCornerRadius(d());
        GradientDrawable gradientDrawable2 = (GradientDrawable) f(R.drawable.process_button_rect_complete).mutate();
        this.f12278j = gradientDrawable2;
        gradientDrawable2.setCornerRadius(d());
        GradientDrawable gradientDrawable3 = (GradientDrawable) f(R.drawable.process_button_rect_error).mutate();
        this.f12279k = gradientDrawable3;
        gradientDrawable3.setCornerRadius(d());
        if (attributeSet != null) {
            l(context, attributeSet);
        }
    }

    private void l(Context context, AttributeSet attributeSet) {
        TypedArray j2 = j(context, attributeSet, R.styleable.ProcessButton);
        if (j2 == null) {
            return;
        }
        try {
            this.f12280l = j2.getString(R.styleable.ProcessButton_pb_textProgress);
            this.m = j2.getString(R.styleable.ProcessButton_pb_textComplete);
            this.n = j2.getString(R.styleable.ProcessButton_pb_textError);
            this.q = j2.getColorStateList(R.styleable.ProcessButton_pb_textColorError);
            this.p = j2.getColorStateList(R.styleable.ProcessButton_pb_textColorComplete);
            this.o = j2.getColorStateList(R.styleable.ProcessButton_pb_textColorProgress);
            this.f12277i.setColor(j2.getColor(R.styleable.ProcessButton_pb_colorProgress, c(R.color.process_button_purple_progress)));
            int i2 = R.color.process_button_green_complete;
            this.f12278j.setColor(j2.getColor(R.styleable.ProcessButton_pb_colorComplete, c(i2)));
            this.f12279k.setColor(j2.getColor(R.styleable.ProcessButton_pb_colorError, c(i2)));
        } finally {
            j2.recycle();
        }
    }

    public abstract void m(Canvas canvas);

    public GradientDrawable n() {
        return this.f12278j;
    }

    public CharSequence o() {
        return this.m;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i2 = this.f12274f;
        if (i2 > this.f12276h && i2 < this.f12275g) {
            m(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f12274f = savedState.mProgress;
            super.onRestoreInstanceState(savedState.getSuperState());
            setProgress(this.f12274f);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mProgress = this.f12274f;
        return savedState;
    }

    public GradientDrawable p() {
        return this.f12279k;
    }

    public CharSequence q() {
        return this.n;
    }

    public CharSequence r() {
        return this.f12280l;
    }

    public int s() {
        return this.f12275g;
    }

    public void setCompleteDrawable(GradientDrawable gradientDrawable) {
        this.f12278j = gradientDrawable;
    }

    public void setCompleteText(CharSequence charSequence) {
        this.m = charSequence;
    }

    public void setErrorDrawable(GradientDrawable gradientDrawable) {
        this.f12279k = gradientDrawable;
    }

    public void setErrorText(CharSequence charSequence) {
        this.n = charSequence;
    }

    public void setLoadingText(CharSequence charSequence) {
        this.f12280l = charSequence;
    }

    @Override // us.pinguo.ui.widget.button.FlatButton
    public void setNormalText(CharSequence charSequence) {
        super.setNormalText(charSequence);
        if (this.f12274f == this.f12276h) {
            setText(charSequence);
        }
    }

    public void setProgress(int i2) {
        this.f12274f = i2;
        int i3 = this.f12276h;
        if (i2 == i3) {
            x();
        } else if (i2 == this.f12275g) {
            v();
        } else if (i2 < i3) {
            w();
        } else {
            y();
        }
        invalidate();
    }

    public void setProgressDrawable(GradientDrawable gradientDrawable) {
        this.f12277i = gradientDrawable;
    }

    public int t() {
        return this.f12274f;
    }

    public GradientDrawable u() {
        return this.f12277i;
    }

    protected void v() {
        if (o() != null) {
            setText(o());
        }
        ColorStateList colorStateList = this.p;
        if (colorStateList != null) {
            setTextColor(colorStateList);
        } else {
            setTextColor(i());
        }
        setBackgroundCompat(n());
    }

    protected void w() {
        if (q() != null) {
            setText(q());
        }
        ColorStateList colorStateList = this.q;
        if (colorStateList != null) {
            setTextColor(colorStateList);
        } else {
            setTextColor(i());
        }
        setBackgroundCompat(p());
    }

    protected void x() {
        if (h() != null) {
            setText(h());
        }
        setTextColor(i());
        setBackgroundCompat(g());
    }

    protected void y() {
        if (r() != null) {
            setText(r());
        }
        ColorStateList colorStateList = this.o;
        if (colorStateList != null) {
            setTextColor(colorStateList);
        } else {
            setTextColor(i());
        }
        setBackgroundCompat(g());
    }

    public ProcessButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    public ProcessButton(Context context) {
        super(context);
        k(context, null);
    }
}
