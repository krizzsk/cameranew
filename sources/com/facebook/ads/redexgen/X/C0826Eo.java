package com.facebook.ads.redexgen.X;
/* renamed from: com.facebook.ads.redexgen.X.Eo  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C0826Eo extends C1451bL {
    public static String[] A00 = {"ebBTtcDfrXbt7XUNv2xXXzukgR", "AfSrg72OINfokWlk8lEehE43rER54C5K", "DLWRAT6zkYb5ZQ4lVerhsjeXnJdmq546", "HcA6UXt4lgXnqoCqWVxSHZRcl", "xLJGdEWbtHtgosfXVcR1IwW", "KlZdBiYd7CYsgOQcQxjIKqODuE8wujbn", "gwTEk6Fa0GjLNEZ2sqovA8E7SRT86ppt", "mobLesdsIst7Z6gfBQK3QOgi9WAmLStS"};

    public C0826Eo(AnonymousClass52 anonymousClass52) {
        super(anonymousClass52);
    }

    @Override // com.facebook.ads.redexgen.X.C1451bL, com.facebook.ads.redexgen.X.MU
    public final void A3q(String rewardedVideoError) {
        if (this.A00.get() == null) {
            return;
        }
        AnonymousClass52 anonymousClass52 = this.A00.get();
        if (A00[1].charAt(12) != 'k') {
            throw new RuntimeException();
        }
        A00[0] = "wcnlDkVPCotGmNFV8gEH10X6";
        anonymousClass52.A0D(rewardedVideoError);
        String A02 = EnumC1097Pm.A08.A02();
        String A022 = EnumC1097Pm.A09.A02();
        if (rewardedVideoError.equals(A02)) {
            this.A00.get().finish(11);
        } else if (rewardedVideoError.equals(A022)) {
            this.A00.get().finish(12);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1451bL, com.facebook.ads.redexgen.X.MU
    public final void A3r(String str, C9N c9n) {
        super.A3r(str, c9n);
    }
}
