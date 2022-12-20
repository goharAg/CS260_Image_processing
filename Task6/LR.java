import ij.ImagePlus;
import ij.IJ;
import ij.process.ImageProcessor;
import ij.process.ByteProcessor;
import ij.process.ColorProcessor;
import ij.plugin.filter.PlugInFilter;
import java.awt.Color;

public class LR implements PlugInFilter{
    ImagePlus inputImage;

    public int setup (String args, ImagePlus im){
        inputImage = im ;
        return DOES_RGB;
    }

    public void run(ImageProcessor inputIP){
        int originalWidth = inputIP.getWidth(), originalHeight = input.getHeight();
        int width = inputIP.getWidth() / 5, height = input.getHeight() / 5;

        ImageProcessor outputIP = new ColorProcessor(width/5, height / 5);

        for(int row =0; row < height; row ++ ){
            for(int col  =0 ; col < width; col++)
                outputIP.putPixel(col, row, inputIP.getPixel(col * 5, row * 5));
        }

        (new ImagePlus(inputImage.getShortTitle() + "LR.jpg", outputIP)).show();
    }
}
