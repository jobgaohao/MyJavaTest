package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.fit.cssbox.demo.ImageRenderer;
import org.xml.sax.SAXException;



public class Html2Img {

	public static void main(String[] args) throws IOException, SAXException {
		
		File fiImg= new File("D:"+File.separator+"html.png");
		// TODO Auto-generated method stub
		ImageRenderer render = new ImageRenderer();
        System.out.println("begin");
        String url = "http://www.cnblogs.com/wangrudong003/p/6201022.html";
        FileOutputStream out = new FileOutputStream(fiImg);
        render.renderURL(url, out, ImageRenderer.Type.PNG);
        System.out.println("OK");
	}

}
