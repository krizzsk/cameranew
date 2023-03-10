package kotlin.text;

import java.util.Map;
/* compiled from: CharDirectionality.kt */
/* loaded from: classes3.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public static final a Companion = new a(null);
    private static final kotlin.f<Map<Integer, CharDirectionality>> directionalityMap$delegate;
    private final int value;

    /* compiled from: CharDirectionality.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    static {
        kotlin.f<Map<Integer, CharDirectionality>> b;
        b = kotlin.h.b(CharDirectionality$Companion$directionalityMap$2.INSTANCE);
        directionalityMap$delegate = b;
    }

    CharDirectionality(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }
}
