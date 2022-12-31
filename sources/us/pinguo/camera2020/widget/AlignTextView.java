package us.pinguo.camera2020.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import us.pinguo.camera2020.R;
/* compiled from: AlignTextView.kt */
/* loaded from: classes3.dex */
public final class AlignTextView extends AppCompatTextView {
    private boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
    }

    private final void b(Canvas canvas, String str, float f2, float f3) {
        int i2 = 0;
        if (str.length() == 0) {
            return;
        }
        float intrinsicWidth = getCompoundDrawables()[0].getIntrinsicWidth() + getCompoundDrawablePadding() + getPaddingLeft();
        boolean z = str.charAt(str.length() - 1) == '\n';
        int length = str.length() - 1;
        if (!z && length != 0) {
            float measuredWidth = (((getMeasuredWidth() - f3) - getPaddingLeft()) - getPaddingRight()) / length;
            int length2 = str.length();
            while (i2 < length2) {
                char charAt = str.charAt(i2);
                i2++;
                String valueOf = String.valueOf(charAt);
                float desiredWidth = StaticLayout.getDesiredWidth(valueOf, getPaint());
                canvas.drawText(valueOf, intrinsicWidth, f2, getPaint());
                intrinsicWidth += desiredWidth + measuredWidth;
            }
            return;
        }
        canvas.drawText(str, intrinsicWidth, f2, getPaint());
    }

    private final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AlignTextView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr….styleable.AlignTextView)");
        this.a = obtainStyledAttributes.getBoolean(R.styleable.AlignTextView_alignOnlyOneLine, false);
        obtainStyledAttributes.recycle();
        setTextColor(getCurrentTextColor());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        CharSequence text = getText();
        if (!(text instanceof String)) {
            super.onDraw(canvas);
            return;
        }
        int i2 = 0;
        Drawable drawable = getCompoundDrawables()[0];
        int bottom = ((getBottom() - getTop()) - getCompoundPaddingBottom()) - getCompoundPaddingTop();
        if (drawable != null) {
            canvas.save();
            canvas.translate(getScrollX() + getPaddingLeft(), getScrollY() + getCompoundPaddingTop() + ((bottom - drawable.getIntrinsicHeight()) / 2));
            drawable.draw(canvas);
            canvas.restore();
        }
        int lineCount = getLayout().getLineCount();
        while (i2 < lineCount) {
            int i3 = i2 + 1;
            int lineBaseline = getLayout().getLineBaseline(i2) + getPaddingTop();
            int lineStart = getLayout().getLineStart(i2);
            int lineEnd = getLayout().getLineEnd(i2);
            if (this.a && getLayout().getLineCount() == 1) {
                String substring = ((String) text).substring(lineStart, lineEnd);
                s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                b(canvas, substring, lineBaseline, StaticLayout.getDesiredWidth(getText(), lineStart, lineEnd, getPaint()));
            } else if (i2 == getLayout().getLineCount() - 1) {
                String substring2 = ((String) text).substring(lineStart);
                s.g(substring2, "this as java.lang.String).substring(startIndex)");
                canvas.drawText(substring2, drawable.getIntrinsicWidth() + getCompoundDrawablePadding() + getPaddingLeft(), lineBaseline, getPaint());
                return;
            } else {
                String substring3 = ((String) text).substring(lineStart, lineEnd);
                s.g(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                b(canvas, substring3, lineBaseline, StaticLayout.getDesiredWidth(text, lineStart, lineEnd, getPaint()));
            }
            i2 = i3;
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i2) {
        super.setTextColor(i2);
        getPaint().setColor(i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlignTextView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        c(context, attrs);
    }
}
