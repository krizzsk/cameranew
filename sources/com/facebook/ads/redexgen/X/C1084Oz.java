package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import org.json.JSONObject;
/* renamed from: com.facebook.ads.redexgen.X.Oz  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public class C1084Oz {
    public final String A00;
    public final String A01;
    public final ArrayList<String> A02;
    public final ArrayList<String> A03;
    public final ArrayList<String> A04;
    public final JSONObject A05;
    public final boolean A06;

    public C1084Oz(JSONObject jSONObject, String str, String str2, ArrayList<String> imageUrls, ArrayList<String> videoUrls, ArrayList<String> fileUrls, boolean z) {
        this.A05 = jSONObject;
        this.A01 = str;
        this.A00 = str2;
        this.A03 = imageUrls;
        this.A04 = videoUrls;
        this.A02 = fileUrls;
        this.A06 = z;
    }
}
