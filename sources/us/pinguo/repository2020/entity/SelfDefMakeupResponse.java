package us.pinguo.repository2020.entity;

import java.util.ArrayList;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: SelfDefMakeupResponse.kt */
/* loaded from: classes6.dex */
public final class SelfDefMakeupResponse implements NoProguard {
    private final ArrayList<MaterialColor> colors;
    private final Integer interval;
    private final String locale;
    private ArrayList<SelfDefMakeup> packages;
    private ArrayList<Topic> topics;

    public SelfDefMakeupResponse(String str, Integer num, ArrayList<Topic> arrayList, ArrayList<SelfDefMakeup> arrayList2, ArrayList<MaterialColor> arrayList3) {
        this.locale = str;
        this.interval = num;
        this.topics = arrayList;
        this.packages = arrayList2;
        this.colors = arrayList3;
    }

    public static /* synthetic */ SelfDefMakeupResponse copy$default(SelfDefMakeupResponse selfDefMakeupResponse, String str, Integer num, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = selfDefMakeupResponse.locale;
        }
        if ((i2 & 2) != 0) {
            num = selfDefMakeupResponse.interval;
        }
        Integer num2 = num;
        ArrayList<Topic> arrayList4 = arrayList;
        if ((i2 & 4) != 0) {
            arrayList4 = selfDefMakeupResponse.topics;
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList<SelfDefMakeup> arrayList6 = arrayList2;
        if ((i2 & 8) != 0) {
            arrayList6 = selfDefMakeupResponse.packages;
        }
        ArrayList arrayList7 = arrayList6;
        ArrayList<MaterialColor> arrayList8 = arrayList3;
        if ((i2 & 16) != 0) {
            arrayList8 = selfDefMakeupResponse.colors;
        }
        return selfDefMakeupResponse.copy(str, num2, arrayList5, arrayList7, arrayList8);
    }

    public final String component1() {
        return this.locale;
    }

    public final Integer component2() {
        return this.interval;
    }

    public final ArrayList<Topic> component3() {
        return this.topics;
    }

    public final ArrayList<SelfDefMakeup> component4() {
        return this.packages;
    }

    public final ArrayList<MaterialColor> component5() {
        return this.colors;
    }

    public final SelfDefMakeupResponse copy(String str, Integer num, ArrayList<Topic> arrayList, ArrayList<SelfDefMakeup> arrayList2, ArrayList<MaterialColor> arrayList3) {
        return new SelfDefMakeupResponse(str, num, arrayList, arrayList2, arrayList3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelfDefMakeupResponse) {
            SelfDefMakeupResponse selfDefMakeupResponse = (SelfDefMakeupResponse) obj;
            return s.c(this.locale, selfDefMakeupResponse.locale) && s.c(this.interval, selfDefMakeupResponse.interval) && s.c(this.topics, selfDefMakeupResponse.topics) && s.c(this.packages, selfDefMakeupResponse.packages) && s.c(this.colors, selfDefMakeupResponse.colors);
        }
        return false;
    }

    public final ArrayList<MaterialColor> getColors() {
        return this.colors;
    }

    public final Integer getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final ArrayList<SelfDefMakeup> getPackages() {
        return this.packages;
    }

    public final ArrayList<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        String str = this.locale;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.interval;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        ArrayList<Topic> arrayList = this.topics;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<SelfDefMakeup> arrayList2 = this.packages;
        int hashCode4 = (hashCode3 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<MaterialColor> arrayList3 = this.colors;
        return hashCode4 + (arrayList3 != null ? arrayList3.hashCode() : 0);
    }

    public final void setPackages(ArrayList<SelfDefMakeup> arrayList) {
        this.packages = arrayList;
    }

    public final void setTopics(ArrayList<Topic> arrayList) {
        this.topics = arrayList;
    }

    public String toString() {
        return "SelfDefMakeupResponse(locale=" + ((Object) this.locale) + ", interval=" + this.interval + ", topics=" + this.topics + ", packages=" + this.packages + ", colors=" + this.colors + ')';
    }
}
