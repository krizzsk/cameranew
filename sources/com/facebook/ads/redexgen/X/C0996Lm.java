package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Deque;
import java.util.LinkedList;
/* renamed from: com.facebook.ads.redexgen.X.Lm  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0996Lm {
    public static String[] A05 = {"YlFlQWjICGV8ywqag1b6Ay", "5zJBssfwfWeqrXRnFZsUzQPBIx8wM7U1", "dym1tHqC1dmHFSZgnmQvvBCyptXRCFyE", "ReBl50wuVZKzAeHcErw", "r5gi9DkEhDoZU86", "diW2RgJl9ou5SRwuprc", "1r89rpPGUWvit", "BXJhCJIGpStJQsMIN6w6cfyx8EdHGsbw"};
    public final int A01;
    public final int A02;
    public final Deque<String> A04 = new LinkedList();
    public final Deque<String> A03 = new LinkedList();
    @Nullable
    public String A00 = null;

    public C0996Lm(int i2, int i3) {
        this.A02 = i2;
        this.A01 = i3;
    }

    public final Iterable<String> A00() {
        return this.A03;
    }

    public final Iterable<String> A01() {
        return this.A04;
    }

    @Nullable
    public final String A02() {
        return this.A00;
    }

    public final void A03() {
        String str = this.A00;
        if (str != null) {
            this.A04.addLast(str);
            if (this.A04.size() > this.A02) {
                this.A04.removeFirst();
            }
        }
        if (this.A03.size() > 0) {
            this.A00 = this.A03.removeFirst();
        } else if (A05[4].length() == 3) {
            throw new RuntimeException();
        } else {
            String[] strArr = A05;
            strArr[5] = "rBMTTnNnBAlsPJgH9pl";
            strArr[3] = "RhxgQAx1k3YbBH8x5Ji";
            this.A00 = null;
        }
    }

    public final void A04(String str) {
        this.A03.addLast(str);
        if (this.A03.size() <= this.A01) {
            return;
        }
        String str2 = this.A00;
        if (str2 != null) {
            this.A04.addLast(str2);
        }
        this.A00 = this.A03.removeFirst();
        if (this.A04.size() > this.A02) {
            this.A04.removeFirst();
        }
    }
}
