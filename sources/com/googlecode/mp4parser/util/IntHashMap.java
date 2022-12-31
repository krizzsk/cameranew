package com.googlecode.mp4parser.util;

import java.util.Objects;
/* loaded from: classes2.dex */
public class IntHashMap {
    private transient int count;
    private float loadFactor;
    private transient a[] table;
    private int threshold;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        int a;
        Object b;
        a c;

        protected a(int i2, int i3, Object obj, a aVar) {
            this.a = i2;
            this.b = obj;
            this.c = aVar;
        }
    }

    public IntHashMap() {
        this(20, 0.75f);
    }

    public synchronized void clear() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        while (true) {
            length--;
            if (length < 0) {
                this.count = 0;
            } else {
                aVarArr[length] = null;
            }
        }
    }

    public boolean contains(Object obj) {
        Objects.requireNonNull(obj);
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return false;
            }
            for (a aVar = aVarArr[i2]; aVar != null; aVar = aVar.c) {
                if (aVar.b.equals(obj)) {
                    return true;
                }
            }
            length = i2;
        }
    }

    public boolean containsKey(int i2) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i2) % aVarArr.length]; aVar != null; aVar = aVar.c) {
            if (aVar.a == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(Object obj) {
        return contains(obj);
    }

    public Object get(int i2) {
        a[] aVarArr = this.table;
        for (a aVar = aVarArr[(Integer.MAX_VALUE & i2) % aVarArr.length]; aVar != null; aVar = aVar.c) {
            if (aVar.a == i2) {
                return aVar.b;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Object put(int i2, Object obj) {
        a[] aVarArr = this.table;
        int i3 = Integer.MAX_VALUE & i2;
        int length = i3 % aVarArr.length;
        for (a aVar = aVarArr[length]; aVar != null; aVar = aVar.c) {
            if (aVar.a == i2) {
                Object obj2 = aVar.b;
                aVar.b = obj;
                return obj2;
            }
        }
        if (this.count >= this.threshold) {
            rehash();
            aVarArr = this.table;
            length = i3 % aVarArr.length;
        }
        aVarArr[length] = new a(i2, i2, obj, aVarArr[length]);
        this.count++;
        return null;
    }

    protected void rehash() {
        a[] aVarArr = this.table;
        int length = aVarArr.length;
        int i2 = (length * 2) + 1;
        a[] aVarArr2 = new a[i2];
        this.threshold = (int) (i2 * this.loadFactor);
        this.table = aVarArr2;
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return;
            }
            a aVar = aVarArr[i3];
            while (aVar != null) {
                a aVar2 = aVar.c;
                int i4 = (aVar.a & Integer.MAX_VALUE) % i2;
                aVar.c = aVarArr2[i4];
                aVarArr2[i4] = aVar;
                aVar = aVar2;
            }
            length = i3;
        }
    }

    public Object remove(int i2) {
        a[] aVarArr = this.table;
        int length = (Integer.MAX_VALUE & i2) % aVarArr.length;
        a aVar = null;
        for (a aVar2 = aVarArr[length]; aVar2 != null; aVar2 = aVar2.c) {
            if (aVar2.a == i2) {
                if (aVar != null) {
                    aVar.c = aVar2.c;
                } else {
                    aVarArr[length] = aVar2.c;
                }
                this.count--;
                Object obj = aVar2.b;
                aVar2.b = null;
                return obj;
            }
            aVar = aVar2;
        }
        return null;
    }

    public int size() {
        return this.count;
    }

    public IntHashMap(int i2) {
        this(i2, 0.75f);
    }

    public IntHashMap(int i2, float f2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + i2);
        } else if (f2 > 0.0f) {
            i2 = i2 == 0 ? 1 : i2;
            this.loadFactor = f2;
            this.table = new a[i2];
            this.threshold = (int) (i2 * f2);
        } else {
            throw new IllegalArgumentException("Illegal Load: " + f2);
        }
    }
}
