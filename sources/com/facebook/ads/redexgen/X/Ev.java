package com.facebook.ads.redexgen.X;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class Ev extends AbstractC1456bQ {
    public static TimeInterpolator A0B;
    public static String[] A0C = {"K3xavpXOVVnTPS8V8FmisIpuez1NdmFn", "QjoCrUVtXYT15qNhmppxWCsnlOvXMRWn", "HVYav4KnfeU3lAWSFDiSVAYelCZD7hW1", "SKhwmHHGUoQzTLK2kw5WKB1efbL3jYLm", "aZpNXGptJoOcjVlsPlgA0RFw1bcc4fI1", "y8DDj9eTKGlZyxtiH83YwnquX80t2qUq", "Eqht3urb", "PkOCx2w9GPXTa0iGANdHxOJetOGxrMw0"};
    public ArrayList<AbstractC05784e> A0A = new ArrayList<>();
    public ArrayList<AbstractC05784e> A07 = new ArrayList<>();
    public ArrayList<C05683u> A09 = new ArrayList<>();
    public ArrayList<C05673t> A08 = new ArrayList<>();
    public ArrayList<ArrayList<AbstractC05784e>> A01 = new ArrayList<>();
    public ArrayList<ArrayList<C05683u>> A05 = new ArrayList<>();
    public ArrayList<ArrayList<C05673t>> A03 = new ArrayList<>();
    public ArrayList<AbstractC05784e> A00 = new ArrayList<>();
    public ArrayList<AbstractC05784e> A04 = new ArrayList<>();
    public ArrayList<AbstractC05784e> A06 = new ArrayList<>();
    public ArrayList<AbstractC05784e> A02 = new ArrayList<>();

    private void A01(C05673t c05673t) {
        if (c05673t.A05 != null) {
            A07(c05673t, c05673t.A05);
        }
        if (c05673t.A04 != null) {
            A07(c05673t, c05673t.A04);
        }
    }

    private void A03(final AbstractC05784e abstractC05784e) {
        final View view = abstractC05784e.A0H;
        final ViewPropertyAnimator animate = view.animate();
        this.A06.add(abstractC05784e);
        animate.setDuration(A07()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3o
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                view.setAlpha(1.0f);
                Ev.this.A0P(abstractC05784e);
                Ev.this.A06.remove(abstractC05784e);
                Ev.this.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    private void A04(AbstractC05784e abstractC05784e) {
        if (A0B == null) {
            A0B = new ValueAnimator().getInterpolator();
        }
        abstractC05784e.A0H.animate().setInterpolator(A0B);
        A0K(abstractC05784e);
    }

    private final void A05(List<AbstractC05784e> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).A0H.animate().cancel();
        }
    }

    private void A06(List<C05673t> list, AbstractC05784e abstractC05784e) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C05673t c05673t = list.get(size);
            if (A07(c05673t, abstractC05784e) && c05673t.A05 == null && c05673t.A04 == null) {
                list.remove(c05673t);
            }
        }
    }

    private boolean A07(C05673t c05673t, AbstractC05784e abstractC05784e) {
        boolean z = false;
        if (c05673t.A04 == abstractC05784e) {
            c05673t.A04 = null;
        } else if (c05673t.A05 == abstractC05784e) {
            c05673t.A05 = null;
            z = true;
        } else {
            return false;
        }
        abstractC05784e.A0H.setAlpha(1.0f);
        abstractC05784e.A0H.setTranslationX(0.0f);
        abstractC05784e.A0H.setTranslationY(0.0f);
        A0Q(abstractC05784e, z);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final void A0I() {
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            C05683u c05683u = this.A09.get(size);
            View view = c05683u.A04.A0H;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            A0O(c05683u.A04);
            this.A09.remove(size);
        }
        for (int size2 = this.A0A.size() - 1; size2 >= 0; size2--) {
            A0P(this.A0A.get(size2));
            this.A0A.remove(size2);
        }
        for (int size3 = this.A07.size() - 1; size3 >= 0; size3--) {
            AbstractC05784e abstractC05784e = this.A07.get(size3);
            abstractC05784e.A0H.setAlpha(1.0f);
            A0N(abstractC05784e);
            this.A07.remove(size3);
        }
        for (int size4 = this.A08.size() - 1; size4 >= 0; size4--) {
            A01(this.A08.get(size4));
        }
        this.A08.clear();
        if (!A0L()) {
            return;
        }
        int listCount = this.A05.size();
        for (int i2 = listCount - 1; i2 >= 0; i2--) {
            ArrayList<C05683u> arrayList = this.A05.get(i2);
            int listCount2 = arrayList.size();
            for (int i3 = listCount2 - 1; i3 >= 0; i3--) {
                C05683u moveInfo = arrayList.get(i3);
                View view2 = moveInfo.A04.A0H;
                view2.setTranslationY(0.0f);
                view2.setTranslationX(0.0f);
                A0O(moveInfo.A04);
                arrayList.remove(i3);
                if (arrayList.isEmpty()) {
                    this.A05.remove(arrayList);
                }
            }
        }
        for (int size5 = this.A01.size() - 1; size5 >= 0; size5--) {
            ArrayList<AbstractC05784e> arrayList2 = this.A01.get(size5);
            int i4 = arrayList2.size();
            for (int i5 = i4 - 1; i5 >= 0; i5--) {
                AbstractC05784e item = arrayList2.get(i5);
                item.A0H.setAlpha(1.0f);
                A0N(item);
                arrayList2.remove(i5);
                if (arrayList2.isEmpty()) {
                    this.A01.remove(arrayList2);
                }
            }
        }
        for (int size6 = this.A03.size() - 1; size6 >= 0; size6--) {
            ArrayList<C05673t> arrayList3 = this.A03.get(size6);
            int j2 = arrayList3.size();
            for (int i6 = j2 - 1; i6 >= 0; i6--) {
                A01(arrayList3.get(i6));
                if (arrayList3.isEmpty()) {
                    this.A03.remove(arrayList3);
                }
            }
        }
        A05(this.A06);
        A05(this.A04);
        A05(this.A00);
        A05(this.A02);
        A0A();
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0033 */
    @Override // com.facebook.ads.redexgen.X.C4I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A0J() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Ev.A0J():void");
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final void A0K(AbstractC05784e abstractC05784e) {
        View view = abstractC05784e.A0H;
        view.animate().cancel();
        for (int size = this.A09.size() - 1; size >= 0; size--) {
            C05683u moveInfo = this.A09.get(size);
            if (moveInfo.A04 == abstractC05784e) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                A0O(abstractC05784e);
                this.A09.remove(size);
            }
        }
        A06(this.A08, abstractC05784e);
        if (this.A0A.remove(abstractC05784e)) {
            view.setAlpha(1.0f);
            A0P(abstractC05784e);
        }
        if (this.A07.remove(abstractC05784e)) {
            view.setAlpha(1.0f);
            A0N(abstractC05784e);
        }
        for (int size2 = this.A03.size() - 1; size2 >= 0; size2--) {
            ArrayList<C05673t> arrayList = this.A03.get(size2);
            A06(arrayList, abstractC05784e);
            if (arrayList.isEmpty()) {
                this.A03.remove(size2);
            }
        }
        for (int size3 = this.A05.size() - 1; size3 >= 0; size3--) {
            ArrayList<C05683u> arrayList2 = this.A05.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).A04 == abstractC05784e) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    String[] strArr = A0C;
                    String str = strArr[4];
                    String str2 = strArr[3];
                    int charAt = str.charAt(9);
                    int j2 = str2.charAt(9);
                    if (charAt != j2) {
                        throw new RuntimeException();
                    }
                    A0C[1] = "ZnQkkSK02m4qlFQsfXGc8k1uWyp7aRL1";
                    A0O(abstractC05784e);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.A05.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        int size5 = this.A01.size();
        if (A0C[0].charAt(3) == 'S') {
            throw new RuntimeException();
        }
        A0C[7] = "NHib0yCpDtVNZGbvtAXjIsv6RzrfBwwf";
        for (int i2 = size5 - 1; i2 >= 0; i2--) {
            ArrayList<AbstractC05784e> arrayList3 = this.A01.get(i2);
            if (arrayList3.remove(abstractC05784e)) {
                view.setAlpha(1.0f);
                A0N(abstractC05784e);
                if (arrayList3.isEmpty()) {
                    this.A01.remove(i2);
                }
            }
        }
        this.A06.remove(abstractC05784e);
        this.A00.remove(abstractC05784e);
        this.A02.remove(abstractC05784e);
        this.A04.remove(abstractC05784e);
        A0V();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0071, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (r4.A02.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
        if (r4.A05.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
        if (r4.A01.isEmpty() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        r3 = r4.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (com.facebook.ads.redexgen.X.Ev.A0C[7].charAt(30) == 'w') goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a1, code lost:
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ab, code lost:
        com.facebook.ads.redexgen.X.Ev.A0C[7] = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK";
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b6, code lost:
        if (r3.isEmpty() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
        return false;
     */
    @Override // com.facebook.ads.redexgen.X.C4I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A0L() {
        /*
            r4 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A07
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.3t> r0 = r4.A08
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.3u> r0 = r4.A09
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A0A
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A04
            boolean r3 = r0.isEmpty()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Ev.A0C
            r0 = 2
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La5
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Ev.A0C
            java.lang.String r1 = "HATKbuX1ioRbKjbJza4uRkbMkwnilInw"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "55W5G9gSwoJRpeM2nuMk9rdzPBhIsXI5"
            r0 = 3
            r2[r0] = r1
            if (r3 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A06
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A00
            boolean r3 = r0.isEmpty()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Ev.A0C
            r0 = 2
            r1 = r2[r0]
            r0 = 5
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La2
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Ev.A0C
            java.lang.String r1 = "PBqWGImhwZdo7IXQpaNFK9QlBHxMp4wk"
            r0 = 7
            r2[r0] = r1
            if (r3 == 0) goto Lb8
        L73:
            java.util.ArrayList<com.facebook.ads.redexgen.X.4e> r0 = r4.A02
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.3u>> r0 = r4.A05
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.4e>> r0 = r4.A01
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lb8
            java.util.ArrayList<java.util.ArrayList<com.facebook.ads.redexgen.X.3t>> r3 = r4.A03
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.Ev.A0C
            r0 = 7
            r1 = r1[r0]
            r0 = 30
            char r1 = r1.charAt(r0)
            r0 = 119(0x77, float:1.67E-43)
            if (r1 == r0) goto Lab
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        La2:
            if (r3 == 0) goto Lb8
            goto L73
        La5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        Lab:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.Ev.A0C
            java.lang.String r1 = "80rjjAfjuSoUPBYOWBOUrC4mhnJBtDwK"
            r0 = 7
            r2[r0] = r1
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Lba
        Lb8:
            r0 = 1
        Lb9:
            return r0
        Lba:
            r0 = 0
            goto Lb9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.Ev.A0L():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0M(@NonNull AbstractC05784e abstractC05784e, @NonNull List<Object> list) {
        return !list.isEmpty() || super.A0M(abstractC05784e, list);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1456bQ
    public final boolean A0R(AbstractC05784e abstractC05784e) {
        A04(abstractC05784e);
        abstractC05784e.A0H.setAlpha(0.0f);
        this.A07.add(abstractC05784e);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1456bQ
    public final boolean A0S(AbstractC05784e abstractC05784e) {
        A04(abstractC05784e);
        this.A0A.add(abstractC05784e);
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1456bQ
    public final boolean A0T(AbstractC05784e abstractC05784e, int i2, int i3, int i4, int i5) {
        View view = abstractC05784e.A0H;
        int deltaY = i2 + ((int) abstractC05784e.A0H.getTranslationX());
        int fromX = (int) abstractC05784e.A0H.getTranslationY();
        int i6 = i3 + fromX;
        A04(abstractC05784e);
        int fromY = i4 - deltaY;
        int i7 = i5 - i6;
        if (fromY == 0 && i7 == 0) {
            A0O(abstractC05784e);
            return false;
        }
        if (fromY != 0) {
            int deltaX = -fromY;
            view.setTranslationX(deltaX);
        }
        if (i7 != 0) {
            int deltaX2 = -i7;
            view.setTranslationY(deltaX2);
        }
        this.A09.add(new C05683u(abstractC05784e, deltaY, i6, i4, i5));
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1456bQ
    public final boolean A0U(AbstractC05784e abstractC05784e, AbstractC05784e abstractC05784e2, int deltaX, int deltaY, int i2, int i3) {
        if (abstractC05784e == abstractC05784e2) {
            return A0T(abstractC05784e, deltaX, deltaY, i2, i3);
        }
        float translationX = abstractC05784e.A0H.getTranslationX();
        float translationY = abstractC05784e.A0H.getTranslationY();
        float alpha = abstractC05784e.A0H.getAlpha();
        A04(abstractC05784e);
        int i4 = (int) ((i2 - deltaX) - translationX);
        int i5 = (int) ((i3 - deltaY) - translationY);
        abstractC05784e.A0H.setTranslationX(translationX);
        abstractC05784e.A0H.setTranslationY(translationY);
        abstractC05784e.A0H.setAlpha(alpha);
        if (abstractC05784e2 != null) {
            A04(abstractC05784e2);
            abstractC05784e2.A0H.setTranslationX(-i4);
            abstractC05784e2.A0H.setTranslationY(-i5);
            abstractC05784e2.A0H.setAlpha(0.0f);
        }
        this.A08.add(new C05673t(abstractC05784e, abstractC05784e2, deltaX, deltaY, i2, i3));
        return true;
    }

    public final void A0V() {
        if (!A0L()) {
            A0A();
        }
    }

    public final void A0W(final C05673t c05673t) {
        final View view;
        AbstractC05784e abstractC05784e = c05673t.A05;
        if (abstractC05784e == null) {
            view = null;
        } else {
            view = abstractC05784e.A0H;
        }
        AbstractC05784e abstractC05784e2 = c05673t.A04;
        final View view2 = abstractC05784e2 != null ? abstractC05784e2.A0H : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(A05());
            this.A02.add(c05673t.A05);
            duration.translationX(c05673t.A02 - c05673t.A00);
            duration.translationY(c05673t.A03 - c05673t.A01);
            ViewPropertyAnimator oldViewAnim = duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3r
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    Ev.this.A0Q(c05673t.A05, true);
                    Ev.this.A02.remove(c05673t.A05);
                    Ev.this.A0V();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            });
            oldViewAnim.start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator animate = view2.animate();
            this.A02.add(c05673t.A04);
            ViewPropertyAnimator newViewAnimation = animate.translationX(0.0f);
            newViewAnimation.translationY(0.0f).setDuration(A05()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3s
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    animate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    Ev.this.A0Q(c05673t.A04, false);
                    Ev.this.A02.remove(c05673t.A04);
                    Ev.this.A0V();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationStart(Animator animator) {
                }
            }).start();
        }
    }

    public final void A0X(final AbstractC05784e abstractC05784e) {
        final View view = abstractC05784e.A0H;
        final ViewPropertyAnimator animate = view.animate();
        this.A00.add(abstractC05784e);
        animate.alpha(1.0f).setDuration(A04()).setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3p
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                Ev.this.A0N(abstractC05784e);
                Ev.this.A00.remove(abstractC05784e);
                Ev.this.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }

    public final void A0Y(final AbstractC05784e abstractC05784e, int i2, int i3, int i4, int deltaX) {
        final View view = abstractC05784e.A0H;
        final int i5 = i4 - i2;
        final int deltaX2 = deltaX - i3;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (deltaX2 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.A04.add(abstractC05784e);
        ViewPropertyAnimator animation = animate.setDuration(A06());
        animation.setListener(new AnimatorListenerAdapter() { // from class: com.facebook.ads.redexgen.X.3q
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (deltaX2 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                animate.setListener(null);
                Ev.this.A0O(abstractC05784e);
                Ev.this.A04.remove(abstractC05784e);
                Ev.this.A0V();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        }).start();
    }
}
