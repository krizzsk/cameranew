package us.pinguo.inspire.widget.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import vStudio.Android.Camera360.R;
/* loaded from: classes9.dex */
public class ClearEditText extends EditText implements View.OnFocusChangeListener, TextWatcher {
    private Drawable a;

    public ClearEditText(Context context) {
        this(context, null);
    }

    private void a(AttributeSet attributeSet) {
        Drawable drawable = getResources().getDrawable(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", R.drawable.clear));
        this.a = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.a.getIntrinsicHeight());
        b(false);
        setOnFocusChangeListener(this);
        addTextChangedListener(this);
    }

    public static Animation c(int i2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator(i2));
        translateAnimation.setDuration(1000L);
        return translateAnimation;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    protected void b(boolean z) {
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], z ? this.a : null, getCompoundDrawables()[3]);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            b(getText().length() > 0);
        } else {
            b(false);
        }
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        b(charSequence.length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        if (motionEvent.getAction() == 1 && getCompoundDrawables()[2] != null) {
            if ((motionEvent.getX() <= ((float) (getWidth() - getTotalPaddingRight())) || motionEvent.getX() >= ((float) (getWidth() - getPaddingRight()))) ? false : false) {
                setText("");
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setMaxLength(int i2) {
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
    }

    public void setShakeAnimation() {
        setAnimation(c(5));
    }

    public ClearEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public ClearEditText(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
