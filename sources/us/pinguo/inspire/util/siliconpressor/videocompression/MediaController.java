package us.pinguo.inspire.util.siliconpressor.videocompression;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import java.io.File;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class MediaController {
    public static File c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile MediaController f11265d;
    public String a;
    private boolean b = true;

    private void b(boolean z, boolean z2) {
        if (this.b) {
            this.b = false;
        }
    }

    private static boolean c(int i2) {
        if (i2 == 39 || i2 == 2130706688) {
            return true;
        }
        switch (i2) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i2, int i3, int i4, int i5, int i6);

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
        if (r10 == (-1)) goto L13;
     */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private long d(android.media.MediaExtractor r22, us.pinguo.inspire.util.siliconpressor.videocompression.b r23, android.media.MediaCodec.BufferInfo r24, long r25, long r27, java.io.File r29, boolean r30) throws java.lang.Exception {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r5 = r21
            r6 = r30
            int r7 = r5.g(r0, r6)
            r8 = -1
            if (r7 < 0) goto L8a
            r0.selectTrack(r7)
            android.media.MediaFormat r10 = r0.getTrackFormat(r7)
            int r11 = r1.a(r10, r6)
            java.lang.String r12 = "max-input-size"
            int r10 = r10.getInteger(r12)
            r12 = 0
            r14 = 0
            int r15 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r15 <= 0) goto L30
            r0.seekTo(r3, r14)
            goto L33
        L30:
            r0.seekTo(r12, r14)
        L33:
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocateDirect(r10)
            r16 = r8
            r4 = 0
        L3a:
            if (r4 != 0) goto L86
            int r10 = r22.getSampleTrackIndex()
            r18 = 1
            if (r10 != r7) goto L78
            int r10 = r0.readSampleData(r3, r14)
            r2.size = r10
            if (r10 >= 0) goto L51
            r2.size = r14
            r19 = r12
            goto L7d
        L51:
            long r12 = r22.getSampleTime()
            r2.presentationTimeUs = r12
            if (r15 <= 0) goto L5f
            int r10 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r10 != 0) goto L5f
            r16 = r12
        L5f:
            r19 = 0
            int r10 = (r27 > r19 ? 1 : (r27 == r19 ? 0 : -1))
            if (r10 < 0) goto L69
            int r10 = (r12 > r27 ? 1 : (r12 == r27 ? 0 : -1))
            if (r10 >= 0) goto L7d
        L69:
            r2.offset = r14
            int r10 = r22.getSampleFlags()
            r2.flags = r10
            r1.q(r11, r3, r2, r6)
            r22.advance()
            goto L7f
        L78:
            r19 = r12
            r12 = -1
            if (r10 != r12) goto L7f
        L7d:
            r10 = 1
            goto L80
        L7f:
            r10 = 0
        L80:
            if (r10 == 0) goto L83
            r4 = 1
        L83:
            r12 = r19
            goto L3a
        L86:
            r0.unselectTrack(r7)
            return r16
        L8a:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.util.siliconpressor.videocompression.MediaController.d(android.media.MediaExtractor, us.pinguo.inspire.util.siliconpressor.videocompression.b, android.media.MediaCodec$BufferInfo, long, long, java.io.File, boolean):long");
    }

    public static MediaCodecInfo e(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        if (!codecInfoAt.getName().equals("OMX.SEC.avc.enc") || codecInfoAt.getName().equals("OMX.SEC.AVC.Encoder")) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo = codecInfoAt;
                    }
                }
                continue;
            }
        }
        return mediaCodecInfo;
    }

    @SuppressLint({"NewApi"})
    public static int f(MediaCodecInfo mediaCodecInfo, String str) {
        int i2;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i3 >= iArr.length) {
                return i4;
            }
            i2 = iArr[i3];
            if (c(i2)) {
                if (!mediaCodecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i2 != 19) {
                    break;
                }
                i4 = i2;
            }
            i3++;
        }
        return i2;
    }

    @TargetApi(16)
    private int g(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i2 = 0; i2 < trackCount; i2++) {
            String string = mediaExtractor.getTrackFormat(i2).getString(IMediaFormat.KEY_MIME);
            if (z) {
                if (string.startsWith("audio/")) {
                    return i2;
                }
            } else if (string.startsWith("video/")) {
                return i2;
            }
        }
        return -5;
    }

    public static MediaController getInstance() {
        MediaController mediaController = f11265d;
        if (mediaController == null) {
            synchronized (MediaController.class) {
                mediaController = f11265d;
                if (mediaController == null) {
                    mediaController = new MediaController();
                    f11265d = mediaController;
                }
            }
        }
        return mediaController;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:(2:25|26)|(5:28|29|30|31|32)|(1:(1:35)(13:567|568|569|570|(1:572)(1:574)|573|(3:42|43|44)(1:88)|45|46|47|48|49|50))(1:580)|36|37|(16:89|90|91|(3:522|523|(3:525|(2:527|(2:536|537)(2:533|534))(3:538|(1:540)(2:541|(1:543)(2:544|(2:546|534)(2:547|(1:549)(1:550))))|537)|535)(2:551|552))(1:93)|94|95|96|97|(3:504|505|(35:507|508|105|106|107|108|109|(1:111)(1:487)|112|113|(1:115)|116|117|118|119|120|(4:122|124|125|126)(1:482)|127|128|129|(2:131|132)(3:469|470|471)|134|135|136|(3:454|455|(11:457|458|140|(4:142|(6:415|416|(3:434|435|(1:445)(4:437|(1:439)(1:444)|440|(1:442)(1:443)))(2:418|(3:420|(4:422|423|424|(2:426|427))(1:432)|428))|433|(0)(0)|428)(1:144)|145|(1:(9:150|151|152|153|(1:155)(2:298|(4:403|404|(1:406)|407)(11:300|(8:385|386|387|(3:389|390|391)(1:399)|392|157|(3:295|296|297)(9:159|160|161|162|163|(1:165)(6:170|(1:172)(2:175|(5:273|274|275|276|277)(2:177|(10:179|180|181|(3:183|(1:185)(1:256)|186)(3:257|(4:259|260|261|(1:263))(1:265)|264)|187|(4:225|226|227|(7:229|230|231|(6:233|234|235|236|237|238)(2:245|(1:247)(1:248))|190|191|(4:193|194|(1:196)(3:198|199|(4:201|202|203|204))|197)(4:221|174|167|168)))|189|190|191|(0)(0))(3:270|271|272)))|173|174|167|168)|166|167|168)|169)(2:302|(5:304|305|306|(1:308)(1:375)|(10:310|311|(5:324|325|326|(3:328|329|(1:331))(2:333|(6:335|(3:339|(2:345|(5:347|348|349|350|351)(1:361))|362)|367|352|(1:355)|356))|332)(1:313)|314|315|(1:317)(1:320)|318|319|(0)(0)|169)(3:372|373|374))(3:382|383|384))|360|283|207|208|209|(1:211)|(1:213)|(1:215)|(1:217)))|156|157|(0)(0)|169)))|452|453|209|(0)|(0)|(0)|(0))(1:460))(1:138)|139|140|(0)|452|453|209|(0)|(0)|(0)|(0))(35:510|494|105|106|107|108|109|(0)(0)|112|113|(0)|116|117|118|119|120|(0)(0)|127|128|129|(0)(0)|134|135|136|(0)(0)|139|140|(0)|452|453|209|(0)|(0)|(0)|(0)))(35:99|(3:101|(2:103|104)|494)(3:495|(3:502|503|104)|494)|105|106|107|108|109|(0)(0)|112|113|(0)|116|117|118|119|120|(0)(0)|127|128|129|(0)(0)|134|135|136|(0)(0)|139|140|(0)|452|453|209|(0)|(0)|(0)|(0))|(0)(0)|45|46|47|48|49|50)(1:39)|40|(0)(0)|45|46|47|48|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x03e6, code lost:
        r37 = r12;
        r13 = r38;
        r8 = r40;
        r7 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:480:0x0800, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:481:0x0801, code lost:
        android.util.Log.e(r13, r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x0826, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:0x0827, code lost:
        r2 = "time = ";
        r13 = "tmessages";
        r1 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x082d, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x082e, code lost:
        r2 = "time = ";
        r13 = "tmessages";
        r1 = r27;
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x083a, code lost:
        r14 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x0844, code lost:
        r35 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02a3 A[Catch: all -> 0x023b, Exception -> 0x0777, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x0777, blocks: (B:129:0x0276, B:133:0x028e, B:136:0x02a3, B:137:0x02af), top: B:533:0x0276 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02bc A[Catch: all -> 0x023b, Exception -> 0x076f, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x076f, blocks: (B:139:0x02b5, B:142:0x02bc), top: B:529:0x02b5 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0654 A[Catch: Exception -> 0x06a5, all -> 0x07c5, TRY_LEAVE, TryCatch #15 {all -> 0x07c5, blocks: (B:320:0x057c, B:450:0x079d, B:451:0x07a7, B:453:0x07ac, B:455:0x07b1, B:457:0x07b6, B:459:0x07be, B:328:0x059a, B:331:0x05a2, B:348:0x05c2, B:350:0x05c7, B:356:0x05d8, B:360:0x05e1, B:362:0x05ef, B:376:0x064e, B:378:0x0654, B:381:0x065f, B:384:0x0665, B:386:0x066b, B:388:0x067d, B:365:0x05fa, B:367:0x0609, B:368:0x0635, B:354:0x05ce, B:338:0x05ae, B:341:0x05b4, B:396:0x06b1, B:397:0x06cd, B:404:0x06d9, B:405:0x06fe, B:411:0x070d, B:412:0x072d), top: B:551:0x057c }] */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0688  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x07ac A[Catch: all -> 0x07c5, Exception -> 0x07c7, TryCatch #15 {all -> 0x07c5, blocks: (B:320:0x057c, B:450:0x079d, B:451:0x07a7, B:453:0x07ac, B:455:0x07b1, B:457:0x07b6, B:459:0x07be, B:328:0x059a, B:331:0x05a2, B:348:0x05c2, B:350:0x05c7, B:356:0x05d8, B:360:0x05e1, B:362:0x05ef, B:376:0x064e, B:378:0x0654, B:381:0x065f, B:384:0x0665, B:386:0x066b, B:388:0x067d, B:365:0x05fa, B:367:0x0609, B:368:0x0635, B:354:0x05ce, B:338:0x05ae, B:341:0x05b4, B:396:0x06b1, B:397:0x06cd, B:404:0x06d9, B:405:0x06fe, B:411:0x070d, B:412:0x072d), top: B:551:0x057c }] */
    /* JADX WARN: Removed duplicated region for block: B:455:0x07b1 A[Catch: all -> 0x07c5, Exception -> 0x07c7, TryCatch #15 {all -> 0x07c5, blocks: (B:320:0x057c, B:450:0x079d, B:451:0x07a7, B:453:0x07ac, B:455:0x07b1, B:457:0x07b6, B:459:0x07be, B:328:0x059a, B:331:0x05a2, B:348:0x05c2, B:350:0x05c7, B:356:0x05d8, B:360:0x05e1, B:362:0x05ef, B:376:0x064e, B:378:0x0654, B:381:0x065f, B:384:0x0665, B:386:0x066b, B:388:0x067d, B:365:0x05fa, B:367:0x0609, B:368:0x0635, B:354:0x05ce, B:338:0x05ae, B:341:0x05b4, B:396:0x06b1, B:397:0x06cd, B:404:0x06d9, B:405:0x06fe, B:411:0x070d, B:412:0x072d), top: B:551:0x057c }] */
    /* JADX WARN: Removed duplicated region for block: B:457:0x07b6 A[Catch: all -> 0x07c5, Exception -> 0x07c7, TryCatch #15 {all -> 0x07c5, blocks: (B:320:0x057c, B:450:0x079d, B:451:0x07a7, B:453:0x07ac, B:455:0x07b1, B:457:0x07b6, B:459:0x07be, B:328:0x059a, B:331:0x05a2, B:348:0x05c2, B:350:0x05c7, B:356:0x05d8, B:360:0x05e1, B:362:0x05ef, B:376:0x064e, B:378:0x0654, B:381:0x065f, B:384:0x0665, B:386:0x066b, B:388:0x067d, B:365:0x05fa, B:367:0x0609, B:368:0x0635, B:354:0x05ce, B:338:0x05ae, B:341:0x05b4, B:396:0x06b1, B:397:0x06cd, B:404:0x06d9, B:405:0x06fe, B:411:0x070d, B:412:0x072d), top: B:551:0x057c }] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x07be A[Catch: all -> 0x07c5, Exception -> 0x07c7, TRY_LEAVE, TryCatch #15 {all -> 0x07c5, blocks: (B:320:0x057c, B:450:0x079d, B:451:0x07a7, B:453:0x07ac, B:455:0x07b1, B:457:0x07b6, B:459:0x07be, B:328:0x059a, B:331:0x05a2, B:348:0x05c2, B:350:0x05c7, B:356:0x05d8, B:360:0x05e1, B:362:0x05ef, B:376:0x064e, B:378:0x0654, B:381:0x065f, B:384:0x0665, B:386:0x066b, B:388:0x067d, B:365:0x05fa, B:367:0x0609, B:368:0x0635, B:354:0x05ce, B:338:0x05ae, B:341:0x05b4, B:396:0x06b1, B:397:0x06cd, B:404:0x06d9, B:405:0x06fe, B:411:0x070d, B:412:0x072d), top: B:551:0x057c }] */
    /* JADX WARN: Removed duplicated region for block: B:468:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:476:0x07f5  */
    /* JADX WARN: Removed duplicated region for block: B:504:0x086f  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x02e1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:576:0x030b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:592:0x02f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:622:0x053d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:624:0x052e A[SYNTHETIC] */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r47, java.io.File r48, int r49, int r50, int r51) {
        /*
            Method dump skipped, instructions count: 2336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: us.pinguo.inspire.util.siliconpressor.videocompression.MediaController.a(java.lang.String, java.io.File, int, int, int):boolean");
    }
}
