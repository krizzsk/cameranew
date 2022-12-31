package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.io.IOException;
/* loaded from: classes3.dex */
public class GifTextView extends TextView {
    private boolean a;

    public GifTextView(Context context) {
        super(context);
    }

    private Drawable a(int i2) {
        if (i2 == 0) {
            return null;
        }
        Resources resources = getResources();
        if (!isInEditMode() && "drawable".equals(resources.getResourceTypeName(i2))) {
            try {
                return new c(resources, i2);
            } catch (Resources.NotFoundException | IOException unused) {
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return resources.getDrawable(i2, getContext().getTheme());
        }
        return resources.getDrawable(i2);
    }

    private void b(Drawable[] drawableArr) {
        for (Drawable drawable : drawableArr) {
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
        }
    }

    private void c(AttributeSet attributeSet, int i2, int i3) {
        if (attributeSet != null) {
            Drawable a = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableLeft", 0));
            Drawable a2 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableTop", 0));
            Drawable a3 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableRight", 0));
            Drawable a4 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableBottom", 0));
            Drawable a5 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableStart", 0));
            Drawable a6 = a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "drawableEnd", 0));
            if (Build.VERSION.SDK_INT >= 17) {
                if (getLayoutDirection() == 0) {
                    if (a5 == null) {
                        a5 = a;
                    }
                    if (a6 == null) {
                        a6 = a3;
                    }
                } else {
                    if (a5 == null) {
                        a5 = a3;
                    }
                    if (a6 == null) {
                        a6 = a;
                    }
                }
                setCompoundDrawablesRelativeWithIntrinsicBounds(a5, a2, a6, a4);
                setCompoundDrawablesWithIntrinsicBounds(a, a2, a3, a4);
            } else {
                setCompoundDrawablesWithIntrinsicBounds(a, a2, a3, a4);
            }
            d(a(attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "background", 0)));
        }
        this.a = e.d(this, attributeSet, i2, i3);
    }

    private void d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b(getCompoundDrawables());
        if (Build.VERSION.SDK_INT >= 17) {
            b(getCompoundDrawablesRelative());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        Drawable[] compoundDrawables = getCompoundDrawables();
        gifViewSavedState.a(compoundDrawables[0], 0);
        gifViewSavedState.a(compoundDrawables[1], 1);
        gifViewSavedState.a(compoundDrawables[2], 2);
        gifViewSavedState.a(compoundDrawables[3], 3);
        if (Build.VERSION.SDK_INT >= 17) {
            Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
            gifViewSavedState.a(compoundDrawablesRelative[0], 4);
            gifViewSavedState.a(compoundDrawablesRelative[2], 5);
        }
        gifViewSavedState.a(getBackground(), 6);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Drawable[] drawableArr = new Drawable[7];
        if (this.a) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            System.arraycopy(compoundDrawables, 0, drawableArr, 0, compoundDrawables.length);
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
                drawableArr[4] = compoundDrawablesRelative[0];
                drawableArr[5] = compoundDrawablesRelative[2];
            }
            drawableArr[6] = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawableArr);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        d(a(i2));
    }

    @Override // android.widget.TextView
    @RequiresApi(17)
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        setCompoundDrawablesRelativeWithIntrinsicBounds(a(i2), a(i3), a(i4), a(i5));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        setCompoundDrawablesWithIntrinsicBounds(a(i2), a(i3), a(i4), a(i5));
    }

    public void setFreezesAnimation(boolean z) {
        this.a = z;
    }

    public GifTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet, 0, 0);
    }

    public GifTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(attributeSet, i2, 0);
    }
}
