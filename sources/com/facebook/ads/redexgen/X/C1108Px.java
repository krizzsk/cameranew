package com.facebook.ads.redexgen.X;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import java.util.ArrayList;
/* renamed from: com.facebook.ads.redexgen.X.Px  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1108Px extends FrameLayout implements PZ {
    @Nullable
    public TextView A00;
    @Nullable
    public TextView A01;
    @Nullable
    public TextView A02;
    @Nullable
    public TextView A03;
    public final MediaView A04;
    public final NativeAd A05;
    public final C1085Pa A06;
    public final ArrayList<View> A07;
    public static String[] A08 = {"LrUXeZd5oXG5wJ7", "S6ePTdxfK6c7yhvbHMQjZqIgQsLDz3QO", "YqVXoEdDoNpK3nL0El5", "Exhg7LXIw6HgSAmcccR052cOKtX3WF", "LN", "59F20xOEewuTmZzPatOKMeF6XI6ZvB1j", "IRBrDKvf2o0dBHWjf99N02m12yrR0Bg7", "KZ90h8EmVWfLUNKv0pT"};
    public static final int A0E = (int) (LY.A00 * 6.0f);
    public static final int A0D = (int) (LY.A00 * 8.0f);
    public static final int A0C = (int) (LY.A00 * 12.0f);
    public static final int A0A = (int) (LY.A00 * 350.0f);
    public static final int A09 = (int) (LY.A00 * 250.0f);
    public static final int A0B = (int) (LY.A00 * 175.0f);

    public C1108Px(XT xt, NativeAd nativeAd, C0955Jt c0955Jt, EnumC0956Ju enumC0956Ju, OA oa, MediaView mediaView, AdOptionsView adOptionsView) {
        super(xt);
        this.A07 = new ArrayList<>();
        this.A05 = nativeAd;
        this.A04 = mediaView;
        this.A06 = new C1085Pa(xt, this.A05, c0955Jt, oa, adOptionsView);
        C1085Pa c1085Pa = this.A06;
        int i2 = A0C;
        c1085Pa.setPadding(i2, i2, i2, A0E);
        addView(this.A06, new FrameLayout.LayoutParams(-1, -2));
        if (enumC0956Ju == EnumC0956Ju.A09 || enumC0956Ju == EnumC0956Ju.A0B) {
            A07(c0955Jt);
        }
        addView(this.A04, new FrameLayout.LayoutParams(-1, -2));
        if (enumC0956Ju != EnumC0956Ju.A0B || this.A05.getAdCreativeType() != NativeAd.AdCreativeType.CAROUSEL) {
            A06(c0955Jt);
            A04(c0955Jt);
            A05(c0955Jt);
        }
        this.A07.add(oa);
        this.A07.add(mediaView);
    }

    private int A00() {
        int i2;
        int i3;
        int i4;
        TextView textView = this.A03;
        int titleHeight = 0;
        if (textView != null && textView.getVisibility() == 0) {
            i2 = this.A03.getMeasuredHeight();
        } else {
            i2 = 0;
        }
        TextView textView2 = this.A02;
        if (A08[1].charAt(0) != 'k') {
            String[] strArr = A08;
            strArr[6] = "SrhbzBCrZmwJCsE1GN19GBhRpshhKBl4";
            strArr[5] = "lZXGEU0s5y97LRskCQS4IC0Q6rEMlB8o";
            if (textView2 != null && textView2.getVisibility() == 0) {
                i3 = this.A02.getMeasuredHeight();
            } else {
                i3 = 0;
            }
            TextView textView3 = this.A00;
            if (textView3 != null && textView3.getVisibility() == 0) {
                i4 = this.A00.getMeasuredHeight();
            } else {
                i4 = 0;
            }
            TextView textView4 = this.A01;
            if (A08[1].charAt(0) != 'k') {
                String[] strArr2 = A08;
                strArr2[6] = "nRuc5lutSXPKh9f7kKzdW2kIhLu3nB9m";
                strArr2[5] = "FuxAmHJZMOFMUG38wB3yXnFuBZuRMBRE";
                if (textView4 != null) {
                    int subtitleHeight = textView4.getVisibility();
                    if (subtitleHeight == 0) {
                        int titleHeight2 = this.A01.getMeasuredHeight();
                        int subtitleHeight2 = A0C;
                        int titleHeight3 = titleHeight2 + subtitleHeight2;
                        int subtitleHeight3 = A0D;
                        titleHeight = titleHeight3 + subtitleHeight3;
                    }
                }
                int measuredHeight = getMeasuredHeight();
                int ctaHeight = this.A06.getMeasuredHeight();
                return ((((measuredHeight - ctaHeight) - i2) - i3) - i4) - titleHeight;
            }
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }

    private void A01() {
        TextView textView = this.A03;
        if (textView != null) {
            textView.setLines(1);
        }
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.setLines(1);
        }
        TextView textView3 = this.A00;
        if (textView3 != null) {
            textView3.setLines(1);
        }
    }

    private void A02(int i2) {
        M5.A0N(this.A04, i2 > A0B ? 0 : 8);
        M5.A0N(this.A03, i2 > A0A ? 0 : 8);
        M5.A0N(this.A00, i2 <= A09 ? 8 : 0);
    }

    public static void A03(int i2, int i3, TextView... textViewArr) {
        for (TextView textView : textViewArr) {
            if (textView != null && textView.getVisibility() == 0) {
                int A04 = M5.A04(textView, i3);
                textView.setLines(A04 + 1);
                textView.measure(i2, View.MeasureSpec.makeMeasureSpec(textView.getMeasuredHeight() + (textView.getLineHeight() * A04), 1073741824));
                i3 -= textView.getLineHeight() * A04;
            }
        }
    }

    private void A04(C0955Jt c0955Jt) {
        if (this.A05.getAdBodyText() != null && !this.A05.getAdBodyText().trim().isEmpty()) {
            this.A00 = new TextView(getContext());
            c0955Jt.A06(this.A00);
            this.A00.setText(this.A05.getAdBodyText());
            TextView textView = this.A00;
            int i2 = A0C;
            textView.setPadding(i2, 0, i2, 0);
            addView(this.A00, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private void A05(C0955Jt c0955Jt) {
        if (this.A05.hasCallToAction()) {
            this.A01 = new TextView(getContext());
            M5.A0K(this.A01);
            c0955Jt.A05(this.A01);
            this.A01.setText(this.A05.getAdCallToAction());
            TextView textView = this.A01;
            int i2 = A0D;
            textView.setPadding(i2, i2, i2, i2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            int i3 = A0D;
            layoutParams.setMargins(i3, 0, i3, 0);
            addView(this.A01, layoutParams);
            this.A07.add(this.A01);
        }
    }

    private void A06(C0955Jt c0955Jt) {
        if (this.A05.getAdHeadline() != null && !this.A05.getAdHeadline().trim().isEmpty()) {
            this.A02 = new TextView(getContext());
            c0955Jt.A07(this.A02);
            this.A02.setText(this.A05.getAdHeadline());
            TextView textView = this.A02;
            int i2 = A0C;
            textView.setPadding(i2, A0D, i2, 0);
            addView(this.A02, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    private void A07(C0955Jt c0955Jt) {
        if (this.A05.getAdLinkDescription() != null && !this.A05.getAdLinkDescription().trim().isEmpty()) {
            this.A03 = new TextView(getContext());
            c0955Jt.A06(this.A03);
            this.A03.setText(this.A05.getAdLinkDescription());
            TextView textView = this.A03;
            int i2 = A0C;
            textView.setPadding(i2, 0, i2, A0D);
            addView(this.A03, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public View getView() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public ArrayList<View> getViewsForInteraction() {
        return this.A07;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        C1085Pa c1085Pa = this.A06;
        c1085Pa.layout(i2, i3, i4, c1085Pa.getMeasuredHeight() + i3);
        int measuredHeight = i3 + this.A06.getMeasuredHeight();
        TextView textView = this.A03;
        if (textView != null && textView.getVisibility() == 0) {
            int measuredHeight2 = this.A03.getMeasuredHeight();
            this.A03.layout(i2, measuredHeight, i4, measuredHeight + measuredHeight2);
            measuredHeight += measuredHeight2;
        }
        MediaView mediaView = this.A04;
        mediaView.layout(i2, measuredHeight, i4, mediaView.getMeasuredHeight() + measuredHeight);
        int measuredHeight3 = measuredHeight + this.A04.getMeasuredHeight();
        TextView textView2 = this.A02;
        if (textView2 != null) {
            textView2.layout(i2, measuredHeight3, i4, textView2.getMeasuredHeight() + measuredHeight3);
            measuredHeight3 += this.A02.getMeasuredHeight();
        }
        TextView textView3 = this.A00;
        if (textView3 != null && textView3.getVisibility() == 0) {
            TextView textView4 = this.A00;
            if (A08[1].charAt(0) == 'k') {
                throw new RuntimeException();
            }
            A08[3] = "gjv6mmFqHT0";
            textView4.layout(i2, measuredHeight3, i4, textView4.getMeasuredHeight() + measuredHeight3);
        }
        TextView textView5 = this.A01;
        if (textView5 != null) {
            int measuredHeight4 = i5 - textView5.getMeasuredHeight();
            int i6 = A0C;
            textView5.layout(A0C + i2, measuredHeight4 - i6, i4 - i6, i5 - i6);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        A02(View.MeasureSpec.getSize(i3));
        A01();
        super.onMeasure(i2, i3);
        int A00 = A00();
        if (this.A04.getMediaWidth() == 0 || this.A04.getMediaHeight() == 0) {
            i4 = A00;
        } else if (((C1438b8) this.A04.getMediaViewApi()).A0J()) {
            i4 = A00;
        } else {
            i4 = Math.min((int) (this.A04.getMeasuredWidth() * (this.A04.getMediaHeight() / this.A04.getMediaWidth())), A00);
        }
        this.A04.measure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        if (i4 < A00) {
            A03(i2, A00 - i4, this.A02, this.A00, this.A03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.PZ
    public final void unregisterView() {
        this.A05.unregisterView();
    }
}
