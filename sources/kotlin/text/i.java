package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.collections.AbstractCollection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class i implements h {
    private final Matcher a;
    private final CharSequence b;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a extends AbstractCollection<g> implements Object, kotlin.jvm.internal.z.a {
        public g c(int i2) {
            throw null;
        }
    }

    public i(Matcher matcher, CharSequence input) {
        kotlin.jvm.internal.s.h(matcher, "matcher");
        kotlin.jvm.internal.s.h(input, "input");
        this.a = matcher;
        this.b = input;
    }

    private final MatchResult b() {
        return this.a;
    }

    @Override // kotlin.text.h
    public kotlin.z.d a() {
        kotlin.z.d g2;
        g2 = j.g(b());
        return g2;
    }

    @Override // kotlin.text.h
    public h next() {
        h e2;
        int end = b().end() + (b().end() == b().start() ? 1 : 0);
        if (end <= this.b.length()) {
            Matcher matcher = this.a.pattern().matcher(this.b);
            kotlin.jvm.internal.s.g(matcher, "matcher.pattern().matcher(input)");
            e2 = j.e(matcher, end, this.b);
            return e2;
        }
        return null;
    }
}
