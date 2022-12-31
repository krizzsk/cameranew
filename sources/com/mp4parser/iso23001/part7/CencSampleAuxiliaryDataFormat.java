package com.mp4parser.iso23001.part7;

import com.coremedia.iso.Hex;
import com.pinguo.camera360.effect.model.entity.Effect;
import java.math.BigInteger;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class CencSampleAuxiliaryDataFormat {
    public byte[] iv = new byte[0];
    public Pair[] pairs = null;

    /* loaded from: classes3.dex */
    public interface Pair {
        int clear();

        long encrypted();
    }

    /* loaded from: classes3.dex */
    private abstract class a implements Pair {
        private a(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return clear() == pair.clear() && encrypted() == pair.encrypted();
        }

        public String toString() {
            return "P(" + clear() + Effect.DIVIDER + encrypted() + ")";
        }

        /* synthetic */ a(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, a aVar) {
            this(cencSampleAuxiliaryDataFormat);
        }
    }

    /* loaded from: classes3.dex */
    private class b extends a {
        private byte a;
        private byte b;

        public b(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (byte) i2;
            this.b = (byte) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class c extends a {
        private byte a;
        private int b;

        public c(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (byte) i2;
            this.b = (int) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class d extends a {
        private byte a;
        private long b;

        public d(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (byte) i2;
            this.b = j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class e extends a {
        private byte a;
        private short b;

        public e(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (byte) i2;
            this.b = (short) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class f extends a {
        private int a;
        private byte b;

        public f(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = i2;
            this.b = (byte) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class g extends a {
        private int a;
        private int b;

        public g(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = i2;
            this.b = (int) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class h extends a {
        private int a;
        private long b;

        public h(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = i2;
            this.b = j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class i extends a {
        private int a;
        private short b;

        public i(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = i2;
            this.b = (short) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class j extends a {
        private short a;
        private byte b;

        public j(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (short) i2;
            this.b = (byte) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class k extends a {
        private short a;
        private int b;

        public k(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (short) i2;
            this.b = (int) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class l extends a {
        private short a;
        private long b;

        public l(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (short) i2;
            this.b = j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    /* loaded from: classes3.dex */
    private class m extends a {
        private short a;
        private short b;

        public m(CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat, int i2, long j2) {
            super(cencSampleAuxiliaryDataFormat, null);
            this.a = (short) i2;
            this.b = (short) j2;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public int clear() {
            return this.a;
        }

        @Override // com.mp4parser.iso23001.part7.CencSampleAuxiliaryDataFormat.Pair
        public long encrypted() {
            return this.b;
        }
    }

    public Pair createPair(int i2, long j2) {
        if (i2 <= 127) {
            if (j2 <= 127) {
                return new b(this, i2, j2);
            }
            if (j2 <= 32767) {
                return new e(this, i2, j2);
            }
            if (j2 <= 2147483647L) {
                return new c(this, i2, j2);
            }
            return new d(this, i2, j2);
        } else if (i2 <= 32767) {
            if (j2 <= 127) {
                return new j(this, i2, j2);
            }
            if (j2 <= 32767) {
                return new m(this, i2, j2);
            }
            if (j2 <= 2147483647L) {
                return new k(this, i2, j2);
            }
            return new l(this, i2, j2);
        } else if (j2 <= 127) {
            return new f(this, i2, j2);
        } else {
            if (j2 <= 32767) {
                return new i(this, i2, j2);
            }
            if (j2 <= 2147483647L) {
                return new g(this, i2, j2);
            }
            return new h(this, i2, j2);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CencSampleAuxiliaryDataFormat cencSampleAuxiliaryDataFormat = (CencSampleAuxiliaryDataFormat) obj;
        if (new BigInteger(this.iv).equals(new BigInteger(cencSampleAuxiliaryDataFormat.iv))) {
            Pair[] pairArr = this.pairs;
            Pair[] pairArr2 = cencSampleAuxiliaryDataFormat.pairs;
            return pairArr == null ? pairArr2 == null : Arrays.equals(pairArr, pairArr2);
        }
        return false;
    }

    public int getSize() {
        int length = this.iv.length;
        Pair[] pairArr = this.pairs;
        return (pairArr == null || pairArr.length <= 0) ? length : length + 2 + (pairArr.length * 6);
    }

    public int hashCode() {
        byte[] bArr = this.iv;
        int hashCode = (bArr != null ? Arrays.hashCode(bArr) : 0) * 31;
        Pair[] pairArr = this.pairs;
        return hashCode + (pairArr != null ? Arrays.hashCode(pairArr) : 0);
    }

    public String toString() {
        return "Entry{iv=" + Hex.encodeHex(this.iv) + ", pairs=" + Arrays.toString(this.pairs) + '}';
    }
}
