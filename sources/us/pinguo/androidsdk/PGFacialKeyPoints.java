package us.pinguo.androidsdk;
/* loaded from: classes3.dex */
public class PGFacialKeyPoints {
    public FacialPts_contour ptsEye_left = new FacialPts_contour();
    public FacialPts_contour ptsEye_right = new FacialPts_contour();
    public FacialPts_contour ptsEyebrow_left = new FacialPts_contour();
    public FacialPts_contour ptsEyebrow_right = new FacialPts_contour();
    public FacialPts_contour ptsMouthoutline = new FacialPts_contour();
    public FacialPts_contour ptsMouthinnerline = new FacialPts_contour();
    public FacialPts_faceOutline ptsFaceOutline = new FacialPts_faceOutline();
    public FacialPts_pupil ptsLeft_pupil = new FacialPts_pupil();
    public FacialPts_pupil ptsRight_pupil = new FacialPts_pupil();
    public FacialPts_nose ptsNose = new FacialPts_nose();

    /* loaded from: classes3.dex */
    public class FacialPts_contour {
        public int downRowCount;
        public float downX;
        public float downY;
        public float leftX;
        public float leftY;
        public float rightX;
        public float rightY;
        public int upRowCount;
        public float upX;
        public float upY;
        public float[] upRow = new float[0];
        public float[] downRow = new float[0];

        public FacialPts_contour() {
        }

        public void fromString(String str) {
            String[] split = str.split(",");
            this.leftX = Float.parseFloat(split[0]);
            this.leftY = Float.parseFloat(split[1]);
            this.rightX = Float.parseFloat(split[2]);
            this.rightY = Float.parseFloat(split[3]);
            this.upX = Float.parseFloat(split[4]);
            this.upY = Float.parseFloat(split[5]);
            this.downX = Float.parseFloat(split[6]);
            this.downY = Float.parseFloat(split[7]);
            this.upRowCount = Integer.parseInt(split[8]);
            this.downRowCount = Integer.parseInt(split[9]);
            this.upRow = new float[this.upRowCount];
            for (int i2 = 0; i2 < this.upRowCount; i2++) {
                this.upRow[i2] = Float.parseFloat(split[i2 + 10]);
            }
            this.downRow = new float[this.downRowCount];
            for (int i3 = 0; i3 < this.downRowCount; i3++) {
                this.downRow[i3] = Float.parseFloat(split[this.upRowCount + 10 + i3]);
            }
        }

