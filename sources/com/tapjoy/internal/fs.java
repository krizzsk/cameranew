package com.tapjoy.internal;

import java.util.Observable;
/* loaded from: classes3.dex */
public final class fs {
    public static final a a = new a();
    public static final a b = new a();
    public static final a c = new a();

    /* renamed from: d  reason: collision with root package name */
    public static final a f7544d = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final a f7545e = new a();

    /* loaded from: classes3.dex */
    public static class a extends Observable {
        @Override // java.util.Observable
        public final void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        @Override // java.util.Observable
        public final void notifyObservers(Object obj) {
            setChanged();
            super.notifyObservers(obj);
        }
    }
}
