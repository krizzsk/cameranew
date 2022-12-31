package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.l;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.h.k;
import com.airbnb.lottie.s;
import com.airbnb.lottie.t.c.n;
import com.airbnb.lottie.t.c.p;
import com.airbnb.lottie.w.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: TextLayer.java */
/* loaded from: classes.dex */
public class g extends com.airbnb.lottie.model.layer.a {
    private final Paint A;
    private final Paint B;
    private final Map<com.airbnb.lottie.model.c, List<com.airbnb.lottie.t.b.d>> C;
    private final LongSparseArray<String> D;
    private final n E;
    private final com.airbnb.lottie.g F;
    private final com.airbnb.lottie.e G;
    @Nullable
    private com.airbnb.lottie.t.c.a<Integer, Integer> H;
    @Nullable
    private com.airbnb.lottie.t.c.a<Integer, Integer> I;
    @Nullable
    private com.airbnb.lottie.t.c.a<Integer, Integer> J;
    @Nullable
    private com.airbnb.lottie.t.c.a<Integer, Integer> K;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> L;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> M;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> N;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> O;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> P;
    @Nullable
    private com.airbnb.lottie.t.c.a<Float, Float> Q;
    private final StringBuilder x;
    private final RectF y;
    private final Matrix z;

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class a extends Paint {
        a(g gVar, int i2) {
            super(i2);
            setStyle(Paint.Style.FILL);
        }
    }

    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    class b extends Paint {
        b(g gVar, int i2) {
            super(i2);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[DocumentData.Justification.values().length];
            a = iArr;
            try {
                iArr[DocumentData.Justification.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DocumentData.Justification.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DocumentData.Justification.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(com.airbnb.lottie.g gVar, Layer layer) {
        super(gVar, layer);
        com.airbnb.lottie.model.h.b bVar;
        com.airbnb.lottie.model.h.b bVar2;
        com.airbnb.lottie.model.h.a aVar;
        com.airbnb.lottie.model.h.a aVar2;
        this.x = new StringBuilder(2);
        this.y = new RectF();
        this.z = new Matrix();
        this.A = new a(this, 1);
        this.B = new b(this, 1);
        this.C = new HashMap();
        this.D = new LongSparseArray<>();
        this.F = gVar;
        this.G = layer.a();
        n a2 = layer.q().a();
        this.E = a2;
        a2.a(this);
        i(a2);
        k r = layer.r();
        if (r != null && (aVar2 = r.a) != null) {
            com.airbnb.lottie.t.c.a<Integer, Integer> a3 = aVar2.a();
            this.H = a3;
            a3.a(this);
            i(this.H);
        }
        if (r != null && (aVar = r.b) != null) {
            com.airbnb.lottie.t.c.a<Integer, Integer> a4 = aVar.a();
            this.J = a4;
            a4.a(this);
            i(this.J);
        }
        if (r != null && (bVar2 = r.c) != null) {
            com.airbnb.lottie.t.c.a<Float, Float> a5 = bVar2.a();
            this.L = a5;
            a5.a(this);
            i(this.L);
        }
        if (r == null || (bVar = r.f425d) == null) {
            return;
        }
        com.airbnb.lottie.t.c.a<Float, Float> a6 = bVar.a();
        this.N = a6;
        a6.a(this);
        i(this.N);
    }

    private void J(DocumentData.Justification justification, Canvas canvas, float f2) {
        int i2 = c.a[justification.ordinal()];
        if (i2 == 2) {
            canvas.translate(-f2, 0.0f);
        } else if (i2 != 3) {
        } else {
            canvas.translate((-f2) / 2.0f, 0.0f);
        }
    }

    private String K(String str, int i2) {
        int codePointAt = str.codePointAt(i2);
        int charCount = Character.charCount(codePointAt) + i2;
        while (charCount < str.length()) {
            int codePointAt2 = str.codePointAt(charCount);
            if (!W(codePointAt2)) {
                break;
            }
            charCount += Character.charCount(codePointAt2);
            codePointAt = (codePointAt * 31) + codePointAt2;
        }
        long j2 = codePointAt;
        if (this.D.containsKey(j2)) {
            return this.D.get(j2);
        }
        this.x.setLength(0);
        while (i2 < charCount) {
            int codePointAt3 = str.codePointAt(i2);
            this.x.appendCodePoint(codePointAt3);
            i2 += Character.charCount(codePointAt3);
        }
        String sb = this.x.toString();
        this.D.put(j2, sb);
        return sb;
    }

    private void L(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    private void M(com.airbnb.lottie.model.c cVar, Matrix matrix, float f2, DocumentData documentData, Canvas canvas) {
        List<com.airbnb.lottie.t.b.d> T = T(cVar);
        for (int i2 = 0; i2 < T.size(); i2++) {
            Path path = T.get(i2).getPath();
            path.computeBounds(this.y, false);
            this.z.set(matrix);
            this.z.preTranslate(0.0f, (-documentData.f375g) * h.e());
            this.z.preScale(f2, f2);
            path.transform(this.z);
            if (documentData.f379k) {
                P(path, this.A, canvas);
                P(path, this.B, canvas);
            } else {
                P(path, this.B, canvas);
                P(path, this.A, canvas);
            }
        }
    }

    private void N(String str, DocumentData documentData, Canvas canvas) {
        if (documentData.f379k) {
            L(str, this.A, canvas);
            L(str, this.B, canvas);
            return;
        }
        L(str, this.B, canvas);
        L(str, this.A, canvas);
    }

    private void O(String str, DocumentData documentData, Canvas canvas, float f2) {
        float floatValue;
        int i2 = 0;
        while (i2 < str.length()) {
            String K = K(str, i2);
            i2 += K.length();
            N(K, documentData, canvas);
            float measureText = this.A.measureText(K, 0, 1);
            float f3 = documentData.f373e / 10.0f;
            com.airbnb.lottie.t.c.a<Float, Float> aVar = this.O;
            if (aVar != null) {
                floatValue = aVar.h().floatValue();
            } else {
                com.airbnb.lottie.t.c.a<Float, Float> aVar2 = this.N;
                if (aVar2 != null) {
                    floatValue = aVar2.h().floatValue();
                } else {
                    canvas.translate(measureText + (f3 * f2), 0.0f);
                }
            }
            f3 += floatValue;
            canvas.translate(measureText + (f3 * f2), 0.0f);
        }
    }

    private void P(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    private void Q(String str, DocumentData documentData, Matrix matrix, com.airbnb.lottie.model.b bVar, Canvas canvas, float f2, float f3) {
        float floatValue;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.model.c cVar = this.G.c().get(com.airbnb.lottie.model.c.c(str.charAt(i2), bVar.a(), bVar.c()));
            if (cVar != null) {
                M(cVar, matrix, f3, documentData, canvas);
                float b2 = ((float) cVar.b()) * f3 * h.e() * f2;
                float f4 = documentData.f373e / 10.0f;
                com.airbnb.lottie.t.c.a<Float, Float> aVar = this.O;
                if (aVar != null) {
                    floatValue = aVar.h().floatValue();
                } else {
                    com.airbnb.lottie.t.c.a<Float, Float> aVar2 = this.N;
                    if (aVar2 != null) {
                        floatValue = aVar2.h().floatValue();
                    }
                    canvas.translate(b2 + (f4 * f2), 0.0f);
                }
                f4 += floatValue;
                canvas.translate(b2 + (f4 * f2), 0.0f);
            }
        }
    }

    private void R(DocumentData documentData, Matrix matrix, com.airbnb.lottie.model.b bVar, Canvas canvas) {
        float f2;
        com.airbnb.lottie.t.c.a<Float, Float> aVar = this.Q;
        if (aVar != null) {
            f2 = aVar.h().floatValue();
        } else {
            com.airbnb.lottie.t.c.a<Float, Float> aVar2 = this.P;
            if (aVar2 != null) {
                f2 = aVar2.h().floatValue();
            } else {
                f2 = documentData.c;
            }
        }
        float f3 = f2 / 100.0f;
        float g2 = h.g(matrix);
        String str = documentData.a;
        float e2 = documentData.f374f * h.e();
        List<String> V = V(str);
        int size = V.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = V.get(i2);
            float U = U(str2, bVar, f3, g2);
            canvas.save();
            J(documentData.f372d, canvas, U);
            canvas.translate(0.0f, (i2 * e2) - (((size - 1) * e2) / 2.0f));
            Q(str2, documentData, matrix, bVar, canvas, g2, f3);
            canvas.restore();
        }
    }

    private void S(DocumentData documentData, com.airbnb.lottie.model.b bVar, Matrix matrix, Canvas canvas) {
        float f2;
        float g2 = h.g(matrix);
        Typeface C = this.F.C(bVar.a(), bVar.c());
        if (C == null) {
            return;
        }
        String str = documentData.a;
        s B = this.F.B();
        if (B == null) {
            this.A.setTypeface(C);
            com.airbnb.lottie.t.c.a<Float, Float> aVar = this.Q;
            if (aVar != null) {
                f2 = aVar.h().floatValue();
            } else {
                com.airbnb.lottie.t.c.a<Float, Float> aVar2 = this.P;
                if (aVar2 != null) {
                    f2 = aVar2.h().floatValue();
                } else {
                    f2 = documentData.c;
                }
            }
            this.A.setTextSize(f2 * h.e());
            this.B.setTypeface(this.A.getTypeface());
            this.B.setTextSize(this.A.getTextSize());
            float e2 = documentData.f374f * h.e();
            List<String> V = V(str);
            int size = V.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = V.get(i2);
                J(documentData.f372d, canvas, this.B.measureText(str2));
                canvas.translate(0.0f, (i2 * e2) - (((size - 1) * e2) / 2.0f));
                O(str2, documentData, canvas, g2);
                canvas.setMatrix(matrix);
            }
            return;
        }
        B.a(str);
        throw null;
    }

    private List<com.airbnb.lottie.t.b.d> T(com.airbnb.lottie.model.c cVar) {
        if (this.C.containsKey(cVar)) {
            return this.C.get(cVar);
        }
        List<j> a2 = cVar.a();
        int size = a2.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new com.airbnb.lottie.t.b.d(this.F, this, a2.get(i2)));
        }
        this.C.put(cVar, arrayList);
        return arrayList;
    }

    private float U(String str, com.airbnb.lottie.model.b bVar, float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            com.airbnb.lottie.model.c cVar = this.G.c().get(com.airbnb.lottie.model.c.c(str.charAt(i2), bVar.a(), bVar.c()));
            if (cVar != null) {
                f4 = (float) (f4 + (cVar.b() * f2 * h.e() * f3));
            }
        }
        return f4;
    }

