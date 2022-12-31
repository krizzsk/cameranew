package com.pinguo.camera360.gallery.photopick;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
/* loaded from: classes3.dex */
public class PhotoPickBroker extends Observable {

    /* renamed from: d  reason: collision with root package name */
    private static volatile PhotoPickBroker f6435d;
    private WeakReference<c> b;
    private int a = 9;
    private List<e> c = new LinkedList();

    /* loaded from: classes3.dex */
    public enum EventType {
        EVENT_ADD,
        EVENT_ADD_BATCH,
        EVENT_REMOVE
    }

    private PhotoPickBroker() {
    }

    public static PhotoPickBroker k() {
        if (f6435d == null) {
            synchronized (PhotoPickBroker.class) {
                if (f6435d == null) {
                    f6435d = new PhotoPickBroker();
                }
            }
        }
        return f6435d;
    }

    public void a(e eVar) {
        if (this.a <= 0 || (this.c.size() < this.a && !this.c.contains(eVar))) {
            this.c.add(eVar);
            setChanged();
            notifyObservers(EventType.EVENT_ADD);
        }
    }

    public void b(List<e> list) {
        boolean z = false;
        for (e eVar : list) {
            if (this.a > 0 && this.c.size() >= this.a) {
                break;
            } else if (!this.c.contains(eVar)) {
                this.c.add(eVar);
                z = true;
            }
        }
        if (z) {
            setChanged();
            notifyObservers(EventType.EVENT_ADD);
        }
    }

    public boolean c() {
        List<e> list = this.c;
        return list == null || this.a - list.size() > 0;
    }

    public void d(e eVar) {
        List<e> list = this.c;
        if (list != null) {
            list.remove(eVar);
            setChanged();
            notifyObservers(EventType.EVENT_REMOVE);
        }
        WeakReference<c> weakReference = this.b;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.b.get().L0(eVar.a, eVar.c);
    }

    public void e() {
        List<e> list = this.c;
        if (list != null) {
            list.clear();
        }
    }

    public void f() {
    }

    public void g() {
        clearChanged();
        deleteObservers();
        for (e eVar : this.c) {
            eVar.b.recycle();
            eVar.b = null;
        }
        e();
        f6435d = null;
    }

    public int h() {
        return this.a;
    }

    public int i() {
        List<e> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<e> j() {
        List<e> list = this.c;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public void l(e eVar) {
        if (this.c.remove(eVar)) {
            setChanged();
            notifyObservers(EventType.EVENT_REMOVE);
        }
    }

    public void m(List<e> list) {
        if (this.c.removeAll(list)) {
            setChanged();
            notifyObservers(EventType.EVENT_REMOVE);
        }
    }

    public void n(c cVar) {
        this.b = new WeakReference<>(cVar);
    }

    public void o(int i2) {
        this.a = i2;
    }
}
