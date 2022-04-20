public class PowOp extends BinaryOp {
    @Override
    public double getPrecedence() {
        return 3;
    }

    public double operate(double left, double right){
        return ((int)left ^ (int)right);
    }
    public String toString() {
        return (string)'^';
    }

}
}
