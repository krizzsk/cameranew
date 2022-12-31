package kotlin.text;

import kotlin.jvm.internal.FunctionReferenceImpl;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
/* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements kotlin.jvm.b.l<h, h> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1, h.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    @Override // kotlin.jvm.b.l
    public final h invoke(h p0) {
        kotlin.jvm.internal.s.h(p0, "p0");
        return p0.next();
    }
}
