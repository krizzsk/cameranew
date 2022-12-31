package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();
    final long[][] a;

    /* loaded from: classes3.dex */
    static class a implements Parcelable.Creator<GifViewSavedState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public GifViewSavedState[] newArray(int i2) {
            return new GifViewSavedState[i2];
        }
    }

    /* synthetic */ GifViewSavedState(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Drawable drawable, int i2) {
        long[][] jArr = this.a;
        if (jArr[i2] == null || !(drawable instanceof c)) {
            return;
        }
        c cVar = (c) drawable;
        cVar.l(cVar.f8981g.restoreSavedState(jArr[i2], cVar.f8980f));
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeInt(this.a.length);
        for (long[] jArr : this.a) {
            parcel.writeLongArray(jArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.a = new long[drawableArr.length];
        for (int i2 = 0; i2 < drawableArr.length; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable instanceof c) {
                this.a[i2] = ((c) drawable).f8981g.getSavedState();
            } else {
                this.a[i2] = null;
            }
        }
    }

    private GifViewSavedState(Parcel parcel) {
        super(parcel);
        this.a = new long[parcel.readInt()];
        int i2 = 0;
        while (true) {
            long[][] jArr = this.a;
            if (i2 >= jArr.length) {
                return;
            }
            jArr[i2] = parcel.createLongArray();
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GifViewSavedState(Parcelable parcelable, long[] jArr) {
        super(parcelable);
        this.a = r2;
        long[][] jArr2 = {jArr};
    }
}
