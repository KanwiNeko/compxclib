import compxclib.*;

final float ninetyDeg = PI / 2;
final float threeHundredAndSixtyDeg = PI * 2;
final int renderSize = 10;
final float conversion = 180 / PI;

float argOfMethod(CNumber myComplex) {
    CNumber myCNumber = new CNumber(myComplex.re(), myComplex.im());
    Double myDegree = myComplex.arg();
    
    if (myDegree < 0){
      myDegree += threeHundredAndSixtyDeg;
    }
    
    myDegree *= conversion;
    
    println("Real degree: " + myDegree);
    
    return Float.valueOf(String.valueOf(myDegree));
}

void setup() {
    size(800, 800, P2D);
    colorMode(HSB, 360);
    for (int i = 0; i < width; i++){
      for (int j = 0; j < height; j++){
        SqrtBranch sqrtBranch = SqrtBranch.POSITIVE;
        CNumber currentPixel = new CNumber((int)(i - width/2),(int)(-j + height/2)).div(renderSize);
        println("Current pixel: " + currentPixel);
        //CNumber transformedPixel = compxclib.functions.TrigonometricKt.sin(currentPixel);
        //CNumber transformedPixel = compxclib.functions.TrigonometricKt.sec(currentPixel);
        //CNumber transformedPixel = compxclib.functions.TrigonometricKt.arcsin(currentPixel, sqrtBranch, 0);
        //CNumber transformedPixel = compxclib.functions.LogarithmicKt.ln(currentPixel, 0);
        //CNumber transformedPixel = compxclib.functions.PrecalculusKt.floor(currentPixel);
        //CNumber transformedPixel = compxclib.functions.HyperbolicKt.sinh(currentPixel);
        CNumber transformedPixel = compxclib.functions.ExponentialKt.exp(currentPixel);
        //CNumber transformedPixel = compxclib.functions.ExponentialKt.sqrt(currentPixel);
        /*CNumber transformedPixel;
        try{
          transformedPixel = compxclib.functions.ExponentialKt.pow(currentPixel, currentPixel);
        } catch (IllegalArgumentException e) {
          continue;
        }*/
        /*CNumber transformedPixel;
        try{
          transformedPixel = compxclib.functions.ExponentialKt.pow(currentPixel, 3);
        } catch (IllegalArgumentException e) {
          continue;
        }*/
        float currentArg = argOfMethod(transformedPixel);
        //println("Curent pixel: " + currentPixel + " Argument: " + currentArg);
        stroke(round(currentArg), 360, (float)transformedPixel.mag()*360);
        point(i,j);
      }
    }
}

void draw() {
}
