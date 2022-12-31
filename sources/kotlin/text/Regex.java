package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.z;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
                this();
            }
        }

        public Serialized(String pattern, int i2) {
            kotlin.jvm.internal.s.h(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i2;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.s.g(compile, "compile(pattern, flags)");
            return new Regex(compile);
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }
    }

    public Regex(Pattern nativePattern) {
        kotlin.jvm.internal.s.h(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ h find$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.find(charSequence, i2);
    }

    public static /* synthetic */ kotlin.sequences.e findAll$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.split(charSequence, i2);
    }

    public static /* synthetic */ kotlin.sequences.e splitToSequence$default(Regex regex, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return regex.splitToSequence(charSequence, i2);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.s.g(pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        kotlin.jvm.internal.s.h(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final h find(CharSequence input, int i2) {
        h e2;
        kotlin.jvm.internal.s.h(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.s.g(matcher, "nativePattern.matcher(input)");
        e2 = j.e(matcher, i2, input);
        return e2;
    }

    public final kotlin.sequences.e<h> findAll(CharSequence input, int i2) {
        kotlin.jvm.internal.s.h(input, "input");
        if (i2 >= 0 && i2 <= input.length()) {
            return kotlin.sequences.h.f(new Regex$findAll$1(this, input, i2), Regex$findAll$2.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + input.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            kotlin.jvm.internal.s.g(allOf, "");
            z.w(allOf, new Regex$special$$inlined$fromInt$1(flags));
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            kotlin.jvm.internal.s.g(unmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.s.g(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final h matchAt(CharSequence input, int i2) {
        kotlin.jvm.internal.s.h(input, "input");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i2, input.length());
        if (region.lookingAt()) {
            kotlin.jvm.internal.s.g(region, "this");
            return new i(region, input);
        }
        return null;
    }

    public final h matchEntire(CharSequence input) {
        h f2;
        kotlin.jvm.internal.s.h(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        kotlin.jvm.internal.s.g(matcher, "nativePattern.matcher(input)");
        f2 = j.f(matcher, input);
        return f2;
    }

    public final boolean matches(CharSequence input) {
        kotlin.jvm.internal.s.h(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean matchesAt(CharSequence input, int i2) {
        kotlin.jvm.internal.s.h(input, "input");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(i2, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        kotlin.jvm.internal.s.h(input, "input");
        kotlin.jvm.internal.s.h(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.s.g(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        kotlin.jvm.internal.s.h(input, "input");
        kotlin.jvm.internal.s.h(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        kotlin.jvm.internal.s.g(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence input, int i2) {
        List<String> e2;
        kotlin.jvm.internal.s.h(input, "input");
        StringsKt__StringsKt.k0(i2);
        Matcher matcher = this.nativePattern.matcher(input);
        if (i2 != 1 && matcher.find()) {
            ArrayList arrayList = new ArrayList(i2 > 0 ? kotlin.z.j.c(i2, 10) : 10);
            int i3 = 0;
            int i4 = i2 - 1;
            do {
                arrayList.add(input.subSequence(i3, matcher.start()).toString());
                i3 = matcher.end();
                if (i4 >= 0 && arrayList.size() == i4) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i3, input.length()).toString());
            return arrayList;
        }
        e2 = kotlin.collections.t.e(input.toString());
        return e2;
    }

    public final kotlin.sequences.e<String> splitToSequence(CharSequence input, int i2) {
        kotlin.jvm.internal.s.h(input, "input");
        StringsKt__StringsKt.k0(i2);
        return kotlin.sequences.h.b(new Regex$splitToSequence$1(this, input, i2, null));
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.s.g(pattern, "nativePattern.toString()");
        return pattern;
    }

    public final String replace(CharSequence input, kotlin.jvm.b.l<? super h, ? extends CharSequence> transform) {
        kotlin.jvm.internal.s.h(input, "input");
        kotlin.jvm.internal.s.h(transform, "transform");
        int i2 = 0;
        h find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i2, find$default.a().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i2 = find$default.a().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i2 >= length) {
                break;
            }
        } while (find$default != null);
        if (i2 < length) {
            sb.append(input, i2, length);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.s.g(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.h(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "compile(pattern)"
            kotlin.jvm.internal.s.g(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.h(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.s.h(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureUnicodeCase(option.value))"
            kotlin.jvm.internal.s.g(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2, java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.s.h(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.s.h(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.j.d(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "compile(pattern, ensureU…odeCase(options.toInt()))"
            kotlin.jvm.internal.s.g(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
