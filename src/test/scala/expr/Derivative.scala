import galileo.environment.Environment
import galileo.expr._
import galileo.trigonometry.SinF1
import org.scalatest._

class DerivativeTest extends FunSuite {

	// D( sin( x ) / x^2 ) = ( x cos(x) - 2 sin( x ) ) / x^3
	val x = Variable( "x" )
	val g = SinF1( x )
	val h = Square( x )
	val f = Fraction( g, h )
  test("fraction") {
		val fd = Derivative( f, x )
		assert( fd.visit().simplify.toString == "(x*cos(x)-2.0*sin(x))/x^3.0" )
	}

  test("Laplace transform derivatives for Exponential distribution at 0 is its moments with factorial coefs") {
    val lambda = Variable("lambda")
    val t = Variable("t")
    val laplaseTransform = Fraction(lambda, Diff(lambda, t))
    val moment = Derivative(laplaseTransform, t)
    val env = new Environment(Option.empty)
    env.set(t.name, Number(0))
    env.set(lambda.name, Number(1))
    assert(laplaseTransform.eval().visit(Option(env)) == Number(1.0))
    assert(moment.visit().visit(Option(env)) == Number(1.0))
  }
}
