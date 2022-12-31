package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: GraphRequestBatch.java */
/* loaded from: classes.dex */
public class i extends AbstractList<GraphRequest> {

    /* renamed from: g  reason: collision with root package name */
    private static AtomicInteger f2637g = new AtomicInteger();
    private Handler a;
    private List<GraphRequest> b;
    private int c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final String f2638d = Integer.valueOf(f2637g.incrementAndGet()).toString();

    /* renamed from: e  reason: collision with root package name */
    private List<a> f2639e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private String f2640f;

    /* compiled from: GraphRequestBatch.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(i iVar);
    }

    /* compiled from: GraphRequestBatch.java */
    /* loaded from: classes.dex */
    public interface b extends a {
        void b(i iVar, long j2, long j3);
    }

    public i() {
        this.b = new ArrayList();
        this.b = new ArrayList();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public final void add(int i2, GraphRequest graphRequest) {
        this.b.add(i2, graphRequest);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: b */
    public final boolean add(GraphRequest graphRequest) {
        return this.b.add(graphRequest);
    }

    public void c(a aVar) {
        if (this.f2639e.contains(aVar)) {
            return;
        }
        this.f2639e.add(aVar);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.b.clear();
    }

    public final List<GraphResponse> d() {
        return e();
    }

    List<GraphResponse> e() {
        return GraphRequest.j(this);
    }

    public final h f() {
        return g();
    }

    h g() {
        return GraphRequest.m(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h */
    public final GraphRequest get(int i2) {
        return this.b.get(i2);
    }

    public final String i() {
        return this.f2640f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Handler j() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<a> k() {
        return this.f2639e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String l() {
        return this.f2638d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<GraphRequest> m() {
        return this.b;
    }

    public int n() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o */
    public final GraphRequest remove(int i2) {
        return this.b.remove(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: p */
    public final GraphRequest set(int i2, GraphRequest graphRequest) {
        return this.b.set(i2, graphRequest);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void q(Handler handler) {
        this.a = handler;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b.size();
    }

    public i(Collection<GraphRequest> collection) {
        this.b = new ArrayList();
        this.b = new ArrayList(collection);
    }

    public i(GraphRequest... graphRequestArr) {
        this.b = new ArrayList();
        this.b = Arrays.asList(graphRequestArr);
    }
}
