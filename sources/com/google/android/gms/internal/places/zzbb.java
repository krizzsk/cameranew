package com.google.android.gms.internal.places;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;
/* loaded from: classes2.dex */
final class zzbb extends zzq<Float> implements zzbh<Float>, zzcw, RandomAccess {
    private static final zzbb zzic;
    private int size;
    private float[] zzid;

    static {
        zzbb zzbbVar = new zzbb(new float[0], 0);
        zzic = zzbbVar;
        zzbbVar.zzab();
    }

    zzbb() {
        this(new float[10], 0);
    }

    private final void zzd(int i2, float f2) {
        int i3;
        zzac();
        if (i2 >= 0 && i2 <= (i3 = this.size)) {
            float[] fArr = this.zzid;
            if (i3 < fArr.length) {
                System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
            } else {
                float[] fArr2 = new float[((i3 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i2);
                System.arraycopy(this.zzid, i2, fArr2, i2 + 1, this.size - i2);
                this.zzid = fArr2;
            }
            this.zzid[i2] = f2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzg(i2));
    }

    private final String zzg(int i2) {
        int i3 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        zzd(i2, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzac();
        zzbd.checkNotNull(collection);
        if (!(collection instanceof zzbb)) {
            return super.addAll(collection);
        }
        zzbb zzbbVar = (zzbb) collection;
        int i2 = zzbbVar.size;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.size;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.zzid;
            if (i4 > fArr.length) {
                this.zzid = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(zzbbVar.zzid, 0, this.zzid, this.size, zzbbVar.size);
            this.size = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbb)) {
            return super.equals(obj);
        }
        zzbb zzbbVar = (zzbb) obj;
        if (this.size != zzbbVar.size) {
            return false;
        }
        float[] fArr = zzbbVar.zzid;
        for (int i2 = 0; i2 < this.size; i2++) {
            if (Float.floatToIntBits(this.zzid[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        zzf(i2);
        return Float.valueOf(this.zzid[i2]);
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.size; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.zzid[i3]);
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzac();
        for (int i2 = 0; i2 < this.size; i2++) {
            if (obj.equals(Float.valueOf(this.zzid[i2]))) {
                float[] fArr = this.zzid;
                System.arraycopy(fArr, i2 + 1, fArr, i2, (this.size - i2) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i2, int i3) {
        zzac();
        if (i3 >= i2) {
            float[] fArr = this.zzid;
            System.arraycopy(fArr, i3, fArr, i2, this.size - i3);
            this.size -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzac();
        zzf(i2);
        float[] fArr = this.zzid;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzf(float f2) {
        zzd(this.size, f2);
    }

    @Override // com.google.android.gms.internal.places.zzbh
    public final /* synthetic */ zzbh<Float> zzh(int i2) {
        if (i2 >= this.size) {
            return new zzbb(Arrays.copyOf(this.zzid, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzbb(float[] fArr, int i2) {
        this.zzid = fArr;
        this.size = i2;
    }

    private final void zzf(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(zzg(i2));
        }
    }

    @Override // com.google.android.gms.internal.places.zzq, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        int i3;
        zzac();
        zzf(i2);
        float[] fArr = this.zzid;
        float f2 = fArr[i2];
        if (i2 < this.size - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }
}
