public class Complex {
    private double real;
    private double imagine;
    public Complex(double real, double imagine){

        this.real = real;
        this.imagine = imagine;
    }
    public Complex(double real){
        this(real, 0.0);
    }
    public Complex(){
        this(0.0, 0.0);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImagine() {
        return imagine;
    }

    public void setImagine(double imagine) {
        this.imagine = imagine;
    }

    public double length(){
        return Math.sqrt(this.real * this.real + this.imagine * this.imagine);
    }
    public Complex plus(Complex other){
        return new Complex(this.real + other.real, this.imagine + other.imagine);
    }
    public Complex plus(double other){
        return new Complex(this.real + other, this.imagine);
    }
    public Complex minus(Complex other){
        return new Complex(this.real - other.real, this.imagine - other.imagine);
    }
    public Complex minus(double other){
        return new Complex(this.real - other, this.imagine);
    }
    public Complex mul(Complex other){
        return new Complex(this.real * other.real - this.imagine * other.imagine,
                this.real * other.imagine + this.imagine * other.real);
    }
    public Complex mul(double other){
        return new Complex(this.real * other,
                this.imagine * other);
    }
    public Complex div(double other){
        return new Complex(this.real / other,
                this.imagine / other);
    }
    public Complex div(Complex other){
        double l = this.length();
        return new Complex((this.real * other.real + this.imagine * other.imagine) / l,
                (-this.real * other.imagine + this.imagine * other.real) / l);
    }


    @Override
    public String toString() {
        return (Math.abs(this.imagine) < 1e-10) ?
                String.format("%f",this.real):
                String.format("(%f, %f)", this.real, this.imagine);
    }
}
