public class AddOp extends BinaryOp {
    @Override
    public double getPrecedence() {
        return 1;
    }

    public double operate(double left, double right){
        return (left + right);
    }
    public String toString() {
        return (string)'+';
    }

}
