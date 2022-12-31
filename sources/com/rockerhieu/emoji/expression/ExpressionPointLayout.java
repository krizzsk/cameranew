package com.rockerhieu.emoji.expression;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class ExpressionPointLayout extends LinearLayout {
    private Context a;
    private int b;
    private int c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<ExpressionPointView> f7107d;

    public ExpressionPointLayout(Context context) {
        super(context);
        this.b = 10;
        this.c = 3;
        this.f7107d = new ArrayList<>();
        this.a = context;
    }

    public void a(int i2, int i3) {
        if (this.f7107d.size() < i3) {
            int size = i3 - this.f7107d.size();
            for (int i4 = 0; i4 < size; i4++) {
                ExpressionPointView expressionPointView = new ExpressionPointView(this.a);
                int a = a.a(this.a, this.c);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a, a);
                int a2 = a.a(this.a, this.b);
                layoutParams.setMargins(a2, 0, a2, 0);
                addView(expressionPointView, layoutParams);
                this.f7107d.add(expressionPointView);
            }
        }
        for (int i5 = 0; i5 < this.f7107d.size(); i5++) {
            if (i5 < i3) {
                this.f7107d.get(i5).setVisibility(0);
                if (i5 == i2) {
                    this.f7107d.get(i5).setSelected(true);
                } else {
                    this.f7107d.get(i5).setSelected(false);
                }
            } else {
                this.f7107d.get(i5).setVisibility(8);
            }
        }
        invalidate();
        setVisibility(i3 <= 1 ? 8 : 0);
    }

    public ExpressionPointLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 10;
        this.c = 3;
        this.f7107d = new ArrayList<>();
        this.a = context;
    }

    public ExpressionPointLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = 10;
        this.c = 3;
        this.f7107d = new ArrayList<>();
        this.a = context;
    }
}