        public String toString() {
            String str = this.leftX + "," + this.leftY + "," + this.rightX + "," + this.rightY + "," + this.upX + "," + this.upY + "," + this.downX + "," + this.downY + "," + this.upRowCount + "," + this.downRowCount;
            float[] fArr = this.upRow;
            if (fArr != null && this.downRow != null) {
                for (float f2 : fArr) {
                    str = str + "," + f2;
                }
                for (float f3 : this.downRow) {
                    str = str + "," + f3;
                }
            }
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public class FacialPts_faceOutline {
        public float[] pts = new float[0];
        public int ptsCount;

        public FacialPts_faceOutline() {
        }

        public void fromString(String str) {
            String[] split = str.split(",");
            int i2 = 0;
            int parseInt = Integer.parseInt(split[0]);
            this.ptsCount = parseInt;
            this.pts = new float[parseInt];
            while (i2 < this.ptsCount) {
                int i3 = i2 + 1;
                this.pts[i2] = Float.parseFloat(split[i3]);
                i2 = i3;
            }
        }

        public String toString() {
            String valueOf = String.valueOf(this.ptsCount);
            float[] fArr = this.pts;
            if (fArr != null) {
                for (float f2 : fArr) {
                    valueOf = valueOf + "," + f2;
                }
            }
            return valueOf;
        }
    }

    /* loaded from: classes3.dex */
    public class FacialPts_nose {
        public int downCount;
        public int leftCount;
        public int middleCount;
        public int rightCount;
        public float[] left = new float[0];
        public float[] right = new float[0];
        public float[] down = new float[0];
        public float[] middle = new float[0];

        public FacialPts_nose() {
        }

        public void fromString(String str) {
            String[] split = str.split(",");
            this.leftCount = Integer.parseInt(split[0]);
            this.rightCount = Integer.parseInt(split[1]);
            this.downCount = Integer.parseInt(split[2]);
            this.middleCount = Integer.parseInt(split[3]);
            this.left = new float[this.leftCount];
            for (int i2 = 0; i2 < this.leftCount; i2++) {
                this.left[i2] = Float.parseFloat(split[i2 + 4]);
            }
            this.right = new float[this.rightCount];
            for (int i3 = 0; i3 < this.rightCount; i3++) {
                this.right[i3] = Float.parseFloat(split[4 + this.leftCount + i3]);
            }
            this.down = new float[this.downCount];
            for (int i4 = 0; i4 < this.downCount; i4++) {
                this.down[i4] = Float.parseFloat(split[this.leftCount + 4 + this.rightCount + i4]);
            }
            this.middle = new float[this.middleCount];
            for (int i5 = 0; i5 < this.middleCount; i5++) {
                this.middle[i5] = Float.parseFloat(split[this.leftCount + 4 + this.rightCount + this.downCount + i5]);
            }
        }

        public String toString() {
            String str = this.leftCount + "," + this.rightCount + "," + this.downCount + "," + this.middleCount;
            float[] fArr = this.left;
            if (fArr != null && this.right != null && this.down != null && this.middle != null) {
                for (float f2 : fArr) {
                    str = str + "," + f2;
                }
                for (float f3 : this.right) {
                    str = str + "," + f3;
                }
                for (float f4 : this.down) {
                    str = str + "," + f4;
                }
                for (float f5 : this.middle) {
                    str = str + "," + f5;
                }
            }
            return str;
        }
    }

    /* loaded from: classes3.dex */
    public class FacialPts_pupil {
        public float[] circle = new float[0];
        public int circleCount;
        public float middleX;
        public float middleY;

        public FacialPts_pupil() {
        }

        public void fromString(String str) {
            String[] split = str.split(",");
            this.middleX = Float.parseFloat(split[0]);
            this.middleY = Float.parseFloat(split[1]);
            int parseInt = Integer.parseInt(split[2]);
            this.circleCount = parseInt;
            this.circle = new float[parseInt];
            for (int i2 = 0; i2 < this.circleCount; i2++) {
                this.circle[i2] = Float.parseFloat(split[i2 + 3]);
            }
        }

        public String toString() {
            String str = this.middleX + "," + this.middleY + "," + this.circleCount;
            float[] fArr = this.circle;
            if (fArr != null) {
                for (float f2 : fArr) {
                    str = str + "," + f2;
                }
            }
            return str;
        }
    }

    public void fromString(String str) {
        String[] split = str.split("/");
        this.ptsEye_left.fromString(split[0]);
        this.ptsEye_right.fromString(split[1]);
        this.ptsEyebrow_left.fromString(split[2]);
        this.ptsEyebrow_right.fromString(split[3]);
        this.ptsMouthoutline.fromString(split[4]);
        this.ptsMouthinnerline.fromString(split[5]);
        this.ptsFaceOutline.fromString(split[6]);
        this.ptsLeft_pupil.fromString(split[7]);
        this.ptsRight_pupil.fromString(split[8]);
        this.ptsNose.fromString(split[9]);
    }

    public String toString() {
        return this.ptsEye_left.toString() + "/" + this.ptsEye_right.toString() + "/" + this.ptsEyebrow_left.toString() + "/" + this.ptsEyebrow_right.toString() + "/" + this.ptsMouthoutline.toString() + "/" + this.ptsMouthinnerline.toString() + "/" + this.ptsFaceOutline.toString() + "/" + this.ptsLeft_pupil.toString() + "/" + this.ptsRight_pupil.toString() + "/" + this.ptsNose.toString();
    }
}
