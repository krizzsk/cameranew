package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MotionSpec.java */
/* loaded from: classes2.dex */
public class g {
    private final SimpleArrayMap<String, h> a = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, PropertyValuesHolder[]> b = new SimpleArrayMap<>();

    private static void a(@NonNull g gVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            gVar.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            gVar.m(objectAnimator.getPropertyName(), h.b(objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
    }

    @NonNull
    private PropertyValuesHolder[] b(@NonNull PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    @Nullable
    public static g c(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    @Nullable
    public static g d(@NonNull Context context, @AnimatorRes int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loadAnimator);
                return e(arrayList);
            }
            return null;
        } catch (Exception e2) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i2), e2);
            return null;
        }
    }

    @NonNull
    private static g e(@NonNull List<Animator> list) {
        g gVar = new g();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(gVar, list.get(i2));
        }
        return gVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.a.equals(((g) obj).a);
        }
        return false;
    }

    @NonNull
    public <T> ObjectAnimator f(@NonNull String str, @NonNull T t, @NonNull Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, g(str));
        ofPropertyValuesHolder.setProperty(property);
        h(str).a(ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    @NonNull
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public h h(String str) {
        if (k(str)) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public long i() {
        int size = this.a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            h valueAt = this.a.valueAt(i2);
            j2 = Math.max(j2, valueAt.c() + valueAt.d());
        }
        return j2;
    }

    public boolean j(String str) {
        return this.b.get(str) != null;
    }

    public boolean k(String str) {
        return this.a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @Nullable h hVar) {
        this.a.put(str, hVar);
    }

    @NonNull
    public String toString() {
        return '\n' + g.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.a + "}\n";
    }
}
