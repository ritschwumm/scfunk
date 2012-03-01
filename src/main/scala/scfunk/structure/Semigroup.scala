package scfunk.structure

object Semigroup {
	def apply[T](appendFunc:(T,T)=>T):Semigroup[T]	= new Semigroup[T] {
		def append(a:T, b:T):T	= appendFunc(a,b)
	}
}

/** 
a Semigroup consists of the a set T and an associative binary operation T x T => T 
examples are Int addition and multiplication, String and List concatenation, Set union etc...
*/
trait Semigroup[T] {
	def append(a:T, b:T):T
}

//------------------------------------------------------------------------------

import scfunk.data.NonEmptyList

object SemigroupInstances {
	implicit def NonEmptyListSemigroup[T] = new Semigroup[NonEmptyList[T]] {
		def append(a:NonEmptyList[T], b:NonEmptyList[T])	= a ++ b
	}
}
