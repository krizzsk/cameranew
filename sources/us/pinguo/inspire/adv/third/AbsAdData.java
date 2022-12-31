package us.pinguo.inspire.adv.third;
/* loaded from: classes9.dex */
public abstract class AbsAdData<T> {
    protected T mData;

    public AbsAdData(T t) {
        this.mData = t;
    }

    public boolean equals(Object obj) {
        T t;
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AbsAdData) && (t = this.mData) != null) {
            return t.equals(((AbsAdData) obj).getData());
        }
        return false;
    }

    public T getData() {
        return this.mData;
    }

    public abstract String getIconUrl();

    public abstract String getImageUrl();

    public int hashCode() {
        T t = this.mData;
        return t == null ? super.hashCode() : t.hashCode();
    }
}
