package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.s;
/* compiled from: ClassifyDefault.kt */
/* loaded from: classes6.dex */
public final class ClassifyDefault {
    private final String appName;
    private final String classify;
    private final String classifyId;

    /* renamed from: default  reason: not valid java name */
    private final Integer f1default;
    private final Long endTime;
    private final String id;
    private final String[] languages;
    private final String scene;
    private final Long startTime;

    public ClassifyDefault(String str, String str2, String str3, String str4, String str5, Integer num, String[] strArr, Long l2, Long l3) {
        this.id = str;
        this.appName = str2;
        this.classify = str3;
        this.classifyId = str4;
        this.scene = str5;
        this.f1default = num;
        this.languages = strArr;
        this.startTime = l2;
        this.endTime = l3;
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.classify;
    }

    public final String component4() {
        return this.classifyId;
    }

    public final String component5() {
        return this.scene;
    }

    public final Integer component6() {
        return this.f1default;
    }

    public final String[] component7() {
        return this.languages;
    }

    public final Long component8() {
        return this.startTime;
    }

    public final Long component9() {
        return this.endTime;
    }

    public final ClassifyDefault copy(String str, String str2, String str3, String str4, String str5, Integer num, String[] strArr, Long l2, Long l3) {
        return new ClassifyDefault(str, str2, str3, str4, str5, num, strArr, l2, l3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClassifyDefault) {
            ClassifyDefault classifyDefault = (ClassifyDefault) obj;
            return s.c(this.id, classifyDefault.id) && s.c(this.appName, classifyDefault.appName) && s.c(this.classify, classifyDefault.classify) && s.c(this.classifyId, classifyDefault.classifyId) && s.c(this.scene, classifyDefault.scene) && s.c(this.f1default, classifyDefault.f1default) && s.c(this.languages, classifyDefault.languages) && s.c(this.startTime, classifyDefault.startTime) && s.c(this.endTime, classifyDefault.endTime);
        }
        return false;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClassify() {
        return this.classify;
    }

    public final String getClassifyId() {
        return this.classifyId;
    }

    public final Integer getDefault() {
        return this.f1default;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String[] getLanguages() {
        return this.languages;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classify;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.classifyId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.scene;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.f1default;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String[] strArr = this.languages;
        int hashCode7 = (hashCode6 + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Long l2 = this.startTime;
        int hashCode8 = (hashCode7 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.endTime;
        return hashCode8 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "ClassifyDefault(id=" + ((Object) this.id) + ", appName=" + ((Object) this.appName) + ", classify=" + ((Object) this.classify) + ", classifyId=" + ((Object) this.classifyId) + ", scene=" + ((Object) this.scene) + ", default=" + this.f1default + ", languages=" + Arrays.toString(this.languages) + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }
}
