package com.facebook.ads.redexgen.X;
/* loaded from: assets/audience_network.dex */
public final class IC {
    public static String[] A01 = {"ai2EfOriaTIhqtzLWYXlPleIkpLxWtX3", "8POqEzQt", "C9XS0tRq", "", "AAxD7MG0VtZMRL4EoelO07EezWtzxWUG", "", "6PKYsgscuQ75gJwNEilmQ2c4nRmBzCem", "CYsAdFFV2DQ1VCBuBS7UZ1OMxmR8"};
    public boolean A00;

    public final synchronized void A00() throws InterruptedException {
        while (!this.A00) {
            wait();
        }
    }

    public final synchronized boolean A01() {
        boolean z;
        z = this.A00;
        this.A00 = false;
        return z;
    }

    public final synchronized boolean A02() {
        if (!this.A00) {
            this.A00 = true;
            notifyAll();
            return true;
        }
        String[] strArr = A01;
        if (strArr[2].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "6xVrNnWg";
        strArr2[1] = "bGYw6WXz";
        return false;
    }
}
