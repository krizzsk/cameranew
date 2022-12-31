package com.rockerhieu.emoji.expression;

import android.content.res.Resources;
import android.util.Pair;
import com.rockerhieu.emoji.R;
/* loaded from: classes9.dex */
public class FaceSize {
    public int a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f7109d;

    /* renamed from: e  reason: collision with root package name */
    public int f7110e;

    /* renamed from: f  reason: collision with root package name */
    public int f7111f;

    /* renamed from: g  reason: collision with root package name */
    public int f7112g;

    /* renamed from: h  reason: collision with root package name */
    public int f7113h;

    /* renamed from: i  reason: collision with root package name */
    public int f7114i;

    /* renamed from: j  reason: collision with root package name */
    public int f7115j;

    /* renamed from: k  reason: collision with root package name */
    public int f7116k;

    /* renamed from: l  reason: collision with root package name */
    private Strategy f7117l;
    private Strategy m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum Strategy {
        COLUMN_ROW_CHANGE,
        DIVIDER_DIVIDE_EQUALLY
    }

    public FaceSize(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, Strategy strategy, Strategy strategy2) {
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.f7110e = i5;
        this.f7109d = i6;
        this.f7115j = i7;
        this.f7113h = i8;
        this.f7116k = i9;
        this.f7114i = i10;
        this.f7117l = strategy;
        this.m = strategy2;
    }

    private int a(int i2, int i3, int i4, Strategy strategy) {
        if (i2 <= 1) {
            return 0;
        }
        return (i4 - (i3 * i2)) / (strategy == Strategy.DIVIDER_DIVIDE_EQUALLY ? i2 + 1 : i2 - 1);
    }

    private Pair<Integer, Integer> b(int i2, int i3, int i4, Strategy strategy) {
        if (strategy == Strategy.COLUMN_ROW_CHANGE) {
            return c(i2, i3, i4);
        }
        return d(i2, i3, i4);
    }

    private Pair<Integer, Integer> c(int i2, int i3, int i4) {
        Strategy strategy;
        int a;
        int i5;
        int a2 = a(i2, i3, i4, Strategy.COLUMN_ROW_CHANGE);
        int i6 = this.f7110e;
        if (a2 > i6 && a2 < this.f7109d) {
            return new Pair<>(Integer.valueOf(a2), Integer.valueOf(i2));
        }
        if (a2 >= i6) {
            do {
                i2++;
                strategy = Strategy.COLUMN_ROW_CHANGE;
                a = a(i2, i3, i4, strategy);
                i5 = this.f7110e;
                if (a > i5 && a < this.f7109d) {
                    return new Pair<>(Integer.valueOf(a), Integer.valueOf(i2));
                }
            } while (a >= i5);
            int i7 = i2 - 1;
            return new Pair<>(Integer.valueOf(a(i7, i3, i4, strategy)), Integer.valueOf(i7));
        }
        while (true) {
            int i8 = i2 - 1;
            if (i2 > 0) {
                int a3 = a(i8, i3, i4, Strategy.COLUMN_ROW_CHANGE);
                if (a3 > this.f7110e && a3 < this.f7109d) {
                    return new Pair<>(Integer.valueOf(a3), Integer.valueOf(i8));
                }
                i2 = i8;
            } else {
                return new Pair<>(Integer.valueOf(a(1, i3, i4, Strategy.COLUMN_ROW_CHANGE)), 1);
            }
        }
    }

    private Pair<Integer, Integer> d(int i2, int i3, int i4) {
        int a = a(i2, i3, i4, Strategy.DIVIDER_DIVIDE_EQUALLY);
        int i5 = this.f7110e;
        if (a > i5 && a < this.f7109d) {
            return new Pair<>(Integer.valueOf(a), Integer.valueOf(i2));
        }
        if (a >= i5) {
            return new Pair<>(Integer.valueOf((i4 - (i3 * i2)) / (i2 + 1)), Integer.valueOf(i2));
        }
        while (true) {
            int i6 = i2 - 1;
            if (i2 > 0) {
                int a2 = a(i6, i3, i4, Strategy.DIVIDER_DIVIDE_EQUALLY);
                if (a2 > this.f7110e && a2 < this.f7109d) {
                    return new Pair<>(Integer.valueOf(a2), Integer.valueOf(i6));
                }
                i2 = i6;
            } else {
                return new Pair<>(Integer.valueOf(a(1, i3, i4, Strategy.DIVIDER_DIVIDE_EQUALLY)), 1);
            }
        }
    }

    public static FaceSize f(Resources resources) {
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.big_expression_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.min_space_size);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.max_space_size);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.big_expression_top_padding);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.big_expression_bottom_padding);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.expression_lr_padding);
        Strategy strategy = Strategy.DIVIDER_DIVIDE_EQUALLY;
        return new FaceSize(dimensionPixelSize, 2, 4, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize6, dimensionPixelSize4, dimensionPixelSize6, dimensionPixelSize5, strategy, strategy);
    }

    public static FaceSize g(Resources resources) {
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.emoji_expression_size);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.min_space_size);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.max_space_size);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.emoji_top_padding);
        int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.emoji_bottom_padding);
        int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.expression_lr_padding);
        Strategy strategy = Strategy.DIVIDER_DIVIDE_EQUALLY;
        return new FaceSize(dimensionPixelSize, 3, 7, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize6, dimensionPixelSize4, dimensionPixelSize6, dimensionPixelSize5, strategy, strategy);
    }

    public void e(int i2, int i3) {
        Strategy strategy = this.m;
        Strategy strategy2 = Strategy.COLUMN_ROW_CHANGE;
        if (strategy == strategy2) {
            i2 = (i2 - this.f7115j) - this.f7116k;
        }
        Pair<Integer, Integer> b = b(this.c, this.a, i2, strategy);
        this.f7111f = ((Integer) b.first).intValue();
        this.c = ((Integer) b.second).intValue();
        Strategy strategy3 = this.m;
        Strategy strategy4 = Strategy.DIVIDER_DIVIDE_EQUALLY;
        if (strategy3 == strategy4) {
            int i4 = this.f7111f;
            this.f7116k = i4;
            this.f7115j = i4;
        }
        Strategy strategy5 = this.f7117l;
        if (strategy5 == strategy2) {
            i3 = (i3 - this.f7113h) - this.f7114i;
        }
        Pair<Integer, Integer> b2 = b(this.b, this.a, i3, strategy5);
        this.f7112g = ((Integer) b2.first).intValue();
        this.b = ((Integer) b2.second).intValue();
        if (this.f7117l == strategy4) {
            int i5 = this.f7112g;
            this.f7114i = i5;
            this.f7113h = i5;
        }
    }
}