    private List<String> V(String str) {
        return Arrays.asList(str.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
    }

    private boolean W(int i2) {
        return Character.getType(i2) == 16 || Character.getType(i2) == 27 || Character.getType(i2) == 6 || Character.getType(i2) == 28 || Character.getType(i2) == 19;
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.model.e
    public <T> void c(T t, @Nullable com.airbnb.lottie.x.c<T> cVar) {
        super.c(t, cVar);
        if (t == l.a) {
            com.airbnb.lottie.t.c.a<Integer, Integer> aVar = this.I;
            if (aVar != null) {
                C(aVar);
            }
            if (cVar == null) {
                this.I = null;
                return;
            }
            p pVar = new p(cVar);
            this.I = pVar;
            pVar.a(this);
            i(this.I);
        } else if (t == l.b) {
            com.airbnb.lottie.t.c.a<Integer, Integer> aVar2 = this.K;
            if (aVar2 != null) {
                C(aVar2);
            }
            if (cVar == null) {
                this.K = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.K = pVar2;
            pVar2.a(this);
            i(this.K);
        } else if (t == l.o) {
            com.airbnb.lottie.t.c.a<Float, Float> aVar3 = this.M;
            if (aVar3 != null) {
                C(aVar3);
            }
            if (cVar == null) {
                this.M = null;
                return;
            }
            p pVar3 = new p(cVar);
            this.M = pVar3;
            pVar3.a(this);
            i(this.M);
        } else if (t == l.p) {
            com.airbnb.lottie.t.c.a<Float, Float> aVar4 = this.O;
            if (aVar4 != null) {
                C(aVar4);
            }
            if (cVar == null) {
                this.O = null;
                return;
            }
            p pVar4 = new p(cVar);
            this.O = pVar4;
            pVar4.a(this);
            i(this.O);
        } else if (t == l.B) {
            com.airbnb.lottie.t.c.a<Float, Float> aVar5 = this.Q;
            if (aVar5 != null) {
                C(aVar5);
            }
            if (cVar == null) {
                this.Q = null;
                return;
            }
            p pVar5 = new p(cVar);
            this.Q = pVar5;
            pVar5.a(this);
            i(this.Q);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, com.airbnb.lottie.t.b.e
    public void e(RectF rectF, Matrix matrix, boolean z) {
        super.e(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.G.b().width(), this.G.b().height());
    }

    @Override // com.airbnb.lottie.model.layer.a
    void t(Canvas canvas, Matrix matrix, int i2) {
        canvas.save();
        if (!this.F.m0()) {
            canvas.setMatrix(matrix);
        }
        DocumentData h2 = this.E.h();
        com.airbnb.lottie.model.b bVar = this.G.g().get(h2.b);
        if (bVar == null) {
            canvas.restore();
            return;
        }
        com.airbnb.lottie.t.c.a<Integer, Integer> aVar = this.I;
        if (aVar != null) {
            this.A.setColor(aVar.h().intValue());
        } else {
            com.airbnb.lottie.t.c.a<Integer, Integer> aVar2 = this.H;
            if (aVar2 != null) {
                this.A.setColor(aVar2.h().intValue());
            } else {
                this.A.setColor(h2.f376h);
            }
        }
        com.airbnb.lottie.t.c.a<Integer, Integer> aVar3 = this.K;
        if (aVar3 != null) {
            this.B.setColor(aVar3.h().intValue());
        } else {
            com.airbnb.lottie.t.c.a<Integer, Integer> aVar4 = this.J;
            if (aVar4 != null) {
                this.B.setColor(aVar4.h().intValue());
            } else {
                this.B.setColor(h2.f377i);
            }
        }
        int intValue = ((this.v.h() == null ? 100 : this.v.h().h().intValue()) * 255) / 100;
        this.A.setAlpha(intValue);
        this.B.setAlpha(intValue);
        com.airbnb.lottie.t.c.a<Float, Float> aVar5 = this.M;
        if (aVar5 != null) {
            this.B.setStrokeWidth(aVar5.h().floatValue());
        } else {
            com.airbnb.lottie.t.c.a<Float, Float> aVar6 = this.L;
            if (aVar6 != null) {
                this.B.setStrokeWidth(aVar6.h().floatValue());
            } else {
                this.B.setStrokeWidth(h2.f378j * h.e() * h.g(matrix));
            }
        }
        if (this.F.m0()) {
            R(h2, matrix, bVar, canvas);
        } else {
            S(h2, bVar, matrix, canvas);
        }
        canvas.restore();
    }
}
