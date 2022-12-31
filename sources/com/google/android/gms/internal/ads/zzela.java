package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
final class zzela extends zzejl<Float> implements zzell<Float>, zzena, RandomAccess {
    private static final zzela zziqi;
    private int size;
    private float[] zziqj;

    static {
        zzela zzelaVar = new zzela(new float[0], 0);
        zziqi = zzelaVar;
        zzelaVar.zzbgf();
    }

    zzela() {
        this(new float[10], 0);
    }

    private final void zzfw(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(zzfx(i2));
        }
    }

    private final String zzfx(int i2) {
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        float floatValue = ((Float) obj).floatValue();
        zzbgg();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            float[] fArr = this.zziqj;
            if (i3 < fArr.length) {
                System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
            } else {
                float[] fArr2 = new float[((i3 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i2);
                System.arraycopy(this.zziqj, i2, fArr2, i2 + 1, this.size - i2);
                this.zziqj = fArr2;
            }
            this.zziqj[i2] = floatValue;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfx(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbgg();
        zzeld.checkNotNull(collection);
        if (!(collection instanceof zzela)) {
            return super.addAll(collection);
        }
        zzela zzelaVar = (zzela) collection;
        int i2 = zzelaVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.zziqj;
            if (i4 > fArr.length) {
                this.zziqj = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(zzelaVar.zziqj, 0, this.zziqj, this.size, zzelaVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzela)) {
            return super.equals(obj);
        }
        zzela zzelaVar = (zzela) obj;
        if (this.size != zzelaVar.size) {
            return false;
        }
        float[] fArr = zzelaVar.zziqj;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Float.floatToIntBits(this.zziqj[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzfw(i2);
        return Float.valueOf(this.zziqj[i2]);
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.zziqj[i3]);
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            int size = size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.zziqj[i2] == floatValue) {
                    return i2;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzbgg();
        zzfw(i2);
        float[] fArr = this.zziqj;
        float f2 = fArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzbgg();
        if (i3 >= i2) {
            float[] fArr = this.zziqj;
            System.arraycopy(fArr, i3, fArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbgg();
        zzfw(i2);
        float[] fArr = this.zziqj;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzell
    public final /* synthetic */ zzell<Float> zzfy(int i2) {
        if (i2 >= this.size) {
            return new zzela(Arrays.copyOf(this.zziqj, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzh(float f2) {
        zzbgg();
        int i2 = this.size;
        float[] fArr = this.zziqj;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.zziqj = fArr2;
        }
        float[] fArr3 = this.zziqj;
        int i3 = this.size;
        this.size = i3 + 1;
        fArr3[i3] = f2;
    }

    private zzela(float[] fArr, int i2) {
        this.zziqj = fArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzejl, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzh(((Float) obj).floatValue());
        return true;
    }
}
