package us.pinguo.inspire.model;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: Endpage.kt */
/* loaded from: classes9.dex */
public final class Endpage implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final String endpageBanner;
    private final String endpageLink;
    private final String endpageText;

    /* compiled from: Endpage.kt */
    /* loaded from: classes9.dex */
    public static final class CREATOR implements Parcelable.Creator<Endpage> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(kotlin.jvm.internal.o oVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public Endpage createFromParcel(Parcel source) {
            kotlin.jvm.internal.s.h(source, "source");
            return new Endpage(source);
        }

        @Override // android.os.Parcelable.Creator
        public Endpage[] newArray(int i2) {
            return new Endpage[i2];
        }
    }

    public Endpage(String endpageBanner, String endpageText, String endpageLink) {
        kotlin.jvm.internal.s.h(endpageBanner, "endpageBanner");
        kotlin.jvm.internal.s.h(endpageText, "endpageText");
        kotlin.jvm.internal.s.h(endpageLink, "endpageLink");
        this.endpageBanner = endpageBanner;
        this.endpageText = endpageText;
        this.endpageLink = endpageLink;
    }

    public static /* synthetic */ Endpage copy$default(Endpage endpage, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = endpage.endpageBanner;
        }
        if ((i2 & 2) != 0) {
            str2 = endpage.endpageText;
        }
        if ((i2 & 4) != 0) {
            str3 = endpage.endpageLink;
        }
        return endpage.copy(str, str2, str3);
    }

    public final String component1() {
        return this.endpageBanner;
    }

    public final String component2() {
        return this.endpageText;
    }

    public final String component3() {
        return this.endpageLink;
    }

    public final Endpage copy(String endpageBanner, String endpageText, String endpageLink) {
        kotlin.jvm.internal.s.h(endpageBanner, "endpageBanner");
        kotlin.jvm.internal.s.h(endpageText, "endpageText");
        kotlin.jvm.internal.s.h(endpageLink, "endpageLink");
        return new Endpage(endpageBanner, endpageText, endpageLink);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Endpage) {
            Endpage endpage = (Endpage) obj;
            return kotlin.jvm.internal.s.c(this.endpageBanner, endpage.endpageBanner) && kotlin.jvm.internal.s.c(this.endpageText, endpage.endpageText) && kotlin.jvm.internal.s.c(this.endpageLink, endpage.endpageLink);
        }
        return false;
    }

    public final String getEndpageBanner() {
        return this.endpageBanner;
    }

    public final String getEndpageLink() {
        return this.endpageLink;
    }

    public final String getEndpageText() {
        return this.endpageText;
    }

    public int hashCode() {
        return (((this.endpageBanner.hashCode() * 31) + this.endpageText.hashCode()) * 31) + this.endpageLink.hashCode();
    }

    public String toString() {
        return "Endpage(endpageBanner=" + this.endpageBanner + ", endpageText=" + this.endpageText + ", endpageLink=" + this.endpageLink + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i2) {
        kotlin.jvm.internal.s.h(dest, "dest");
        dest.writeString(this.endpageBanner);
        dest.writeString(this.endpageText);
        dest.writeString(this.endpageLink);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Endpage(android.os.Parcel r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.model.Endpage.<init>(android.os.Parcel):void");
    }
}
