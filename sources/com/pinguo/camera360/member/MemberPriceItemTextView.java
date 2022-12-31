package com.pinguo.camera360.member;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.LinkedHashMap;
/* compiled from: MemberPriceItemTextView.kt */
/* loaded from: classes3.dex */
public final class MemberPriceItemTextView extends AppCompatTextView {
    private final int a;
    private float b;
    private float c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPriceItemTextView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = 80;
    }

    public final void b(String str, String str2) {
        this.b = getPaint().measureText(str);
        this.c = getPaint().measureText(str2);
    }

    public final void c(String firstWord, String secondWord, String thirdWord) {
        kotlin.jvm.internal.s.h(firstWord, "firstWord");
        kotlin.jvm.internal.s.h(secondWord, "secondWord");
        kotlin.jvm.internal.s.h(thirdWord, "thirdWord");
        float measureText = getPaint().measureText(firstWord);
        float measureText2 = getPaint().measureText(secondWord);
        float measureText3 = getPaint().measureText(" ");
        int i2 = this.a;
        int i3 = (int) (((i2 + this.b) - measureText) / measureText3);
        int i4 = (int) (((i2 + this.c) - measureText2) / measureText3);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getCurrentTextColor());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(firstWord);
        if (i3 >= 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                spannableStringBuilder.append((CharSequence) " ");
                if (i5 == i3) {
                    break;
                }
                i5 = i6;
            }
        }
        spannableStringBuilder.append((CharSequence) secondWord);
        int length = spannableStringBuilder.length();
        if (i4 >= 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                spannableStringBuilder.append((CharSequence) " ");
                if (i7 == i4) {
                    break;
                }
                i7 = i8;
            }
        }
        spannableStringBuilder.append((CharSequence) thirdWord).setSpan(foregroundColorSpan, 0, firstWord.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFFFC300")), firstWord.length(), length, 33);
        spannableStringBuilder.setSpan(new StrikethroughSpan(), spannableStringBuilder.length() - thirdWord.length(), spannableStringBuilder.length(), 33);
        setText(spannableStringBuilder, TextView.BufferType.EDITABLE);
    }

    public final void setMaxPriceSize(float f2) {
        this.c = f2;
    }

    public final void setMaxTitleSize(float f2) {
        this.b = f2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPriceItemTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = 80;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberPriceItemTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = 80;
    }
}
