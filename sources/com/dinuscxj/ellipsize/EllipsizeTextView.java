package com.dinuscxj.ellipsize;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class EllipsizeTextView extends TextView {
    private CharSequence a;
    private CharSequence b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f2235d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2236e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2237f;

    /* loaded from: classes9.dex */
    public static final class a<T extends Comparable<? super T>> {
        private final T a;
        private final T b;

        public a(T t, T t2) {
            this.a = t;
            this.b = t2;
            if (t.compareTo(t2) > 0) {
                throw new IllegalArgumentException("lower must be less than or equal to upper");
            }
        }

        public boolean a(T t) {
            return (t.compareTo(this.a) >= 0) && (t.compareTo(this.b) < 0);
        }

        public T b() {
            return this.a;
        }
    }

    public EllipsizeTextView(Context context) {
        this(context, null);
    }

    private void a(Layout layout) {
        CharSequence charSequence = this.b;
        CharSequence subSequence = charSequence.subSequence(charSequence.length() - this.c, charSequence.length());
        int width = (layout.getWidth() - getPaddingLeft()) - getPaddingRight();
        int max = Math.max(1, d(layout)) - 1;
        int lineEnd = layout.getLineEnd(max);
        this.f2237f = false;
        int lineWidth = ((int) layout.getLineWidth(max)) + ((int) (Layout.getDesiredWidth(this.a, getPaint()) + Layout.getDesiredWidth(subSequence, getPaint()))) + 1;
        if (lineWidth > width) {
            setText(charSequence.subSequence(0, lineEnd - e(lineWidth - width, charSequence.subSequence(0, lineEnd))));
            append(this.a);
            append(subSequence);
        } else {
            setText(charSequence.subSequence(0, lineEnd));
            append(this.a);
            append(subSequence);
        }
        this.f2237f = true;
    }

    private a<Integer> b(List<a<Integer>> list, int i2) {
        if (list != null && !list.isEmpty()) {
            for (a<Integer> aVar : list) {
                if (aVar.a(Integer.valueOf(i2))) {
                    return aVar;
                }
            }
        }
        return null;
    }

    private List<a<Integer>> c(CharSequence charSequence) {
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(charSequence);
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) valueOf.getSpans(0, valueOf.length(), CharacterStyle.class);
        if (characterStyleArr != null && characterStyleArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (CharacterStyle characterStyle : characterStyleArr) {
                arrayList.add(new a(Integer.valueOf(valueOf.getSpanStart(characterStyle)), Integer.valueOf(valueOf.getSpanEnd(characterStyle))));
            }
            return arrayList;
        }
        return Collections.EMPTY_LIST;
    }

    private int d(Layout layout) {
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i2 = 0; i2 < layout.getLineCount(); i2++) {
            if (measuredHeight < layout.getLineBottom(i2)) {
                return i2;
            }
        }
        return layout.getLineCount();
    }

    private int e(int i2, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        List<a<Integer>> c = c(charSequence);
        String charSequence2 = charSequence.toString();
        charSequence.length();
        int codePointCount = charSequence2.codePointCount(0, charSequence.length());
        int i3 = 0;
        while (codePointCount > 0 && i2 > i3) {
            codePointCount--;
            int offsetByCodePoints = charSequence2.offsetByCodePoints(0, codePointCount);
            a<Integer> b = b(c, offsetByCodePoints);
            if (b != null) {
                offsetByCodePoints = b.b().intValue();
                codePointCount = charSequence2.codePointCount(0, offsetByCodePoints);
            }
            i3 = (int) Layout.getDesiredWidth(charSequence.subSequence(offsetByCodePoints, charSequence.length()), getPaint());
        }
        return charSequence.length() - charSequence2.offsetByCodePoints(0, codePointCount);
    }

    private boolean f(Layout layout) {
        int lineCount = layout.getLineCount();
        int i2 = this.f2235d;
        return lineCount > i2 && i2 > 0;
    }

    private boolean g(Layout layout) {
        return layout.getHeight() > (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        setText(this.b);
        super.onMeasure(i2, i3);
        try {
            this.f2236e = View.MeasureSpec.getMode(i2) == 1073741824;
            Layout layout = getLayout();
            if (layout != null) {
                if (f(layout) || g(layout)) {
                    a(layout);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setEllipsizeText(CharSequence charSequence, int i2) {
        this.a = charSequence;
        this.c = i2;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i2) {
        if (this.f2235d != i2) {
            super.setMaxLines(i2);
            this.f2235d = i2;
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f2237f) {
            this.b = charSequence;
        }
        super.setText(charSequence, bufferType);
        if (this.f2236e) {
            requestLayout();
        }
    }

    public EllipsizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2237f = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EllipsizeTextView);
        this.c = obtainStyledAttributes.getInt(R.styleable.EllipsizeTextView_ellipsize_index, 0);
        CharSequence text = obtainStyledAttributes.getText(R.styleable.EllipsizeTextView_ellipsize_text);
        this.a = text;
        if (text == null) {
            this.a = "...";
        }
        obtainStyledAttributes.recycle();
    }
}
