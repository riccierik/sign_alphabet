package com.example.myapplication3;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.List;

public class ImgAnalyzer {
    public static String ANALYZE(List<Mat> arrayImmagini, List<Mat> immaginiGallery, Scalar low, Scalar high) {
        try {
            Mat immagineDaAnalizzare = arrayImmagini.get(0);

            //hsv per creazione mask
            Mat hsvImage = new Mat();
            Imgproc.cvtColor(immagineDaAnalizzare, hsvImage, Imgproc.COLOR_BGR2HSV_FULL);


            //solo mano, rimozione background
            Mat mask = new Mat();
            Core.inRange(hsvImage,
                    low,
                    high,
                    mask);


            //conversione per Core.norm()
            Imgproc.cvtColor(mask, mask, Imgproc.COLOR_BGR2RGB);
            mask.convertTo(mask, CvType.CV_8U);

            double min = Core.norm(mask, immaginiGallery.get(0), Core.NORM_L1);
            int k = 0;
            int x = 0;
            for (Mat i : immaginiGallery) {
                double N = Core.norm(mask, i, Core.NORM_L1);
                if (N < min) {
                    min = N;
                    k = x;
                }
                x++;
            }

            arrayImmagini.clear();

            switch (k) {
                case 0:
                case 1:
                case 2:
                    return "A";
                case 3:
                case 4:
                case 5:
                    return "B";

                case 6:
                case 7:
                case 8:
                    return "C";
                case 9:
                case 10:
                case 11:
                    return "D";
                case 12:
                case 13:
                case 14:
                    return "E";
                case 15:
                case 16:
                case 17:
                    return "F";
                case 18:
                case 19:
                case 20:
                    return "G";
                case 21:
                case 22:
                case 23:
                    return "H";
                case 24:
                case 25:
                case 26:
                    return "i";
                case 27:
                case 28:
                case 29:
                    return "J";
                case 30:
                case 31:
                case 32:
                    return "K";
                case 33:
                case 34:
                case 35:
                    return "L";
                case 36:
                case 37:
                case 38:
                    return "M";
                case 39:
                case 40:
                case 41:
                    return "N";
                case 42:
                case 43:
                case 44:
                    return "O";
                case 45:
                case 46:
                case 47:
                    return "P";
                case 48:
                case 49:
                case 50:
                    return "Q";
                case 51:
                case 52:
                case 53:
                    return "R";
                case 54:
                case 55:
                case 56:
                    return "S";
                case 57:
                case 58:
                case 59:
                    return "T";
                case 60:
                case 61:
                case 62:
                    return "U";
                case 63:
                case 64:
                case 65:
                    return "V";
                case 66:
                case 67:
                case 68:
                    return "W";
                case 69:
                case 70:
                case 71:
                    return "X";
                case 72:
                case 73:
                case 74:
                    return "Y";
                case 75:
                case 76:
                case 77:
                    return "Z";
                default:
                    return "A";
            }

//////galleria
            //ImgLoader.SaveToGallery(mask, getContentResolver());
//////galleria


        } catch (Exception e) {
            return "";
        }


    }

}

