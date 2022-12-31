package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Influencer.kt */
/* loaded from: classes9.dex */
public final class Influencer implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String influencerIcon;
    private final String influencerLink;
    private final String influencerText;

    /* compiled from: Influencer.kt */
    /* loaded from: classes9.dex */
    public static final class CREATOR implements Parcelable.Creator<Influencer> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(kotlin.jvm.internal.o oVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public Influencer createFromParcel(Parcel source) {
            kotlin.jvm.internal.s.h(source, "source");
            return new Influencer(source);
        }

        @Override // android.os.Parcelable.Creator
        public Influencer[] newArray(int i2) {
            return new Influencer[i2];
        }
    }

    public Influencer(String influencerIcon, String influencerText, String influencerLink) {
        kotlin.jvm.internal.s.h(influencerIcon, "influencerIcon");
        kotlin.jvm.internal.s.h(influencerText, "influencerText");
        kotlin.jvm.internal.s.h(influencerLink, "influencerLink");
        this.influencerIcon = influencerIcon;
        this.influencerText = influencerText;
        this.influencerLink = influencerLink;
    }

    public static /* synthetic */ Influencer copy$default(Influencer influencer, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = influencer.influencerIcon;
        }
        if ((i2 & 2) != 0) {
            str2 = influencer.influencerText;
        }
        if ((i2 & 4) != 0) {
            str3 = influencer.influencerLink;
        }
        return influencer.copy(str, str2, str3);
    }

    public final String component1() {
        return this.influencerIcon;
    }

    public final String component2() {
        return this.influencerText;
    }

    public final String component3() {
        return this.influencerLink;
    }

    public final Influencer copy(String influencerIcon, String influencerText, String influencerLink) {
        kotlin.jvm.internal.s.h(influencerIcon, "influencerIcon");
        kotlin.jvm.internal.s.h(influencerText, "influencerText");
        kotlin.jvm.internal.s.h(influencerLink, "influencerLink");
        return new Influencer(influencerIcon, influencerText, influencerLink);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Influencer) {
            Influencer influencer = (Influencer) obj;
            return kotlin.jvm.internal.s.c(this.influencerIcon, influencer.influencerIcon) && kotlin.jvm.internal.s.c(this.influencerText, influencer.influencerText) && kotlin.jvm.internal.s.c(this.influencerLink, influencer.influencerLink);
        }
        return false;
    }

    public final String getInfluencerIcon() {
        return this.influencerIcon;
    }

    public final String getInfluencerLink() {
        return this.influencerLink;
    }

    public final String getInfluencerText() {
        return this.influencerText;
    }

    public int hashCode() {
        return (((this.influencerIcon.hashCode() * 31) + this.influencerText.hashCode()) * 31) + this.influencerLink.hashCode();
    }

    public String toString() {
        return "Influencer(influencerIcon=" + this.influencerIcon + ", influencerText=" + this.influencerText + ", influencerLink=" + this.influencerLink + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        kotlin.jvm.internal.s.h(dest, "dest");
        dest.writeString(this.influencerIcon);
        dest.writeString(this.influencerText);
        dest.writeString(this.influencerLink);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Influencer(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.s.h(r4, r0)
            java.lang.String r0 = r4.readString()
            java.lang.String r1 = ""
            if (r0 != 0) goto Le
            r0 = r1
        Le:
            java.lang.String r2 = r4.readString()
            if (r2 != 0) goto L15
            r2 = r1
        L15:
            java.lang.String r4 = r4.readString()
            if (r4 != 0) goto L1c
            goto L1d
        L1c:
            r1 = r4
        L1d:
            r3.<init>(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.model.Influencer.<init>(android.os.Parcel):void");
    }
}
