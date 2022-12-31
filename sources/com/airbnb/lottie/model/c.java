package com.airbnb.lottie.model;

import androidx.annotation.RestrictTo;
import com.airbnb.lottie.model.content.j;
import java.util.List;
/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {
    private final List<j> a;
    private final char b;
    private final double c;

    /* renamed from: d  reason: collision with root package name */
    private final String f380d;

    /* renamed from: e  reason: collision with root package name */
    private final String f381e;

    public c(List<j> list, char c, double d2, double d3, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d3;
        this.f380d = str;
        this.f381e = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return c(this.b, this.f381e, this.f380d);
    }
}
