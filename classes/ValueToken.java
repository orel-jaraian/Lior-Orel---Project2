public class ValueToken extends CalcToken{
    public ValueToken(double val){
        this.val =val;
    }
    public double getValue() {
        return val;
    }
    public String toString() {
        return (string)getValue();
    }


}
