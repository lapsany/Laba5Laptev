package editing;

public class ImplPrinter implements Printer{
    public void printResult(String result) {
        if(result != null) {
            System.out.println(result);
        }
    }
}
