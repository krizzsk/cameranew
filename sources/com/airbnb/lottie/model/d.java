package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Marker;
/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class d {
    private final List<String> a;
    @Nullable
    private e b;

    public d(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d a(String str) {
        d dVar = new d(this);
        dVar.a.add(str);
        return dVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i2) {
        if (i2 >= this.a.size()) {
            return false;
        }
        boolean z = i2 == this.a.size() - 1;
        String str2 = this.a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.a.size() + (-2) && b())) && (str2.equals(str) || str2.equals(Marker.ANY_MARKER));
        }
        if (!z && this.a.get(i2 + 1).equals(str)) {
            return i2 == this.a.size() + (-2) || (i2 == this.a.size() + (-3) && b());
        } else if (z) {
            return true;
        } else {
            int i3 = i2 + 1;
            if (i3 < this.a.size() - 1) {
                return false;
            }
            return this.a.get(i3).equals(str);
        }
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e d() {
        return this.b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i2) {
        if (f(str)) {
            return 0;
        }
        if (this.a.get(i2).equals("**")) {
            return (i2 != this.a.size() - 1 && this.a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean g(String str, int i2) {
        if (f(str)) {
            return true;
        }
        if (i2 >= this.a.size()) {
            return false;
        }
        return this.a.get(i2).equals(str) || this.a.get(i2).equals("**") || this.a.get(i2).equals(Marker.ANY_MARKER);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i2) {
        return "__container".equals(str) || i2 < this.a.size() - 1 || this.a.get(i2).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d i(e eVar) {
        d dVar = new d(this);
        dVar.b = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.b != null);
        sb.append('}');
        return sb.toString();
    }

    private d(d dVar) {
        this.a = new ArrayList(dVar.a);
        this.b = dVar.b;
    }
}
