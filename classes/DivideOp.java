public class DivideOp extends BinaryOp {
    @Override
    public double getPrecedence() {
        return 2;
    }

    public double operate(double left, double right){
        return (left / right);
    }
    public String toString() {
        return (string)'/';
    }

}
