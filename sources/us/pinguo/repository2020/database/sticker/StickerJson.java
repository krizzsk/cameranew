package us.pinguo.repository2020.database.sticker;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Sticker.kt */
/* loaded from: classes6.dex */
public final class StickerJson implements NoProguard {
    private final int interval;
    private final String locale;
    private final Sticker[] packages;
    private final StickerCategory[] topics;
    private final int version;

    public StickerJson(String locale, int i2, Sticker[] packages, StickerCategory[] topics, int i3) {
        s.h(locale, "locale");
        s.h(packages, "packages");
        s.h(topics, "topics");
        this.locale = locale;
        this.interval = i2;
        this.packages = packages;
        this.topics = topics;
        this.version = i3;
    }

    public static /* synthetic */ StickerJson copy$default(StickerJson stickerJson, String str, int i2, Sticker[] stickerArr, StickerCategory[] stickerCategoryArr, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = stickerJson.locale;
        }
        if ((i4 & 2) != 0) {
            i2 = stickerJson.interval;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            stickerArr = stickerJson.packages;
        }
        Sticker[] stickerArr2 = stickerArr;
        if ((i4 & 8) != 0) {
            stickerCategoryArr = stickerJson.topics;
        }
        StickerCategory[] stickerCategoryArr2 = stickerCategoryArr;
        if ((i4 & 16) != 0) {
            i3 = stickerJson.version;
        }
        return stickerJson.copy(str, i5, stickerArr2, stickerCategoryArr2, i3);
    }

    public final String component1() {
        return this.locale;
    }

    public final int component2() {
        return this.interval;
    }

    public final Sticker[] component3() {
        return this.packages;
    }

    public final StickerCategory[] component4() {
        return this.topics;
    }

    public final int component5() {
        return this.version;
    }

    public final StickerJson copy(String locale, int i2, Sticker[] packages, StickerCategory[] topics, int i3) {
        s.h(locale, "locale");
        s.h(packages, "packages");
        s.h(topics, "topics");
        return new StickerJson(locale, i2, packages, topics, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(StickerJson.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.sticker.StickerJson");
            StickerJson stickerJson = (StickerJson) obj;
            return s.c(this.locale, stickerJson.locale) && this.interval == stickerJson.interval && Arrays.equals(this.packages, stickerJson.packages) && Arrays.equals(this.topics, stickerJson.topics) && this.version == stickerJson.version;
        }
        return false;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Sticker[] getPackages() {
        return this.packages;
    }

    public final StickerCategory[] getTopics() {
        return this.topics;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((this.locale.hashCode() * 31) + this.interval) * 31) + Arrays.hashCode(this.packages)) * 31) + Arrays.hashCode(this.topics)) * 31) + this.version;
    }

    public String toString() {
        return "StickerJson(locale=" + this.locale + ", interval=" + this.interval + ", packages=" + Arrays.toString(this.packages) + ", topics=" + Arrays.toString(this.topics) + ", version=" + this.version + ')';
    }
}
