package us.pinguo.repository2020.entity;

import java.util.Arrays;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: UnityFilterItemIndex.kt */
/* loaded from: classes6.dex */
public final class UnityFilterItemIndex implements NoProguard {
    private final ChildComponent[] childComponents;

    public UnityFilterItemIndex(ChildComponent[] childComponentArr) {
        this.childComponents = childComponentArr;
    }

    public static /* synthetic */ UnityFilterItemIndex copy$default(UnityFilterItemIndex unityFilterItemIndex, ChildComponent[] childComponentArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            childComponentArr = unityFilterItemIndex.childComponents;
        }
        return unityFilterItemIndex.copy(childComponentArr);
    }

    public final ChildComponent[] component1() {
        return this.childComponents;
    }

    public final UnityFilterItemIndex copy(ChildComponent[] childComponentArr) {
        return new UnityFilterItemIndex(childComponentArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnityFilterItemIndex) && s.c(this.childComponents, ((UnityFilterItemIndex) obj).childComponents);
    }

    public final ChildComponent[] getChildComponents() {
        return this.childComponents;
    }

    public int hashCode() {
        ChildComponent[] childComponentArr = this.childComponents;
        if (childComponentArr == null) {
            return 0;
        }
        return Arrays.hashCode(childComponentArr);
    }

    public String toString() {
        return "UnityFilterItemIndex(childComponents=" + Arrays.toString(this.childComponents) + ')';
    }
}
