package com.coremedia.iso.boxes.vodafone;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.Utf8;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import h.a.a.b.b;
import java.nio.ByteBuffer;
import org.aspectj.lang.a;
/* loaded from: classes.dex */
public class LyricsUriBox extends AbstractFullBox {
    public static final String TYPE = "lrcu";
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0328a ajc$tjp_2 = null;
    private String lyricsUri;

    static {
        ajc$preClinit();
    }

    public LyricsUriBox() {
        super(TYPE);
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("LyricsUriBox.java", LyricsUriBox.class);
        ajc$tjp_0 = bVar.h("method-execution", bVar.g("1", "getLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 39);
        ajc$tjp_1 = bVar.h("method-execution", bVar.g("1", "setLyricsUri", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "java.lang.String", "lyricsUri", "", "void"), 43);
        ajc$tjp_2 = bVar.h("method-execution", bVar.g("1", "toString", "com.coremedia.iso.boxes.vodafone.LyricsUriBox", "", "", "", "java.lang.String"), 64);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        this.lyricsUri = IsoTypeReader.readString(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
        byteBuffer.put(Utf8.convert(this.lyricsUri));
        byteBuffer.put((byte) 0);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        return Utf8.utf8StringLengthInBytes(this.lyricsUri) + 5;
    }

    public String getLyricsUri() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_0, this, this));
        return this.lyricsUri;
    }

    public void setLyricsUri(String str) {
        RequiresParseDetailAspect.aspectOf().before(b.d(ajc$tjp_1, this, this, str));
        this.lyricsUri = str;
    }

    public String toString() {
        RequiresParseDetailAspect.aspectOf().before(b.c(ajc$tjp_2, this, this));
        return "LyricsUriBox[lyricsUri=" + getLyricsUri() + "]";
    }
}
