package com.pinguo.camera360.member;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import java.util.LinkedHashMap;
import vStudio.Android.Camera360.R;
/* compiled from: TwoLineTextView.kt */
/* loaded from: classes3.dex */
public final class TwoLineTextView extends AppCompatTextView {
    private int a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private int f6917d;

    /* renamed from: e  reason: collision with root package name */
    private String f6918e;

    /* renamed from: f  reason: collision with root package name */
    private String f6919f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6920g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6921h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoLineTextView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f6917d = ViewCompat.MEASURED_STATE_MASK;
    }

    public final int b(float f2) {
        return (int) ((f2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public final String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        kotlin.jvm.internal.s.e(str);
        return str;
    }

    public final void setFirstLineText(String text) {
        kotlin.jvm.internal.s.h(text, "text");
        String str = this.f6919f;
        kotlin.jvm.internal.s.e(str);
        setTwoLinesText(text, str);
    }

    public final void setMFirstLineText(String str) {
        this.f6918e = str;
    }

    public final void setMFirstLineTextBold(boolean z) {
        this.f6920g = z;
    }

    public final void setMFirstLineTextColor(int i2) {
        this.c = i2;
    }

    public final void setMFirstLineTextSize(int i2) {
        this.a = i2;
    }

    public final void setMSecondLineText(String str) {
        this.f6919f = str;
    }

    public final void setMSecondLineTextBold(boolean z) {
        this.f6921h = z;
    }

    public final void setMSecondLineTextColor(int i2) {
        this.f6917d = i2;
    }

    public final void setMSecondLineTextSize(int i2) {
        this.b = i2;
    }

    public final void setSecondLineText(String text) {
        kotlin.jvm.internal.s.h(text, "text");
        String str = this.f6918e;
        kotlin.jvm.internal.s.e(str);
        setTwoLinesText(str, text);
    }

    public final void setTwoLinesText(String str, String str2) {
        this.f6918e = str;
        this.f6919f = str2;
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.f6918e);
        sb.append('\n');
        sb.append((Object) this.f6919f);
        String sb2 = sb.toString();
        SpannableString spannableString = new SpannableString(sb2);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.a);
        String str3 = this.f6918e;
        kotlin.jvm.internal.s.e(str3);
        spannableString.setSpan(absoluteSizeSpan, 0, str3.length(), 33);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.c);
        String str4 = this.f6918e;
        kotlin.jvm.internal.s.e(str4);
        spannableString.setSpan(foregroundColorSpan, 0, str4.length(), 33);
        if (this.f6920g) {
            StyleSpan styleSpan = new StyleSpan(1);
            String str5 = this.f6918e;
            kotlin.jvm.internal.s.e(str5);
            spannableString.setSpan(styleSpan, 0, str5.length(), 33);
        }
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(this.b);
        String str6 = this.f6918e;
        kotlin.jvm.internal.s.e(str6);
        spannableString.setSpan(absoluteSizeSpan2, str6.length(), sb2.length(), 33);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(this.f6917d);
        String str7 = this.f6918e;
        kotlin.jvm.internal.s.e(str7);
        spannableString.setSpan(foregroundColorSpan2, str7.length(), sb2.length(), 33);
        if (this.f6921h) {
            StyleSpan styleSpan2 = new StyleSpan(1);
            String str8 = this.f6918e;
            kotlin.jvm.internal.s.e(str8);
            spannableString.setSpan(styleSpan2, str8.length(), sb2.length(), 33);
        }
        setText(spannableString);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f6917d = ViewCompat.MEASURED_STATE_MASK;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLineTextView, 0, 0);
        kotlin.jvm.internal.s.g(obtainStyledAttributes, "context.obtainStyledAttr…le.TwoLineTextView, 0, 0)");
        this.a = obtainStyledAttributes.getDimensionPixelSize(2, b(14.0f));
        this.b = obtainStyledAttributes.getDimensionPixelSize(6, b(14.0f));
        this.c = obtainStyledAttributes.getColor(1, ViewCompat.MEASURED_STATE_MASK);
        this.f6917d = obtainStyledAttributes.getColor(5, ViewCompat.MEASURED_STATE_MASK);
        this.f6918e = obtainStyledAttributes.getString(3);
        this.f6919f = obtainStyledAttributes.getString(7);
        this.f6920g = obtainStyledAttributes.getBoolean(0, false);
        this.f6921h = obtainStyledAttributes.getBoolean(4, false);
        setTwoLinesText(c(this.f6918e), c(this.f6919f));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoLineTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.c = ViewCompat.MEASURED_STATE_MASK;
        this.f6917d = ViewCompat.MEASURED_STATE_MASK;
    }
}
