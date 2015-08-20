package com.xiaofei.face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 * ͼƬ����ʶ��
 */
public class identificate {

	public static void main(String[] args) {
		
		// ָ��������ͼƬ·����������ļ�
	    String inputImagePath = identificate.class.getClassLoader().getResource("hf.jpg").getPath().substring(1);
	    String outputImageFile = "identificate.png";
	    
	    String xmlPath = identificate.class.getClassLoader().getResource("cascade_storage.xml").getPath().substring(1);
	    System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	    CascadeClassifier faceDetector = new CascadeClassifier(xmlPath);
	    Mat image = Highgui.imread(inputImagePath);
	    MatOfRect faceDetections = new MatOfRect();
	    faceDetector.detectMultiScale(image, faceDetections);
	    
	    // ��������λ��
	    for (Rect rect : faceDetections.toArray()) {
	        Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 0, 255));
	    }

	    // д�뵽�ļ�
	    Highgui.imwrite(outputImageFile, image);
	    
	    System.out.print("\nOK!");
	}

}
