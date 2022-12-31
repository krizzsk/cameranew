package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.aspectj.lang.a;
/* loaded from: classes2.dex */
public abstract class Utf8AppleDataBox extends AppleDataBox {
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    String value;

    static {
        ajc$preClinit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Utf8AppleDataBox(String str) {
        super(str, 1);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("Utf8AppleDataBox.java", Utf8AppleDataBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "", "", "", "java.lang.String"), 21);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setValue", "com.googlecode.mp4parser.boxes.apple.Utf8AppleDataBox", "java.lang.String", FirebaseAnalytics.Param.VALUE, "", "void"), 30);
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected int getDataLength() {
        return this.value.getBytes(Charset.forName("UTF-8")).length;
    }

    public String getValue() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        return this.value;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    protected void parseData(ByteBuffer byteBuffer) {
        this.value = IsoTypeReader.readString(byteBuffer, byteBuffer.remaining());
    }

    public void setValue(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.value = str;
    }

    @Override // com.googlecode.mp4parser.boxes.apple.AppleDataBox
    @DoNotParseDetail
    public byte[] writeData() {
        return Utf8.convert(this.value);
    }
}
