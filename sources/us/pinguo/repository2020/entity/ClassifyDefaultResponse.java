package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.s;
/* compiled from: ClassifyDefault.kt */
/* loaded from: classes6.dex */
public final class ClassifyDefaultResponse {
    private final ClassifyDefault[] lists;

    public ClassifyDefaultResponse(ClassifyDefault[] lists) {
        s.h(lists, "lists");
        this.lists = lists;
    }

    public static /* synthetic */ ClassifyDefaultResponse copy$default(ClassifyDefaultResponse classifyDefaultResponse, ClassifyDefault[] classifyDefaultArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            classifyDefaultArr = classifyDefaultResponse.lists;
        }
        return classifyDefaultResponse.copy(classifyDefaultArr);
    }

    public final ClassifyDefault[] component1() {
        return this.lists;
    }

    public final ClassifyDefaultResponse copy(ClassifyDefault[] lists) {
        s.h(lists, "lists");
        return new ClassifyDefaultResponse(lists);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClassifyDefaultResponse) && s.c(this.lists, ((ClassifyDefaultResponse) obj).lists);
    }

    public final ClassifyDefault[] getLists() {
        return this.lists;
    }

    public int hashCode() {
        return Arrays.hashCode(this.lists);
    }

    public String toString() {
        return "ClassifyDefaultResponse(lists=" + Arrays.toString(this.lists) + ')';
    }
}
