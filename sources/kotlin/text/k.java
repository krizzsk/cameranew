package kotlin.text;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
/* loaded from: classes3.dex */
public final class k {
    public static final k a = new k();
    public static final Regex b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }

    private k() {
    }
}
