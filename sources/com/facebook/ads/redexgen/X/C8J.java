package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.facebook.ads.redexgen.X.8J  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public class C8J extends ContextWrapper {
    public final C8L A00;
    public final AtomicReference<String> A01;

    public C8J(Context context, C8L c8l) {
        super(context.getApplicationContext());
        this.A01 = new AtomicReference<>();
        this.A00 = c8l;
    }

    public final XS A00() {
        return this.A00.A7G(this);
    }

    public final C8K A01() {
        return this.A00.A5n(this);
    }

    public final C8M A02() {
        return this.A00.A6R(this);
    }

    public final C8O A03() {
        return this.A00.A7F(this);
    }

    public final C8P A04() {
        return this.A00.A7W();
    }

    public final C8Y A05() {
        return this.A00.A6H(this);
    }

    public final InterfaceC06798l A06() {
        return this.A00.A6I(this);
    }

    public final C9C A07() {
        return this.A00.A7N();
    }

    public final JT A08() {
        return this.A00.A5Z(A00());
    }

    public final InterfaceC0941Jf A09() {
        return this.A00.A7H(A00());
    }

    @Nullable
    public final String A0A() {
        return this.A01.get();
    }

    public final void A0B(@Nullable String str) {
        this.A01.set(str);
    }
}
