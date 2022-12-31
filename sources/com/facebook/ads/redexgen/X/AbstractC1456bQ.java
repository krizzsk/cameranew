package com.facebook.ads.redexgen.X;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* renamed from: com.facebook.ads.redexgen.X.bQ  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public abstract class AbstractC1456bQ extends C4I {
    public static String[] A01 = {"ufm8s7LRmOM7", "sIBwdoM05ajejE", "0NxvrnR7UZDHrBy4xVhLU5lsqzWJ5R3x", "FsILnIqpIa8iE3wffvJrO4tNlZdDmpUd", "wKnqjXSh8f61FKWyknAGi8xlXXoDdiLA", "lpMPMGmveEx5YZPPZgDkriuB4nzdouJK", "fQPzW90JHWOApVaaQbndX59CGXgCnXlm", "Pp9SKBa6RS3IfLIGXA9e4oeVKGHa5CsE"};
    public boolean A00 = true;

    public abstract boolean A0R(AbstractC05784e abstractC05784e);

    public abstract boolean A0S(AbstractC05784e abstractC05784e);

    public abstract boolean A0T(AbstractC05784e abstractC05784e, int i2, int i3, int i4, int i5);

    public abstract boolean A0U(AbstractC05784e abstractC05784e, AbstractC05784e abstractC05784e2, int i2, int i3, int i4, int i5);

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0D(@NonNull AbstractC05784e abstractC05784e) {
        return !this.A00 || abstractC05784e.A0b();
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0E(@NonNull AbstractC05784e abstractC05784e, @Nullable C4H c4h, @NonNull C4H c4h2) {
        if (c4h != null && (c4h.A01 != c4h2.A01 || c4h.A03 != c4h2.A03)) {
            return A0T(abstractC05784e, c4h.A01, c4h.A03, c4h2.A01, c4h2.A03);
        }
        return A0R(abstractC05784e);
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0F(@NonNull AbstractC05784e abstractC05784e, @NonNull C4H c4h, @Nullable C4H c4h2) {
        int i2 = c4h.A01;
        int i3 = c4h.A03;
        View view = abstractC05784e.A0H;
        int left = c4h2 == null ? view.getLeft() : c4h2.A01;
        int newLeft = c4h2 == null ? view.getTop() : c4h2.A03;
        if (!abstractC05784e.A0c() && (i2 != left || i3 != newLeft)) {
            view.layout(left, newLeft, view.getWidth() + left, view.getHeight() + newLeft);
            return A0T(abstractC05784e, i2, i3, left, newLeft);
        }
        return A0S(abstractC05784e);
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0G(@NonNull AbstractC05784e abstractC05784e, @NonNull C4H c4h, @NonNull C4H c4h2) {
        if (c4h.A01 != c4h2.A01 || c4h.A03 != c4h2.A03) {
            return A0T(abstractC05784e, c4h.A01, c4h.A03, c4h2.A01, c4h2.A03);
        }
        A0O(abstractC05784e);
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4I
    public final boolean A0H(@NonNull AbstractC05784e abstractC05784e, @NonNull AbstractC05784e abstractC05784e2, @NonNull C4H c4h, @NonNull C4H c4h2) {
        int fromTop;
        int toLeft;
        int i2 = c4h.A01;
        int i3 = c4h.A03;
        if (abstractC05784e2.A0h()) {
            fromTop = c4h.A01;
            toLeft = c4h.A03;
        } else {
            fromTop = c4h2.A01;
            toLeft = c4h2.A03;
        }
        if (A01[1].length() != 14) {
            throw new RuntimeException();
        }
        A01[1] = "7F8ns227Orjao7";
        return A0U(abstractC05784e, abstractC05784e2, i2, i3, fromTop, toLeft);
    }

    public final void A0N(AbstractC05784e abstractC05784e) {
        A0C(abstractC05784e);
    }

    public final void A0O(AbstractC05784e abstractC05784e) {
        A0C(abstractC05784e);
    }

    public final void A0P(AbstractC05784e abstractC05784e) {
        A0C(abstractC05784e);
    }

    public final void A0Q(AbstractC05784e abstractC05784e, boolean z) {
        A0C(abstractC05784e);
    }
}
