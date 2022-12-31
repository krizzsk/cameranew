package com.airbnb.lottie.t.c;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MaskKeyframeAnimation.java */
/* loaded from: classes.dex */
public class g {
    private final List<a<com.airbnb.lottie.model.content.h, Path>> a;
    private final List<a<Integer, Integer>> b;
    private final List<Mask> c;

    public g(List<Mask> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.add(list.get(i2).b().a());
            this.b.add(list.get(i2).c().a());
        }
    }

    public List<a<com.airbnb.lottie.model.content.h, Path>> a() {
        return this.a;
    }

    public List<Mask> b() {
        return this.c;
    }

    public List<a<Integer, Integer>> c() {
        return this.b;
    }
}
