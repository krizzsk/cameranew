package us.pinguo.repository2020.database.background;

import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: BackgroundDisplay.kt */
/* loaded from: classes6.dex */
public final class BackgroundJson implements NoProguard {
    private final int interval;
    private final String locale;
    private final Background[] packages;
    private final Stroke[] sketches;
    private final BackgroundCategory[] topics;

    public BackgroundJson(String locale, int i2, Background[] packages, BackgroundCategory[] topics, Stroke[] sketches) {
        s.h(locale, "locale");
        s.h(packages, "packages");
        s.h(topics, "topics");
        s.h(sketches, "sketches");
        this.locale = locale;
        this.interval = i2;
        this.packages = packages;
        this.topics = topics;
        this.sketches = sketches;
    }

    public static /* synthetic */ BackgroundJson copy$default(BackgroundJson backgroundJson, String str, int i2, Background[] backgroundArr, BackgroundCategory[] backgroundCategoryArr, Stroke[] strokeArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = backgroundJson.locale;
        }
        if ((i3 & 2) != 0) {
            i2 = backgroundJson.interval;
        }
        int i4 = i2;
        if ((i3 & 4) != 0) {
            backgroundArr = backgroundJson.packages;
        }
        Background[] backgroundArr2 = backgroundArr;
        if ((i3 & 8) != 0) {
            backgroundCategoryArr = backgroundJson.topics;
        }
        BackgroundCategory[] backgroundCategoryArr2 = backgroundCategoryArr;
        if ((i3 & 16) != 0) {
            strokeArr = backgroundJson.sketches;
        }
        return backgroundJson.copy(str, i4, backgroundArr2, backgroundCategoryArr2, strokeArr);
    }

    public final String component1() {
        return this.locale;
    }

    public final int component2() {
        return this.interval;
    }

    public final Background[] component3() {
        return this.packages;
    }

    public final BackgroundCategory[] component4() {
        return this.topics;
    }

    public final Stroke[] component5() {
        return this.sketches;
    }

    public final BackgroundJson copy(String locale, int i2, Background[] packages, BackgroundCategory[] topics, Stroke[] sketches) {
        s.h(locale, "locale");
        s.h(packages, "packages");
        s.h(topics, "topics");
        s.h(sketches, "sketches");
        return new BackgroundJson(locale, i2, packages, topics, sketches);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (s.c(BackgroundJson.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type us.pinguo.repository2020.database.background.BackgroundJson");
            BackgroundJson backgroundJson = (BackgroundJson) obj;
            return s.c(this.locale, backgroundJson.locale) && this.interval == backgroundJson.interval && Arrays.equals(this.packages, backgroundJson.packages) && Arrays.equals(this.topics, backgroundJson.topics) && Arrays.equals(this.sketches, backgroundJson.sketches);
        }
        return false;
    }

    public final int getInterval() {
        return this.interval;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Background[] getPackages() {
        return this.packages;
    }

    public final Stroke[] getSketches() {
        return this.sketches;
    }

    public final BackgroundCategory[] getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return (((((((this.locale.hashCode() * 31) + this.interval) * 31) + Arrays.hashCode(this.packages)) * 31) + Arrays.hashCode(this.topics)) * 31) + Arrays.hashCode(this.sketches);
    }

    public String toString() {
        return "BackgroundJson(locale=" + this.locale + ", interval=" + this.interval + ", packages=" + Arrays.toString(this.packages) + ", topics=" + Arrays.toString(this.topics) + ", sketches=" + Arrays.toString(this.sketches) + ')';
    }
}
