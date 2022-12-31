package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.collections.t;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: ListBuilder.kt */
/* loaded from: classes3.dex */
public final class SerializedCollection implements Externalizable {
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    /* compiled from: ListBuilder.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }

    public SerializedCollection(Collection<?> collection, int i2) {
        s.h(collection, "collection");
        this.collection = collection;
        this.tag = i2;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        List d2;
        Collection<?> a2;
        Set b;
        s.h(input, "input");
        byte readByte = input.readByte();
        int i2 = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                int i3 = 0;
                if (i2 == 0) {
                    d2 = t.d(readInt);
                    while (i3 < readInt) {
                        d2.add(input.readObject());
                        i3++;
                    }
                    a2 = t.a(d2);
                } else if (i2 == 1) {
                    b = r0.b(readInt);
                    while (i3 < readInt) {
                        b.add(input.readObject());
                        i3++;
                    }
                    a2 = r0.a(b);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + i2 + '.');
                }
                this.collection = a2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        s.h(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SerializedCollection() {
        /*
            r2 = this;
            java.util.List r0 = kotlin.collections.s.h()
            r1 = 0
            r2.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.builders.SerializedCollection.<init>():void");
    }
}
