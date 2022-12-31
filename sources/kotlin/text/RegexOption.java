package kotlin.text;
/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public enum RegexOption implements f {
    IGNORE_CASE(2, 0, 2, null),
    MULTILINE(8, 0, 2, null),
    LITERAL(16, 0, 2, null),
    UNIX_LINES(1, 0, 2, null),
    COMMENTS(4, 0, 2, null),
    DOT_MATCHES_ALL(32, 0, 2, null),
    CANON_EQ(128, 0, 2, null);
    
    private final int mask;
    private final int value;

    RegexOption(int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    @Override // kotlin.text.f
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.f
    public int getValue() {
        return this.value;
    }

    /* synthetic */ RegexOption(int i2, int i3, int i4, kotlin.jvm.internal.o oVar) {
        this(i2, (i4 & 2) != 0 ? i2 : i3);
    }
}
