import repositories.Images;
import repositories.filters.FiltersKernel3x3;
import repositories.filters.FiltersKernel7x7;
import repositories.filters.FiltersKernel9x9;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Convolution convulationClass = new Convolution();

        FiltersKernel3x3 filters3x3 = new FiltersKernel3x3();
        FiltersKernel7x7 filters7x7 = new FiltersKernel7x7();
        FiltersKernel9x9 filters9x9 = new FiltersKernel9x9();

        List<String> blurImagesPaths = new Images().blurImages();
        List<String> noiseImagesPaths = new Images().noiseImages();
        List<String> withoutNoiseImagesPaths = new Images().withoutNoiseImages();

        List<String> blurImagesWithSharpness3x3 = new Images().blurImagesWithSharpness3x3();
        List<String> blurImagesWithSharpness7x7 = new Images().blurImagesWithSharpness7x7();
        List<String> blurImagesWithSharpness9x9 = new Images().blurImagesWithSharpness9x9();


        // FUI TROCANDO DE LISTA E DE FUNÇÃO PARA CRIAR TODAS AS IMAGENS COM TODOS OS KERNELS NAS QUESTÕES 1, 2, 3, 4, 5
        for (int i = 0; i < 5; i++) {
            convulationClass.convolution(blurImagesPaths.get(i), filters9x9.gaussiano, String.format("C:\\Users\\princ\\OneDrive\\Documentos\\4º Período - Ccompt\\P. de imagens e V. computacional\\digital_image_processing_report\\src\\assets\\questaoCinco\\kernel9x9\\gaussianFilter\\gaussian_image_filtered%d.png", i + 1));
        }
    }
}
